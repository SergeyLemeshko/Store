angular.
	module('brandList', ['ui.router']).
	component('brandList', {
		templateUrl:"resources/scripts/app/brand-list/brand_list_template.html",
		controller: function BrandListController($stateParams, $http, $scope) {
			
			$scope.category = $stateParams.category;
			$http.get('category/' + $stateParams.category).then(function successCallback(response) {
				$scope.brands = response.data.brands;
			});
		}
	});