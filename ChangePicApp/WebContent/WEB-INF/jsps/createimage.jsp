<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
<title>Upload Image</title>
</head>
<body>

<h3 style="color:red">${filesuccess}</h3>  
<form:form method="post" action="${pageContext.request.contextPath}/docreate" enctype="multipart/form-data">  
	<p><label for="image">Choose Image</label></p>  
	<p><input name="name" id="fileToUpload" type="file" /><br/>
	<form:errors path="name" cssClass="error" ></form:errors>
	</p>  
	<p><input type="submit" value="Upload"></p>  
</form:form>  
</body>
</html>