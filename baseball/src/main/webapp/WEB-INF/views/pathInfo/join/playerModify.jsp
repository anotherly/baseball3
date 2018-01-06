<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
function fileDelete(){
	if(confirm("파일을 삭제하시겠습니까?"))
	{
		fmt.action="FileDelete"
		fmt.submit()
	}
	
}


</script>

</head>
<body>
<form name="fmt" action="detail?playerId=${data.dd.playerId}" method="post" enctype="multipart/form-data">
<input type="hidden" name="playerId" value="${data.dd.playerId }"/>
	<table  border="">
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="playerName" value="${data.dd.playerName }"/></td>
		</tr>
		<%--  <tr>
				<td>구단명</td>
				<td><select name="teamId">

						<option selected="selected" value="">${data.dd.teamId }</option>
						<option value="1">두산</option>
						<option value="2">NC</option>
						<option value="3">넥센</option>
						<option value="4">LG</option>
						<option value="5">KIA</option>
						<option value="6">SK</option>
						<option value="7">한화</option>
						<option value="8">롯데</option>
						<option value="9">삼성</option>
						<option value="10">kt</option>

				</select></td>
			</tr> 
			<c:choose>
			<c:when test="${data.dd.sysFile!=null && data.dd.sysFile!='null'}">
				<c:choose>
					<c:when test="${data.dd.img }">
						<img alt="" src="../../../resources/${data.dd.sysFileEnc}">
					</c:when>
					<c:otherwise>
						${data.dd.sysFile}
					</c:otherwise>
				</c:choose>
				<input type="hidden" name="sysFile" value="${data.dd.sysFile }" />	
				<a href="javascript:fileDelete();">파일삭제</a>
			</c:when>
			
			<c:otherwise>
				<input type="file" name="sysFile"  value="${data.dd.sysFile }"/>
			</c:otherwise>
		</c:choose>	
			<tr>
				<td>등번호</td>
				<td><input type="text" name="backNum" value="${data.dd.backNum }"/></td>
			</tr>
			<tr>
				<td>포지션</td>
				<td><input type="text" name="position" value="${data.dd.position }"/></td>
			</tr>
			<tr>
				<td>출신교</td>
				<td><input type="text" name="schoolName" value="${data.dd.schoolName }"/></td>
			</tr>
			<tr>
				<td>신장</td>
				<td><input type="text" name="height" value="${data.dd.height }"/></td>
			</tr>
			<tr>
				<td>체중</td>
				<td><input type="text" name="weight" value="${data.dd.weight }"/></td>
			</tr>
			<tr>
				<td>국적</td>
				<td><input type="text" name="country" value="${data.dd.country }"/></td>
			</tr>
			<tr>
				<td>연봉</td>
				<td><input type="text" name="salary" value="${data.dd.salary }"/></td>
			</tr>
			<tr>
				<td>투</td>
				<td><input type="text" name="pitchingHand" value="${data.dd.pitchingHand }"/></td>
			</tr>
			<tr>
				<td>타</td>
				<td><input type="text" name="battingHand" value="${data.dd.battingHand }"/></td>
			</tr> 		
		<tr> --%>
			
			<td colspan="2" align="center">
			<input type="submit" value="수정" />
			<a href="view?playerId=${data.dd.playerId }">뒤로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>