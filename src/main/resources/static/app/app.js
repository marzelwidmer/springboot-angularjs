'use strict';

var app = angular.module ( 'myApp', [ 'ui.router', 'ngResource', 'myApp.controllers', 'myApp.services', 'hateoas' ] );

/*
app.config(function (HateoasInterceptorProvider) {
    HateoasInterceptorProvider.transformAllResponses();
});*/

app.config(function (HateoasInterfaceProvider) {
    HateoasInterfaceProvider.setHttpMethods({
        update: {
            method: "PUT"
        }
    });
});
/*
app.config(function (HateoasInterfaceProvider) {
        HateoasInterfaceProvider.setLinksKey("related");
    // HateoasInterface will now search response data for links in a property called "related"
});*/
