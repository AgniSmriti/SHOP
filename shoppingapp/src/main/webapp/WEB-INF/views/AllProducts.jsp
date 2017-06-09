%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="fm"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<c:url value="/resources/image/" var="image"/>
  <html>
  
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/AllProducts.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap.css.map" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstr 
	ap.min.css.map" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap-theme.css" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap-theme.css.map" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
	<link href="resources/css/bootstrap-theme.min.css.map" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="resources/js/table.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/npm.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://code.jquery.com/jquery.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.min.js"></script>
    <script>
    var app=angular.module("searchApp",[]);
    app.controller("ControlTb",function($scope){
    	$scope.prod=${listCatPro};
    	
    })
    </script>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
             <title>ProductDetails</title>

   </head>
<body>
                      <h1>All Products</h1>



<div class="container">
    
    
    
    
    
    
    
    <div class="row">
    	<div class="col-md-12">
</div>
     <c:forEach items="${listProduct}" var="cp"><div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
					<h4 class="text-center"><span class="label label-info">${cp.catId}</span></h4>
					<img alt="${cp.proName}" src="${image}${cp.proId}.jpg" class="responsive">
										<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${cp.proName}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
							</div>
						</div>
						<div class="row"><div class="col-md-6">
								<a href="<c:url value='/MoreDetails/${cp.proId}'/>"><span class="glyphicon glyphicon-plus"></span> More Details</a> 
							</div>
							
							</div>
					</div>		
					</div>
					</div>
				
			</c:forEach>		
					</div>
</div>


 
   <!--     <img alt="${cp.name}" src="${image}${cp.productId}.jpg">
  //  <img alt="${cp.name}" src="<c:url value='/resources/image/${cp.productId}.jpg'/>"> -->   
    
    

      <!-- <div ng-app="searchApp">
<div class="container" ng-controller="ControlTb">
 	<div class="search"> 
    <input type="search" ng-model="searchText" class="form-control" id="inputSearch" placeholder="Search Here"/>
    <div class="table-responsive bs-example"> 
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>CATEGORY</th>
                <th>PRICE</th>
                <th>More</th>
            </tr>
        </thead>
        <tbody>
        <tr ng-repeat="p in prod|filter:searchText">
    <td>{{p.productId}}  </td>
    <td>{{p.name}}</td>
    <td>{{p.catId}}</td>
    <td>{{p.price|currency}}</td>
    
    <td><a href="<c:url value='/MoreDetails/${p.productId}'/>"><span class="glyphicon glyphicon-plus"></span> More Details</a>
     </td>
    </tr>   
         
        </tbody>
    </table>
</div>

</div>
</div>
</div>

  

</body>
</html>-->