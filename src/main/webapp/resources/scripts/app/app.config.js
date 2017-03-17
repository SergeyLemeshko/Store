angular.
	module('storeApp', ['ui.router', 'categoryList','brandList']).
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
			}
	);

