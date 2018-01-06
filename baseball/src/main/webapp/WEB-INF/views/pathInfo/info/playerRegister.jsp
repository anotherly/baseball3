<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="detail" method="post" enctype="multipart/form-data">
		<table border="2">
			<tr>
				<td>선수고유번호</td>
				<td><input type="text" name="playerId" /></td>
			</tr>
			 <tr>
				<td>구단명</td>
				<td><select name="teamId">

						<option selected="selected" value="무적">무적</option>
						<option value="두산">두산</option>
						<option value="NC">NC</option>
						<option value="넥센">넥센</option>
						<option value="LG">LG</option>
						<option value="KIA">KIA</option>
						<option value="SK">SK</option>
						<option value="한화">한화</option>
						<option value="롯데">롯데</option>
						<option value="삼성">삼성</option>
						<option value="KT">KT</option>

				</select></td>
			</tr> 
			 <tr>
				<td>현재상태</td>
				<td><select name="status">

						<option selected="selected" value="정식선수">정식선수</option>
						<option value="신고선수">신고선수</option>
						<option value="은퇴">은퇴</option>
						<option value="임의탈퇴">임의탈퇴</option>
				</select></td>
			</tr> 
			<tr>
				<td>클래스</td>
				<td><select name="gun">

						<option selected="selected" value="2군">2군</option>
						<option value="1군">1군</option>
						
				</select></td>
			</tr> 
			<tr>
				<td>사진</td>
				<td><input type="file" name="playerPhoto" /></td>
			</tr>
			<tr>
				<td>등번호</td>
				<td><input type="text" name="backNum" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="playerName" /></td>
			</tr>
			<tr>
				<td>포지션</td>
				<td><select name="position">

						<option selected="selected" value="p, 투수">투수</option>
						<option value="c, 내야수, 포수">포수</option>
						<option value="1b, 내야수, 1루수">1루수</option>
						<option value="2b, 내야수, 2루수">2루수</option>
						<option value="3b, 내야수, 3루수">3루수</option>
						<option value="ss, 내야수, 유격수">유격수</option>
						<option value="lf, 외야수, 좌익수">좌익수</option>
						<option value="cf, 외야수, 중견수">중견수</option>
						<option value="rf, 외야수, 우익수">우익수</option>
						
						
				</select></td>
			</tr> 
		<tr>
				<td>생년월일</td>
				<td><input type="text" name="playerBirth" /></td>
			</tr>
			<tr>
				<td>출신교</td>
				<td><input type="text" name="schoolName" /></td>
			</tr>
			<tr>
				<td>신장</td>
				<td><input type="text" name="height" /></td>
			</tr>
			<tr>
				<td>체중</td>
				<td><input type="text" name="weight" /></td>
			</tr>
			<tr>
				<td>국적</td>
				<td><input type="text" name="country" /></td>
			</tr>
			<tr>
				<td>연봉</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>투</td>
				<td><select name="pitchingHand">

						<option selected="selected" value="우투">우투</option>
						<option value="좌투">좌투</option>
												
				</select></td>
			</tr> 
			<tr>
				<td>타</td>
				<td><select name="battingHand">

						<option selected="selected" value="우타">우타</option>
						<option value="좌타">좌타</option>
						<option value="양타">양타</option>
												
				</select></td>
			</tr> 
			<tr>
				<td colspan="2" align="center">
				<td><input type="submit" value="입력" /></td>
			</tr>
		</table>
	</form>
</body>

</html>