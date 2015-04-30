<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<c:if test="${empty userObject}">
	<c:redirect url="/login"></c:redirect>
</c:if>
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
            <div class="col-md-9">
                <c:if test="${!empty forumModel.questionList}">
        	 <div class="row" style="padding: 10px 0;">
                    <div class="">
                        <h3>Top question</h3>
                    </div>
                </div>
                <div class="row">
                    <table class="table">
                    	<c:forEach items="${forumModel.questionList}" var="question">
	                    	<tr>
	                            <td>
	                                <div class="col-md-4">
	                                		<div class="col-sm-4">Votes</div>
                                    		<div class="col-sm-4">Answers</div>
	                                    	<div class="col-sm-4">Views</div>                                	
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
	                                            <span>modified 51 secs ago</span>
	                                        </div>
	                                    </div>                                    
	                                </div>
	                            </td>
	                        </tr>
                    	</c:forEach>
                    
                        <tr>
                            <td>
                                <div class="col-lg-4">
                                    <div class="col-sm-4">Votes</div>
                                	<div class="col-sm-4">Answers</div>
                                   	<div class="col-sm-4">Views</div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="row">
                                        <div class="col-md-12">
                                             <a href="#">How to successfully connect HTC One M8 to Android Studio How to successfully connect HTC One M8 to Android Studio</a>
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 10px;">
                                        <div class="col-md-8">
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-tag fa-lg"></i>&nbsp;HTC</a>
                                        </div>
                                        <div class="col-md-4">
                                            <span>modified 51 secs ago</span>
                                        </div>
                                    </div>                                    
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="col-lg-4">
                                    <div class="col-sm-4">Votes</div>
                                  	<div class="col-sm-4">Answers</div>
                                   	<div class="col-sm-4">Views</div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="row ">
                                        <div class="col-md-12">
                                             <a href="#">How to successfully connect HTC One M8 to Android Studio How to successfully connect HTC One M8 to Android Studio</a>
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 10px;">
                                        <div class="col-md-8">
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-tag fa-lg"></i>&nbsp;HTC</a>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-tag fa-lg"></i>&nbsp;HTC</a>
                                        </div>
                                        <div class="col-md-4">
                                            <span>modified 51 secs ago</span>
                                        </div>
                                    </div>                                    
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
        </c:if>
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
    </section>

	<jsp:include page="base/footer.jsp"></jsp:include>

</body>
</html>