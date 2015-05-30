angular.module('myApp.controllers', [])
    .controller('EmpController', function ($log, $scope, $http, ServiceClient) {
        'use strict';

        // GET ALL
        $scope.customers = ServiceClient.query(); //fetch all
        $scope.getTotalCustomers = function () {
            return $scope.customers.length;
        };


        // callback for ng-click 'deleteUser':
        $scope.deleteCustomer = function (customerId) {
            ServiceClient.delete({id: customerId});
            $scope.customers = ServiceClient.query();
        };
    })
    .controller('CustomerController', function ($log, $scope, $http, $resource) {
        'use strict';
        var url = "http://localhost:8080/hal/customer/ ";

        $scope.customersHal = [];

        // also works with array results from $resource(...).query()
        var response = $resource(url).query(null, function () {
            console.log("Found  " + response.length + " customers on URL " + url);

            angular.forEach(response, function (customer) {
                angular.forEach(customer.links, function (link) {
                    console.log("firstname:" + customer.firstname + " lastname:" + customer.lastname + " link:" + link.href);
                    console.log("------ create user object");
                    //$scope.customersHal = new User(customer.firstname,  customer.lastname, link.href);

                    $scope.customersHal.push(new User(customer.firstname,  customer.lastname, link.href));
                });
            });
        });


        /**
         * Constructor, with class name
         */
        function User(firstname, lastname, link) {
            // Public properties, assigned to the instance ('this')
            this.firstname = firstname;
            this.lastname = lastname;
            this.link = link;
        }
    });