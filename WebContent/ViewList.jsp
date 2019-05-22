<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="item" items="${ list }">
<<<<<<< HEAD
		${ item }<br>
=======
		${ item }
>>>>>>> db154b6c3f93b52aa9a7d3fd4f7a3e6bc74a783f
	</c:forEach>
</body>
</html>