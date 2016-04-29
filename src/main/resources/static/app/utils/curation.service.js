(function () {

    'use strict';

    /*
        Curation Service
        A service with all the useful and heavily used functions of the app
    */

    angular
        .module('app.core')
        .factory('curationService', curationService);

    curationService.$inject = ['$http'];
    function curationService($http) {
        var factory = {
            req: req
        };

        return factory;

        /*
            Request (req) function
            @params {String} requestMethod - Method e.g. 'GET', 'POST'...
            @params {String} url - The url of the REST service
            @params {Object} - A data object to send with the request
            @description - Function that calls the http function of angular
                           Acts as an abstraction layer
        */
        function req(requestMethod, url, reqObj) {
            return $http({
                method: requestMethod,
                url: url,
                data: reqObj ? reqObj : {},
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        }
    }

})();