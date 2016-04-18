app.service('TableSetupService', function ($resource) {
    return {

        getAll : $resource('rest/tableSetup/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getAllForSelect : $resource('rest/tableSetup/getAllForSelect', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        save: $resource('rest/tableSetup/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/tableSetup/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});