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
	
	<%for(UserBean u:users){ %>
	
		<%=u.getUserId() %>|<%=u.getFirstName() %> | <%=u.getEmail() %><br>
	
	<%} %>
	
</body>
</html>