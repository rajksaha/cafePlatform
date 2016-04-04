app.controller('LoginController', function($scope,$rootScope, $state, $http, $timeout, $location,ApplicationService) {

    $scope.credentials = {};
    $scope.login = function () {
        if(validator.validateForm("#loginFormID",".validatorMsg",null)) {
            $scope.$emit('event:loginRequest', $scope.credentials.username, $scope.credentials.password, function() {
                ApplicationService.getAppData.query().$promise.then(function(result) {
                    $rootScope.suser = result.user;
                    $rootScope.entityType = result.entityType;
                    $state.go('root.home');
                });
            });
        }
        //$state.go('root.home');
    };

    $scope.requestForLogin = function(){
        $rootScope.$broadcast('event:loginRequired');
    };

    $scope.forgetPassword = function(){
        $state.go('forgetPassword');
    };


}); 