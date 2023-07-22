<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="common/header.jspf"%>
<title>Add Todo</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form:form action="" method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" />
				<form:errors path="description" class="text-warning" />
			</fieldset>

			<fieldset>
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" />
				<form:errors path="targetDate" class="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>

	<%@ include file="common/footer.jspf"%>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>
</body>
</html>


