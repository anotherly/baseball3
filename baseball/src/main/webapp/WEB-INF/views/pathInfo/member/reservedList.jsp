<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">


$(document).on("click",".btn",function(){  
	var btn = $(this);
	var tr = btn.parent().parent();
	var td = tr.children();

	var res = confirm(td.eq(1).text()+'-'+td.eq(2).text()+'-'+td.eq(3).text()+'일자 \n\r'+
		td.eq(4).text()+'홈 구장 경기입니다.\r\n'+td.eq(5).text()+'구역'+
		td.eq(6).text()+'행'+td.eq(7).text()+'열 좌석 예매를 취소하시겠습니까?');
		
	if(res){
		

var $form = $('<form></form>');

$form.attr('action', 'cancel');
$form.attr('method', 'post');
$form.appendTo('body');
var example_1 = $('<input type="hidden" value="'+td.eq(8).text()+'" name="ticketinfo">'); 
var example_2 = $('<input type="hidden" value="'+td.eq(3).text()+'" name="match_day">'); 
$form.append(example_1);
$form.append(example_2);
$form.submit();
alert('예매가 취소되었습니다.');
	}else{
	}
});
		

</script>

</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
<c:set var="sysMonth"><fmt:formatDate value="${now}" pattern="MM" /></c:set>
<c:set var="sysDay"><fmt:formatDate value="${now}" pattern="dd" /></c:set>
<c:set var="fullNow"><fmt:formatDate value="${now }" pattern="yyyyMMdd"/></c:set>
<c:out value="${sysYear}" /> - <c:out value="${sysMonth }"/> - <c:out value="${sysDay }" /> 일 입니다.
환불시 유의사항<br>
1. 환불이 가능한 날짜는 경기시작시간 +24h 입니다.<br>
2. 환불 시 환불수수료가 부가됩니다.<br>
	- 2~3일 내 : 환불수수료 없음.<br>
	- 1~2일 내 : 환불수수료 10%.<br>
	- 경기시작전 ~ 1일 내 : 환불수수료 20%. <br>
	- 경기시작 후 : 환불수수료 100%. <br>


	<table border="1" width="100%" id="tbl">
		<tr align="center">
			<td>번호</td>
			<td>시즌</td>
			<td>월</td>
			<td>일</td>
			<td>구장</td>
			<td>구역</td>
			<td>행</td>
			<td>열</td>
			<td>티켓</td>
			<td>결제여부</td>
			<td>환불정보</td>
		</tr>
		<c:forEach items="${data.dd }" var="i" varStatus="no">
	<%-- 	<c:choose>
		<c:when test="${i.match_month - 10 >=0  }">
		<c:set var="match_date"><fmt:parseDate value="${i.match_year}${i.match_month}${i.match_day}" pattern="yyyyMMdd"/></c:set>
			</c:when>
			<c:otherwise>
		<c:set var="match_date"><fmt:parseDate value="${i.match_year*10}${i.match_month}${i.match_day}" pattern="yyyyMMdd"/></c:set>
			</c:otherwise>
		</c:choose>
		
		<fmt:formatDate value="${now}" pattern="yyyyMMdd" var="nowDate" />
		<fmt:formatDate value="${match_date}" pattern="yyyyMMdd" var="matchDate"/> 
	<c:choose>
		<c:when test="${matchDate < nowDate}">
		</c:when>
		<c:otherwise> --%>
			<tr align="center">
				<td>${no.index+1 }</td>
				<td>${i.match_year }</td>
				<td>${i.match_month }</td>
				<td>${i.match_day }</td>
				<td>${i.stadium }</td>
				<td>${i.seat }</td>
				<td>${i.listt }</td>
				<td>${i.line }</td>
				<td>${i.ticketinfo }</td>
				<td>
				<c:choose>
						<c:when test="${i.paid eq 1}">
				결제완료
				</c:when>
						<c:otherwise>
				예매취소
				</c:otherwise>
					</c:choose></td>
				<c:choose>
<%-- 						class="${i.ticketinfo }${i.stadium }${i.match_day }" --%>
						<c:when test="${i.paid eq 1 }">
					<td>	<input type="button" value="예매취소" 
						class="btn" /> </td>

						</c:when>
						<c:otherwise>
						<td>-</td>
						</c:otherwise>
					</c:choose>
			</tr>
	<%-- 	</c:otherwise>
	</c:choose> --%>
		</c:forEach>
	</table>
</body>
</html>