/* jshint expr: true */
describe('Rating Controller', function () {
    beforeEach(module('app'));
    var scope;

    it('should get an empty list of items to display in the table', inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        var vm = $controller('RatingController', { $scope: scope });
        expect(vm.items).to.be.instanceOf(Array);
        expect(vm.items).to.be.empty;
    }));

    it('should fill the array when the http method is called', inject(function ($controller, $rootScope, $httpBackend) {
        var vm = $controller('RatingController', { $scope: scope });
        $httpBackend.expectGET('/get/responses').respond(200, {
            response: {
                docs: [{ id: 1}, { id: 2}]
            }
        });
        $httpBackend.flush();
        expect(vm.items).to.not.be.empty;
    }));

    it('should filter title and author items', inject(function ($controller) {
        var vm = $controller('RatingController', { $scope: scope });
        expect(vm.gridOptions.columnDefs[1].filter.term).to.equal('');
        expect(vm.gridOptions.columnDefs[3].filter.term).to.equal('');
    }));

});