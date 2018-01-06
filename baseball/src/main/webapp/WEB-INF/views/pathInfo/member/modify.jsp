<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	System.out.println("멤버 모디파이.jsp");
%>
<html>
<script type="text/javascript">
	function fileDelete() {
		if (confirm("파일을 삭제하시겠습니까?")) {
			fmt.action = "fileDelete"
			fmt.submit()
		}

	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	정보 수정
	<form action="modifyReg" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"
					value="${data.dd.userid }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td colspan="2"><input type="text" name="nick"
					value="${data.dd.nick }"></td>
			</tr>
			<tr>
				<td>변경할 비밀번호</td>
				<td colspan="2"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passwordtwo"></td>
				<td><input type="button" name="passcheck" value="확인" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" name="name"
					value="${data.dd.name }"></td>
			</tr>
			<%-- <tr><td>사진</td>
			<td><input type="file" name="file" value="${data.mvo.file }"></td></tr> --%>
		
			<tr>
				<td>사진</td>
				<td><c:choose>
						<c:when test="${data.dd.sysname!=null && data.dd.sysname!='null'}">
							<input type="hidden" name="file" value="${data.dd.sysname }" />
							<a href="javascript:fileDelete();">사진 삭제</a>
						</c:when>
						<c:otherwise>
							<input type="file" name="file" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			
			<tr>
				<td>생년월일</td>
				<td colspan="2"><input type="text" name="birth"
					value="${data.dd.birth }"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td colspan="2"><input type="text" name="address"
					value="${data.dd.address }"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td colspan="2"><input type="text" name="phone"
					value="${data.dd.phone }"></td>
			</tr>
			<tr>
				<td>수신동의</td>
				<td colspan="2"><c:choose>
						<c:when test="${data.dd.receivemail eq '동의'}">
							<input type="radio" name="receivemail" value="동의"
								checked="checked">동의
			<input type="radio" name="receivemail" value="거부">거부			
			</c:when>
						<c:otherwise>

							<input type="radio" name="receivemail" value="동의">동의
			<input type="radio" name="receivemail" value="거부" checked="checked">거부			
			</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>선호구단</td>
				<td colspan="2"><select name="preferTeam">
						<option value=lgtwins
							<c:if test="${data.dd.preferTeam eq 'lgtwins' }">
                              <c:out value="selected" /></c:if>>LG트윈스</option>
						<option value=ncdinos
							<c:if test="${data.dd.preferTeam eq 'ncdinos' }">
                              <c:out value="selected" /></c:if>>NC다이노스</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정" />
					<a href="detail?userid="${data.dd.userid }>뒤로가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>