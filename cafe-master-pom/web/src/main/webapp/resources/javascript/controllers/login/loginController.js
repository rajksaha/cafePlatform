app.controller('LoginController', function($scope,$rootScope, $state, $http, $timeout, $location,ApplicationService) {

    $scope.credentials = {};
    $scope.login = function () {
        if(validator.validateForm("#loginFormID",".validatorMsg",null)) {
            $scope.$emit('event:loginRequest', $scope.credentials.username, $scope.credentials.password, function() {
                ApplicationService.getAppData.query().$promise.then(function(result) {
                    $rootScope.userData = result.userData;
                    $state.go('root.home');
                });
            });
        }

    };



    $scope.requestForLogin = function(){
        $rootScope.$broadcast('event:loginRequired');
    };

    $scope.forgetPassword = function(){
        $state.go('forgetPassword');
    };

    if($rootScope.suser && $rootScope.suser.userProfileId && $rootScope.suser.userProfileId > 0){
        $state.go('root.home');
    }

}); 