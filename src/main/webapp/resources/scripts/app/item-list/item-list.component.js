angular.
	module('itemList', ['ui.router', 'storeApp.item']).
	component('itemList', {
		templateUrl:"resources/scripts/app/item-list/item_list_template.html",
		controller: function ($stateParams, $http, Items) {
			
			var self = this;
			
			Items.query({categoryId:$stateParams.category, brandId:$stateParams.brand}, function(data){
				self.items = data.items;
				self.description = data.description;
			});
	
			
			self.setCurrentItem = function(item) {
				this.currentItem = item;
			}
		}
	});