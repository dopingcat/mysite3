<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${vo.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								<% pageContext.setAttribute("cn", "\n"); %>
								${fn:replace(vo.content, cn, "<br/>")}
							</div>
						</td>
					</tr>
					<tr>
						<td class="label">첨부 파일</td>
						<td>
							<!-- 파일이 있으면 리스트 뿌리기 -->
							<div align="right">
								<form method="post" action="${pageContext.request.contextPath }/upload" enctype="multipart/form-data">
									<input type="file" name="uploadFile">
									<input type="submit" value="upload">
								</form>
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board">글목록</a>
					<c:if test="${(not empty authUser) && (vo.memberNo eq authUser.no)}">
						<a href="${pageContext.request.contextPath}/board/modify/${vo.no}">글수정</a>
					</c:if>
					
					<c:if test="${(not empty authUser) && (vo.memberNo ne authUser.no)}" >
						<a href="${pageContext.request.contextPath}/board/reply/${vo.no}">답글</a>
					</c:if>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="pwd" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>