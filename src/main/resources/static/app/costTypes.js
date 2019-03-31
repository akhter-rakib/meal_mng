var app = angular.module('costingTypesEntry', []);
app.controller('CostingTypesController', ['$http', '$scope', function ($http, $scope) {
    var costingTypesEntry = this;
    costingTypesEntry.costingTypesModel = {
        id: null,
        costing_name: ''
    };


    costingTypesEntry.saveCostingTypes = function (costingTypes) {
        console.log(costingTypes);
        $http.post('/saveCostingTypes', costingTypes).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            //getUserList();
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {
            }
        });
    }

}]);
