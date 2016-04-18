app.controller('TableSetupController', function($scope, $rootScope, $state, $http, $timeout, $location, TableSetupService, RestaurantSetupService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.cafeTable = {};
    $scope.cafeTableList = [];
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
        {columnHeaderDisplayName: 'Name', displayProperty: 'name', sortKey: 'name'},
        {columnHeaderDisplayName: 'Restaurant Name', displayProperty: 'restaurantName', sortKey: 'r.restaurantName'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '5em'}
    ];

    //datasource configuration
    $scope.dataSourceConfig = {
        url: 'rest/tableSetup/getAll',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };

    $scope.save = function(cafeTable) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            TableSetupService.save.query({}, cafeTable ).$promise.then(function(result) {
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

    $scope.update = function(cafeTable){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            TableSetupService.update.query({}, cafeTable ).$promise.then(function(result) {
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

    $scope.edit = function(cafeTable){
        $scope.cafeTable = {};
        angular.copy(cafeTable, $scope.editObj);
        angular.copy(cafeTable, $scope.cafeTable);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.cafeTable);
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