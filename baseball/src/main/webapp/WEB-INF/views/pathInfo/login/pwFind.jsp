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
<body>
	<c:choose>
		<c:when test="${data.dd.password != null && data.dd.password ne '' }">
			회원님의 비밀번호는 ${data.dd.password } 입니다.<br>
		</c:when>
		<c:otherwise>
			회원정보를 잘못 입력하셨습니다.<br>
		</c:otherwise>
	</c:choose>
	<a href="findPWGo">뒤로가기</a>
	<a href="first">로그인</a>
	<a href="findIdGo">ID 찾기</a>
</body>
</html>