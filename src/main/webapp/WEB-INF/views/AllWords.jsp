<%@page import="com.dao.WordBeanDao"%>
<%@page import="com.bean.WordBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body class="bg-light">
	<div class="container mt-5">
		<div class="card shadow">
			<div
				class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
				<h4 class="mb-0">Words List</h4>
				<a href="newword" class="btn btn-light btn-sm">+ Add More Word</a>
			</div>
			<div class="card-body">
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
						<tr class="th">
							<th>Hint</th>
							<th>Word</th>
							<th>Difficulty</th>
						</tr>
					</thead>
					<tbody>

						<%
						for (WordBean w : WordBeanDao.words) {
							out.print("<tr><td>" + w.getHint() + "</td><td>" + w.getWord() + "</td><td> " + w.getDifficulty() + "</td></tr>");
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>