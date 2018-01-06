<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="loginCheck" method="post">
${title }
	<table>
		<tr>
			<td>id</td>
			<td><input type="text" name="userid" /></td>
		</tr>
		<tr>
			<td>pw</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="로그인" />
			<a href="../../home/notice/first">홈으로</a>
			<a href="findIdGo">ID 찾기</a>
			<a href="findPWGo">PW 찾기</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>