<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" 
	type="text/javascript" ></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">/* 선택가능좌석/ 선택한 좌석/ 선택 불가 좌석 css */
	input[type=checkbox] {
		display: none;
	}
	
	input[type=checkbox]+label {
		display: inline-block;
		cursor: pointer;
		line-height: 22px;
		padding-left: 22px;
		background: url(../resources/img/empty.JPG) left/22px no-repeat;
	}
	
	input[type=checkbox]:checked+label {
		background-image: url(../resources/img/selected.JPG);
	}
	
	input[type=checkbox]:disabled+label {
		background-image: url(../resources/img/blocked.JPG);
	}
</style>

<script>
	/* 	$(document).ready(function() {
	 $(":checkbox").change(function() {
	 var cnt = ${param.cnt}
	
	
	 if (cnt == $(":checkbox:checked").length) {
	 $(":checkbox:not(:checked)").attr("disabled", "disabled");
	 $(":submit:not(:checked)").removeAttr("disabled", false);
	 } else  {
	 $(":checkbox").removeAttr("disabled");
	 $(":submit").attr("disabled", true);

	 }
	 });

	 }); */
	function count_ck(obj) {
		var chkbox = document.getElementsByName("chk");
		var chkCnt1 = 0;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				chkCnt1++; //기존 DB에 저장되어있는 좌석의 갯수를 구해서 더한다.
			}
		}

		if ((chkCnt1) == "${param.cnt}") { 
			$(":submit:not(:checked)").removeAttr("disabled", false);
		} else if ((chkCnt1) < "${param.cnt}") {
			$(":submit").attr("disabled", true);
		} else if ((chkCnt1) > "${param.cnt}") {
			alert("선택가능한 좌석개수를 초과하였습니다.");
			obj.checked = false;
			return false; 
		} //좌석 선택갯수로 다음으로 넘어가는 버튼을 활성/비활성화.

		/* 		if((chkCnt1)=="${param.cnt}"){
		 $(":submit:not(:checked)").removeAttr("disabled", false);
		 }else if((chkCnt1)>"${param.cnt}"){
		 alert("선택가능한 좌석개수를 초과하였습니다.");
		 obj.checked = false;
		 return false;
		 } */

	}
</script>
</head>
<body>
		 ${param.stadium }
	<br> ${param.seat}
	
	<!-- VIP좌석 - 15000원 / 
		R-1/2 - 12000원 / 
		S-1/2 - 10000원 / 
		A-1/2 - 8000원 -->
	
	<br> ${param.cnt }
	<form action="checkTest" method="post"> <!-- checkTest로 이동 -->
		<c:set value="${param.seat eq 'b1'?15000:
				param.seat eq 'b2' or param.seat eq 'b3'?12000:
				param.seat eq 'b4' or param.seat eq 'b5'?10000:8000}" var="price"/>
			
		<input type="text" value="${price}" name="price" /> 
		<input type="hidden" value="${param.match_year}" name="match_year" /> 
		<input type="hidden" value="${param.match_month}" name="match_month" /> 
		<input type="hidden" value="${param.match_day}" name="match_day" />
		<input type="hidden" value="${param.userid }" name="userid" /> 
		<input type="hidden" value="${param.stadium }" name="stadium" /> 
		<input type="hidden" value="${param.cnt }" name="cnt" /> 
		<input type="hidden" value="${param.seat }" name="seat" />
		<table>

			<c:forEach begin="0" end="9" var="j" varStatus="g">
				<tr>
					<c:set
						value="${g.index eq 0 ?'A':g.index eq 1?'B': g.index eq 2?'C':g.index eq 3 
					?'D':g.index eq 4 ?'E':g.index eq 5 ?'F':g.index eq 6 ?'G':g.index eq 7?'H':g.index eq 8?'I':'J'}"
						var="c" />
					<td><c:out value="${c }" /></td>
					<c:forEach begin="1" end="20" var="i" varStatus="h">
						<td><input type="checkbox" id="${g.index*20+h.index}"
							name="chk" onClick="count_ck(this);"
							value="${c }${g.index*20+h.index }" /> <label
							for="${g.index*20+h.index}"> ${c }${g.index*20+h.index }</label></td>
					</c:forEach>
				</tr> <!-- 10행 20열 좌석 화면단에 뿌려주기 -->
			</c:forEach>
				<tr>
					<td>
					</td>
				</tr>
			<c:forEach items="${data.dd}" var="filled">
				<c:set var="asd" value="${filled.listt }${filled.line }" />
				
				<script> /* 해당 일자,구장, 좌석 정보가 같으면 버튼 비활성하 */
					var checked = document.getElementsByName("chk");
					for (var i = 0; i < 200; i++) {
						if (checked[i].value == "${asd}"
								&& "${filled.stadium}" == "${param.stadium}"
								&& "${filled.seat}" == "${param.seat}"
								&& "${filled.match_year}" == "${param.match_year}"
								&& "${filled.match_month}" == "${param.match_month}"
								&& "${filled.match_day}" == "${param.match_day}") {
							checked[i].disabled = true;
						}
					}
				</script>
			</c:forEach>
			<tr>
				<td><input type="submit" value="다음으로" disabled="disabled" /></td>
			</tr>
		</table>
	</form>

</body>
</html>