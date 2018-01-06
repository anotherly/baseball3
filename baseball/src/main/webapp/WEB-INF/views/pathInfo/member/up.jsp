<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%System.out.println("####################업인데 이건설마 진입 안하겟지#####################33"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr><td>아이디</td>
			<td>${fileDataa.userid }</td></tr>
			<tr><td>닉네임</td>
			<td>${fileDataa.nick }</td></tr>
			<tr><td>이름</td>
			<td>${fileDataa.name }</td></tr>
			<tr><td>기존파일명</td>
			<td>${fileDataa.orifile}</td></tr>
			<tr><td>바뀐파일명</td>
			<td>${fileDataa.sysfile}</td></tr>
			<tr><td>사진</td><td>
			<img alt="" src="../resources/memberPhoto/${fileDataa.sysfile }" width="200px"></td></tr>
			<tr><td>생년월일</td>
			<td>${fileDataa.birth }</td></tr>
			<tr><td>주소</td>
			<td>${fileDataa.address }</td></tr>
			<tr><td>휴대폰</td>
			<td>${fileDataa.phone }</td></tr>
			<tr><td>수신동의</td>
			<td>${fileDataa.receivemail }</td></tr>
			<tr><td>선호구단</td>
			<td>${fileDataa.preferTeam }
			</td></tr>
			<tr><td colspan="2" align="center"> <a href="dataModify?id=${fileDataa.id }">수정하기</a>
			<a href="delForm?id=${fileDataa.id }">삭제하기</a></td>
		</table>
	</body>
</html>