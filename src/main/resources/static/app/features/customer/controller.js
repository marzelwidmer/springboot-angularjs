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
    .controller('CustomerController', function ($log, $scope, $http, $resource, CustomerServiceClient) {
        'use strict';

        // GET ALL
        $scope.customerResource = CustomerServiceClient.query(); //fetch all
        console.log($scope.customerResource.length);

        var url = "http://localhost:8080/hal/customer/ ";
        $scope.customerList = [];


        // also works with array results from $resource(...).query()
        var response = $resource(url).query(null, function () {
            console.log("Found  " + response.length + " customers on URL " + url);

            angular.forEach(response, function (customer) {
                var user = new User();
                user.firstname = customer.firstname;
                user.lastname = customer.lastname;
                console.log(user.firstname +  " " + user.lastname);

                // TODO workaround to get the self link at the moment we only have one
                // FIXME
                angular.forEach(customer.links, function (link) {
                    console.log("link:" + link.href);
                    user.addSelfLink(link.href);
                });
                $scope.customerList.push(user);
            });
        });


        $scope.deleteMe = function (url) {
            console.log("Delelet Customer " + url);
            $http.delete(url);
           // CustomerServiceClient.delete(url);
            //$scope.customerList = CustomerServiceClient.query();
        };


        /**
         * Constructor, with class name
         */
        function User(firstname, lastname) {
            "use strict";
            // Public properties, assigned to the instance ('this')
            this.firstname = firstname;
            this.lastname = lastname;
            this.selfLink;

            return {
                addSelfLink : function (link){
                    this.selfLink = link;
                },

                getSelfLink : function(){
                    return selfLink;
                }
            };
        }



    });