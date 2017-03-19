angular.
	module('categoryList', ['ui.router']).
	component('categoryList', {
		templateUrl:"resources/scripts/app/category-list/categories_template.html",
		controller: function CategoryListController($http, $stateParams, $scope) {
			
			$http.get('category/').then(function successCallback(response) {
				$scope.categories = response.data.categories;
			})
		}
	});