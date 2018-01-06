<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="">
		<tr>
			<td>선수고유번호</td>
			<td>${data.dd.playerId}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${data.dd.playerName}</td>
		</tr>
		<tr>
			<td>팀명</td>
			<td>${data.dd.teamId}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><img alt=""
				src="../../../resources/playerPhoto/${data.dd.sysFile}"
				width="150px" height="200px"></td>
		</tr>
		
		<tr>
			<td>등번호</td>
			<td>${data.dd.backNum}</td>
		</tr>
		
		<tr>
			<td>포지션</td>
			<td>${data.dd.position}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${data.dd.playerBirth}</td>
		</tr>
		<tr>
			<td>출신교</td>
			<td>${data.dd.schoolName}</td>
		</tr>
		<tr>
			<td>신장</td>
			<td>${data.dd.height}</td>
		</tr>
		<tr>
			<td>체중</td>
			<td>${data.dd.weight}</td>
		</tr>
		<tr>
			<td>국적</td>
			<td>${data.dd.country}</td>
		</tr>
		<tr>
			<td>연봉</td>
			<td>${data.dd.salary}</td>
		</tr>
		<tr>
			<td>투구</td>
			<td>${data.dd.pitchingHand}</td>
		</tr>
		<tr>
			<td>타격</td>
			<td>${data.dd.battingHand}</td>
		</tr>
		 <tr>

			<td colspan="2" align="right"><%-- <a href="delete?id=${data.dd.id}">회원탈퇴</a> --%>
				<a href="playerModify?playerId=${data.dd.playerId}">선수정보수정</a> <a href="playerList">리스트로</a></td>
		</tr> 

	</table>

</body>
</html>