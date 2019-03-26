var app = angular.module('payment', []);
app.controller('PaymentController', ['$http', '$scope', function ($http, $scope) {
    var payment = this;
    payment.paymentModel = {id: null, paymentDate: '', paymentBy: '', paymentMoney: '', cratedBy: ''};
    payment.userList = [];
    getUserList();
    payment.savePayment = function (payment) {
        console.log(payment);
    }

    function getUserList() {
        alert("Hello");
        $http.get('/getUserList').success(function (d) {
            console.log(d);
            payment.userList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }
}]);
