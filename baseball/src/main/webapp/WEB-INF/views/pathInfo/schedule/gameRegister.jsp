<%@page import="baseball.schedule.model.ScheduleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	ScheduleDao awayBean = new ScheduleDao();
	ArrayList awayList = new ArrayList();
	ArrayList homeList = new ArrayList();
	ArrayList stadiumList = new ArrayList();
	awayList = awayBean.getaway(request);
	homeList = awayBean.gethome(request);
	stadiumList = awayBean.getstadium(request);
%>
<%-- <%=awayBean.getawayState(request)%>
<%=awayBean.gethomeState(request)%>
<%=awayBean.getstadiumState(request)%>
<%=awayBean.getstadiumState1(request)%>
<%=awayBean.getstadiumState2(request)%> --%>
<script type="text/javascript">
	function reLoading(key) {
		if (key == "away") {
			var set1 = document.getElementsByName("home");
			var set2 = document.getElementsByName("stadium");
			set1[0].selectedIndex = 0;
			set2[0].selectedIndex = 0;
		}
		var res = document.gameRegister.game_num;/* .options[gameRegister.stadium.selectedIndex].value; */
		var abc = "?game_num=" + res.replace(/[^0-9]/g, "");

		document.gameRegister.action = "gameRegister" + abc
		document.gameRegister.submit();
	}

	var monthtext = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11',
			'12' ];
	function populatedropdown(yearfield, monthfield, dayfield) {
		var today = new Date()
		var dayfield = document.getElementById(dayfield)
		var monthfield = document.getElementById(monthfield)
		var yearfield = document.getElementById(yearfield)
		for (var i = 0; i < 31; i++)
			dayfield.options[i] = new Option(i + 1, i + 1)
		dayfield.options[today.getDate()] = new Option(today.getDate(), today
				.getDate(), true, true) //select today's day
		for (var m = 0; m < 12; m++)
			monthfield.options[m] = new Option(monthtext[m], monthtext[m])
		monthfield.options[today.getMonth()] = new Option(monthtext[today
				.getMonth()], monthtext[today.getMonth()], true, true) //select today's month
		var thisyear = today.getFullYear()
		for (var y = 0; y < 20; y++) {
			yearfield.options[y] = new Option(thisyear, thisyear)
			thisyear += 1
		}
		yearfield.options[0] = new Option(today.getFullYear(), today
				.getFullYear(), true, true) //select today's year
	}
</script>
</head>
<body>
	
	<form action="gameRegisterDetail" method="post" id="gameRegister"
		name="gameRegister">
		<table border="2" align="center">
		<!-- 경기번호가져오기!!!!!!!!!!!!! -->
		
			<!-- <tr>
				<td>경기번호</td>
				<td><input name="game_num"/>
					style="border: 0; height: 30px;" size="50" </td>
			</tr> -->
			<!-- <tr>
				<td>출장여부</td>
				Y/N
				일단 폼은 어쨌든 다 만들어 놔야겠군
				버튼형식
				<td><input id="btOnclick" type="button" value="네"
					onclick="bt_onclick()"> <input type="hidden" name="g"
					value="1"> <input id="btInsOnclick" type="button"
					value="취소" onclick="bt_ins_onclick()" style="display: none;">
					<input name="g" type="hidden" value="0"></td>
			</tr> -->
			<tr>
				<td colspan="2" align="center"><select id="year" name="year"></select>
					<select id="month" name="month"></select> <select id="day"
					name="day"></select></td>
			</tr>
			<tr>
				<td>요일</td>
				<td><select name="yoil" id="yoil">

						<option selected="selected" value="mon">월</option>
						<option value="tue">화</option>
						<option value="wed">수</option>
						<option value="thu">목</option>
						<option value="fri">금</option>
						<option value="sat">토</option>
						<option value="sun">일</option>

				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><select id="away" name="away"
					onchange="javascript:reLoading('away')">
						<option value="">==원정팀선택==</option>
						<%
							for (int i = 0; i < awayList.size(); i++) {
						%>
						<option value="<%=awayList.get(i)%>"
							<%if (awayList.get(i).equals(awayBean.getawayState(request))) {
					out.print("selected");
				}%>>
							<%=awayList.get(i)%></option>
						<%
							}
						%>
				</select> <select name="home" onchange="javascript:reLoading('home')">
						<option value="">==홈팀선택==</option>
						<%
							for (int i = 0; i < homeList.size(); i++) {
						%>
						<option value="<%=homeList.get(i)%>"
							<%if (homeList.get(i).equals(awayBean.gethomeState(request))) {
					out.print("selected");
				}%>><%=homeList.get(i)%></option>
						<%
							}
						%>
				</select> <select name="stadium" id="stadium"
					onchange="javascript:reLoading('stadium')">
						<!-- id="stadium"  -->
						<option value="">==구장선택==</option>
						<%
							for (int i = 0; i < stadiumList.size(); i++) {
						%>
						<option value="<%=stadiumList.get(i)%>"
							<%if (stadiumList.get(i).equals(awayBean.getstadiumState(request))) {
					out.print("selected");
				}%>><%=stadiumList.get(i)%></option>

						<%
							}
						%>
						<c:forEach items="${data.dd2 }" var="vo">
		<input type="hidden" name="game_num" value="${vo.game_num }"></c:forEach>
				</select> <%--  <input type="hidden" name="game_num" value="${ }"> --%>
				<%--<input type="hidden" name="playerName" value="<%=awayBean.getstadiumState2(request)%>"> --%>
				</td>
			</tr>
			<tr>
				<td>경기시간</td>
				<td><select name="game_time" id="game_time">

						<option selected="selected" value="14:00">14:00</option>
						<option value="16:00">16:00</option>
						<option value="18:00">18:00</option>

				</select></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<td><input type="submit" value="입력" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		window.onload = function() {
			populatedropdown("year", "month", "day")
		}
	</script>
	<!-- <script type="text/javascript">
		function bt_onclick() {//y버튼눌렀을때
			/* document.all.g.style.border = "1px solid #dddddd";
			document.all.g.disabled = false; */
			document.all.gs.style.border = "1px solid #dddddd";
			document.all.gs.disabled = false;
			document.all.homeToday.style.border = "1px solid #dddddd";
			document.all.homeToday.disabled = false;
			// -------------수비지표--------------
			document.all.inn.style.border = "1px solid #dddddd";
			document.all.inn.readOnly = false;
			document.all.tc.style.border = "1px solid #dddddd";
			document.all.tc.readOnly = false;
			document.all.po.style.border = "1px solid #dddddd";
			document.all.po.readOnly = false;
			document.all.a.style.border = "1px solid #dddddd";
			document.all.a.readOnly = false;
			document.all.e.style.border = "1px solid #dddddd";
			document.all.e.readOnly = false;
			document.all.dp.style.border = "1px solid #dddddd";
			document.all.dp.readOnly = false;
			// -------------타자지표--------------
			document.all.ab.style.border = "1px solid #dddddd";
			document.all.ab.readOnly = false;
			document.all.r.style.border = "1px solid #dddddd";
			document.all.r.readOnly = false;
			document.all.h.style.border = "1px solid #dddddd";
			document.all.h.readOnly = false;
			document.all.twoBase.style.border = "1px solid #dddddd";
			document.all.twoBase.readOnly = false;
			document.all.thirdBase.style.border = "1px solid #dddddd";
			document.all.thirdBase.readOnly = false;
			document.all.hr.style.border = "1px solid #dddddd";
			document.all.hr.readOnly = false;
			document.all.rbi.style.border = "1px solid #dddddd";
			document.all.rbi.readOnly = false;
			document.all.bb.style.border = "1px solid #dddddd";
			document.all.bb.readOnly = false;
			document.all.so.style.border = "1px solid #dddddd";
			document.all.so.readOnly = false;
			document.all.sb.style.border = "1px solid #dddddd";
			document.all.sb.readOnly = false;
			document.all.cs.style.border = "1px solid #dddddd";
			document.all.cs.readOnly = false;
			// -------------투수지표--------------
			document.all.w.style.border = "1px solid #dddddd";
			document.all.w.disabled = false;
			document.all.l.style.border = "1px solid #dddddd";
			document.all.l.disabled = false;
			document.all.hold.style.border = "1px solid #dddddd";
			document.all.hold.disabled = false;
			document.all.sv.style.border = "1px solid #dddddd";
			document.all.sv.disabled = false;
			document.all.svo.style.border = "1px solid #dddddd";
			document.all.svo.disabled = false;
			document.all.ip.style.border = "1px solid #dddddd";
			document.all.ip.readOnly = false;
			document.all.pitcherH.style.border = "1px solid #dddddd";
			document.all.pitcherH.readOnly = false;
			document.all.pitcherR.style.border = "1px solid #dddddd";
			document.all.pitcherR.readOnly = false;
			document.all.pitcherHr.style.border = "1px solid #dddddd";
			document.all.pitcherHr.readOnly = false;
			document.all.pitcherBb.style.border = "1px solid #dddddd";
			document.all.pitcherBb.readOnly = false;
			document.all.pitcherSo.style.border = "1px solid #dddddd";
			document.all.pitcherSo.readOnly = false;

			document.all.btInsOnclick.style.display = "inline";
			document.all.btOnclick.style.display = "none";
		}
		function bt_ins_onclick() {//n버튼눌렀을때(읽기전용+초기화)
			/* var b = document.all.a.value;
			alert("입력 내용이 초기화 됩니다"); */
			if (confirm("입력 내용이 초기화 됩니다") == true) { //확인
				document.all.a.value;
			} else { //취소
				return;
			}
			document.all.btInsOnclick.style.display = "none";
			document.all.btOnclick.style.display = "inline";
			/* document.all.g.style.border = "0px";
			document.all.g.disabled = true; */
			document.all.gs.style.border = "0px";
			document.all.gs.disabled = true;
			document.all.homeToday.style.border = "0px";
			document.all.homeToday.disabled = true;
			// -------------수비지표--------------
			document.all.inn.style.border = "0px";
			document.all.inn.readOnly = true;
			document.all.tc.style.border = "0px";
			document.all.tc.readOnly = true;
			document.all.po.style.border = "0px";
			document.all.po.readOnly = true;
			document.all.a.style.border = "0px";
			document.all.a.readOnly = true;
			document.all.e.style.border = "0px";
			document.all.e.readOnly = true;
			document.all.dp.style.border = "0px";
			document.all.dp.readOnly = true;
			// -------------타자지표--------------
			document.all.ab.style.border = "0px";
			document.all.ab.readOnly = true;
			document.all.r.style.border = "0px";
			document.all.r.readOnly = true;
			document.all.h.style.border = "0px";
			document.all.h.readOnly = true;
			document.all.twoBase.style.border = "0px";
			document.all.twoBase.readOnly = true;
			document.all.thirdBase.style.border = "0px";
			document.all.thirdBase.readOnly = true;
			document.all.hr.style.border = "0px";
			document.all.hr.readOnly = true;
			document.all.rbi.style.border = "0px";
			document.all.rbi.readOnly = true;
			document.all.bb.style.border = "0px";
			document.all.bb.readOnly = true;
			document.all.so.style.border = "0px";
			document.all.so.readOnly = true;
			document.all.sb.style.border = "0px";
			document.all.sb.readOnly = true;
			document.all.cs.style.border = "0px";
			document.all.cs.readOnly = true;
			// -------------투수지표--------------
			document.all.w.style.border = "0px";
			document.all.w.disabled = true;
			document.all.l.style.border = "0px";
			document.all.l.disabled = true;
			document.all.hold.style.border = "0px";
			document.all.hold.disabled = true;
			document.all.sv.style.border = "0px";
			document.all.sv.disabled = true;
			document.all.svo.style.border = "0px";
			document.all.svo.disabled = true;
			document.all.ip.style.border = "0px";
			document.all.ip.readOnly = true;
			document.all.pitcherH.style.border = "0px";
			document.all.pitcherH.readOnly = true;
			document.all.pitcherR.style.border = "0px";
			document.all.pitcherR.readOnly = true;
			document.all.pitcherHr.style.border = "0px";
			document.all.pitcherHr.readOnly = true;
			document.all.pitcherBb.style.border = "0px";
			document.all.pitcherBb.readOnly = true;
			document.all.pitcherSo.style.border = "0px";
			document.all.pitcherSo.readOnly = true;

			document.getElementById("gameRegister").reset();
		}
		function resetForm() {

		}
	</script> -->
</body>
</html>