<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
계정을 삭제하시겠습니까? 비밀번호를 입력해주세요
	<form action="deleteReg" method="post">
		<table border="1">
				<tr>
				<td><input type="hidden" name="userid" value="${param.userid }"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td><input type="submit" value="확인"></td>
				</tr>
		</table>
	</form>
</body>
</html>