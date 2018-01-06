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
			<td>날짜</td>
			<td>${data.dd.year}${data.dd.month}${data.dd.day}</td>
		</tr>	
		<tr>
			<td>팀</td>
			<td>${data.dd.teamId}</td>
		</tr>	
		<%-- <tr>
			<td>포지션</td>
			<td>${data.dd.position}</td>
		</tr> --%>
		<tr>
			<td>이름</td>
			<td>${data.dd.playerName}</td>
		</tr>
		<tr>
			<td>선수고유번호</td>
			<td>${data.dd.playerId}</td>
		</tr>		
			<!-- <tr>
				<td>오늘경기 포함 출장수</td>
				어디선가 불러와서 Y이면 +1 ---------------리스트+디테일에구현
				<td>불러오기</td>
			</tr> -->
			<tr>
				<td>출장여부</td>
			
				<td>${data.dd.g}</td>
			</tr>
			<tr>
				<td>선발여부</td>
				<!-- 셀렉트나 콤보나 뭐 그런걸로 Y/N-->
				<td>${data.dd.gs}</td>
			</tr>
			<tr><td colspan="2" align="center">---------------------수비지표---------------------------</td></tr>
			<tr>
				<td>오늘의 포지션</td>
				<td>${data.dd.positionToday}</td>
			</tr>
			<tr>
				<td>이닝</td>
				<td>${data.dd.inn}</td>
			</tr>
			<tr>
				<td>총 수비기회</td>
				<td>${data.dd.tc}</td>
			</tr>
			<tr>
				<td>자살(내/외야수가 직접 아웃시킨 경우)</td>
				<td>${data.dd.po}</td>
			</tr>
			<tr>
				<td>보살</td>
				<td>${data.dd.a}</td>
			</tr>
			<tr>
				<td>실책</td>
				<td>${data.dd.e}</td>
			</tr>
			<tr>
				<td>병살</td>
				<td>${data.dd.dp}</td>
			</tr>
			<!-- <tr>
				<td>수비율</td>
				앞의지표로 계산해서 결과값만 나오게, 상세보기와 리스트에서 구현
				<td><input type="text" name="weight" /></td>
			</tr>
			<tr>
				<td>수비범위</td>
				앞의지표로 계산해서 결과값만 나오게, 상세보기와 리스트에서 구현
				<td><input type="text" name="country" /></td>
			</tr> -->
			<!-- ---------------------여기까지 수비지표------------------- -->
			<tr><td colspan="2" align="center">---------------------타자지표---------------------------</td></tr>
			<tr>
				<td>타석</td>
				<td>${data.dd.ab}</td>
			</tr>
			<tr>
				<td>득점</td>
				<td>${data.dd.r}</td>
			</tr>
			<tr>
				<td>안타</td>
				<td>${data.dd.h}</td>
			</tr>
			<tr>
				<td>2루타</td>
				<td>${data.dd.twoBase}</td>
			</tr>
			<tr>
				<td>3루타</td>
				<td>${data.dd.thirdBase}</td>
			</tr>
			<tr>
				<td>홈런</td>
				<td>${data.dd.hr}</td>
			</tr>
			<tr>
				<td>타점</td>
				<td>${data.dd.rbi}</td>
			</tr>
			<tr>
				<td>볼넷</td>
				<td>${data.dd.bb}</td>
			</tr>
			<tr>
				<td>삼진</td>
				<td>${data.dd.so}</td>
			</tr>
			<tr>
				<td>도루</td>
				<td>${data.dd.sb}</td>
			</tr>
			<tr>
				<td>도실</td>
				<td>${data.dd.cs}</td>
			</tr>
			<!-- <tr>
				<td>타율</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>출루율</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>장타율</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>ops</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr> -->
			<!-- ---------------------------여기까지 타자지표---------- -->
			<tr><td colspan="2" align="center">---------------------투수지표---------------------------</td></tr>
			<tr>
				<td>승리</td>
			<td>${data.dd.w}</td></tr>
				<tr>
				<td>패배</td>
			<td>${data.dd.l}</td></tr>
				<tr>
				<td>홀드</td>
			<td>${data.dd.hold}</td></tr>
				<tr>
				<td>세이브</td>
			<td>${data.dd.sv}</td></tr>
			<!-- <tr>
				<td>평균자책점</td>
				<td><input type="text" name="salary" /></td>
			</tr> -->
			<tr>
				<td>세이브 기회</td>
				<td>${data.dd.svo}</td>
			</tr>
			<tr>
				<td>소화이닝</td>
				<td>${data.dd.ip}</td>
			</tr>
			<tr>
				<td>피안타</td>
				<td>${data.dd.pitcherH}</td>
			</tr>
			<tr>
				<td>실점</td>
				<td>${data.dd.pitcherR}</td>
			</tr>
			<!-- <tr>
				<td>자책점</td>
				계산후 출력 요망 + 구원성공률도 ㄱㄱ
				<td><input type="text" name="salary" /></td>
			</tr> -->
			<tr>
				<td>피홈런</td>
				<td>${data.dd.pitcherHr}</td>
			</tr>
			<tr>
				<td>볼넷허용</td>
				<td>${data.dd.pitcherBb}</td>
			</tr>
			<tr>
				<td>탈삼진</td>
				<td>${data.dd.pitcherSo}</td>
			</tr>
			<!-- <tr>
				<td>피안타율</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>whip</td>
				계산후 출력 요망
				<td><input type="text" name="salary" /></td>
			</tr> -->
		<tr>

			<td colspan="2" align="right"><a href="deleteTodayStat?playerId=${data.dd.playerId}">회원탈퇴</a>
				<a href="modifyTodayStat?playerId=${data.dd.playerId}">선수정보수정</a> <a href="list">리스트로</a></td>
		</tr> 
		</table>
	</form>

</body>
</html>