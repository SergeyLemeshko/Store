angular.
	module('storeApp').
	config(function config($locationProvider, $routeProvider) {
		
			$locationProvider.hashPrefix('!');
			
			$routeProvider.
			when('/category/:category', {
				template:'<brand-list></brand-list>'
			}).
			otherwise('/');
		}
	);