/* jshint expr: true */
describe('Curation Service', function () {
    var curationService;
    var httpBackend;

    beforeEach(module('app'));
    beforeEach(inject(function (_curationService_, $httpBackend) {
        curationService = _curationService_;
        httpBackend = $httpBackend;
    }));

    it('should contain a $http request function', function () {
        expect(curationService.req).to.be.instanceof(Function);
    });

    it('should return a promise from the $http method (get req)', function () {
        var url = 'http://api.test.com/test.json';
        httpBackend.whenGET(url).respond(200, {
            test: true
        });

        curationService.req('GET', url).then(function (testData) {
            expect(testData.data.test).to.equal(true);
            expect(testData.data).to.be.instanceof(Object);
        });

        httpBackend.flush();
    });

    it('should return a 201 with a test POST request', function () {
        var url = 'http://api.test.com/post/';
        var name = 'John Smith';
        var email = 'johnsmith@smith.com';

        httpBackend.whenPOST(url).respond(201);

        curationService.req('POST', url, {
            name: name,
            email: email
        }).then(function (data) {
            expect(data.status).to.equal(201);
            expect(data.config.data.name).to.equal(name);
            expect(data.config.data.email).to.equal(email);
        });

        httpBackend.flush();
    });
});