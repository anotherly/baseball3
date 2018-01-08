<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function dayClick(url) {
		location.replace(url);
	}
</script>
<body>

	<c:choose>
		<c:when test="${loginVo.grade ne 'admin' }">
			유효하지 않은 접근입니다.
		</c:when>
		<c:otherwise>
			통합 총계
			<br>
			<table border="1">
				<tr>
					<td>총 수익</td>
					<td>지출</td>
					<td>홈팀 분배</td>
					<td>원정팀 분배</td>
					<td>kbo 분배</td>
					<td>순수익</td>
				</tr>
				<tr>
					<td>${data.dd3.deposit }</td>
					<td>${data.dd3.withdraw }</td>
					<td>${data.dd3.home }</td>
					<td>${data.dd3.away }</td>
					<td>${data.dd3.kbo }</td>
					<td>${data.dd3.we }</td>
				</tr>
			</table>

			<br>
			<%-- 구장별 총계
			<br>
			<table border="1">
				<tr>
					<td>구장명</td>
					<td>총 수익</td>
					<td>지출</td>
					<td>홈팀 분배</td>
					<td>원정팀 분배</td>
					<td>kbo 분배</td>
					<td>순수익</td>
				</tr>
				<c:forEach items="${data.dd2 }" var="stadd">
					<tr>
						<td>${stadd.stadium }</td>
						<td>${stadd.deposit }</td>
						<td>${stadd.withdraw }</td>
						<td>${stadd.home }</td>
						<td>${stadd.away }</td>
						<td>${stadd.kbo }</td>
						<td>${stadd.we }</td>
					</tr>
				</c:forEach>
			</table>--%>			
			<br>
			조건 검색
			<br>

			<form action="list" method="get">
				<table border=1 width="400">
					<tr>
							<td colspan="4">
							<select name="year">
									<option value="no year" selected="selected">선택</option>
									<c:forEach items="${yearArr }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>년 
							<select name="month">
									<option value="no month" selected="selected">선택</option>
									<c:forEach items="${monthArr }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>월 
							<select name="day">
									<option value="no day" selected="selected">선택</option>
									<c:forEach items="${dayArr }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>일~ 
							<select name="year2">
									<option value="no year2" selected="selected">선택</option>
									<c:forEach items="${yearArr2 }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>년
							 <select name="month2">
							 		<option value="no month2" selected="selected">선택</option>
									<c:forEach items="${monthArr2 }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>월 
							<select name="day2">
							<option value="no day2" selected="selected">선택</option>
									<c:forEach items="${dayArr2 }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>일
							</td>
							<td>
							<select name="steam">
							<option value="no team" selected="selected">선택</option>
									<c:forEach items="${teamArr }" var="kk">
											<option value="${kk[1] }">${kk[1] }</option>
									</c:forEach>
							</select>구장
							</td>
					</tr>
					<tr>
						<td colspan="5" align="center"><input type="submit"
							value="검색" /></td>
					</tr>
				</table>
			</form>




			<%-- <table border="1" align="center">
				<tr>
					<td align="center">기간별 조회</td>
					<td align="center">구장별 조회</td>
				</tr>
				<tr>
					<td><select name="${data.dd.year1 }">
							<option value="2018" selected="selected">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
					</select>년 <select id="${data.dd.month1 }" name="month1">
							<c:forEach var="i" begin="01" end="12" step="1">
								<option value="${i }">${i }</option>
							</c:forEach>
					</select>월 <select id="${data.dd.day1 }" name="day1">
							<c:forEach var="i" begin="01" end="31" step="1">
								<option value="${i }">${i }</option>
							</c:forEach>
					</select>일 ~ <select name="${data.dd.year2 }">
							<option value="2018" selected="selected">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
					</select>년 <select name="${data.dd.month2 }">
							<c:forEach var="i" begin="01" end="12" step="1">
								<option value="month">${i }</option>
							</c:forEach>
					</select>월 <select name="${data.dd.day2 }">
							<c:forEach var="i" begin="01" end="31" step="1">
								<option value="day">${i }</option>
							</c:forEach>
					</select>일</td>

					<td><select id="steam">
							<option value="all" selected="selected">전체</option>
							<c:forEach items="${data.dd }" var="stad">
								<option value="${stad.stadium }">${stad.stadium }</option>
							</c:forEach>
							<option value="nothing">선택하지 않음(통합)</option>
					</select>구장</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<form action="listDay" method="post">
						<input type="submit" value="일별 조회" />
					</form>
					
					<!-- <input type="button" onclick="dayClick('listDay')" value="일별 조회" /> 
					<input type="button" onclick="monthClick('listMonth')" value="월별 조회" /> 
					<input type="button" onclick="yearClick('listYear')" value="년도별 조회" /> 
					<input type="button" onclick="allClick('listAll')" value="전체 조회" /> -->
					</td>
				</tr>
				</table> --%>

			<br>
			<table border="1" align="center">
				<tr>
					<td align="center">정산 날짜</td>
					<td>구장명</td>
					<td>총 수익</td>
					<td>지출</td>
					<td>홈팀 분배</td>
					<td>원정팀 분배</td>
					<td>kbo 분배</td>
					<td>순수익</td>
				</tr>
				<c:forEach items="${mdata }" var="sta">
					<tr>
						<td>${sta.billdate }</td>
						<td align="center">${sta.stadium }</td>
						<td>${sta.deposit }</td>
						<td>${sta.withdraw }</td>
						<td>${sta.home }</td>
						<td>${sta.away }</td>
						<td>${sta.kbo }</td>
						<td>${sta.we }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>