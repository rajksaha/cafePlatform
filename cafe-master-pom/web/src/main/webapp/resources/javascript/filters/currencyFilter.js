'use strict';

//produces in format nn,nn,nnn,nn,nn,nn,nnn.n......
app.filter('bdtCurrency', ['$filter', function ($filter) {
    return function (input) {
        if (input) {
            input = input.toString();
            var result = "";
            var befDec = "";
            if(input.indexOf(".") >= 0) {
                result = input.substr(input.indexOf("."), input.length);
                befDec = input.substr(0, input.indexOf("."));
            } else {
                befDec = input;
            }

            var length = 7;
            var startIndex = befDec.length - 7;
            if(startIndex < 0) {
                startIndex = 0; length = befDec.length;
            }
            var toBreak = false;
            do{
                if(startIndex == 0) toBreak = true;
                var tempStr = befDec.substr(startIndex, length);
                if(tempStr.length > 3) {
                    result = tempStr.substr(0, tempStr.length - 3).replace(/\B(?=(\d{2})+(?!\d))/g, ",") + "," +
                        tempStr.substr(tempStr.length - 3, tempStr.length) + result;
                } else {
                    result = tempStr + result;
                }
                if(startIndex - 7 < 0) {
                    length = startIndex;
                    startIndex = 0;
                } else {
                    startIndex -= 7;
                    length = 7;
                }
                if(!toBreak) {
                    result = "," + result;
                }

            } while(!toBreak);

            return result;
        } else {
            return '0';
        }
    };
}]);