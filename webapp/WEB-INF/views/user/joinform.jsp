<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function() {
	$("#email").change(function() {
		$("#btn-checkemail").show();
		$("#image-checked").hide();
	});
	$("#btn-checkemail").click(function() {
		var email = $("#email").val();
		console.log(email);
		if(email=="") {
			return;
		}
		$.ajax({
			url: "${pageContext.request.contextPath}/api/user/checkemail",
			type: "get",
			dataType: "json",
			data: "email=" + email,
			contentType : "application/json",
			success: function(response) {
				console.log(response);
				if(response.result=="fail") {
					console.error(response.message);
					return;
				}
				if(response.data == false) {
					alert("이미 사용 중입니다");
					var $email = $("#email");
					$email.val("");
					$email.focus();
					return;
				}
				$("#btn-checkemail").hide();
				$("#image-checked").show();
			},
			error: function(jqXHR, status, error) {
				console.error(status + ":" + error);
			}
		});
	});
});
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<img id="image-checked" src="${pageContext.request.contextPath}/assets/images/checked.png" style="width:12px; display:none">
					<input id="btn-checkemail" type="button" value="id 중복체크">
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">

					<fieldset>
						<legend>성별</legend>
						<label>여</label>
						<input type="radio" name="gender" value="female" checked="checked">
						<label>남</label>
						<input type="radio" name="gender" value="male">
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"/>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>