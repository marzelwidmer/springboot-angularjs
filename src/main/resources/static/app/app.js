
angular.module ( 'myApp', [ 'ui.router', 'ngResource', 'myApp.controllers', 'myApp.services' ] );




angular.module('myHalApp', ['ui.router', 'ngResource', 'myApp.controllers', 'myApp.services', 'angular-hal'])
    .run(function ($rootScope, halClient) {
        $rootScope.apiRoot = halClient.$get('/hal/customer/');
    })

    .controller('appController', function ($rootScope, $scope, $window, $scope, $timeout, halClient) {
        $scope.root = function() {
            halClient.$get('/hal/customer/', {
                linksAttribute : "_links"
            }).then(function(resource) {
                $rootScope.resource = resource;
            });
        };
        $scope.root();
    })

    .controller('customer', function ($window, $scope, $timeout, halClient) {

        var searchTimeout;
        $scope.$watch('search', function (value) {
            $timeout.cancel(searchTimeout);
            searchTimeout = $timeout(load, 300);
        }, true);


        $scope.submitNewContactForm = function () {
            if ($scope.newContactForm.$invalid) return;

            return $scope.apiRoot.then(function (apiRoot) {
                return apiRoot.$post('customer', null, $scope.newContact);
            }).then(load);
        };

        $scope.deleteContact = function (index) {
            var contact = $scope.contactItems[index];

            contact.$del('self').then(load);
        };

        $scope.$watch('customer', function (contacts) {
            if (!contacts) return;
            contacts.$get('item').then(function (contactItems) {
                $scope.contactItems = contactItems;
            });
        });

        function load() {
            var search = $scope.search;
            var promise;
            if (search) {
                promise = $scope.apiRoot.then(function (apiRoot) {
                    return apiRoot.$get('customer', {
                        search: search
                    });
                });
            } else {
                promise = $scope.apiRoot.then(function (apiRoot) {
                    return apiRoot.$get('customer');
                });
            }
            return promise.then(function (contacts) {
                $scope.contacts = contacts;
                $scope.newContactForm.$setPristine();
                delete $scope.newContact;
            });
        }
    })