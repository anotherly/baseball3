<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>id</td>
			<td>제목</td>
		</tr>
			<!-- data로 저장한 값이 있으면 vo 를 통해 모두 출력한다. foreach문이 한번 돌 때마다 no에 1씩 추가! -->
				<!-- no의 순번 -->
		<c:forEach items="${data.dd}" var="vo" varStatus="no">
			<tr>
				<td align="center">${no.index +1}</td>
				<td>${vo.id}</td>
				<td><a href="detail?id=${vo.id}">${vo.title }</a></td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="3" align="center"><a href="insertForm"> 글쓰기</a></td>
			<!-- InsertForm으로 이동 -->
		</tr>
	</table>
</body>
</html>