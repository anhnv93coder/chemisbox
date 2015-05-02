<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.chemisbox.constant.ChemisboxConstant" %>
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
					<c:if test="${not empty userObject}">
						<li><a>Xin chào: ${userObject.fullName}</a></li>
						<li><a href="${baseURL}/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<section class="featured" style="padding: 60px 0 40px;"> </section>

	<section class="section appear clearfix">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
                    <div class="panel-heading">
                        <h1 class="panel-title"><i class="fa fa-user fa-lg"></i><strong>&nbsp;Đăng ký thành viên</strong></h1>
                    </div>
                    <div class="panel-body">
                    	<form>
                    		<div class="alert alert-danger" role="alert" id="errorMessage" style="display: none"></div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label>
								<input type="email" class="form-control" id="email" placeholder="Email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Mật khẩu</label>
								<input type="password" class="form-control" id="password" placeholder="Mật khẩu">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Xác nhận mật khẩu</label>
								<input type="password" class="form-control" id="confirmPassword" placeholder="Xác nhận lại mật khẩu">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Họ và tên</label>
								<input type="text" class="form-control" id="fullName" placeholder="Họ và tên">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Địa chỉ</label>
								<input type="text" class="form-control" id="address" placeholder="Địa chỉ">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Ngày sinh</label>
								<input type="date" class="form-control" id="dataOfBirth" placeholder="Ngày sinh">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Số điện thoại</label>
								<input type="text" class="form-control" id="phoneNumber" placeholder="Số điện thoại">
							</div>
							<button type="button" class="btn btn-danger" id="btnRegister">Đăng ký</button>
						</form>
                    </div>
	            </div>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="base/footer.jsp"></jsp:include>
	<script type="text/javascript">
	
		var emailPattern = /<%= ChemisboxConstant.EMAIL_PATTERN %>/;
	
		$("#btnRegister").click(function() {
						
			var email = $.trim($("#email").val());
			var password = $.trim($("#password").val());
			var confirmPassword = $.trim($("#confirmPassword").val());
			var fullName = $.trim($("#fullName").val());
			var address = $.trim($("#address").val());
			var dateOfBirth = $("#dataOfBirth").val();
			var phoneNumber = $.trim($("#phoneNumber").val());
			
			if(stringIsNullOrEmpty(email) || stringIsNullOrEmpty(password) 
					|| stringIsNullOrEmpty(confirmPassword) || stringIsNullOrEmpty(fullName) 
					|| stringIsNullOrEmpty(address) || stringIsNullOrEmpty(dataOfBirth) || stringIsNullOrEmpty(phoneNumber)){
				$("#errorMessage").css("display", "block");
				$("#errorMessage").html("Vui lòng nhập đầy đủ thông tin");
				return;
			}
			
			if(password.localeCompare(confirmPassword) != 0){
				$("#errorMessage").css("display", "block");
				$("#errorMessage").html("Mật khẩu không khớp");
				return;
			}

			var model = {
				email : email,
				password : password,
				confirmPassword : confirmPassword,
				fullName : fullName,  
				address : address,
				dateOfBirth : dateOfBirth,
				phoneNumber : phoneNumber
			};

			$.ajax({
				url : '${baseURL}/register',
				dataType : "json",
				contentType : "application/json",
				type : 'POST',
				data : JSON.stringify(model),
				success : function(data) {
					if (!stringIsNullOrEmpty(data.errorMessage)) {
						$("#errorMessage").css("display", "block");
						$("#errorMessage").html(data.errorMessage);
					} else {
						$("#errorMessage").css("display", "none");
						alert("Đăng ký thành công. Nhấn Ok để đến trang đăng nhập.");
						window.location = "login";
					}
				},
				error : function(data) {
					alert(JSON.stringify(data));
				}
			});

		});
	</script>
</body>
</html>