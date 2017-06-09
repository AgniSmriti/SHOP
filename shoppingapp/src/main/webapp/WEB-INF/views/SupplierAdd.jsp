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

<fm:form action="${pageContext.request.contextPath}/manage_supplier" commandName="supplier" modelAttribute="supplier" >
<c:if test="${not empty supplier.supName }">
<fm:input type="text" path="supId" disabled="true" readOnly="true"/>
<fm:hidden path="supId"/>
</c:if>
<br>

<td>SupplierName:</td>
<fm:input type="text" path="supName"></fm:input>

<c:if test="${empty supplier.supName }">
<br>
<fm:button type="submit">add</fm:button>
</c:if>



<c:if test="${! empty supplier.supName }">
<fm:button type="submit">update</fm:button>
</c:if>
</fm:form>



<c:if test="${not empty listSupplier}">
SupplierLIST

<table style="width:100%">
  
<tr>
    <th>ID</th>
    <th>NAME</th> 
    <th>OPERATIONS</th>
 </tr>
<c:forEach items="${listSupplier}" var="supplier">

<tr>

<td>${supplier.supId}</td>
<td>${supplier.supName}</td>
<th><a href="<c:url value='updateSupplier/${supplier.supId}'/>">EDIT</a></th>
<th><a href="<c:url value='deleteSupplier/${supplier.supId}'/>">Delete</a></th>

</tr>



</c:forEach>
</table>

</c:if>
</body>
</html>