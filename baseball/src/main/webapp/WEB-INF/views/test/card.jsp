<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body onresize="parent.resizeTo(800,600)" onload="parent.resizeTo(800,600)">
	예매자 확인
    	<form action="card2" method="post">
     	<input type="hidden" value="${param.userid }" name="userid"/>
		<input type="hidden" value="${param.money }" name="money" /> <!-- 값넘어온거확인했음! -->
		<input type="hidden" value="${param.stadium }" name="stadium" />
		<input type="hidden" value="${param.match_year}" name="match_year"/>
		<input type="hidden" value="${param.match_month}" name="match_month"/>
		<input type="hidden" value="${param.match_day}" name="match_day"/>
		
		<table border="1">
			<tr>
				<td style="width: 120px;">이름</td>
				<td><input type="text" name="user_name" size="20" style="width: 200px;"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" style="width: 80px;">
					예)870201(YYMMDD)</td>
			</tr>
			<tr>
				<td colspan="2">현장수령 및 고객문의시 본인확인을 위해 정확한 정보를 입력해주세요.
			</tr>
			<tr>	
				<td>연락처</td>
				<td><input type="text" name="user_phone" style="width: 200px;"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="radio"
					checked="checked" readonly="readonly">현장수령</td>
			</tr>
			<tr align="right">
				<td colspan="2"><a href="checkTest">이전단계</a> 
				<input type="submit" value="다음단계" /></td>
			</tr>
		</table>
	</form>
</body>
</html> 