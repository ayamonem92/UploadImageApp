<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Hi there</title>
</head>
<body>
<!-- 
Request from controller = ${name} <br/>
Jstl varible  <c:out value="${name}"></c:out>
 
<sql:query var="rs" dataSource="jdbc/spring">
select name, password from user
</sql:query>
-->
<br/>
<!--  
<c:forEach var="row" items="${rs.rows}">
	Name : ${row.name}<br/>
	Password : ${row.password}<br/>
</c:forEach>-->
<p><a href="${pageContext.request.contextPath}/images">Show Current Images</a></p>
<p><a href="${pageContext.request.contextPath}/createimage">Add New Image</a></p>

<sec:authorize access="!isAuthenticated()">
<p><a href="<c:url value="/login"/>">Login</a></p>
</sec:authorize>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<sec:authorize access="isAuthenticated()">
<p><a href="${logoutUrl}">Log Out</a></p>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
<p><a href="<c:url value="/admin"/>">Admin</a></p>
</sec:authorize>
</body>
</html>