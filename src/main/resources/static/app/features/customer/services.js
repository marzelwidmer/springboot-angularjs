
angular.module ( 'myApp.services', [] )
    .factory ( 'ServiceClient', function ( $resource ) {
    'use strict';

    return $resource ( "http://127.0.0.1:8080/api/customer/:id ", {id : '@_id'}, {
        update : {
            method : 'PUT'
        }
    } );
})

    .factory ( 'CustomerServiceClient', function ( $resource ) {

    //http://blog.mgechev.com/2014/02/05/angularjs-resource-active-record-http/

    'use strict';
    return $resource ( "http://127.0.0.1:8080/hal/customer/ ", {}, {
        update : {
            method : 'PUT'
        }
    } );
});

