<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Chemisbox Forum</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="base/head.jsp"></jsp:include>

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
                    <li><a href="${baseURL}">Trang chủ</a></li>
                    <li><a href="${baseURL}/ask">Đặt câu hỏi</a></li>
                    <c:if test="${empty userObject}">
                    	<li><a href="${baseURL}/login">Đăng nhập</a></li>	
                    </c:if>
                    <c:if test="${not empty userObject}">
                    	<li><a>Xin chào: ${userObject.fullName}</a></li>
                    	<li><a href="${baseURL}/logout">Logout</a></li>
                    </c:if>
                </ul>
            </div><!--/.navbar-collapse -->
        </div>
    </div>

    <section class="featured" style="padding: 60px 0 40px;">
    </section>

    <section class="section appear clearfix">
        <div class="container">
            <div class="col-md-9">
                <c:if test="${!empty forumModel.questionList}">
        	 <div class="row" style="padding: 10px 0;">
                    <div class="">
                        <h3>Câu hỏi mới nhất</h3>
                    </div>
                </div>
                <div class="row">
                    <table class="table">
                    	<c:forEach items="${forumModel.questionList}" var="question">
	                    	<tr>
	                            <td>
	                                <div class="col-md-4">
                                    		<div class="col-sm-6" style="margin: 10% auto;">${question.answerCounter} Lượt trả lời</div>
                                   			<div class="col-sm-6" style="margin: 10% auto;">${question.views} Lượt xem</div>                                	
	                                </div>
	                                <div class="col-md-8">
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                             <a href="${baseURL}/question/${question.questionId}">${question.title}</a>
	                                        </div>
	                                    </div>
	                                    <div class="row" style="margin-top: 10px;">
	                                        <div class="col-md-8">
												<c:forEach items="${question.questionTagList}" var="questionTag">
													<a href="#" class="btn btn-danger btn-sm"><i class="fa fa-tag fa-lg"></i>&nbsp;${questionTag.tag.tagName}</a>	
												</c:forEach>
											</div>
	                                        <div class="col-md-4">
	                                            <span><fmt:formatDate type="both" value="${question.createdDate}" /></span>
	                                        </div>
	                                    </div>                                    
	                                </div>
	                            </td>
	                        </tr>
                    	</c:forEach>
                    </table>
                </div>
        </c:if>
            </div>
            <jsp:include page="forum/rightBar.jsp"></jsp:include>
        </div>
    </section>

	<jsp:include page="base/footer.jsp"></jsp:include>

</body>
</html>