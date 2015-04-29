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

<title>Insert title here</title>
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
					<h3>How can I write a caching HTTP proxy in Perl?</h3>
					<hr/>
				</div>
            </div>
			<div class="row">
				<div class="col-md-9">
					<div class="question-block">
						<div class="col-md-1">
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<h3 class="text-center">4</h3>
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<p class="text-center"><i class="fa fa-star fa-2x"></i></p>
						</div>
						<div class="col-md-11" style="padding: 10px 0;">
							<p>I intend to write a simple HTTP proxy in Perl using the <a href="http://search.cpan.org/dist/HTTP-Proxy" rel="nofollow">HTTP::Proxy</a> module.
							I'm clear with the very basic task of how to create a proxy and basic filters and stuff. But what I cannot understand is how to manually force-serve a file through cache. </p>

							<p>Basically, the scenario is this that I run this proxy in computer A. The user on computer B accesses web uses this proxy. Now, this proxy will just act as a pass through for all B's requests, until he requests a particular URL (a file, say <a href="http://abc.com/file.zip" rel="nofollow">http://abc.com/file.zip</a>). I need to intercept this request, and instead of allowing him to download the actual file.zip, give him an already downloaded file that I manually kept on computer A.</p>

							<p>Also, note that I might not have a web server running on computer A, so I can't just redirect the url, I need to serve it from cache.</p>

							<p>Any pointers for this would be appreciated.
							Thanks</p>

							<p>Edit: Some more info. I started using HTTP::Daemon and LWP::UserAgent in combination instead of HTTP::Proxy
							So far, I intercept all requests successfully, and then I search the headers for the url. If the particular filename is not there, I just pass the request to actual destination using LWP:UserAgent (simple_request) and return the response to original sender using send_response. If I find the filename, I don't further forward the request, instead I'm trying to serve my particular file using "send_file_response" method. The problem is that all other requests  are working fine and comp B is able to surf the net, but when it tries to download this file, it just keeps waiting for a response.
							About using squid, It is not an option for me to install squid on these machines.</p>
							<div class="tag-block">
								<a href="#"><span class="label label-danger"><i class="fa fa-tag"></i>&nbsp;HTC<span></span></span></a>
								<a href="#"><span class="label label-danger"><i class="fa fa-tag"></i>&nbsp;HTC<span></span></span></a>
							</div>
							<div class="alert alert-success col-md-4 pull-right">
								<p><a href="#">Đăng bởi: Nguyen Viet Anh</a></p>
								<span>Apr 3 '09 at 22:00</span>
							</div>
						</div>
					</div>
					<div class="answers-block">
						<h4>1 Answers</h4>
						<hr/>
						<div class="col-md-1">
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<h3 class="text-center">4</h3>
							<p class="text-center"><i class="fa fa-code fa-2x"></i></p>
							<p class="text-center"><i class="fa fa-star fa-2x"></i></p>
						</div>
						<div class="col-md-11" style="padding: 10px 0;">
						
							<p>I intend to write a simple HTTP proxy in Perl using the <a href="http://search.cpan.org/dist/HTTP-Proxy" rel="nofollow">HTTP::Proxy</a> module.
							I'm clear with the very basic task of how to create a proxy and basic filters and stuff. But what I cannot understand is how to manually force-serve a file through cache. </p>

							<p>Basically, the scenario is this that I run this proxy in computer A. The user on computer B accesses web uses this proxy. Now, this proxy will just act as a pass through for all B's requests, until he requests a particular URL (a file, say <a href="http://abc.com/file.zip" rel="nofollow">http://abc.com/file.zip</a>). I need to intercept this request, and instead of allowing him to download the actual file.zip, give him an already downloaded file that I manually kept on computer A.</p>

							<p>Also, note that I might not have a web server running on computer A, so I can't just redirect the url, I need to serve it from cache.</p>

							<p>Any pointers for this would be appreciated.
							Thanks</p>

							<p>Edit: Some more info. I started using HTTP::Daemon and LWP::UserAgent in combination instead of HTTP::Proxy
							So far, I intercept all requests successfully, and then I search the headers for the url. If the particular filename is not there, I just pass the request to actual destination using LWP:UserAgent (simple_request) and return the response to original sender using send_response. If I find the filename, I don't further forward the request, instead I'm trying to serve my particular file using "send_file_response" method. The problem is that all other requests  are working fine and comp B is able to surf the net, but when it tries to download this file, it just keeps waiting for a response.
							About using squid, It is not an option for me to install squid on these machines.</p>
						</div>
					</div>
					
					<div class="your-answer">
						<h4>Your answer</h4>
						<hr/>
						<div class="col-md-12">
							<textarea class="ckeditor" name="editor1"></textarea>
							<button type="button" class="btn btn-primary" style="margin: 20px auto;">Post your answer</button>
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
</body>
</html>