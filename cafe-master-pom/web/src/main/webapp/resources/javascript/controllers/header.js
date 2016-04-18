/**
 * Created by raj on 1/6/16.
 */
app.controller('HeaderController', function($scope, $rootScope,$state, $location, $timeout, $modal, $http,AuthenticationService) {

    $scope.logout = function () {
        AuthenticationService.logout().then(function() {
            $rootScope.userData = {};
            $location.path('/login');
            $scope.$emit('event:clearStatus');
        });
    };

    $scope.home = function () {

        $location.path('/home');
        $scope.$emit('event:clearStatus');
    };


    $rootScope.$on('event:logout', function() {
        $scope.logout();
    });

});