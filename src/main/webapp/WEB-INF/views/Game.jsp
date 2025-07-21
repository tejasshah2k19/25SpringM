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
	<c:set var="i" value="0"></c:set>
	<c:forEach begin="1" end="${wb.word.length()}" step="1">
			
		
		<c:if test="${guessCorrectChar.contains(wb.word.toLowerCase().charAt(i))}">
			__<u>${wb.word.charAt(i)}</u>__&nbsp;
		</c:if>
		<c:if test="${guessCorrectChar.contains(wb.word.toLowerCase().charAt(i)) == false}">
			_____&nbsp;
 		</c:if>
	<c:set var="i" value="${i+1}"></c:set>

	</c:forEach>
	<br>
	<br>

	<form action="checkword" method="post">
		Guess Character : <input type="text" name="guessChar" /><br>
		<br> <input type="submit" value="Check" />
	</form>
	<br><br>
	${guessCorrectChar}
	
</body>
</html>