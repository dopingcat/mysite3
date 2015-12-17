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
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath}/board" method="post">
					<input type="text" id="keyword" name="keyword" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${boardData.list}" var="vo" varStatus="stat">
						<tr>
							<td>${vo.no}</td>
							<td class="title">
								<c:if test="${vo.depth > 0 }">
									<img src="${pageContext.request.contextPath }/assets/images/ico-reply.gif">
								</c:if>
								<a href="${pageContext.request.contextPath}/board/view/${vo.no}">${vo.title}</a>
							</td>
							<td>${vo.memberName}</td>
							<td>${vo.viewCount}</td>
							<td>${vo.regDate}</td>
							<td><c:if test="${(not empty authUser) && (vo.memberNo eq authUser.no)}">
								<a href="${pageContext.request.contextPath}/board/delete/${vo.no}">
									<img src="${pageContext.request.contextPath}/assets/images/recycle.png">
								</a>
							</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<c:if test="${boardData.prevBlock > 0 }">
							<li class="pg-prev"><a href="${pageContext.request.contextPath}/board?page=${boardData.prevBlock}&keyword=${boardData.keyword}">◀ 이전</a></li>
						</c:if>
						<c:forEach begin="${boardData.begin}" end="${boardData.end}" varStatus="stat">
							<c:choose>
								<c:when test="${stat.index > boardData.pageCount}">
									<li class="disable">${stat.index}</li>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${stat.index == boardData.currentPage}">
											<li>${stat.index}</li>
										</c:when>
										<c:otherwise>
											<li><a href="${pageContext.request.contextPath}/board?page=${stat.index}&keyword=${boardData.keyword}">${stat.index}</a></li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${boardData.nextBlock > 0 }">
							<li class="pg-next"><a href="${pageContext.request.contextPath }/board?page=${boardData.nextBlock}&keyword=${boardData.keyword}">다음 ▶</a></li>
						</c:if>	
					</ul>	
				</div>
				<c:if test="${not empty authUser}">
					<div class="bottom">
						<a href="${pageContext.request.contextPath}/board/write" id="new-book">글쓰기</a>
					</div>
				</c:if>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="pwd" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>