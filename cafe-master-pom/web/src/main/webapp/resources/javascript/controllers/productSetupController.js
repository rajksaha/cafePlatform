app.controller('ProductSetupController', function($scope, $rootScope, $state, $http, $timeout, $location, ProductSetupService, RestaurantSetupService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.product = {};
    $scope.productList = [];
    $scope.showForm = false;
    $scope.editObj = {};

    $scope.init = function() {

        $scope.showForm = false;
        RestaurantSetupService.getAll.query({}, {}).$promise.then(function(result) {
            $scope.restaurantDataList = result;
        });
    };


    //reloading the grid
    $scope.reloadList = false;
    $scope.refreshList = function () {
        $scope.reloadList = !$scope.reloadList;
        $scope.dataSourceConfig.params.refresh = $scope.reloadList;
    };

    $scope.searchParam = {};
    $scope.search = function() {
        $scope.dataSourceConfig.params = angular.copy($scope.searchParam);
    };

    // column definition
    $scope.columnDefinition = [
        /*{columnHeaderDisplayName: 'SL', displayProperty: 'serial', width: '4em'},*/
        {columnHeaderDisplayName: 'Product Name', displayProperty: 'name', sortKey: 'name'},
        {columnHeaderDisplayName: 'Restaurant Name', displayProperty: 'restaurantName', sortKey: 'r.restaurantName'},
        {columnHeaderDisplayName: 'Price', displayProperty: 'price', sortKey: 'price'},
        {columnHeaderDisplayName: 'Cost', displayProperty: 'cost', sortKey: 'cost'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '5em'}
    ];

    //datasource configuration
    $scope.dataSourceConfig = {
        url: 'rest/productSetup/getAll',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };

    $scope.save = function(product) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            ProductSetupService.save.query({}, product ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information saved successfully");
                    $scope.product = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }

    };

    $scope.update = function(product){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            ProductSetupService.update.query({}, product ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information updated successfully");
                    $scope.product = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
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

    $scope.edit = function(product){
        $scope.product = {};
        angular.copy(product, $scope.editObj);
        angular.copy(product, $scope.product);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.product);
        $scope.hideMessage();
        validator.hideError("#validationRequired");
    };

    $scope.add = function(){
        $scope.editObj = {};
        $scope.reset();
        $scope.showForm = true;
    };

    $scope.cancel = function(){
        $scope.reset();
        $scope.showForm = false;
    };

    $scope.backToList = function() {
        $scope.cancel();
    };

    $scope.init();

});