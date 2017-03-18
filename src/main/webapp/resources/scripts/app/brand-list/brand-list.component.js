angular.
	module('brandList', ['ui.router']).
	component('brandList', {
		templateUrl:"resources/scripts/app/brand-list/brand_list_template.html",
		controller: function BrandListController($stateParams, $http) {
			
			var self = this;
			self.category = $stateParams.category;
			$http.get('category/' + $stateParams.category).then(function successCallback(response) {
				self.brands = response.data.brands;
			});
		}
	});