angular.module('app',['ngStorage']).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/sb';

    $scope.loadPage = function (page) {
        $http({
            url: contextPath + '/api/v1/users',
            method: 'GET',
            params: {
                p: page,
            }
        }).then(function (response) {
            $scope.usersPage = response.data;
            console.log($scope.usersPage);

            let minPageIndex = page - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = page + 2;
            if (maxPageIndex > $scope.usersPage.totalPages) {
                maxPageIndex = $scope.usersPage.totalPages;
            }

            $scope.paginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
             console.log("PAGE FROM BACKEND")

        });
    };


    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadPage(1);
});