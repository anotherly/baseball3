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
<%System.out.println("템플레이트 .jsp"); %>
	<table border="" align="center" width="80%">
		<tr>
			<td colspan="2"><jsp:include page="inc/top_upper.jsp" /></td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="inc/top_lower.jsp" /></td>
		</tr>
		<tr>
			<c:set var="name" value="${data.cate1}" />
				 <c:choose>
					<c:when test="${name eq 'home' || name eq 'login' || name eq 'join'}">
						<td align="center" colspan="2">
						<jsp:include page="${data.cate1 }/${data.service }.jsp" /></td>
					</c:when>
					<c:otherwise>
						<td><jsp:include page="inc/sub.jsp" /></td>
						<td align="center">
						<jsp:include page="${data.cate1 }/${data.service }.jsp" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
		<tr>
			<td colspan="2"><jsp:include page="inc/bottom.jsp" /></td>
		</tr>
	</table>
</body>
</html>