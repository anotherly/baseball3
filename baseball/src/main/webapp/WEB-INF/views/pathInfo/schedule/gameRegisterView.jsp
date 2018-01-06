
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<form action="" align="center">

		<table border="2">

			<tr>
				<td colspan="3">${data.dd.away_img }${data.dd.away }
					${data.dd.away_score } : ${data.dd.home_score } ${data.dd.home }
					${data.dd.home_img }</td>

			</tr>

			<tr>
				<td>승/패, 선수이름, 몇승몇패<br>(승리팀에세이브있을시 추가)세, 선수이름, 몇세이브
				</td>
				
			
				<td>${data.dd.year }년${data.dd.month }월
					${data.dd.day }일 ${data.dd.yoil }요일<br>${data.dd.stadium }</td>
				<td>승/패, 선수이름, 몇승몇패<br>(승리팀에세이브있을시 추가)세, 선수이름, 몇세이브
				</td>
			</tr>
			<tr>
				<td>${data.dd.away }</td>
				<td></td>
				<td>${data.dd.home }</td>
			</tr>
			<tr>
				<td>${data.dd2.h }</td>
				<td>안타</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>홈런</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>도루</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>삼진</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>병살</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>실책</td>
				<td></td>
			</tr>
			<%-- <tr>
				<td>년</td>
				<td>${data.dd.year }</td>
				
			</tr>
			<tr>
				<td>월</td>
				<td>${data.dd.month }</td>
				
			</tr>
			<tr>
				<td>일</td>
				<td>${data.dd.day }</td>
				
			</tr>
			<tr>
				<td>요일</td>
				<td>${data.dd.yoil }</td>
				
			</tr>
			<tr>
				<td>원정팀</td>
				<td>${data.dd.away }</td>
				
			</tr>
			<tr>
				<td>홈팀</td>
				<td>${data.dd.home }</td>
				
			</tr>
			<tr>
				<td>구장</td>
				<td>${data.dd.stadium }</td>
				
			</tr>
			<tr>
				<td>경기시간</td>
				<td>${data.dd.game_time }</td>
				
			</tr>
			 
			<tr>
				<td colspan="2" align="center">
				<td><a href="gameRegModifyForm">수정</a></td>
				
			</tr>--%>
		</table>
	</form>


</body>
</html>