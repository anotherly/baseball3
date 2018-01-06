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
	<c:choose>
		<c:when test="${data.dd.userid != null && data.dd.userid ne '' }">
			회원님의 ID는 ${data.dd.userid } 입니다.<br>
		</c:when>
		<c:otherwise>
			찾으시는 ID가 존재하지 않거나 회원정보를 잘못 입력하셨습니다.<br>
		</c:otherwise>
	</c:choose>
	<a href="findIdGo">뒤로가기</a>
	<a href="first">로그인</a>
	<a href="findPWGo">PW 찾기</a>
</body>
</html>