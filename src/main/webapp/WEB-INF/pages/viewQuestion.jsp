<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.chemisbox.constant.ChemisboxConstant" %>
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
                <h1><a class="navbar-brand" href="${baseURL}" data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a></h1>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                    <li class="active"><a href="${baseURL}">Trang chủ</a></li>
                    <li class="active"><a href="${baseURL}/forum">Diễn đàn</a></li>
                    <li><a href="${baseURL}/ask">Đặt câu hỏi</a></li>
                    <c:if test="${empty userObject}">
                    	<li><a href="${baseURL}/login">Đăng nhập</a></li>	
                    </c:if>
                    <c:if test="${not empty userObject}">
                    	<li><a>Xin chào: ${userObject.fullName}</a></li>
                    	<li><a href="${baseURL}/logout">Đăng xuất</a></li>
                    </c:if>
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
					<div class="row question-block clearfix">
						<div class="col-md-1">
							<p class="text-center"><i class="fa fa-question-circle fa-2x"></i></p>
							<p class="text-center"><a href="#" title="Favorite question"><i class="fa fa-star fa-2x"></i></a></p>
						</div>
						<div class="col-md-11" style="padding: 10px 0;">
							${loadQuestionModel.question.content}
							<div class="tag-block">
								<c:forEach items="${loadQuestionModel.question.questionTagList}" var="questionTag">
									<a href="#" class="btn btn-danger btn-sm"><i class="fa fa-tag"></i>&nbsp;<strong>${questionTag.tag.tagName}</strong></a>	
								</c:forEach>
							</div>
							<div class="alert alert-info col-md-4 pull-right">
								<p>Đăng bởi: <a href="#"><strong>${loadQuestionModel.question.user.fullName}</strong></a></p>
								<span>${loadQuestionModel.question.createdDate}</span>
							</div>
						</div>
					</div>
					<c:if test="${!empty loadQuestionModel.answerList}">
						<div class="answers-block clearfix">
							<h3>${loadQuestionModel.answerCount} câu trả lời</h3>
							<c:forEach items="${loadQuestionModel.answerList}" var="answer">
								<hr/>
								<div class="row">
									<div class="col-md-1">
										<p class="text-center"><i class="fa fa-quote-left fa-2x"></i></p>
										<c:if test="${not empty userObject}">
											<c:if test="${userObject.email eq loadQuestionModel.question.user.email and loadQuestionModel.question.goodAnswerId < 0}">
												<p class="text-center"><a href="#" onclick="doVoteGoodAnswer(${loadQuestionModel.question.questionId}, ${answer.answerId})" title="Bình chọn câu trả lời tốt nhất"><i class="fa fa-check-square fa-2x"></i></a></p>
											</c:if>
										</c:if>
										<c:if test="${loadQuestionModel.question.goodAnswerId eq answer.answerId}">
											<p class="text-center"><a title="Đây là câu trả lời tốt nhất"><i class="fa fa-check fa-2x"></i></a></p>
										</c:if>
									</div>
									<div class="col-md-11" style="padding: 10px 0;">
										<p>${answer.content}</p>
										<div class="alert alert-info col-md-4 pull-right">
											<p>Trả lời bởi: <a><strong>${answer.user.fullName}</strong></a></p>
											<span>${answer.answerDate}</span>
										</div>
									</div>
								</div>
							</c:forEach>
							
						</div>
					</c:if>
					<div class="your-answer clearfix" style="margin-top: 50px;">
						<h3>Gửi câu trả lời của bạn</h3>
						<hr/>
						<input type="hidden" value="${loadQuestionModel.question.questionId}" id="questionId"/>
						<div class="col-md-12">
							<textarea id="ckeditor" class="ckeditor" name="editor1"></textarea>
							<button id="btnSendAnswer" type="button" class="btn btn-primary" style="margin: 20px auto;">Gửi câu trả lời</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<c:if test="${not empty loadQuestionModel.topQuestionList}">
						<div class="list-group">
						<a href="#" class="list-group-item list-group-item-info"><strong>Câu hỏi có lượt xem nhiều nhất</strong></a>
							<c:forEach items="${loadQuestionModel.topQuestionList}" var="topQuestion">		 
								<a href="${baseURL}/question/${topQuestion.questionId}" class="list-group-item">${topQuestion.title}</a>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${not empty loadQuestionModel.questionHaveNotAnswerList}">
						<div class="list-group">
						<a href="#" class="list-group-item list-group-item-warning"><strong>Câu hỏi chưa có câu trả lời</strong></a>
							<c:forEach items="${loadQuestionModel.questionHaveNotAnswerList}" var="questionHaveNotAnswer">		 
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
		var CB_001 = '<%= ChemisboxConstant.CB_001 %>' 
		
		$("#btnSendAnswer").click(function() {
			
			var content = CKEDITOR.instances['ckeditor'].getData();
			var questionId = $("#questionId").val(); 
			
			//validate
			
			var model = {
				content : content,
				questionId : questionId
			};

			$.ajax({
				url : '${baseURL}/answer',
				dataType : "json",
				contentType : "application/json",
				type : 'POST',
				data : JSON.stringify(model),
				success : function(data) {
					if (!stringIsNullOrEmpty(data.errorMessage)) {
						if(data.errorMessage.localeCompare(CB_001) == 0){
							window.location = "${baseURL}/login";
						} else {
							alert(data.errorMessage);	
						}
					} else {
						window.location = "${baseURL}/question/${loadQuestionModel.question.questionId}";
					}
				},
				error : function(data) {
					alert(JSON.stringify(data));
				}
			});
		});
		
		function doVoteGoodAnswer(questionId, answerId) {
			//validate
			
			var model = {
				answerId : answerId,
				questionId : questionId
			};

			$.ajax({
				url : '${baseURL}/answer/vote',
				dataType : "json",
				contentType : "application/json",
				type : 'POST',
				data : JSON.stringify(model),
				success : function(data) {
					if (!stringIsNullOrEmpty(data.errorMessage)) {
						if(data.errorMessage.localeCompare(CB_001) == 0){
							window.location = "${baseURL}/login";
						} else {
							alert(data.errorMessage);	
						}
					} else {
						window.location = "${baseURL}/question/${loadQuestionModel.question.questionId}";
					}
				},
				error : function(data) {
					alert(JSON.stringify(data));
				}
			});
		}
	</script>
</body>
</html>