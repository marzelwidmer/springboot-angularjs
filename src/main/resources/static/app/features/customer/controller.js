
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
            ServiceClient.delete({ id: customerId });
            $scope.customers = ServiceClient.query();
        };
    })
    .controller('CustomerController', function ($log, $scope, $http, $resource) {
        'use strict';
        console.log("CustomerController try to get a HAL RESOURCE");
        var url = "http://localhost:8080/hal/customer/ ";
        /*var item = $resource(url).get(null, function () {
            console.log("Get some resources");
            console.log("Here's a related $resource object: ", item.resource("some-related-endpoint"));
        });*/


        // also works with array results from $resource(...).query()
        var items = $resource(url).query(null, function () {
            console.log(items);
            angular.forEach(items, function (item) {
                console.log("Get some resources " + item.firstname + " " + item.lastname + " ");

                console.log("Here's a related $resource object: ", item.links.self);
            });
        });

    });





/*
var item = $resource("/hal/customer").get(null, function () {
    console.log("Here's a related $resource object: ", item.resource("some-related-endpoint"));
});

// also works with array results from $resource(...).query()
var items = $resource("/hal/customer").query(null, function () {
    angular.forEach(items, function (item) {
        console.log("Here's a related $resource object: ", item.resource("some-related-endpoint"));
    });
});




var personResource = $resource("/hal/customer/:id");

var people = personResource.query(null, function () {
    var firstPerson = people[0];
    var firstPersonAddresses = new HateoasInterface(firstPerson).resource("addresses").query(null, function () {
        console.log(firstPersonAddresses);
    });
});



*/