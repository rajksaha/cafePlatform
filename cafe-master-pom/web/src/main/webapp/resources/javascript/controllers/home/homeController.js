app.controller('HomeController', function($scope, $state, $http, $timeout, $location) {
	

    $scope.requestForLogin = function(){
        $state.go();

    };
}); 