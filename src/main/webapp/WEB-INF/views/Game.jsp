<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game</title>
</head>
<body>

	${wb.hint } : Life ${life}
	<br>
	<br>  
	<br>
	
	<c:forEach begin="1" end="${wb.word.length()}" step="1">
	
		________&nbsp;
	
	</c:forEach>
<br><br> 
      
	<form action="checkword" method="post">
		Guess Character : <input type="text" name="guessChar"/><br><br>
		<input type="submit" value="Check"/>
	</form>

</body>
</html>