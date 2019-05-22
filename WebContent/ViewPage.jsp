<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지 입력 또는 출력</title>
<script>
	window.onload = function(){
		document.getElementById("toViewList").onclick = function(){
			location.href = "output.control";
		}
	}
</script>
</head>
<body>
	<form action="input.control">
		이름 : <input type="text" placeholder="이름" name="name">
		메세지 : <input type="text" placeholder="메세지" name="msg">
		<input type="submit"> 
	</form>
	<input id="toViewList" type="button" value="출력하기">
</body>
</html>