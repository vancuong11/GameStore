var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    	.when("/user", {
            templateUrl: "/admin/user/index.html",
            controller: "user-ctrl"
        })
        .when("/product", {
            templateUrl: "/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/order", {
            templateUrl: "/admin/order/index.html",
            controller: "order-ctrl"
        })
        .when("/orderdetail", {
            templateUrl: "/admin/orderdetail/table.html",
            controller: "order-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'>Adminstrator</h1>"
        });
})