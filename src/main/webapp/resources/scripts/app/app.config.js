angular.
	module('storeApp', ['ui.router', 'categoryList','brandList', 'itemList']).
		config(function config($stateProvider, $urlRouterProvider) {
			
				$urlRouterProvider.otherwise('/');
				
				$stateProvider
					.state('category', {
						url:"/",
						views:{
							'category': {
								template:'<category-list></category-list>'
							}
						}
					})
					.state('category.brand', {
						url:"category/:category",
						views:{
							'brand@':{
								template:'<brand-list></brand-list>'
							}
						}
				    })
				    .state('category.brand.item', {
				    	url:"/brand/:brand",
				    	views:{
				    		'item@':{
				    			template:'<item-list></item-list>'
				    		}
				    	}
				    })
				    
			}
	);

