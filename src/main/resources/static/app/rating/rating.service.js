(function () {

    'use strict';

    /*
        Rating Service
        Service used for all logic and http calls on the rating page
    */

    angular
        .module('app')
        .factory('ratingService', ratingService);


    ratingService.$inject = ['curationService'];
    function ratingService(curationService) {
        var service = {
            getItems: getItems,
            items: []
        };

        return service;

        /*
            GetItems function
            @params {Object} filters - an object of all filters to be applied to the request
            @description - Gets the JSON array of items to be rated
        */
        function getItems(filters) {
            return curationService.req('GET', '/get/responses');
        }
    }

})();