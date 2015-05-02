<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chemisbox Forum</title>
<jsp:include page="base/head.jsp"></jsp:include>
<script src="${baseURL}/assets/js/ckeditor.js"></script>
<script src="${baseURL}/assets/js/config.js"></script>
<script src="${baseURL}/assets/js/styles.js"></script>
<script src="${baseURL}/assets/js/lang/vi.js"></script>
</head>
<body>
	<section id="header" class="appear"></section>
	<div class="navbar navbar-fixed-top" role="navigation"
		data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);"
		data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="fa fa-bars color-white"></span>
				</button>
				<h1>
					<a class="navbar-brand" href="${baseURL}"
						data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a>
				</h1>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" data-0="margin-top:20px;"
					data-300="margin-top:5px;">
					<li class="active"><a href="${baseURL}">Trang chủ</a></li>
					<li><a href="${baseURL}/forum">Forum</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<section class="featured" style="padding: 60px 0 40px;"> </section>

	<section class="section appear clearfix" style="padding: 250px 0;">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
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
                                <label for="userName">Email</label>
                                <input type="text" class="form-control" id="email" placeholder="Email" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" placeholder="Mật khẩu" required="required"/>
                            </div>
                            <div class="form-group">
						        <label><a href="${baseURL}/loadRegister">Đăng ký tại đây</a></label>
							 </div>
                            <button type="button" id="btnLogin" class="btn btn-primary"><i class="fa fa-sign-in"></i>&nbsp;Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
		</div>
	</div>
	</section>
	<jsp:include page="base/footer.jsp"></jsp:include>
	<script>
	 $(function() {
		
		$("#email, #password").keyup(function(e) {
			var code = e.keyCode || e.which;
			if(code == 13){
				$("#btnLogin").click();
			}
		});
		
		$("#btnLogin").click(function() {
			var email = $.trim($("#email").val());
			var password = $.trim($("#password").val());
			
			if(stringIsNullOrEmpty(email) || stringIsNullOrEmpty(password)){
				$("#loginMessage").css("display", "block");
				$("#errorMessage").html("Tài khoản và mật khẩu không được để trống!");
				return;
			}
		
			var model = {"email": email, "password" : password};
			
			$.ajax({
				url : "${baseURL}/doAuth",
				type : "POST",
				data : JSON.stringify(model),
				dataType : "json",
				contentType : "application/json",
				success : function(data) {
					if(stringIsNullOrEmpty(data.errorMessage)){
						window.location = "${baseURL}/forum";
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