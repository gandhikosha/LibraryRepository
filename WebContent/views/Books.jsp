<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>Title</th><th>Author</th><th>Category</th><th>Action</th>
</tr>
<c:forEach items="${books}" var="b">
<tr>
<td>${b.title}</td><td>${b.author}</td><td>${b.category }</td><td>Action</td>
</tr>
</c:forEach>
</table>
</body>
</html>