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

	<table border="">
		<tr>
			<!-- <td>선수고유번호</td> -->
			<td>팀</td>
			<!-- <td>선수 사진</td> -->
			<td>등번호</td>
			<td>선수 이름</td>
			<td>포지션</td>
			<td>투</td>
			<td>타</td>
			<td>연봉</td>
		 	<td>생년월일</td>
			<td>출신교</td>
			<td>신장</td>
			<td>체중</td>
			<td>국적</td>
			<td>최종수정시간</td>
			<td>상세보기</td>
		</tr>

		<c:forEach items="${data.dd }" var="vo">
			<tr>

				<%-- <td>${vo.playerId}</td> --%>
				<td>${vo.teamId}</td>
				<%-- <td>${vo.sysFile}</td> --%>
				<td>${vo.backNum}</td>
				<td>${vo.playerName}</td>
				<td>${vo.position}</td>
				<td>${vo.pitchingHand}</td>
				<td>${vo.battingHand}</td>
				<td>${vo.salary}</td>
				<td>${vo.playerBirth}</td>
				<td>${vo.schoolName}</td>
				<td>${vo.height}</td>
				<td>${vo.weight}</td>
				<td>${vo.country}</td>
				<td>${vo.regDate}</td>
				<td><a href="view?playerId=${vo.playerId}">${vo.playerName}</a></td>
				<%-- <td>${vo.grade}</td> --%>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="15" align="right"><a href="register">선수정보입력</a></td>


		</tr>



	</table>

</body>
</html>