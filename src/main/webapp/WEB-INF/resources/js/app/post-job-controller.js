var iBossJobPostApp = angular.module('iBossJobPostApp',[]);

iBossJobPostApp.controller('PostJobCtrlJS', ['$scope', 'JobCategoryService', function($scope, JobCategoryService) {
  
  $scope.postjob = {
    CatId:'', 
    SubCatId: '',
    SkillId: []
  };
    
  $scope.getSubCategory = function(){
	 $('ul.chosen-results').empty();	
  	 JobCategoryService.getSubCategory($scope.postjob.CatId).then(function(data) {
  		 if (typeof data !== 'undefined' && data.length > 1){
	  		$scope.subcatetries = data;
	  		$scope.postjob.SubCatId = data[0].id;
  		 } else {
  			$scope.subcatetries = [];
  		 }
  	 }, function(error) {
  		$scope.subcatetries = [];
     });
  };
  
  $scope.searchSkill = function(){
	  	 JobCategoryService.searchSkill($scope.postjob.SubCatId).then(function(data) {
	  		 if (typeof data !== 'undefined' && data.length > 1){
		  		$scope.skills = data;
		  		$scope.postjob.SkillId = data[0].id;
	  		 } else {
	  			$scope.skills = [];
	  		 }
	  	 }, function(error) {
	  		$scope.skills = [];
	     });
  };
  
//  $scope.submitForm = function(isValid) {
//
//    // check to make sure the form is completely valid
//    if (isValid) {
//      alert('our form is amazing');
//    }
//
//  };
}]);

iBossJobPostApp.factory("JobCategoryService", ['$filter', '$http', function($filter, $http){
  
  var service = {};
  
  service.getSubCategory = function(categoryId){
	  var subcategorylist;
	  if ( !subcategorylist ) {		  	
		  subcategorylist = $http({
			  method: 'GET',
			  url: 'api/get_subcategories?cId='+categoryId
		    }).then(function successCallback(data, status, headers, config) {	 
			      return ($filter('filter')(data.data.result, {categoryId: categoryId}));
			}, function errorCallback(response) {
			      console.info(response);
			});
	  }
	  return subcategorylist;
  };
  
  service.searchSkill = function(subCategoryId){
	  var skilllist;
	  console.info(subCategoryId);
	  if ( !skilllist ) {		  	
		  skilllist = $http({
			  method: 'GET',
			  url: 'api/search_cat_skills?scId=' + subCategoryId
		    }).then(function successCallback(data, status, headers, config) {	 
			      return data.data.result;
			}, function errorCallback(response) {
			      return [];
			});
	  }
	  return skilllist;
  };
  
  return service;
  
  
}]);
