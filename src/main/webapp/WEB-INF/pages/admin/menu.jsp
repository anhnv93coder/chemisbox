<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="#"><i class="fa fa-flask fa-5x"></i></a>
			</p>
			<h5 class="centered">ChemisBox</h5>

			<li class="active mt"><a href="#" id="dashboard">&nbsp;<i class="fa fa-dashboard"></i>&nbsp;<span>Tổng quan</span></a></li>

			<li class="sub-menu"><a href="${baseURL}/admin/chemical">&nbsp;<i class="fa fa-desktop"></i>&nbsp;<span>Chất Hóa Học</span></a>
				<ul class="sub">
					<li><a href="#">Phản hồi</a></li>
					<li><a href="#">Ngừng kích hoạt</a></li>
				</ul>
			</li>

			<li class="sub-menu"><a href="javascript:;">&nbsp;<i class="fa fa-cogs"></i>&nbsp;<span>Phương Trình Hóa Học</span></a>
				<ul class="sub">
					<li><a href="#">Phản hồi</a></li>
					<li><a href="#">Ngừng kích hoạt</a></li>
				</ul>
			</li>
		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>