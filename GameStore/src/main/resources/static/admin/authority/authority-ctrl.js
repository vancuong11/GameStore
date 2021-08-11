app.controller("authority-ctrl", function($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.initialize = function() {
        //load all roles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load user and admin
        $http.get("/rest/accounts").then(resp => {
            $scope.admins = resp.data;
        })

        // load authority
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
            console.log(" abc"+resp.data);
        }).catch(error => {
            $location.path("/unauthorized");
            console.log(error)
        })
    }
    $scope.authority_of = function(acc,role) {
    	
        if ($scope.authorities) {
//        	console.log($scope.authorities);	
            return $scope.authorities.find(p => p.account.username == acc.username && p.role.id == role.id);
        }
        
    }

    $scope.authority_changed = function(acc,role) {
      var authority = $scope.authority_of(acc,role);
        if (authority) { //da cap quyen => thu hoi quyen xoa
            $scope.revoke_authority(authority);
        } else { // chua cap quyen => cap quyen moi
            authority = { account: acc, role: role };
            $scope.grant_authority(authority);
        }
    }

    // xoa authority
    $scope.revoke_authority = function(authority) {
            $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
                var index = $scope.authorities.findIndex(a => a.id == authority.id);
                $scope.authorities.splice(index, 1);
                alert("Thu hồi quyền sử dụng thành công!");
            }).catch(error => {
                alert("Thu hồi quyền sử dụng thất bại!");
                console.log(error);
            });
        }
        // them moi
    $scope.grant_authority = function(authority) {
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data);
            alert("cấp quyền sử dụng thành công!");
        }).catch(error => {
            alert("cấp quyền sử dụng thất bại!");
            console.log(error);
        });
    }
    
    $scope.initialize();
});