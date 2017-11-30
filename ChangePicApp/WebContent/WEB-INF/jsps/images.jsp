<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Images</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table class="images">
<tr><td>Image</td></tr>

<c:forEach var="image" items="${images}">
<tr>

<td><img src="${pageContext.request.contextPath}/static/images/${image.name}" height="200" width="200"/></td>

   
</tr>
</c:forEach>
</table>
</body>
</html>