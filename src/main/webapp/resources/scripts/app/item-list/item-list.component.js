angular.
	module('itemList', ['ui.router']).
	component('itemList', {
		templateUrl:"resources/scripts/app/item-list/item_list_template.html",
		controller: function ItemListController($stateParams, $http, $scope) {
			
			$http.get('category/' + $stateParams.category + '/brand/' + $stateParams.brand).then(function successCallback(response) {
				$scope.items = response.data.items;
				$scope.description = response.data.description;
			});
			
			$scope.setCurrentItem = function(item) {
				$scope.currentItem = item;
			}
		}
	});