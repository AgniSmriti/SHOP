<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        

<!-- jQuery library -->
<<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


       
       <style>
body { background: #9cb8b3; }



</style>

</head>
<body>
 <%-- 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
<br> <a class="navbar-brand" href="${pageContext.request.contextPath}/index">BE CRAZY FOR READING</a>
    </div>
     <ul class="nav navbar-nav">
     
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      
     
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">BOOKS SEARCH <span class="caret"></span></a>
      
     <ul class="dropdown-menu">    
         
         <c:forEach items="${listCategory}" var="pro">
          <li><a href="${pageContext.request.contextPath }/productbyCategory/${pro.catId}">${pro.catId}</a></li>
         
         
        
          </c:forEach>          
         </ul>
          </li>
         </ul> 
         



--%>

 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath }/index">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${listCategory}" var="cat">
    <li><a href="${ pageContext.request.contextPath}/productbyCategory/${cat.catId}">${cat.catId}</a></li> 
          
         
          </c:forEach>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>


         <ul class="nav navbar-nav navbar-center">
     
     <sec:authorize access="hasRole('ROLE_ADMIN')">
     
         <li class="active"><a href="${pageContext.request.contextPath }/adminHome"><span class="glyphicon-user"></span></a>

</sec:authorize>

</ul>




 <ul class="nav navbar-nav navbar-right">
     
     <sec:authorize access="isAuthenticated()">
     <li style="color:powerblue"><br>welcome<i>${pageContext.request.userPrincipal.name}</i></li>
          <li><a href="${pageContext.request.contextPath }/LogOut">Logout</a></li>
 
 </sec:authorize>
</ul> 
    
    

 <ul class="nav navbar-nav navbar-right">    
     <sec:authorize access="isAnonymous()">
     
          <li><a href="${pageContext.request.contextPath }/signup">signup </a></li>





          <li><a href="${pageContext.request.contextPath }/Login">Login</a></li>


</sec:authorize>
</ul>
    </ul>
  </div>
</nav>

</body>





</html>