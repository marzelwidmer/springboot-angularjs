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
                var user = new User();
                user.firstname = customer.firstname;
                user.lastname = customer.lastname;
                console.log(user.firstname +  " " + user.lastname);

                angular.forEach(customer.links, function (link) {
                    console.log("link:" + link.href);
                    user.addLink(link.href);
                    console.log("total links " + user.getTotalLinks());
                });
                $scope.customersHal.push(user);
            });
        });


        /**
         * Constructor, with class name
         */
        function User(firstname, lastname) {
            "use strict";
            // Public properties, assigned to the instance ('this')
            this.firstname = firstname;
            this.lastname = lastname;
            var links = [];

            return {
                addLink : function (link){
                    links.push(link);
                },
                getTotalLinks : function(){
                    return links.length;
                },
                getLinks : function(){
                    return links;
                }
            };
        }



    });