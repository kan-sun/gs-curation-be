(function () {

    'use strict';

    /*
        Rating Controller
        The controller used on the rating page
    */

    angular
        .module('app')
        .controller('RatingController', RatingController);

    RatingController.$inject = ['$scope', '$timeout', 'ratingService', 'gridService'];
    function RatingController($scope, $timeout, ratingService, gridService) {
        var vm = this;

        vm.items = [];
        vm.activeItem = 0;
        vm.selectRow = selectRow;
        vm.currentRow = {};
        vm.filterByTagName = filterByTagName;
        vm.expandTags = expandTags;

        vm.tagFilter = '';
        vm.authorFilter = '';
        vm.titleFilter = '';

        vm.gridOptions = gridService.getOptions();

        activate();

        return vm;

        /*
            Activate function
            @description - runs functions to clean up code in this controller
        */
        function activate() {
            // Register our API for the controller
            registerApi();


            // Get the documents from the rating service
            ratingService.getItems().then(function (data) {
                vm.items = data.data.response.docs;
                addLimitToFilters();
                vm.gridOptions.data = vm.items;
                initWatchers();
            });

            // Register Key events on page load
            initEventHandlers();
        }

        /*
            SelectRow function
            @params {Object} row - an object that represents the row that the user has clicked on
            @description - Selects the row and sets it as an activeItem for the preview screen
        */
        function selectRow(row) {
            if (vm.activeItem !== row.entity.id) {
                vm.gridApi.selection.clearSelectedRows();
                vm.activeItem = row.entity.id;
                $timeout(function () {
                    vm.gridApi.selection.selectRow(row.entity);
                });
            }
        }

        /*
            AddLimitToFilters function
            @description - initally add the tag limit to the rows,
                            this is used for later on when the user clicks on a tag
        */
        function addLimitToFilters() {
            for (var i = 0; i < vm.items.length; i++) {
                vm.items[i].tagLimit = 1;
            }
        }

        /*
            FilterByTagName function
            @params {String} tag - the tag name that should filter the items
            @description - sets the filter for the tags column
        */
        function filterByTagName(tag) {
            vm.tagFilter = tag;
        }

        /*
            ExpandFilters function
            @params {object} row - the row object of the table that the user wants to expand
            @description - expands the row to allow the tags to be expanded
                            (when the user clicks 'x more' tags)
        */
        function expandTags(row) {
            row.entity.tagsExpanded = true;
            row.entity.tagLimit = row.entity.industry_en.length;
            renderTable();
        }

        /*
            FindDataArrayIndex function
            @params {String} name - the value of the DisplayName or Name field in columnDefs to find
            @description - Finds the index of the column definition that get's inputted
        */
        function findDataArrayIndex(name) {
            for (var i = 0; i < vm.gridOptions.columnDefs.length; i++) {
                if (vm.gridOptions.columnDefs[i].name === name || vm.gridOptions.columnDefs[i].displayName === name) {
                    return i;
                }
            }
            return;
        }

        /*
            HandleDocKeySelect function
            @params {String} arrowKey - key representation of what key was pressed
            @description - handles the user clicking the up or down arrows and selecting the next row
        */
        function handleDocKeySelect(arrowKey) {
            var currentRowIndex;
            var selectedRows = vm.gridApi.selection.getSelectedRows();
            if (selectedRows.length < 1) {
                // If nothing selected, we'll select the top row
                currentRowIndex = -1;
            } else {
                // If there are multiple selected, we use the first one
                var selectedRow = selectedRows[0];
                var gridRow = vm.gridApi.grid.getRow(selectedRow);
                currentRowIndex = vm.gridApi.grid.renderContainers.body.visibleRowCache.indexOf(gridRow);
            }
            if (currentRowIndex === 0 && arrowKey === 'up') { return; }
            if (currentRowIndex >= vm.items.length - 1 && arrowKey === 'down') { return; }

            vm.gridApi.selection.clearSelectedRows();
            $timeout(function () {
                currentRowIndex = (arrowKey === 'up') ? currentRowIndex -= 1 : currentRowIndex += 1;
                var rowEntity = vm.gridApi.grid.renderContainers.body.visibleRowCache[currentRowIndex].entity;
                vm.gridApi.selection.selectRow(rowEntity);
            });
        }

        /*
            RegisterApi function
            @description - Registers the grid api with the controller
        */
        function registerApi() {
            vm.gridOptions.onRegisterApi = function (gridApi) {
                vm.gridApi = gridApi;
                if (vm.gridApi.selection) {
                    vm.gridApi.selection.on.rowSelectionChanged($scope, function (row) {
                        vm.currentRow = row.entity;
                        console.log('row selected ' + row.entity.id);
                    });
                }

                $timeout(function () {
                    vm.gridApi.selection.selectRow(vm.gridOptions.data[0]);
                });
            };
        }


        function setPreviewTimeout(id) {
            console.log('Setting preview window with the ID of ' + id);
        }

        /*
            InitWatchers function
            @description - Initialises the watchers for the grid-controller communication
        */
        function initWatchers() {
            var titleFilterIndex = findDataArrayIndex('Title');
            var authorIndex = findDataArrayIndex('Author');
            var tagIndex = findDataArrayIndex('Tags');
            var aiIndex = findDataArrayIndex('AI');

            /*
                Todo: dont render table straight away, wait for a timeout to complete, speeds up runtime of searches!
            */
            $scope.$watch('vm.titleFilter', function () {
                vm.gridOptions.columnDefs[titleFilterIndex].filter.term = vm.titleFilter;
                renderTable();
            });

            $scope.$watch('vm.authorFilter', function () {
                vm.gridOptions.columnDefs[authorIndex].filter.term = vm.authorFilter;
                renderTable();
            });

            $scope.$watch('vm.tagFilter', function () {
                vm.gridOptions.columnDefs[tagIndex].filter.term = vm.tagFilter;
                renderTable();
            });

        }

        /*
            RenderTable function
            @description - manual refresh for the table when something is updated
        */
        function renderTable() {
            vm.gridApi.core.refresh();
        }

        /*
            GetRatingFromKey function
            @description - Gets the value of the key, 0-9 have keycodes 48-57,
                            so we just minus 48 to get the actual value
        */
        function getRatingFromKey(key) {
            return key - 48;
        }

        /*
            InitEventHandlers function
            @description - Initialises the event handlers for the grid
        */
        function initEventHandlers() {
            var handler = function (e) {
                switch (e.keyCode) {
                    case 40:
                        e.preventDefault();
                        handleDocKeySelect('down');
                        break;
                    case 38:
                        e.preventDefault();
                        handleDocKeySelect('up');
                        break;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        vm.currentRow.rating = getRatingFromKey(e.keyCode);
                        renderTable();
                        break;
                }
                return;
            };

            var $doc = angular.element(document);

            $doc.on('keydown', handler);
            $scope.$on('$destroy', function () {
                $doc.off('keydown', handler);
            });
        }
    }

})();