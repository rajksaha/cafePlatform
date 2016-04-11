app.controller('RestaurantSetupController', function($scope, $rootScope, $location, $stateParams, $state, $http, $timeout, RestaurantSetupService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.restaurantData = {};
    $scope.restaurantDataList = [];
    $scope.showForm = false;
    $scope.editObj = {};

    $scope.init = function() {

        $scope.restaurantData = {};
        $scope.showForm = false;
        RestaurantSetupService.getAll.query({}, {}).$promise.then(function(result) {
            $scope.restaurantDataList = result;
        });
    };

    $scope.save = function(restaurantData) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            RestaurantSetupService.save.query({}, restaurantData ).$promise.then(function(result) {
                $scope.showSuccessMessage("Information updated successfully");
                $scope.init();
            });
        }

    };

    $scope.update = function(restaurantData){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            RestaurantSetupService.update.query({}, restaurantData ).$promise.then(function(result) {
                $scope.showSuccessMessage("Information updated successfully");
                    $scope.init();
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


    $scope.edit = function(restaurantData){
        $scope.restaurantData = {};
        angular.copy(restaurantData, $scope.editObj);
        angular.copy(restaurantData, $scope.restaurantData);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.restaurantData);
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

    $scope.init();

});