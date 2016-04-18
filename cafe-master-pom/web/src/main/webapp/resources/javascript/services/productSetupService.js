app.service('ProductSetupService', function ($resource) {
    return {

        getAll : $resource('rest/productSetup/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getProductForTypeHead : $resource('rest/productSetup/getProductForTypeHead/data/:data', {}, {
            'query':  {
                method:'GET',
                params: {data : '@data'},
                isArray:true
            }
        }),
        save: $resource('rest/productSetup/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/productSetup/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});