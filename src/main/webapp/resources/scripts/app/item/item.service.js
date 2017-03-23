angular.
	module('storeApp.item',['ngResource']).
		factory('Items', function($resource){
		return $resource("category/:categoryId/brand/:brandId",{categoryId:'@categoryId', brandId:'@brandId'}, {
				query:{
					method:'GET'
				}
			});
	});