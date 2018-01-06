<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("Å¾ ·Î¾î.jsp ");
%>
<table width="100%">
	<tr>
		<c:forEach items="${data.topMenu }" var="mm">

			<td><a href="../../${mm.name}/${mm.url }/list">${mm.korName }</a></td>

		</c:forEach>
	</tr>
	<tr>

		<c:choose>
			<c:when test="${loginVo.grade eq 'admin' }">
				<c:forEach items="${data.managerMenu }" var="mm">
					<td><a href="../../${mm.name}/${mm.url }/list">${mm.korName }</a></td>
				</c:forEach>
			</c:when>
		</c:choose>

	</tr>
</table>