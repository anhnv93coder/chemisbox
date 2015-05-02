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
			<div class="col-md-12">
				<h3>Ask question</h3>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<div class="your-answer">
					<div class="col-md-12">
						<div class="form-group">
							<label for="exampleInputEmail1">Tiêu đề</label> <input
								type="text" class="form-control" id="title"
								placeholder="Tiêu đề">
						</div>
						<textarea id="ckeditor" class="ckeditor" name="editor1"></textarea>
						<div class="form-group" style="margin: 10px auto;">
							<label for="exampleInputEmail1">Tag</label> <input type="text"
								class="form-control" id="tag" placeholder="Hữu cơ, Vô cơ,...">
						</div>
						<button type="button" class="btn btn-primary" id="btnSendQuestion"
							style="margin: 20px auto;">Gửi câu hỏi của bạn</button>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item active"> Hot question </a> <a
						href="#" class="list-group-item">Dapibus ac facilisis in</a> <a
						href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
						class="list-group-item">Porta ac consectetur ac</a> <a href="#"
						class="list-group-item">Vestibulum at eros</a> <a href="#"
						class="list-group-item">Dapibus ac facilisis in</a> <a href="#"
						class="list-group-item">Morbi leo risus</a> <a href="#"
						class="list-group-item">Porta ac consectetur ac</a> <a href="#"
						class="list-group-item">Vestibulum at eros</a>
				</div>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="base/footer.jsp"></jsp:include>
	<script type="text/javascript">
	
		$("#btnSendQuestion").click(function() {
						
			var title = $.trim($("#title").val());
			var content = CKEDITOR.instances['ckeditor'].getData();
			var tag = $.trim($("#tag").val());

			var model = {
				title : title,
				content : content,
				tagName : tag
			};

			$.ajax({
				url : '${baseURL}/ask/add',
				dataType : "json",
				contentType : "application/json",
				type : 'POST',
				data : JSON.stringify(model),
				success : function(data) {
					if (!stringIsNullOrEmpty(data.errorMessage)) {
						alert(data.errorMessage);
					} else {
						alert("Success");
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