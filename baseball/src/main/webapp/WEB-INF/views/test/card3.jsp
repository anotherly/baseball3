<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
/* 	function complete(){
 
		frm.action = "insertticket";
		frm.submit();
		 	alert('결제가 완료되었습니다');
		 	self.close();
			window.opener.close();
	};
		 */
	/* function closewindow(){
 		if(confirm('현재페이지를 닫으시겠습니까?')){
			self.close();
			window.opener.close();
 		}
	} */
	
	function goSubmit() {
	    window.opener.name = "parent"; // 부모창의 이름 설정
	    document.frm.target = "parent"; // 타켓을 부모창으로 설정
 	    document.frm.action = "insertticket"; 
	    document.frm.submit();
	
	    self.close();
	}
	
</script><!-- 
window.onload = function() {
		alert("예매가 완료되었습니다."); 
	}; -->
</head>
<body>
	<form action="" method="post" name="frm">
		<input type="hidden" value="${param.userid }" name="userid"/>
		<input type="hidden" value="${param.user_name }" name="user_name"/>
		<input type="hidden" value="${param.user_phone}" name="user_phone"/>
		<input type="hidden" value="${param.money }" name="money"/>
		<input type="hidden" value="${param.stadium }" name="stadium" />
		<input type="hidden" value="${param.match_year}" name="match_year"/>
		<input type="hidden" value="${param.match_month}" name="match_month"/>
		<input type="hidden" value="${param.match_day}" name="match_day"/>	
		<input type="hidden" value="${param.price }" name="price"/>
		
		<table border=1>
			<tr>
				<td>판매자</td>
				<td>: (주) 스탯팩토리</td>
			</tr>
			<tr>
				<td>금액</td>
				<td>: ${param.money }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${param.match_year }년 ${param.match_month }월 ${param.match_day }일<br>
				${param.stadium } 홈 경기</td>
			</tr>
			<tr>
				<td>카드번호</td>
				<td><input type="text" name="12num"></td>
			<tr>
			</tr>
			<tr>
				<td colspan="2" align="right">('-'없이 카드번호만 입력해주세요.)</td>
			</tr>
			<tr align="center">
				<td colspan="3"><a href="card2">취소</a>
<!-- <a href="javascript:complete()">예매완료</a></td>
 -->	
 <input type="button" onclick="goSubmit()" value="예매완료">
 		</tr>
		</table>
	</form>
</body>
</html>