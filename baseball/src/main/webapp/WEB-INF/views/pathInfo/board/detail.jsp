<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
 	function delalert(){
		if(confirm('삭제하시겠습니까?')){
			fmt.submit()
		}else{
			
		}
		
		}; 
</script>
</head>
<body>
<form action="delete" name="fmt">
<input type="hidden" name="userid" value="${data.dd.userid }" />
<input type="hidden" name="boardid" value="${data.dd.boardid }" />
</form>
	<table border="1">
			<tr><td>아이디</td>
			<td>${data.dd.userid }</td></tr>
			<tr><td>제목</td>
			<td>${data.dd.title }</td></tr>
				<tr><td>내용</td>
				<td>${data.dd.content }</td></tr>
			<c:choose>
			<c:when test="${data.dd.sysname eq null}">
			</c:when>
			<c:otherwise>
			<tr><td>사진</td>
			<td><img alt="" src="../../../resources/board/${data.dd.sysname }" width="200px"></td></tr>
			</c:otherwise>
			</c:choose>
			<tr><td>날짜</td>
			<td>${data.dd.regdate}</td></tr>
			<tr><td colspan="2" align="center"><a href="list">목록으로</a> 
			<a href="modify?boardid=${data.dd.boardid }">수정하기</a>
			 <a href="javascript:delalert()">자바스크립트띄우기 삭제하기</a> </td>
		</table>
	</body>
</html>