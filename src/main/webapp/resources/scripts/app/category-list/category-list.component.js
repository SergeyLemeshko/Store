angular.
	module('categoryList').
	component('categoryList', {
		templateUrl:"resources/scripts/app/category-list/categories_template.html",
		controller: function CategoryListController($http, $routeParams) {
			
			var self = this;
			
			$http({
				method:'GET',
				url:requestContextPath + '/category'
			}).then(function successCallback(response) {
				self.categories = response.data.categories;
			})
		}
	});