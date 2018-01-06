<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

player¿« template

<table style="background-color: #ffa" width="100%">


	<tr>
		<td><c:forEach items="${data.topMenu2 }" var="mm">

				<a href="../../${mm.name}/${mm.url }/list">${mm.korName }</a>

			</c:forEach></td>
	</tr>
	<tr>
		<td><jsp:include page="${data.service }.jsp" /></td>
	</tr>


</table>
