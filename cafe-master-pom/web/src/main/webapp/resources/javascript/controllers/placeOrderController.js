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

        RestaurantSetupService.getRestaurantByID.query({}, {cafeID : 1}).$promise.then(function(result) {
            $scope.cafeData = result;
        });
    };

    $scope.getProductName = function(term) {

            return  ProductSetupService.getProductForTypeHead.query({}, {data : term}).$promise.then(function(result) {
                $scope.productList = result;
                return limitToFilter($scope.productList, 10);
            });

    };

    $scope.save = function(sector) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            PlaceOrderService.sectorExists.query({}, sector).$promise.then(function(result) {
                if(result.exists == true){
                    $scope.showErrorMessage("Sector " + sector.sectorName + " already exists");
                }else{
                    PlaceOrderService.saveSector.query({}, sector ).$promise.then(function(result) {
                        $scope.showSuccessMessage("Sector " + sector.sectorName + " saved successfully");
                        $scope.sector = {};
                        $scope.init();
                        $scope.showForm = false;
                    });
                }
            });
        }

    };

    $scope.update = function(sector){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            PlaceOrderService.sectorExists.query({},sector).$promise.then(function(result) {
                if(result.exists == true){
                    $scope.showErrorMessage("Sector " + sector.sectorName + " already exists");
                }else{
                    PlaceOrderService.updateSector.query({}, sector ).$promise.then(function(result) {
                        $scope.showSuccessMessage("Sector " + sector.sectorName + " updated successfully");
                        $scope.sector = {};
                        $scope.init();
                        $scope.showForm = false;
                    });
                }
            });
            if($scope.sectorId){
                //$location.path('setupmenu/subSector');
                $state.go("setupmenu.subSector");
            }
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

        if($scope.mainOrder.orderByProductList == undefined){
            $scope.mainOrder.orderByProductList = [];
        }
        $scope.mainOrder.orderByProductList.push({});
    };

    $scope.onSelectProductName = function(item, model, label, orderByProduct){

        orderByProduct.price = item.price;
    };

    $scope.cancel = function(){
        $scope.reset();
        $scope.showForm = false;
    };

    $scope.calculatePrice = function(mainOrder){

        var sum = 0;
        angular.forEach(mainOrder.orderByProductList, function(value, key) {
            if(value.price != undefined){
                sum = sum + (value.price * value.quantity);
            }
        });

        mainOrder.netAmount = sum;
        mainOrder.gstRate = mainOrder.netAmount * $scope.cafeData.gstRate;
        mainOrder.subTotal = mainOrder.netAmount + mainOrder.gstRate;
        $scope.calculateDiscount(mainOrder,mainOrder.subTotal);
    };

    $scope.calculateDiscount = function (mainOrder , subTotal){

        if(mainOrder.discount != undefined){
            mainOrder.discountedAmount = subTotal * mainOrder.discount;
            mainOrder.total = subTotal - mainOrder.discountedAmount;
        }

    };

    $scope.init();

});