<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="common/header.jspf"%>
<title>Welcome</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h1>Welcome ${name}</h1>
		<a href="list-todos" class="text-info">Manage</a> your todos
	</div>
	<script src="webjars/jquery/3.7.0/dist/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>