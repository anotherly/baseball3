<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
아이디 찾기
<form action="idFind" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="아이디 찾기" />
				<a href="../../home/notice/first">홈으로</a> 
				<a href="findPWGo">패스워드 찾기</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>