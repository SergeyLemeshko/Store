angular.
	module('brandList').
	component('brandList', {
		templateUrl:"resources/scripts/app/brand-list/brand_list_template.html",
		controller: function BrandListController($routeParams, $http) {
			
			var self = this;
			$http.get('category/' + $routeParams.category).then(function successCallback(response) {
				self.brands = response.data.brands;
			});
		}
	});