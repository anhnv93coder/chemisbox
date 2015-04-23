<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
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
				<a class="navbar-brand" href="${baseURL}" data-0="line-height:90px;"
					data-300="line-height:50px;">ChemisBox</a>
			</h1>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav" data-0="margin-top:20px;"
				data-300="margin-top:5px;">
				<li class="active"><a href="${baseURL}">Trang chủ</a></li>
				<li><a href="#section-works">Bảng tuần hoàn</a></li>
				<li><a href="#section-about">Thông tin</a></li>
				<li><a href="#section-contact">Liên hệ</a></li>
			</ul>
		</div>
	</div>
</div>