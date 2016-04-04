app.service('PlaceOrderService', function ($resource) {
    return {

        getAll : $resource('rest/division/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),

        save: $resource('rest/division/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/division/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});