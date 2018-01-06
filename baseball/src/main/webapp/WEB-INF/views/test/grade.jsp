<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<form action="ticket" method="post">

<!-- 병화형님 value에다가 형이 넘겨주신방식으로 넣으시면됩니다 -->
<input type="hidden" value="SAMSUNG" name="stadium"/>
<input type="text" value="2018" name="match_year"/>
<input type="text" value="1" name="match_month"/>
<input type="text" value="24" name="match_day"/>

<!--  여기까지     -->
<input type="hidden" value="${loginVo.userid }" name="user_id"/>

<table border=1>
<tr>
<td>
<div class="tab_con b0" id="b0" style="display: block;"><img src="../resources/img/All.png" alt="모든구역"/></div>
<div class="tab_con b1" id="b1" style="display: none"><img src="../resources/img/VIP.png" alt="VIP구역" /></div> 
<div class="tab_con b2" id="b2" style="display: none;"><img src="../resources/img/R-1.png" alt="R-1구역"/></div> 
<div class="tab_con b3" id="b3" style="display: none;"><img src="../resources/img/R-2.png" alt="R-2구역"/></div> 
<div class="tab_con b4" id="b4" style="display: none;"><img src="../resources/img/S-1.png" alt="S-1구역"/></div> 
<div class="tab_con b5" id="b5" style="display: none;"><img src="../resources/img/S-2.png" alt="S-2구역"/></div> 
<div class="tab_con b6" id="b6" style="display: none;"><img src="../resources/img/A-1.png" alt="A-1구역"/></div> 
<div class="tab_con b7" id="b7" style="display: none;"><img src="../resources/img/A-2.png" alt="A-2구역"/></div> 
</td>

<td>

<p id="tabid">

 <input type="radio" name="seat" value="b1" id="VIP"><label for="VIP">VIP구역</label><br>
 <input type="radio" name="seat" value="b2" id="R1"><label for="R1">R-1구역</label><br>
 <input type="radio" name="seat" value="b3" id="R2"><label for="R2">R-2구역</label><br>
 <input type="radio" name="seat" value="b4" id="S1"><label for="S1">S-1구역</label><br>
 <input type="radio" name="seat" value="b5" id="S2"><label for="S2">S-2구역</label><br>
 <input type="radio" name="seat" value="b6" id="A1"><label for="A1">A-1구역</label><br>
 <input type="radio" name="seat" value="b7" id="A2"><label for="A2">A-2구역</label><br>
</p>
<input type="submit" value="다음으로"/>
</td>

</tr>
</table>
</form>

<script type=text/javascript>  
  /* $('#tabid a').on('click',function(){
	    var _this = $(this);
	    var tab_con = $('.tab_con');

	    _this.siblings().removeClass('on');
	    _this.addClass('on');
	    tab_con.css('display','none');
	    $('.tab_con.'+_this.attr('href')).css('display','block');
	    return false;
	}); */
	
	
  $('#tabid input[type=radio]').on('click',function(){
	  
	 
	    var _this = $(this);
	    var tab_con = $('.tab_con');
	   // _this.checked();
	    _this.siblings().removeClass('on');
	    _this.addClass('on');
	    tab_con.css('display','none');
	    $('.tab_con.'+_this.attr('value')).css('display','block');
	    _this.checked = true;
	});

</script>
 
 </body>
 </html>