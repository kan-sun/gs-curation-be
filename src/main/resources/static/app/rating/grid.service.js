(function () {

    'use strict';

    angular
        .module('app.ui')
        .factory('gridService', gridService);

    gridService.$inject = ['uiGridConstants'];
    function gridService(uiGridConstants) {
        var service = {
            getOptions: getOptions
        };

        return service;

        /*
            GetOptions function
            @description - Gets the options object for the table grid
                            preferred to be in a service than in the controller for readability
        */
        function getOptions() {
            var regionWidth = 37;
            var options = {
                enableRowSelection: true,
                enableSelectAll: false,
                selectionRowHeaderWidth: 0,
                rowHeight: 28,
                showGridFooter: false,
                fastWatch: true,
                enableFiltering: true,
                columnDefs: [
                    {
                        field: 'AI',
                        displayName: 'AI',
                        width: 45,
                        enableColumnMenu: false,
                        cellTemplate: '<div><div ai-rating rating="3"></div><span class="tag-hidden">{{3}}</span></div>',
                        filter: {
                            condition:  function (searchTerm, cellValue, a) {
                                if (!cellValue) { return; }
                                var separators = ['-', '/', ':', ';', ','];
                                var strippedValue = searchTerm.split(new RegExp(separators.join('|'), 'g'));
                                var bReturnValue = false;
                                var sValueToTest;
                                for (var iIndex in strippedValue) {
                                    sValueToTest = strippedValue[iIndex];
                                    sValueToTest = sValueToTest.replace(' ', '');
                                    if (cellValue.toLowerCase().indexOf(sValueToTest.toLowerCase()) >= 0) {
                                        bReturnValue = true;
                                    }
                                }
                                return bReturnValue;
                            }
                        }
                    }, {
                        name: 'title_en',
                        displayName: 'Title',
                        filter: {
                            term: ''
                        }
                    },{
                        name: 'publicationDateTime',
                        displayName: 'Publication Date',
                        width: 110,
                        cellTemplate: '<div class="ui-grid-cell-contents">{{row.entity[col.field] | date}}</div>'
                    }, {
                        name: 'author_en[0]',
                        displayName: 'Author',
                        filter: {
                            term: ''
                        },
                        maxWidth: 170
                    }, {
                        name: 'industry_en',
                        displayName: 'Tags',
                        width: 200,
                        enableColumnMenu: false,
                        filter: {
                            term: ''
                        },
                        cellTemplate:   '<div class="ui-grid-cell-contents">' +
                            '<span ng-repeat="tag in row.entity[col.field] | limitTo: row.entity.tagLimit track by $index">' +
                            '    <span class="badge badge-sm badge-sm--tag tag" ng-click="grid.appScope.vm.filterByTagName(tag);">{{tag}}</span>' +
                            '    <span class="badge badge-sm" ng-click="grid.appScope.vm.expandTags(row)"' +
                            ' ng-if="$last && row.entity[col.field].length > 1 && !row.entity.tagsExpanded">' +
                            '       {{row.entity[col.field].length - 1}} more' +
                            '    </span>' +
                            '    <span class="tag-hidden">{{tag}}</span>' +
                            '</span>' +
                        '</div>'
                    }, {
                        name: 'w_Equity',
                        displayName: 'Eq.',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'w_Europe',
                        displayName: 'EU',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'w_Macro',
                        displayName: 'M.',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'w_US',
                        displayName: 'US',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'w_Asia',
                        displayName: 'As.',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'w_Commodity',
                        displayName: 'Cm.',
                        width: regionWidth,
                        enableColumnMenu: false,
                        enableSorting: false
                    }, {
                        name: 'rating',
                        displayName: 'Rating',
                        enableColumnMenu: false,
                        cellTemplate: '<div>{{ row.entity[col.field] }}</div>',
                        enableSorting: false,
                        width: 50
                    }
                ],
                rowTemplate: '<div ng-click="grid.appScope.vm.selectRow(row)"' +
                               'ng-repeat="(colRenderIndex, col) in colContainer.renderedColumns track by col.uid"' +
                               'class="ui-grid-cell" ng-class="col.colIndex()" ui-grid-cell></div>',
            };

            angular.forEach(options.columnDefs, function (value) {
                value.enableFiltering = false;
                value.enableHiding = false;
            });

            return options;
        }
    }

})();