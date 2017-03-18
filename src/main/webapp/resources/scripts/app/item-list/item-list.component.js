angular.
	module('itemList', ['ui.router']).
	component('itemList', {
		templateUrl:"resources/scripts/app/item-list/item_list_template.html",
		controller: function ItemListController($stateParams, $http) {
			
			var self = this;
			$http.get('category/' + $stateParams.category + '/brand/' + $stateParams.brand).then(function successCallback(response) {
				self.items = response.data.items;
				self.description = response.data.description;
			});
		}
	});