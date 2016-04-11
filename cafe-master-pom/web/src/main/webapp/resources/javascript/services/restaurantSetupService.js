app.service('RestaurantSetupService', function ($resource) {
    return {

        getAll : $resource('rest/restaurant/getAll', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),

        save: $resource('rest/restaurant/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        update : $resource('rest/restaurant/update', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        })
    };
});