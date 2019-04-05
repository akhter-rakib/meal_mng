var app = angular.module('costingTypesEntry', []);
app.controller('CostingTypesController', ['$http', '$scope', function ($http, $scope) {
    var costingTypesEntry = this;
    costingTypesEntry.costingTypesList = [];
    costingTypesEntry.costingTypesModel = {
        id: '',
        costingName: ''
    };
    costingTypesList();

    function costingTypesList() {
        $http.get('/getCostTypes').success(function (d) {
            console.log(d);
            costingTypesEntry.costingTypesList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    };

    costingTypesEntry.saveCostingTypes = function (costingTypes) {
        console.log(costingTypes);
        $http.post('/saveCostingTypes', costingTypes).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            //getUserList();
            costingTypesList();
            reset();
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {
            }
        });
    }

    function reset() {
        costingTypesEntry.costingTypesModel = {id: '', costingName: ''};
    }

}]);
