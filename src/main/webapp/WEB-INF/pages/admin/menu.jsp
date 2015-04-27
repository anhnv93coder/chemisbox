<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<aside>
	<div id="sidebar" class="nav-collapse ">
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="#"><i class="fa fa-flask fa-5x"></i></a>
			</p>
			<h4 class="centered">ChemisBox</h4>
			<li class="active mt"><a href="${baseURL}/admin/dashboard" id="dashboard">&nbsp;<strong><i class="fa fa-dashboard"></i>&nbsp;<span>Tổng quan</span></strong></a></li>
			<li><a href="${baseURL}/admin/element" id="element">&nbsp;<i class="fa fa-fire"></i>&nbsp;<span>Nguyên tố hóa học</span></a></li>
			<li class="sub-menu"><a href="javascript:;" >&nbsp;<i class="fa fa-flask"></i>&nbsp;<span>Chất Hóa Học</span></a>
				<ul class="sub">
					<li><a href="${baseURL}/admin/chemical">Danh sách</a></li>	
					<li><a href="#">Phản hồi</a></li>
					<li><a href="#">Ngừng kích hoạt</a></li>
				</ul>
			</li>

			<li class="sub-menu"><a href="javascript:;">&nbsp;<i class="fa fa-cog"></i>&nbsp;<span>Phương Trình Hóa Học</span></a>
				<ul class="sub">
					<li><a href="${baseURL}/admin/equation">Danh sách</a></li>	
					<li><a href="#">Phản hồi</a></li>
					<li><a href="#">Ngừng kích hoạt</a></li>
				</ul>
			</li>
		</ul>
	</div>
</aside>
