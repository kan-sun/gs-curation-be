(function () {
    'use strict';

    angular
        .module('app')
        .config(config);


    /*
        Config function
        @params {Object} $stateProvider - ui routers object for providing routing
        @params {Object} $urlRouterProvider - ui routers object for providing an otherwise clause
        @description - Provides routing for the application and
                        sets up the configuration for the angular application
    */
    config.$inject = ['$stateProvider', '$urlRouterProvider'];
    function config($stateProvider, $urlRouterProvider) {
        $stateProvider
        .state('rating', {
            url: '/',
            templateUrl: '/app/views/rating.html',
            controller: 'RatingController',
            controllerAs: 'vm'
        });

        $urlRouterProvider.otherwise('/');
    }

})();
