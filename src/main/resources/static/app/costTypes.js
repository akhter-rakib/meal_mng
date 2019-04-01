var app = angular.module('costingTypesEntry', []);
app.controller('CostingTypesController', ['$http', '$scope', function ($http, $scope) {
    var costingTypesEntry = this;
    costingTypesEntry.costingTypesModel = {
        id: '',
        costingName: ''
    };


    costingTypesEntry.saveCostingTypes = function (costingTypes) {
        console.log(costingTypes);
        $http.post('/saveCostingTypes', costingTypes).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            //getUserList();
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
