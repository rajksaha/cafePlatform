'use strict';

var httpHeaders;

var jsVersion = "?v=001";

// This will store the original URL before login sequence
var originalLocation = "/home";

app.config(function($stateProvider, $urlRouterProvider, $compileProvider, $controllerProvider, $filterProvider, $provide, $ocLazyLoadProvider, datepickerConfig, datepickerPopupConfig) {


    // For any unmatched url, redirect to /login
    $urlRouterProvider.otherwise("/login");
    
    // datepicker hide week
    datepickerConfig.showWeeks = false;


    var root = {
        name : 'root',
        url : '',
        abstract : true,
        views : {
            'header' : {
                templateUrl : 'resources/javascript/templates/header.html',
                controller : 'HeaderController'
            },
            'status' : {
                templateUrl : 'resources/javascript/templates/status.html',
                controller : 'MenuController'
            },
            'menu' : {
                templateUrl : 'resources/javascript/templates/menu/menu.html',
                controller : 'MenuController'
            },
            'footer' : {
                templateUrl : 'resources/javascript/templates/footer.html',
                controller : 'FooterController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/footer.js'  + jsVersion,
                            'resources/javascript/controllers/header.js'  + jsVersion,
                            'resources/javascript/controllers/menu/menuController.js'  + jsVersion
                        ]
                    });
            }]
        }
    };

    var login = {
        name : 'login',
        url : '/login',
        views : {
            'header' : {
                templateUrl : 'resources/javascript/templates/header.html',
                controller : 'HeaderController'
            },
            'container@' : {
                templateUrl : 'resources/javascript/templates/login/login.html',
                controller : 'LoginController'
            },
            'footer' : {
                templateUrl : 'resources/javascript/templates/footer.html',
                controller : 'FooterController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
              // you can lazy load files for an existing module
              return $ocLazyLoad.load(
                {
                  name: 'bfpbApp',
                  files: [
                      'resources/javascript/controllers/login/loginController.js' + jsVersion,
                      'resources/javascript/controllers/footer.js'  + jsVersion,
                      'resources/javascript/controllers/header.js'  + jsVersion
                  ]
                });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                        ]
                    });
            }]
        }
    };

    var home = {
        name : 'root.home',
        url : '/home',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/home/home.html',
                controller : 'HomeController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                // you can lazy load files for an existing module
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/home/homeController.js' + jsVersion
                        ]
                    });
            }]
        }
    };


    var forgetPassword = {
        name : 'forgetPassword',
        url : '/forgetPassword',
        views : {
            'header' : {
                templateUrl : 'resources/javascript/templates/header.html',
                controller : 'HeaderController'
            },
            'container@' : {
                templateUrl : 'resources/javascript/templates/user/forgetPassword.html',
                controller : 'ForgetPasswordController'
            },
            'footer' : {
                templateUrl : 'resources/javascript/templates/footer.html',
                controller : 'FooterController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                // you can lazy load files for an existing module
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/user/forgetPasswordController.js' + jsVersion,
                            'resources/javascript/controllers/footer.js'  + jsVersion,
                            'resources/javascript/controllers/header.js'  + jsVersion,
                            'resources/javascript/services/user/userService.js'  + jsVersion
                        ]
                    });
            }]
        }
    };

    var division = {
        name  : 'root.division',
        url   : '/division',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/division/division.html',
                controller : 'DivisionController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/division/divisionController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/division/divisionService.js' + jsVersion
                        ]
                    });
            }]
        }
    };

    var restaurantSetup = {
        name  : 'root.restaurantSetup',
        url   : '/restaurantSetup',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/restaurantSetup.html',
                controller : 'RestaurantSetupController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/restaurantSetupController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/restaurantSetupService.js' + jsVersion
                        ]
                    });
            }]
        }
    };
    
    var placeOrder = {
            name  : 'root.placeOrder',
            url   : '/placeOrder',
            views : {
                'container@' : {
                    templateUrl : 'resources/javascript/templates/placeOrder/placeOrder.html',
                    controller : 'PlaceOrderController'
                }
            },
            resolve : {
                loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load(
                        {
                            name: 'bfpbApp',
                            files: [
                                'resources/javascript/controllers/placeOrderController.js' + jsVersion
                            ]
                        });
                }],
                loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                    return $ocLazyLoad.load(
                        {
                            name: 'bfpbApp',
                            files: [
                                'resources/javascript/services/placeOrderService.js' + jsVersion, 'resources/javascript/services/productSetupService.js' + jsVersion,
                                'resources/javascript/services/tableSetupService.js' + jsVersion, 'resources/javascript/services/userSetupService.js' + jsVersion,
                                'resources/javascript/services/restaurantSetupService.js' + jsVersion
                            ]
                        });
                }]
            }
        };

    var userSetup = {
        name  : 'root.userSetup',
        url   : '/userSetup',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/userSetup.html',
                controller : 'UserSetupController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/userSetupController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/userSetupService.js' + jsVersion, 'resources/javascript/services/restaurantSetupService.js' + jsVersion
                        ]
                    });
            }]
        }
    };

    var productSetup = {
        name  : 'root.productSetup',
        url   : '/productSetup',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/productSetup.html',
                controller : 'ProductSetupController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/productSetupController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/productSetupService.js' + jsVersion, 'resources/javascript/services/restaurantSetupService.js' + jsVersion

                        ]
                    });
            }]
        }
    };

    var tableSetup = {
        name  : 'root.tableSetup',
        url   : '/tableSetup',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/tableSetup.html',
                controller : 'TableSetupController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/tableSetupController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/tableSetupService.js' + jsVersion, 'resources/javascript/services/restaurantSetupService.js' + jsVersion
                        ]
                    });
            }]
        }
    };

    var reportSetup = {
        name  : 'root.reportSetup',
        url   : '/reportSetup',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/reportSetup.html',
                controller : 'ReportSetupController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/reportSetupController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/reportSetupService.js' + jsVersion
                        ]
                    });
            }]
        }
    };

    var tableStatus = {
        name  : 'root.tableStatus',
        url   : '/tableStatus',
        views : {
            'container@' : {
                templateUrl : 'resources/javascript/templates/tableStatus.html',
                controller : 'TableStatusController'
            }
        },
        resolve : {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/controllers/tableStatusController.js' + jsVersion
                        ]
                    });
            }],
            loadMyService: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load(
                    {
                        name: 'bfpbApp',
                        files: [
                            'resources/javascript/services/reportSetupService.js' + jsVersion
                        ]
                    });
            }]
        }
    };

    $stateProvider
        .state(root)
        .state(login)
        .state(home)
        .state(forgetPassword)
        .state(division)
        .state(restaurantSetup)
        .state(userSetup)
        .state(productSetup)
        .state(placeOrder)
        .state(tableSetup)
        .state(reportSetup)
        .state(tableStatus);

    //set debug:true if need ocLazyLoad log
	$ocLazyLoadProvider.config({debug:false, events:true});
	
});

app.config(function ($httpProvider) {
    //configure $http to view a login whenever a 401 unauthorized response arrives
    //$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.responseInterceptors.push(function ($rootScope, $q) {
        return function (promise) {
            return promise.then(
                //success -> don't intercept
                function (response) {
                    return response;
                },
                //error -> if 401 save the request and broadcast an event
                function (response) {

                    if (response.status === 401) {
                        // Set the message why is unauthorized
                        $rootScope.warn = true;
                        $rootScope.warnMessage = response.data.message;

                        var deferred = $q.defer(),
                            req = {
                                config: response.config,
                                deferred: deferred
                            };
                        $rootScope.requests401.push(req);
                        //Hide and remove all open dialog.
                        $('.modal-backdrop').hide();
                        $(".modal").remove();
                        $rootScope.$broadcast('event:loginRequired');
                        return deferred.promise;
                    }
                    if (response.status === 403) {
                        // Set the message why is forbidden
                        $rootScope.warn = true;
                        $rootScope.warnMessage = response.data.message;

                        var deferred = $q.defer(),
                            req = {
                                config: response.config,
                                deferred: deferred
                            };
                        //Hide and remove all open dialog.
                        $('.modal-backdrop').hide();
                        $(".modal").remove();
                        return deferred.promise;
                    }
                    return $q.reject(response);
                }
            );
        };
    });
    httpHeaders = $httpProvider.defaults.headers;
});
