app.controller('PlaceOrderController', function($scope, $rootScope, $location, $state, $http, $timeout, PlaceOrderService, ProductSetupService, TableSetupService, UserSetupService, limitToFilter, RestaurantSetupService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.mainOrder = {};
    $scope.sectorList = [];
    $scope.showForm = false;
    $scope.editObj = {};

    $scope.init = function() {

        TableSetupService.getAllForSelect.query({}, {}).$promise.then(function(result) {
            $scope.cafeTableList = result;
        });

        UserSetupService.getAll.query({}, {}).$promise.then(function(result) {
            $scope.waiterList = result;
        });

        RestaurantSetupService.getRestaurantByID.query({}, {cafeID : $rootScope.userData.restaurantID}).$promise.then(function(result) {
            $scope.cafeData = result;
        });
    };

    $scope.getProductName = function(term) {

            return  ProductSetupService.getProductForTypeHead.query({}, {data : term}).$promise.then(function(result) {
                $scope.productList = result;
                return limitToFilter($scope.productList, 10);
            });

    };

    $scope.save = function(mainOrder) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {

            PlaceOrderService.save.query({}, mainOrder ).$promise.then(function(result) {
                //$scope.showSuccessMessage("Sector " + sector.sectorName + " saved successfully");
                $state.go('root.tableStatus');
                $scope.showForm = false;
            });
        }

    };

    $scope.update = function(sector){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            PlaceOrderService.update.query({}, sector ).$promise.then(function(result) {
                $scope.showSuccessMessage("Sector " + sector.sectorName + " updated successfully");
                $scope.sector = {};
                $scope.init();
                $scope.showForm = false;
            });
        }
    };

    $scope.showErrorMessage = function(message){
        $scope.hasError = true;
        $scope.hasSuccess = false;
        $scope.message = message;
    };

    $scope.showSuccessMessage = function(message){
        $scope.hasError = false;
        $scope.hasSuccess = true;
        $scope.message = message;
    };

    $scope.hideMessage = function(){
        $scope.hasError = false;
        $scope.hasSuccess = false;
    };


    $scope.edit = function(sector){
        $scope.sector = {};
        angular.copy(sector, $scope.editObj);
        angular.copy(sector, $scope.sector);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.sector);
        $scope.hideMessage();
        validator.hideError("#validationRequired");
    };

    $scope.add = function(){

        if($scope.mainOrder.subOrderList == undefined){
            $scope.mainOrder.subOrderList = [];
        }
        $scope.mainOrder.subOrderList.push({});
    };

    $scope.onSelectProductName = function(item, model, label, orderByProduct){

        orderByProduct.price = item.price;
        orderByProduct.productID = item.productID;
    };

    $scope.cancel = function(){
        $scope.reset();
        $scope.showForm = false;
    };

    $scope.calculatePrice = function(mainOrder){

        var sum = 0;
        angular.forEach(mainOrder.subOrderList, function(value, key) {
            if(value.price != undefined){
                sum = sum + (value.price * value.quantity);
            }
        });

        mainOrder.netAmount = sum;
        mainOrder.gst = mainOrder.netAmount * $scope.cafeData.gstRate;
        mainOrder.subtotal = mainOrder.netAmount + mainOrder.gst;
        $scope.calculateDiscount(mainOrder,mainOrder.subtotal);
    };

    $scope.calculateDiscount = function (mainOrder , subtotal){

        if(mainOrder.discount != undefined){
            mainOrder.discountedAmount = subtotal * mainOrder.discount;
            mainOrder.total = subtotal - mainOrder.discountedAmount;
        }else{
            mainOrder.total = subtotal;
        }

    };

    $scope.init();

});