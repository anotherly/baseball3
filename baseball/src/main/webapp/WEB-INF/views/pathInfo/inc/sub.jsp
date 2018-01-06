<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("¼­ºê.jsp ");
%>
<table width="100%">
	<c:forEach items="${data.subMenu }" var="mm">
		<tr>
			<td align="center"><a href="../${mm.name}/${mm.url }">${mm.korName }</a></td>
		</tr>
	</c:forEach>
</table>