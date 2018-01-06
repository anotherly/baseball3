<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("@@@@@@@@@@@@@@@@view.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>팀 아이디 넘버</td>
			<td>${data.dd.teamId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${data.dd.teamName }</td>
		</tr>
		<tr>
			<td>사무실</td>
			<td>${data.dd.office }</td>
		</tr>
		<tr>
			<td>전화</td>
			<td>${data.dd.tel }</td>
		</tr>
		<tr>
			<td>홈페이지</td>
			<td>${data.dd.homepage }</td>
		</tr>
		<tr>
			<td>창단년도</td>
			<td>${data.dd.teamBirth }</td>
		</tr>
		<tr>
			<td>연고지</td>
			<td>${data.dd.home }</td>
		</tr>
		<tr>
			<td>구단주</td>
			<td>${data.dd.owner }</td>
		</tr>
		<tr>
			<td>대표이사</td>
			<td>${data.dd.president }</td>
		</tr>
		<tr>
			<td>단장</td>
			<td>${data.dd.captin }</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${data.dd.manager }</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>${data.dd.sysFile }<img alt=""
				src="../../resources/teamPhoto/${data.dd.sysFile}">
			</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>${data.dd.sysFile }<img alt=""
				src="../../../resources/teamPhoto/${data.dd.sysFile}">
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center"><a href="teaminfolist">목록으로</a> 
				<c:choose>
					<c:when test="${loginVo.grade eq 'admin' }">
						<a href="modify?teamId=${data.dd.teamId }">수정하기</a>
						<a href="delete?teamId=${data.dd.teamId }">삭제하기</a>
					</c:when>
				</c:choose>
			</td>
	</table>
</body>
</html>