<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ListUsers</h2>
	<%
	List<UserBean> users = (List<UserBean>) request.getAttribute("users");
	%>

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>

		<%
		for (UserBean u : users) {
		%>
		<tr>
			<td><%=u.getUserId()%></td>
			<td><%=u.getFirstName()%></td>
			<td><%=u.getEmail()%></td>
			<td><a href="deleteuser?userId=<%=u.getUserId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>