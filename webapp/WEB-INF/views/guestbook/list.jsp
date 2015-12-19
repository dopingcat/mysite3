<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="guestbook">
				<c:choose>
					<c:when test="${not empty authUser}">
						<form action="${pageContext.request.contextPath}/guestbook/write" method="post">
							<table>
								<tr>
									<td align="center">이름</td>
									<td><input type="hidden" name="name" value="${authUser.name}"><b>${authUser.name}</b></td>
									<td align="center">비밀번호</td>
									<td><input type="password" name="password"></td>
								</tr>
								<tr>
									<td colspan=4><textarea name="message" id="message"></textarea></td>
								</tr>
								<tr>
									<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
								</tr>
							</table>
						</form>
					</c:when>
					<c:otherwise>
						방명록을 남기시려면 로그인을 하세요.
					</c:otherwise>
				</c:choose>
				<ul>
					<% pageContext.setAttribute("cn", "\n"); %>
					<c:set var="total" value="${fn:length(guestBookList)}" />
					<c:forEach items="${guestBookList}" var="vo" varStatus="stat">
						<li>
							<table>
								<tr>
									<td align="center">[${total - stat.index}]</td>
									<td>작성자 : ${vo.name}</td>
									<td>작성일시 : ${vo.regDate}</td>
									<td align="center"><a href="/${vo.no}">삭제</a></td>
								</tr>
								<tr>
									<td colspan="4">${fn:replace(vo.message, cn, "<br/>")}</td>
								</tr>
							</table>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"/>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>