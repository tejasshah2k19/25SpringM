<%@page import="com.dao.WordBeanDao"%>
<%@page import="com.bean.WordBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	for(WordBean w: WordBeanDao.words){
		out.print(w.getHint()+" "+w.getWord()+ " "+w.getDifficulty()+"<Br>");
	}
%>
</body>
</html>