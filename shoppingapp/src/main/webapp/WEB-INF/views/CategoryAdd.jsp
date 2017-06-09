<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
${msg}
<fm:form action="${pageContext.request.contextPath}/manage_category" commandName="category" modelAttribute="category" >
<c:if test="${not empty category.name }">

<fm:input type="text" path="catId" disabled="true" readOnly="true"/>
<fm:hidden path="catId"/>
</c:if>
<br>
<td>CategoryName:</td>
<fm:input type="text" path="name"></fm:input>



<c:if test="${empty category.name }">
<br>
<fm:button type="submit">add</fm:button>
</c:if>

<c:if test="${! empty category.name }">
<fm:button type="submit">update</fm:button>

</c:if>
</fm:form>

<c:if test="${not empty listCategory}">

CategoryLIST
<table style="width:100%">
  
  <tr>
    <th>ID</th>
    <th>NAME</th> 
    <th>OPERATIONS</th>
 </tr>
  <c:forEach items="${listCategory}" var="category">
 
 <tr>
 <td>${category.catId}</td>
<td>${category.name}</td>

<th><a href="<c:url value='updateCategory/${category.catId}'/>">EDIT</a></th>
<th><a href="<c:url value='deleteCategory/${category.catId}'/>">Delete</a></th>


  </tr>
</c:forEach>
</table>
<tr>




</c:if>
<a href="index">GO TO HOME PAGE</a>

</body>
</html>
