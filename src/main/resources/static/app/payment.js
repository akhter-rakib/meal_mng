var app = angular.module('payment', []);
app.controller('PaymentController', ['$http', '$scope', function ($http, $scope) {
    var payment = this;
    payment.paymentModel = {id: null, paymentDate: '', paymentBy: '', paymentMoney: '', cratedBy: ''};

    payment.opps = function () {
        
    }
}]);
