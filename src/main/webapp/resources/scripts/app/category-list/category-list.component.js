angular.
	module('categoryList', ['ui.router']).
	component('categoryList', {
		templateUrl:"resources/scripts/app/category-list/categories_template.html",
		controller: function CategoryListController($http, $stateParams) {
			
			var self = this;
					
			$http({
				method:'GET',
				url:requestContextPath + '/category'
			}).then(function successCallback(response) {
				self.categories = response.data.categories;
			})
		}
	});