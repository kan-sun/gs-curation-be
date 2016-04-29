(function () {

    'use strict';

    angular
        .module('app')
        .factory('docViewService', docViewService);

    docViewService.$inject = ['curationService'];
    function docViewService(curationService) {
        var service = {
            renderDocument: renderDocument
        };

        return service;

        function renderDocument(id) {
            // Url will need to change with backend
            curationService.req('GET', 'document/' + id).then(function (documentData) {
                // Render the document to the page here
            });
        }
    }

})();