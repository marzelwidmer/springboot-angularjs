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
        //$scope.customerResource = CustomerServiceClient.query(); //fetch all
        //console.log($scope.customerResource.length);

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
    }).controller('CustomerController2', function ($log, $scope, $http, $resource, CustomerServiceClient) {
        'use strict';

        // GET ALL
        $scope.customerList = CustomerServiceClient.query(); //fetch all
        console.log($scope.customerList.length);


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
    }).controller('CustomerController3', function ($log, $scope, $http, $resource, CustomerServiceClient, HateoasInterface) {
        'use strict';
        var url = "http://localhost:8080/hal/customer/:id ";
        var personResource = $resource(url);

        $scope.customerList = [];
        var user = new User();
        var people = personResource.query(null, function () {

            var firstPerson = people[0];
            console.log("Here's a firstperson firstname:" + firstPerson.firstname + " lastname:" + firstPerson.lastname);
            console.log("link: " + firstPerson.links[0].href + " rel : " + firstPerson.links[0].rel);

            var firstcustomer = $resource(firstPerson.links[0].href).get(null, function () {
                console.log("Here's a related $resource object: ID:", firstcustomer.id + " firstname:" + firstcustomer.firstname + " lastName:" + firstcustomer.lastname);

                //var user = new User(firstcustomer.id, firstcustomer.firstname, firstcustomer.lastname,firstPerson.links[0].href);
                user.setId(firstcustomer.id);
                user.setFirstname(firstcustomer.firstname);
                user.setLastname(firstcustomer.lastname);
                user.setSelfLink(firstPerson.links[0].href);
                $scope.customerList.push(user);

            });
        });



        /**
         * Constructor, with class name
         */
        function User() {
            "use strict";
            // Public properties, assigned to the instance ('this')
            this.id;
            this.firstname;
            this.lastname;
            this.selfLink;

            return {
                setId : function (id){
                    this.id = id;
                },
                getId : function(){
                    return id;
                },
                setFirstname : function (firstname){
                    this.firstname = firstname;
                },
                getFirstname : function(){
                    return firstname;
                },
                setLastname : function (lastname){
                    this.lastname = lastname;
                },
                getLastname : function(){
                    return lastname;
                },
                setSelfLink : function (link){
                    this.selfLink = link;
                },
                getSelfLink : function(){
                    return selfLink;
                }
            };
        }

    });