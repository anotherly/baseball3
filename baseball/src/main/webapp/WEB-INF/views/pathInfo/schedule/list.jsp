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
			2017시즌 경기일정
			<br>
			<td>경기번호</td>
			<td>년</td>
			<td>월</td>
			<td>일</td>
			<td>요일</td>
			<td>결과</td>
			<td>구장</td>
			<td>시간</td>
			<td>정보입력</td>
			<td>중계방송사</td>
			
		</tr>
		<c:forEach items="${data.dd2 }" var="voo">
		<input type="hidden" name="year" value="${voo.year }">
		<input type="hidden" name="month" value="${voo.month }">
		<input type="hidden" name="day" value="${voo.day }">
		<input type="hidden" name="teamId" value="${voo.teamId }">
		<%-- <input type="hidden" name="h" value="${voo.h }">
		<input type="hidden" name="h" value="${voo.h }">
		<input type="hidden" name="h" value="${voo.h }"> --%>
		
		</c:forEach>
		

		<c:forEach items="${data.dd }" var="vo">
			<tr>
				<td>${vo.game_num}</td>
				<td>${vo.year}</td>
				<td>${vo.month}</td>
				<td>${vo.day}</td>
				<td>${vo.yoil}</td>
				<%-- ${vo.away_img} --%>
				<td>${vo.away} ${vo.away_score} : ${vo.home_score} ${vo.home}</td><%-- ${vo.home_img} --%>
				<td>${vo.stadium}</td>
				<td>${vo.game_time}</td>
				
				<td><a href="gameRegisterView?game_num=${vo.game_num}?year=${vo.year }?month=${vo.month }?day=${vo.day }?away=${vo.away }">상세보기</a></td>
				
				<td>${vo.channel}</td>
				<%-- <td><a href="register?home=${vo.home }&away=${vo.away}">정보입력</a></td> --%>

			</tr>
		</c:forEach>
		<!-- <tr>
			<td colspan="15" align="right"><a href="register">선수정보입력</a></td>


		</tr> -->



	</table>

</body>
</html>