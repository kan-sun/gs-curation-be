(function () {
    'use strict';

    angular
        .module('app.ui')
        .directive('navbar', navbar);

    navbar.$inject = [];
    function navbar() {
        var directive = {
            restrict: 'EA',
            replace: true,
            transclude: true,
            templateUrl: '/app/views/directives/navbar.html',
            link: function (scope, elem, attr) {

            }
        };

        return directive;
    }

})();