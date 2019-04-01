var app = angular.module('purchaseInvoice', []);
app.controller('PurchaseInvoiceController', ['$http', '$scope', function ($http, $scope) {
    var purchaseInvoice = this;
    purchaseInvoice.purchaseInvoiceModel = {
        id: null,
        marketBy: '',
        markedDate: new Date(),
        costTypes: '',
        createdOn: '',
        totalCost: ''
    };
    purchaseInvoice.userList = [];
    purchaseInvoice.costTypeList = [];
    getUserList();
    getCostTypesList();

    function getCostTypesList() {
        $http.get('/getCostTypes').success(function (d) {
            console.log(d);
            purchaseInvoice.costTypeList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }

    purchaseInvoice.savePurchaseInvoice = function (purchaseInvoice) {
        console.log(purchaseInvoice);
        $http.post('/savePurchaseInvoice', purchaseInvoice).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            getUserList();
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {
            }
        });
    }

    function getUserList() {
        $http.get('/getUserList').success(function (d) {
            console.log(d);
            purchaseInvoice.userList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }
}]);
