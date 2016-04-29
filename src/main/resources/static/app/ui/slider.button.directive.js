(function () {

    'use strict';

    angular
        .module('app.ui')
        .directive('sliderButton', sliderButton);


    function sliderButton() {
        var directive = {
            restrict: 'EA',
            replace: true,
            transclude: true,
            templateUrl: '/app/views/directives/slider-button.html',
            link: function (scope, elem, attr) {
                scope.id = 1;
            }
        };

        return directive;
    }

})();