<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%System.out.println("%%%%%%%%%%%%%%%%%%관리자 멤버 디테일%"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr><td>아이디</td>
			<td>${data.dd.userid }</td></tr>
			<tr><td>닉네임</td>
			<td>${data.dd.nick }</td></tr>
			<tr><td>이름</td>
			<td>${data.dd.name }</td></tr>
			<tr><td>사진</td><td>
			<img alt="" src="../../../resources/memberPhoto/${data.dd.sysname }" width="200px"></td></tr>
			<tr><td>생년월일</td>
			<td>${data.dd.birth }</td></tr>
			<tr><td>주소</td>
			<td>${data.dd.address }</td></tr>
			<tr><td>휴대폰</td>
			<td>${data.dd.phone }</td></tr>
			<tr><td>수신동의</td>
			<td>${data.dd.receivemail }</td></tr>
			<tr><td>선호구단</td>
			<td>${data.dd.preferTeam }
			</td></tr>
			<tr><td colspan="2" align="center">
			<a href="first">회원목록보기</a>
			<a href="mailInsert?userid=${data.dd.userid }">쪽지 보내기</a>
			<a href="delete?userid=${data.dd.userid }">삭제하기</a></td>
		</table>
	</body>
</html>