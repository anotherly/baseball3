<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%System.out.println("@@@@@@@@@@@@@@@@레지스터폼.jsp"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
	<table border="1">
			<tr>
				<td>팀 아이디 넘버</td>
				<td><input type="text" name="teamId" /></td>
			</tr>
			<tr>
				<td>구단이름</td>
				<td><input type="text" name="teamName" /></td>
			</tr>
			<tr>
				<td>사무실</td>
				<td><input type="text" name="office" /></td>
			</tr>
			<tr>
				<td>전화</td>
				<td><input type="text" name="tel" /></td>
			</tr>
			<tr>
				<td>홈페이지</td>
				<td><input type="text" name="homepage" /></td>
			</tr>
			<tr>
				<td>창단년도</td>
				<td><input type="text" name="teamBirth" /></td>
			</tr>
			<tr>
				<td>연고지</td>
				<td><input type="text" name="home" /></td>
			</tr>
			<tr>
				<td>구단주</td>
				<td><input type="text" name="owner" /></td>
			</tr>
			<tr>
				<td>대표이사</td>
				<td><input type="text" name="president" /></td>
			</tr>
			<tr>
				<td>단장</td>
				<td><input type="text" name="captin" /></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><input type="text" name="manager" /></td>
			</tr>
			<tr>
				<td>우승 수</td>
				<td><input type="text" name="win" /></td>
			</tr>
			<tr>
				<td>구단 로고</td>
				<td><input type="file" name="ff" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원 가입" /> <a href="list">뒤로가기</a>
			</tr>
		</table>
</form>
</body>
</html>