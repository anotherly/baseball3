<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="delete" method="post">
<input type="hidden" name="id" value="${vo.id }" />
	<table border="">
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<tr>
			
			<td colspan="2" align="center">
				<input type="submit" value="삭제"/>
				<a href="view?id=${vo.id }">뒤로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>