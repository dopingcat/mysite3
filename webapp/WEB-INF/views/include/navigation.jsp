<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="navigation">
		<ul>
			<c:choose>
				<c:when test="${param.pwd eq 'main'}">
					<li class="selected"><a href="${pageContext.request.contextPath}/">권대혁</a></li>
					<li><a href="${pageContext.request.contextPath}/guestbook">방명록</a></li>
					<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				</c:when>
				<c:when test="${param.pwd eq 'guestbook'}">
					<li><a href="${pageContext.request.contextPath}/">권대혁</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/guestbook">방명록</a></li>
					<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				</c:when>
				<c:when test="${param.pwd eq 'board'}">
					<li><a href="${pageContext.request.contextPath}/">권대혁</a></li>
					<li><a href="${pageContext.request.contextPath}/guestbook">방명록</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/">권대혁</a></li>
					<li><a href="${pageContext.request.contextPath}/guestbook">방명록</a></li>
					<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>