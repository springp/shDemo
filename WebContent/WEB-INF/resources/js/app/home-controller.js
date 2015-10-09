var myApp = angular.module('myApp',[]);

myApp.controller('JobCategoryCtrlJS', ['$scope', 'JobCategoryService', function($scope, JobCategoryService) {
  
  $scope.jobcetegory = {
  	Test:'', 
    Name:'', 
    SubCatName: ''
  };
  
  $scope.catetries = JobCategoryService.getCategory();
    
  $scope.getSubCategory = function(){
  	$scope.subcatetries = JobCategoryService.getSubCategory($scope.jobcetegory.Name);
  	console.info($scope.subcatetries);
  }
  
 
}]);

myApp.factory("JobCategoryService", ['$filter', function($filter, $http){
  
  
  var service = {};
  
  
  var categorylist = [
            { "id": 1, "category": "USA" },
            { "id": 2, "category": "Canada" },
            { "id": 3, "category": "India" },
  ];
  
  var subcategorylist = [
    {"id":1, "subcategory":"Alaska", "categoryId": 1},
    {"id":2, "subcategory":"California", "categoryId": 1},
    {"id":3, "subcategory":"New York", "categoryId": 1},
    {"id":4, "subcategory":"New Brunswick", "categoryId": 2},
    {"id":5, "subcategory":"Manitoba", "categoryId": 2},
    {"id":6, "subcategory":"Delhi", "categoryId": 3},
    {"id":7, "subcategory":"Bombay", "categoryId": 3},
    {"id":8, "subcategory":"Calcutta", "categoryId": 3}
  ];
   
  service.getCategory = function(){    
  	return categorylist;
  };
  
  service.getSubCategory = function(cetegoryName){
  	console.info(cetegoryName);
  	
  	$http({
	  method: 'GET',
	  url: '/api/list_subcategory?cId=1'
    }).then(function successCallback(response) {
	      console.info(response);
	}, function errorCallback(response) {
	      console.info(response);
	});
  
  	
    var subcategory = ($filter('filter')(subcategorylist, {categoryId: cetegoryName}));    
    return subcategory;
  };
  
  return service;
  
  
}]);
