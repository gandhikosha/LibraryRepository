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
<table><tr><td><a href="addBook">Add a new Book</a></td></table>
<form action="search" method="post">
<table>
<tr><td>Title</td><td><input type="text" name="title"/></td></tr>
<tr><td>Author</td><td><input type="text" name="author"/></td></tr>
<tr><td colspan="2"><input type="submit"/></td></tr>
</table>
</form>

${error}

<table border="1">
<tr>
<th>Id</th><th>Title</th><th>Author</th><th>Category</th><th>Action</th>
</tr>
<c:forEach items="${books}" var="b">
<tr>
<td>${b.id}</td>
<td>${b.title}</td>
<td>${b.author}</td>
<td>${b.category }</td>
<td><a href="addBook?id=${b.id}">Update</a><a href="deleteBook?id=${b.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>