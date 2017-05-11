<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
        jQuery(document).ready(function($) {
            $("#dayofbirth").datepicker();
        });
</script>
<style>
.error-msg {
	color: #ff0000;
	font-weight: bold;
    width: 60%;
}
</style>
<title>Add student</title>
</head>
<body>
	<div class="container" style="margin-top: 10px">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2>Add student</h2>
			</div>
			<div class="panel-body">
				<form:form commandName="student" id="studentUpdateForm"
					method="post" action="${pageContext.request.contextPath}/students">
					<div>
						<div class="row">
							<div class="form-group col-xs-3">
								<form:label path="id" for="studentid">Student ID:</form:label>
								<form:input path="id" type="text" class="form-control"
									id="studentid"></form:input>
							</div>
							<div class="col-xs-9">
								<form:errors path="id" class="error-msg" element="div"/>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-3">
								<form:label path="fullName" for="studentname">Student name:</form:label>
								<form:input path="fullName" type="text" class="form-control"
									id="studentname"></form:input>
							</div>
							<div class="col-xs-9">
								<form:errors path="fullName" class="error-msg" element="div"/>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-3">
								<form:label path="dayOfBirth" for="dayofbirth">Day of birth:</form:label>
								<form:input path="dayOfBirth" type="text" id="dayofbirth"
									class="form-control"></form:input>
							</div>
							<div class="col-xs-9">
								<form:errors path="dayOfBirth" class="error-msg" element="div"/>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</body>
</html>