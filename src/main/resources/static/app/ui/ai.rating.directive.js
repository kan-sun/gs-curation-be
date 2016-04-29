(function () {

    'use strict';

    angular
        .module('app.ui')
        .directive('aiRating', aiRating);

    function aiRating() {
        var directive = { restrict: 'EA',
            replace: true,
            transclude: true,
            templateUrl: '/app/views/directives/ai-rating.html',
            link: function (scope, elem, attr) {
                scope.rating = parseInt(attr.rating);
                scope.loopTo = generateArray(attr.rating);
            }
        };

        return directive;

        function generateArray(rating) {
            var ratingArray = [];
            for (var i = 0; i < 3; i++) {
                if (rating > i) {
                    ratingArray.push('star');
                } else {
                    ratingArray.push('star-o');
                }
            }
            return ratingArray;
        }
    }

})();