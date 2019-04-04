var app = angular.module('payment', []);
app.controller('PaymentController', ['$http', '$scope', function ($http, $scope) {
    var payment = this;
    payment.paymentModel = {id: null, paymentDate: new Date(), paymentBy: '', paymentMoney: ''};
    payment.userList = [];
    payment.memberList =[];
    getUserList();
    memberList();

    function memberList() {
        $http.get('/memberList').success(function (d) {
            console.log(d);
            payment.memberList=d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    };

    payment.savePayment = function (payment) {
        console.log("Pay" + payment);
        console.log("test" + payment.paymentBy);
        $http.post('/savePayment', payment).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            getUserList();
            memberList();
            reset();
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {
            }
        });
    }

    function getUserList() {
        $http.get('/getUserList').success(function (d) {
            console.log(d);
            payment.userList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }
    function reset() {
        payment.paymentModel = {id: null, paymentDate: new Date(), paymentBy: '', paymentMoney: ''};
    }
}]);
