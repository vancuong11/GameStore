 app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
        .when("/staff", {
            templateUrl: "/admin/manager/staff.html",
            controller: "staff-ctrl"
        })
        .when("/product", {
            templateUrl: "/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/categori", {
            templateUrl: "/admin/manager/categori.html",
            controller: "categori-ctrl"
        })
        .when("/order", {
            templateUrl: "/admin/manager/order.html",
            controller: "order-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'> MOLLA ADMINISTRATOR</h1>"
        });
})