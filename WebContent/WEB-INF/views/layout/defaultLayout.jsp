<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title><tiles:insertAttribute name="title" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="Login, Flat, HTML5, CSS3" />	
	
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet"></link>
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap-responsive.css" rel="stylesheet"></link>
	<link href="<%=request.getContextPath()%>/resources/css/app.css" rel="stylesheet"></link>
	
	<%-- <link href="<%=request.getContextPath()%>/resources/css/font-awesome.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/login_style.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico" />
	<link rel="apple-touch-icon" href="<%=request.getContextPath()%>/resources/img/favicon.png" /> --%>
	<script src="<%= request.getContextPath()%>/resources/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/ekko-lightbox.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath()%>/resources/js/angular.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		<!-- Begin page content -->
    	<div class="container" style="margin-top: 104px;">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="push"></div>
	</div>
	<div id="footer">
      	<div class="container">
      		<tiles:insertAttribute name="footer" />        
      	</div>
    </div>  
</body>
  
</html>
