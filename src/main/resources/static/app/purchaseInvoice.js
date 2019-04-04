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
    purchaseInvoice.purchaseList =[];
    getUserList();
    getCostTypesList();
    purchaseList();

    function purchaseList() {
        $http.get('/purchaseList').success(function (d) {
            console.log(d);
            purchaseInvoice.purchaseList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    };


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
            purchaseList();
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
            purchaseInvoice.userList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }
    function reset() {
        purchaseInvoice.purchaseInvoiceModel = {
            id: null,
            marketBy: '',
            markedDate: new Date(),
            costTypes: '',
            createdOn: '',
            totalCost: ''
        };
    }
}]);
