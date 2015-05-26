
angular.module ( 'myApp.services', [] ).factory ( 'ServiceClient', function ( $resource ) {
    'use strict';

    return $resource ( 'http://localhost:8080/api/customer/:id', {id : '@_id'}, {
        update : {
            method : 'PUT'
        }

    } );
});
