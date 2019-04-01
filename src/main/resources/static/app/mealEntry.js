var app = angular.module('mealEntry', []);
app.controller('MealEntryController', ['$http', '$scope', function ($http, $scope) {
    var mealEntry = this;
    mealEntry.mealModel = {id: null, meal_date: new Date(), member: '', quantity: ''};

    mealEntry.userList = [];
    getUserList();

    mealEntry.saveMeal = function (meal) {
        console.log(meal);
        $http.post('/saveMeal', meal).success(function (d) {
            /* self.success = 'Unit name successfully added in system !!!!';
             self.error = null;*/
            getUserList();
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
            mealEntry.userList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    }
    function reset() {
        mealEntry.mealModel = {id: null, meal_date: new Date(), member: '', quantity: ''};
    }
}]);
