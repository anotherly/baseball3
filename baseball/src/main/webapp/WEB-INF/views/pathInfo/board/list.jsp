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
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>게시일자</td>
		</tr>
		<!-- data로 저장한 값이 있으면 vo 를 통해 모두 출력한다. foreach문이 한번 돌 때마다 no에 1씩 추가! -->
		<!-- no의 순번 -->
		<c:forEach items="${data.dd}" var="vo" varStatus="no">
			<tr>
				<td align="center">${data.startNum+no.index}</td>
				<td><a href="detail?boardid=${vo.boardid}&nowPage=${data.nowPage}">${vo.title }</a></td>
				<td>${vo.userid }</td>
				<td>${vo.regdate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
			<c:if test="${data.startPage > 1}">
					<a href="?nowPage=1">[처음으로]</a>
					<a href="nowPage=${data.startPage-1 }">&gt;</a>
				</c:if> 
				
				<c:forEach begin="${data.startPage }" end="${data.endPage }" var="i">
					<c:choose>
						<c:when test="${data.nowPage==i }"> [${i}]
					</c:when>
						<c:otherwise>
							<a href="?nowPage=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${data.endPage<data.totalPage }">
					<a href="?nowPage=${data.endPage+1 }">></a>
					<a href="?nowPage=${data.totalPage }">[마지막으로]</a>
				</c:if></td>
		<tr>
			<td colspan="4" align="center"><a href="insertForm"> 글쓰기</a></td>
			<!-- InsertForm으로 이동 -->
		</tr>
	</table>
</body>
</html>