'use strict';

angular.module ( 'myApp.services', [] ).factory ( 'ServiceClient', function ( $resource ) {
    return $resource ( '/api/customer/:id', {id : '@_id'}, {
        update : {
            method : 'PUT'
        }

    } );
});
