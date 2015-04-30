<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="base/head.jsp"></jsp:include>
<script src="${baseURL}/assets/js/ckeditor.js"></script>
<script src="${baseURL}/assets/js/config.js"></script>
<script src="${baseURL}/assets/js/styles.js"></script>
<script src="${baseURL}/assets/js/lang/vi.js"></script>

<title>Question</title>
</head>
<body>
	<section id="header" class="appear"></section>
    <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="fa fa-bars color-white"></span>
                </button>
                <h1><a class="navbar-brand" href="index.html" data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a></h1>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                    <li class="active"><a href="index.html">Trang chủ</a></li>
                    <li><a href="#section-works">Bảng tuần hoàn</a></li>
                    <li><a href="#section-about">Thông tin</a></li>
                    <li><a href="#section-contact">Liên hệ</a></li>
                </ul>
            </div><!--/.navbar-collapse -->
        </div>
    </div>

    <section class="featured" style="padding: 60px 0 40px;">
    </section>

    <section class="section appear clearfix">
        <div class="container">
            <div class="row">
				<div class="col-md-12">
					<h3>${loadQuestionModel.question.title}</h3>
					<hr/>
				</div>
            </div>
			<div class="row">
				<div class="col-md-9">
					<div class="question-block clearfix">
						<div class="col-md-1">
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<h3 class="text-center">4</h3>
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<p class="text-center"><i class="fa fa-star fa-2x"></i></p>
						</div>
						<div class="col-md-11" style="padding: 10px 0;">
							${loadQuestionModel.question.content}
							<div class="tag-block">
								<a href="#"><span class="label label-danger"><i class="fa fa-tag"></i>&nbsp;HTC<span></span></span></a>
								<a href="#"><span class="label label-danger"><i class="fa fa-tag"></i>&nbsp;HTC<span></span></span></a>
							</div>
							<div class="alert alert-success col-md-4 pull-right">
								<p><a href="#">Đăng bởi: ${loadQuestionModel.question.user.fullName}</a></p>
								<span>${loadQuestionModel.question.createdDate}</span>
							</div>
						</div>
					</div>
					<c:if test="${!empty loadQuestionModel.answerList}">
						<div class="answers-block clearfix">
							<h4>1 Answers</h4>
							<c:forEach items="${loadQuestionModel.answerList}" var="answer">
								<hr/>
								<div class="col-md-1">
									<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
									<h3 class="text-center">4</h3>
									<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
									<p class="text-center"><i class="fa fa-star fa-2x"></i></p>
								</div>
								<div class="col-md-11" style="padding: 10px 0;">
									${answer.content}
								</div>
							</c:forEach>
						</div>
					</c:if>
					<div class="your-answer clearfix" style="margin-top: 50px;">
						<h4>Your answer</h4>
						<hr/>
						<div class="col-md-12">
							<textarea id="ckeditor" class="ckeditor" name="editor1"></textarea>
							<button id="btnSendAnswer" type="button" class="btn btn-primary" style="margin: 20px auto;">Post your answer</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="list-group">
						<a href="#" class="list-group-item active">
							Hot question
						</a>
						<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
						<a href="#" class="list-group-item">Morbi leo risus</a>
						<a href="#" class="list-group-item">Porta ac consectetur ac</a>
						<a href="#" class="list-group-item">Vestibulum at eros</a>
						<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
						<a href="#" class="list-group-item">Morbi leo risus</a>
						<a href="#" class="list-group-item">Porta ac consectetur ac</a>
						<a href="#" class="list-group-item">Vestibulum at eros</a>
					</div>
				</div>
			</div>
        </div>
    </section>
	<jsp:include page="base/footer.jsp"></jsp:include>
	<script type="text/javascript">
		
		$("#btnSendAnswer").click(function() {
			var value = CKEDITOR.instances['ckeditor'].getData();
			
		});
	</script>
</body>
</html>