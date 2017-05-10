<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add result</title>
</head>
<body>
	<div class="container" style="margin-top: 10px">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="alert alert-${css}" role="alert">
					<strong>${msg}</strong>
				</div>
			</div>
			<div class="panel-body">
				<c:if test="${css eq 'success'}">
            		User name: ${student.fullName}
            		<br />
					<fmt:formatDate var="dayOfBirth" value="${student.dayOfBirth}"
						pattern="dd/MM/yyyy"></fmt:formatDate>
                	Day of birth: ${dayOfBirth}
                	<br />
				</c:if>
				<a href="<%= request.getContextPath() %>/students"
					class="btn btn-primary"> <i class="fa fa-cog"
					aria-hidden="true"></i>Return to student list
				</a>
			</div>
		</div>
	</div>
</body>
</html>