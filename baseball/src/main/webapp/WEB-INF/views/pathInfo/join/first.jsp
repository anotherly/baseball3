<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr><td>아이디</td>
			<td><input type="text" name="userid"><td><input type="button" name="idcheck" value="중복확인"/></td></tr>
			<tr><td>닉네임</td>
			<td colspan="2"><input type="text" name="nick"></td></tr>
			<tr><td>비밀번호</td>
			<td colspan="2"><input type="password" name="password"></td></tr>
			<tr><td>비밀번호 확인</td>
			<td><input type="password" name="passwordtwo"></td><td><input type="button" name="passcheck" value="확인"/></td></tr>
			<tr><td>이름</td>
			<td colspan="2"><input type="text" name="name"></td></tr>
			<tr><td>사진</td>
			<td><input type="file" name="file"></td></tr>
			<tr><td>생년월일</td>
			<td colspan="2"><input type="text" name="birth"></td></tr>
			<tr><td>주소</td>
			<td colspan="2"><input type="text" name="address"></td></tr>
			<tr><td>휴대폰</td>
			<td colspan="2"><input type="text" name="phone"></td></tr>
			<tr><td>수신동의</td>
			<td colspan="2"><input type="radio" name="receivemail" value="동의" checked="checked">동의
			<input type="radio" name="receivemail" value="거부">거부</td></tr>
			<tr><td>선호구단</td>
			<td colspan="2"><select name="preferTeam">
			<option value="lgtwins">LG트윈스</option>
			<option value="ncdinos">NC다이노스</option>
			</select>
			</td></tr>
			
			<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원 가입" />
				<a href="list">뒤로가기</a>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>