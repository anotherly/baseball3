<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="">
		<tr>
			<td>id</td>
			<td>${vo.playerId}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${vo.playerBirth}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<td>등급</td>
			<td>${vo.grade}</td>
		</tr>
		<%-- <tr>
			<td>파일</td>
			<td>${vo.sysFile}-${vo.oriFile}<br>
			<img alt="" src="../resources/up1/${vo.sysFile}">

			</td>
		</tr>  --%>
		<tr>
			
			<td colspan="2" align="right">
			<a href="delete?id=${vo.id}">회원탈퇴</a>
			<a href="modify?id=${vo.id}">회원수정</a>
			<a href="list">리스트로</a>
			</td>
		</tr>
		
	</table>

</body>
</html>