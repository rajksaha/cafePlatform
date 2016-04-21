app.service('PlaceOrderService', function ($resource) {
    return {

        getAll : $resource('rest/orderController/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),

        save: $resource('rest/orderController/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/orderController/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});