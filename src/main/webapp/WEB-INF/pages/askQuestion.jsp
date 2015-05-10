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
					<li><a href="${baseURL}/forum">Diễn đàn</a></li>
					<c:if test="${not empty userObject}">
						<li><a>Xin chào: ${userObject.fullName}</a></li>
						<li><a href="${baseURL}/logout">Đăng xuất</a></li>
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
				<h3>Đặt câu hỏi</h3>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<div class="your-answer">
					<div class="col-md-12">
						<div class="alert alert-warning alert-dismissible" role="alert" id="askErrorMsg" style="display:none">
							<i class="fa fa-frown-o fa-2x"></i>&nbsp;<span id="errorMessage"></span>
						</div>
						<div class="alert alert-success alert-dismissible" role="alert" id="askSuccessMsg" style="display:none">
							<i class="fa fa-check fa-2x"></i>&nbsp;<span id="successMessage">Gửi câu hỏi thành công.</span>&nbsp;<a href="${baseURL}/forum">Quay lại diễn đàn</a>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Tiêu đề</label> 
							<input type="text" class="form-control" id="title" placeholder="Tiêu đề">
						</div>
						<textarea id="ckeditor" class="ckeditor" name="editor1"></textarea>
						<div class="form-group" style="margin: 10px auto;">
							<label for="exampleInputEmail1">Tag</label> <input type="text"
								class="form-control" id="tag" placeholder="Hữu cơ, Vô cơ,...">
						</div>
						<button type="button" class="btn btn-primary" id="btnSendQuestion"
							style="margin: 20px auto;">Gửi câu hỏi</button>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<c:if test="${not empty askQuestionModel.topQuestionList}">
					<div class="list-group">
					<a href="#" class="list-group-item list-group-item-info"><strong>Câu hỏi có lượt xem nhiều nhất</strong></a>
						<c:forEach items="${askQuestionModel.topQuestionList}" var="topQuestion">		 
							<a href="${baseURL}/question/${topQuestion.questionId}" class="list-group-item">${topQuestion.title}</a>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${not empty askQuestionModel.questionHaveNotAnswerList}">
					<div class="list-group">
					<a href="#" class="list-group-item list-group-item-warning"><strong>Câu hỏi chưa có câu trả lời</strong></a>
						<c:forEach items="${askQuestionModel.questionHaveNotAnswerList}" var="questionHaveNotAnswer">		 
							<a href="${baseURL}/question/${questionHaveNotAnswer.questionId}" class="list-group-item">${questionHaveNotAnswer.title}</a>
						</c:forEach>
					</div>
				</c:if>
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
			
			if(stringIsNullOrEmpty(title)){
				$("#askSuccessMsg").css("display", "none")
				$("#askErrorMsg").css("display", "block")
				$("#errorMessage").html("Tiêu đề của câu hỏi không được để trống.");
				return;
			}

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
						$("#askSuccessMsg").css("display", "none")
						$("#askErrorMsg").css("display", "block")
						$("#errorMessage").html(data.errorMessage);
					} else {
						$("#askErrorMsg").css("display", "none")
						$("#askSuccessMsg").css("display", "block")
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