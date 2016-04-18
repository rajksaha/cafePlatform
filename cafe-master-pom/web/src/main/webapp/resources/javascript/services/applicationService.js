/**
 * Created by raj on 1/6/16.
 */

app.service('ApplicationService', function ($resource) {
    return {

        getAppData : $resource('rest/application/data', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        checkAuthentication : $resource('rest/application/checkAuthentication/userName/:userName/password/:password', {}, {
            'query':  {
                method:'GET',
                params: {userName : '@userName', password : '@password'},
                isArray:false
            }
        }),

    };
});