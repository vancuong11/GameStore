const app = angular.module("shopping-cart-app", [])
app.controller("shopping-cart-ctrl", function($scope, $http) {
    // QUAN LI GIO HANG
    $scope.cart = {
        items: [],
        // them san pham
        add(id) {
            // tim id san pham trong gio hang

            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveLocalStorage();
                    alert("Success Products");
                })
            }
        },
        // xoa san pham khoi gio hang
        remove(id) {
            // tim id san pham trong gio hang
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveLocalStorage();
        },
        // clear gio hang
        clear() {
            this.items = [];
            this.saveLocalStorage();
        },
        // tinh tien 1 san pham
        amt_of(item) {

        },
        // tong so luong
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        // tong tien
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        // luu gio hang vao LocalStore
        saveLocalStorage() {
            // chuyem mang item sang dang json
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        // doc gio hang tu localStore
        loadFormLocalStorage() {
            var json = localStorage.getItem("cart")
            this.items = json ? JSON.parse(json) : [];
        }
    }
    
    $scope.cart.loadFormLocalStorage();
    
    $scope.order = {
            createDate: new Date(),
            status: false,
            address: "",
            account: { username: $("#username").text()},
            get orderDetails() {
                return $scope.cart.items.map(item => {
                    return {
                        product: { id: item.id },
                        price: item.price,
                        quantity: item.qty
                    }
                });
                
            },
            purchase() {
                // dat hang
                var order = angular.copy(this);
                $http.post("/rest/orders", order).then(resp => {
                    alert("Đặt hàng thành công!");
                    $scope.cart.clear();
                    location.href = "/cart/view";
//                    console.log(username);
                }).catch(error => {
                    alert("Lỗi đặt hàng!")
                    console.log(error)
                })
                
            }
        }
    
//  
    $scope.favorite ={
    		likes :[],
    		add(id) {
                // tim id san pham trong gio hang

                var item = this.likes.find(item => item.id == id);
                if (item) {
                    item.qty++;
                    this.saveLocalStorage();
                } else {
                    $http.get(`/rest/products/${id}`).then(resp => {
                        resp.data.qty = 1;
                        this.likes.push(resp.data);
                        this.saveLocalStorage();
                        alert("Success Favorite");
                    })
                }
            },
            // xoa san pham khoi gio hang
            remove(id) {
                // tim id san pham trong gio hang
                var index = this.likes.findIndex(item => item.id == id);
                this.likes.splice(index, 1);
                this.saveLocalStorage();
            },
            // clear gio hang
            clear() {
                this.likes = [];
                this.saveLocalStorage();
            },
          
            // tong so luong
            get count() {
                return this.likes
                    .map(item => item.qty)
                    .reduce((total, qty) => total += qty, 0);
            },
            // tong tien
            get amount() {
                return this.likes
                    .map(item => item.qty * item.price)
                    .reduce((total, qty) => total += qty, 0);
            },
            // luu gio hang vao LocalStore
            saveLocalStorage() {
                // chuyem mang item sang dang json
                var json = JSON.stringify(angular.copy(this.likes));
                localStorage.setItem("like", json);
            },
            // doc gio hang tu localStore
            loadFormLocalStorage() {
                var json = localStorage.getItem("like")
                this.likes = json ? JSON.parse(json) : [];
            }
    }
    
    $scope.favorite.loadFormLocalStorage();
})