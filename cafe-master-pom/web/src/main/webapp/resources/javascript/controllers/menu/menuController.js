/**
 * Created by raj on 1/6/16.
 */

app.controller('MenuController', function($scope, $state, $rootScope, $http, $timeout, $location) {

    $scope.isCollapse = [];

    $scope.requestForLogin = function(){
        $state.go('home');
    };

    $scope.menuItem = "";

    $scope.showMenu = function(index){
        $scope.isCollapse[index] = !$scope.isCollapse[index];
    };

    $scope.initMenu = function(stateName) {
        try{
            //stateName = stateName.split('.')[1];
            if($('a[href$="'+stateName+'"]') && $('a[href$="'+stateName+'"]').length > 0) {
                $('a[href$="'+stateName+'"]').addClass('bfpb-active');
                var angularAttr = $('a[href$="'+stateName+'"]').parent().attr('data-ng-show');
                var menuNumber = parseInt(angularAttr.substr(angularAttr.indexOf('[') + 1, angularAttr.length + 1 - angularAttr.indexOf(']')));
                $scope.showMenu(menuNumber);
            }
        } catch(e){
            console.error("Unable to expand left menu --> from menuController.js")
        }
    };

    $rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams) {
        $rootScope.$emit('event:clearStatus');
        window.scrollTo(1, 1);
        var stateName = toState.name;
        if(stateName.indexOf('.') > 0) {
            //add active class
            stateName = stateName.split('.')[1];
            if($('a[href$="'+stateName+'"]') && $('a[href$="'+stateName+'"]').length > 0) {
                $('.bfpb-active').removeClass('bfpb-active');
                $('a[href$="'+stateName+'"]').addClass('bfpb-active');

                $scope.isCollapse = [];
                $scope.initMenu(stateName);
            }
        }
        $("html, body").animate({ scrollTop: 0 }, "fast");
    });

    $scope.initMenu($location.path());
});
