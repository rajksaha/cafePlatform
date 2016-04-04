app.service('UserSetupService', function ($resource) {
    return {

        getAll : $resource('rest/userSetup/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),

        save: $resource('rest/userSetup/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/userSetup/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});