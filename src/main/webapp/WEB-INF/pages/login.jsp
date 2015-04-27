<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<c:if test="${not empty adminObject}">
	<c:redirect url="/admin/dashboard"></c:redirect>
</c:if>
<title>Đăng nhập</title>

<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="${baseURL}/assets/css/bootstrap.css">
<!-- Custom styles for this template -->
<link href="${baseURL}/assets/css/admin-style.css" rel="stylesheet">

</head>

<body>
	
	<div class="container">
            <div class="col-md-4 col-md-offset-4" style="margin-top: 20%;">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h1 class="panel-title"><i class="fa fa-flask fa-lg"></i><strong>&nbsp;Chemisbox</strong></h1>
                    </div>
                    <div class="panel-body">
                        <form style="padding: 15px;margin: 0 auto;">
                        	<div class="alert alert-warning alert-dismissible" role="alert" id="loginMessage" style="display:none">
								<strong>Warning!</strong>&nbsp;<span id="errorMessage"></span>
							</div>
                            <div class="form-group">
                                <label for="userName">Tài khoản</label>
                                <input type="text" class="form-control" id="userName" placeholder="Tài khoản" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" placeholder="Mật khẩu" required="required"/>
                            </div>
                            <button type="button" id="btnLogin" class="btn btn-primary"><i class="fa fa-sign-in"></i>&nbsp;Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="${baseURL}/assets/js/jquery.js"></script>
	<script src="${baseURL}/assets/js/bootstrap.min.js"></script>
	<script src="${baseURL}/assets/js/admin.js"></script>
	<script>
	$(function() {
		
		$("#userName, #password").keyup(function(e) {
			var code = e.keyCode || e.which;
			if(code == 13){
				$("#btnLogin").click();
			}
		});
		
		$("#btnLogin").click(function() {
			var userName = $.trim($("#userName").val());
			var password = $.trim($("#password").val());
			
			if(stringIsNullOrEmpty(userName) || stringIsNullOrEmpty(password)){
				$("#loginMessage").css("display", "block");
				$("#errorMessage").html("Tài khoản và mật khẩu không được để trống!");
				return;
			}
		
			var model = {"userName": userName, "password" : password};
			
			$.ajax({
				url : "${baseURL}/admin/login",
				type : "POST",
				data : JSON.stringify(model),
				dataType : "json",
				contentType : "application/json",
				success : function(data) {
					if(stringIsNullOrEmpty(data.errorMessage)){
						window.location = "${baseURL}/admin";
					}else{
						$("#loginMessage").css("display", "block");
						$("#errorMessage").html(data.errorMessage);
					}
				},
				error : function(msg) {
					console.log(msg);
				}
			});
			
		});
		
	});
		
	</script>
</body>
</html>
