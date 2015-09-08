<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<%= request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet"></link>
	<link href="<%= request.getContextPath()%>/resources/css/app.css" rel="stylesheet"></link>
	<script src="<%= request.getContextPath()%>/resources/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/ekko-lightbox.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/angular.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

<div class="generic-container">
	<div data-ng-app="myApp" data-ng-controller="app">
	 	 <%--  <div data-ng-init='userList = ${userList}'></div> --%>
			<form >
	 	 		 <label>Search: <input data-ng-model="firstName" placeholder="first Name"> <input data-ng-model="lastName" placeholder="Last Name"><input data-ng-model="email" placeholder="Email"></label>
	 	 		 <button class="btn btn-success" data-ng-click="searchData()">Search</button>
			</form>
			<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
		      			<th>Id</th>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>SSO ID</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
					<tr data-ng-repeat='user in userList'>
						<td>{{user.id}}</td>
						<td>{{user.firstName}}</td>
						<td>{{user.lastName}}</td>
						<td>{{user.email}}</td>
						<td>{{user.ssoId}}</td>
						<sec:authorize access="hasRole('ROLE_SUPERADMIN')">
							<td><a href="<c:url value='/edit-user-{{user.ssoId}}' />" class="btn btn-success custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-user-{{user.ssoId}}' />" class="btn btn-danger custom-width">delete</a></td>
						</sec:authorize>
					</tr>
	    		</tbody>
	    	</table>
		</div>
	</div>
	<script>
	angular.module('myApp', []).controller('app', function($scope,$http) {   
	    	$http.get("<%= request.getContextPath()%>/getList")
		    .success(function (data, status, headers, config) {
		        $scope.userList=angular.fromJson(angular.toJson(data,null));
		    })
		    .error(function (data, status, headers, config) {
		         alert("Dang It!"+status);
		    });
	    	
	     	$scope.searchData = function() {	    	
		    	var config={
		    		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		    	};
	    	
	    		$http.post("<%= request.getContextPath()%>/searchData", {firstName:$scope.firstName, lastName:$scope.lastName, email:$scope.email})
	    	    .success(function (data, status, headers, config) {
	    	        $scope.userList=angular.fromJson(angular.toJson(data,null));
	    	    })
	    	    .error(function (data, status, headers, config) {
	    	         alert("Dang It!"+status);
	    	     });
	     	}
	  	    $scope.edit = true;
	  	    $scope.incomplete = true;
	});
	</script>
 	<div class="well"> 	
 		<a class="btn btn-info" href="<c:url value='/newuser' />">Add New User</a>&nbsp;
 		<a class="btn btn-info" href="<c:url value="/logout" />" > Logout</a>&nbsp;
 		<a class="btn btn-info" href="#" onclick="return downloadPDF();">PDF</a>&nbsp;
 		<a href="<%= request.getContextPath()%>/resources/img/Penguins.jpg"
        				data-toggle="lightbox"
        				data-type="image"
        				data-title="Penguins" 
        				title="Penguins" class="zoom" >
        				<img alt="" src="<%= request.getContextPath()%>/resources/img/Penguins.jpg" width="50px" height="50px" onclick="return false;">			
        				 <span class="overlay"></span>
        			</a> 
 	</div>
</div>
<script type="text/javascript">
function downloadPDF(){
	$.ajax({
	    url: '<%= request.getContextPath()%>/download?type=pdf',
	    type: 'get',
	    success: function() {
	        window.location = '<%= request.getContextPath()%>/download?type=pdf';
	    }
	});
}
</script>
<script type="text/javascript">
$(document).delegate('*[data-toggle="lightbox"]', 'click', function(event) {
    event.preventDefault();
    $(this).ekkoLightbox();
}); 
</script>
</body>
</html>