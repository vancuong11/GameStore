app.controller("order-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.details = [];

    $scope.initialize = function () {
        $http.get(`/rest/orders`).then(resp => {
            $scope.items = resp.data;
            console.log(resp.data);
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate);
            });
        })
//        load orderdetail
        
    }
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        var item = angular.copy($scope.form);
        $(".nav-tabs a:eq(0)").tab('show')
//        var item = angular.copy($scope.form);
    	$http.get(`/rest/orderdetail/${item.id}`).then(resp =>{
    		$scope.details = resp.data;
    		
    		console.log($scope.details)
    	})
    };
    
    $scope.delivery = function(item){
    	$scope.form = angular.copy(item);
    	var item = angular.copy($scope.form);
    	 $http.put(`/rest/orders/${item.id}`, item).then(resp => {
             var index = $scope.items.findIndex(p => p.id == item.id)    
             $scope.items[index] = item;
             console.log($scope.items);
             alert("Đã giao hàng!")
             location.href = "#!order" ;
         }).catch(error => {
             alert("Error", error)
             console.log(error);
         })
    	
    		
    }
    $scope.initialize();
//    $scope.edit();
    
}) 