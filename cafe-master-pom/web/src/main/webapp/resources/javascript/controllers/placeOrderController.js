app.controller('PlaceOrderController', function($scope, $rootScope, $location, $stateParams, $state, $http, $timeout, PlaceOrderService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.sector = {};
    $scope.sectorList = [];
    $scope.showForm = false;
    $scope.editObj = {};
    $scope.sectorId = $stateParams.sectorId;

    $scope.init = function() {
        /*if($scope.sectorId){
            PlaceOrderService.getSectorById.query({}, {sectorId: $scope.sectorId}).$promise.then(function(result) {
                $scope.sector = result;
                $scope.edit($scope.sector);
            });
        }
        PlaceOrderService.getAllSector.query({}, {}).$promise.then(function(result) {
            $scope.sectorList = result;
        });*/
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
        $scope.editObj = {};
        $scope.reset();
        $scope.showForm = true;
    };

    $scope.cancel = function(){
        if($scope.sectorId){
            $state.go("setupmenu.subSector");
        }
        $scope.reset();
        $scope.showForm = false;
    };

    $scope.init();

});