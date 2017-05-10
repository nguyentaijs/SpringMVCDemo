<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Student Manager</title>
</head>
<body>
    <div class="container" style="margin-top: 10px">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h2>Student Manager</h2>
            </div>
            <div class="panel-body">
                <a href="<%= request.getContextPath() %>/students/add" class="btn btn-primary"> <i
                    class="fa fa-cog" aria-hidden="true"></i>Add student
                </a>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Full Name</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.fullName}</td>
                            <td><fmt:formatDate var="birthYear"
                                value="${student.dayOfBirth}" pattern="yyyy" /> <c:out
                                value="${currentYear - birthYear}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>