app.controller('ReportSetupController', function($scope, $rootScope, $location, $stateParams, $state, $http, $timeout, ReportSetupService, $modal) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.userData = {};
    $scope.userDataList = [];
    $scope.showForm = false;
    $scope.editObj = {};

    //reloading the grid
    $scope.reloadList = false;
    $scope.refreshList = function () {
        $scope.reloadList = !$scope.reloadList;
        $scope.getData.dataSourceConfig.params.refresh = $scope.reloadList;
    };

    $scope.searchData = {};
    $scope.search = function() {
        //$scope.getData($scope.searchData);
        //$scope.dataSourceConfig.params = angular.copy($scope.searchData);

        ReportSetupService.getAll.query({}, $scope.searchData ).$promise.then(function(result) {
            $scope.mainOrderList = result;
        });
    };

    // column definition
    $scope.columnDefinition = [
        {columnHeaderDisplayName: 'SL', displayProperty: 'serial', width: '4em'},
        {columnHeaderDisplayName: 'Date', displayProperty: 'date | date:"dd/MM/yy"', sortKey: 'date'},
        {columnHeaderDisplayName: 'Time', displayProperty: 'time | time:"h:m"', sortKey: 'time'},
        {columnHeaderDisplayName: 'Net Amount', displayProperty: 'netAmount ', sortKey: 'netAmount'},
        {columnHeaderDisplayName: 'Sub Total', displayProperty: 'subtotal', sortKey: 'subtotal'},
        {columnHeaderDisplayName: 'Total', displayProperty: 'total', sortKey: 'total'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '30em'}
    ];

    //datasource configuration

    $scope.init = function() {


    };

/*    $scope.dataSourceConfig = {
        url: 'rest/orderController/getOrderReport',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };*/



/*    $scope.save = function(userData) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            UserSetupService.save.query({}, userData ).$promise.then(function(result) {
                $scope.showSuccessMessage("Information updated successfully");
                $scope.loadData();
            });
        }
    };

    $scope.update = function(userData){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            UserSetupService.update.query({}, userData ).$promise.then(function(result) {
                $scope.showSuccessMessage("Information updated successfully");
                $scope.loadData();
            });
        }
    };*/

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


    $scope.edit = function(mainOrder){

        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/SubOrderModal.html',
            controller: 'ReportSetupController.SubOrderDetailController',
            backdrop: "static",
            windowClass: 'fade in ',
            resolve: {
                modalConfig: function () {
                    return mainOrder;
                }
            }
        });
        modalInstance.result.then(function(result) {
            $scope.showSuccessMessage("Information updated successfully");
            $scope.init();
        });

    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.userData);
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

app.controller('ReportSetupController.SubOrderDetailController', function($scope, $modalInstance, $timeout, $filter, modalConfig) {

    $scope.mainOrder = modalConfig;


    $scope.close = function (){
        $modalInstance.dismiss('cancel');
    };


});