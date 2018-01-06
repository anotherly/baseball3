<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userid" >
			<table border="1">
				<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" ></td>
			</tr>
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원 가입" /> <a href="list">뒤로가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>