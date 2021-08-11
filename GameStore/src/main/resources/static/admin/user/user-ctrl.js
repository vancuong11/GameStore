app.controller("user-ctrl", function($scope, $http, $location) {
    $scope.users = [];
    $scope.form = {};

    $scope.initialize = function() {
        $http.get("/rest/accounts").then(resp => {
            $scope.users = resp.data;
        })
    }   
    $scope.initialize();
    //
    $scope.reset = function () {
        $scope.form = {
            
        };
    };
    //
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    };
    //
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/accounts`, item).then(resp => {
            $scope.users.push(resp.data)
            $scope.reset();
            alert("Them moi nguoi dung thanh cong!")
        }).catch(error => {
            alert("Error", error)
            console.log(error);
        })
    }
    //
    $scope.update = function () {
        var item = angular.copy($scope.form)
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            var index = $scope.users.findIndex(p => p.username == item.username)
            $scope.users[index] = item;
//            $scope.users.push(resp.data);
            $scope.reset();
            alert("Cap nhat nguoi dung thanh cong!")
        }).catch(error => {
            alert("Error", error)
            console.log(error);
        })
    }
    //
    $scope.delete = function (item) {
        $http.delete(`/rest/accounts/${item.username}`).then(resp => {
            var index = $scope.users.findIndex(p => p.username == item.username);
            $scope.users.splice(index, 1);
            $scope.reset();
            alert("Xoa nguoi dung thanh cong!")
        }).catch(error => {
            alert("Error", error)
            console.log(error);
        })
    }
});