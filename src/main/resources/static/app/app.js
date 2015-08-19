(function() {
	var app = angular.module('foodStore', ['store-directives']);

	app.controller('StoreController',['$http', function($http){
	    var store = this;
	    store.products = [];
	    
		
	    $http.get('/products').success(function(data){
	        store.products=data;
		    
	    });   
	}]);
	app.controller('ReviewController',['$http', function($http){
		
		this.review = {};
		
	    this.addReview = function(product) {
	    	
	    	this.review.productId=product.id;
	    		
		    $http.post('/reviews',this.review).success(function(data, status, headers, config) {
		    	
		    	this.review = {};
		    	    
		    }).
		    error(function(data, status, headers, config) {
		    	
		    });
   	
	    };
	}]);
})();