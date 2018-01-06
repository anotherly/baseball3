<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${not empty loginVo }">
<a href= "../../../test/list" target="_blank" >예매하러가기</a>
</c:when>
<c:otherwise>
<script type="text/javascript">
function needlogin(){
      alert("로그인이 필요한 메뉴입니다.");
      window.location = "../../../../../baseball/pathInfo/login/loginSub/fisrt";
  }
needlogin();
  </script>
</c:otherwise>
</c:choose>
</body>
</html>