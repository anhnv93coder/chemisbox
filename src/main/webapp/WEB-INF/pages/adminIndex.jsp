<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">

<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />

<c:if test="${empty adminObject}">
	<c:redirect url="/admin"></c:redirect>
</c:if>
<%@ page import="com.chemisbox.constant.ChemisboxConstant" %>
<c:set var="menuConstant" value="<%= ChemisboxConstant.MENU_CONSTANT %>" />
<c:set var="equationConstant" value="<%= ChemisboxConstant.EQUATION_MENU %>" />
<c:set var="chemicalConstant" value="<%= ChemisboxConstant.CHEMICAL_MENU %>" />
<c:set var="elementConstant" value="<%= ChemisboxConstant.ELEMENT_MENU %>" />
<c:set var="dashboardConstant" value="<%= ChemisboxConstant.DASHBOARD_MENU %>" />
<c:set var="questionConstant" value="<%= ChemisboxConstant.QUESTION_MENU %>" />
<title>Admin</title>

<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="${baseURL}/assets/css/bootstrap.css">
<!-- Custom styles for this template -->
<link href="${baseURL}/assets/css/admin-style.css" rel="stylesheet">

</head>

<body>
	<section id="container"> <header class="header black-bg">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
		</div>
		<a href="Chemisbox/" class="logo"><strong>ChemisBox</strong></a>
		<div class="top-menu">
			<ul class="nav pull-right top-menu">
				<li><a class="logout btn btn-default" href="${baseURL}/admin/logout"><i class="fa fa-sign-out"></i>&nbsp;Logout</a></li>
			</ul>
		</div>
		</header>
		<jsp:include page="admin/menu.jsp" />
		<section id="main-content">
			<c:if test="${page eq chemicalConstant}">
					<jsp:include
						page="admin/chemicalManagement.jsp" />
			</c:if>
			<c:if test="${page eq equationConstant}">
				<jsp:include
					page="admin/equationManagement.jsp" />
			</c:if>
			<c:if test="${page eq elementConstant}">
				<jsp:include
					page="admin/elementManagement.jsp" />
			</c:if>
			<c:if test="${page eq dashboardConstant}">
				<jsp:include
					page="admin/dashboardManagement.jsp" />
			</c:if>
			<c:if test="${page eq questionConstant}">
				<jsp:include
					page="admin/questionManagement.jsp" />
			</c:if>
		</section> 
		 
		 <footer class="site-footer">
			<div class="text-center">
				2015 - ChemisBox <a href="blank.html#" class="go-top"> <i
					class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer> 
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="${baseURL}/assets/js/jquery.js"></script>
	<script src="${baseURL}/assets/js/bootstrap.min.js"></script>
	<script src="${baseURL}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="${baseURL}/assets/js/jquery.nicescroll.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${baseURL}/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${baseURL}/assets/js/common-scripts.js"></script>
	<script src="${baseURL}/assets/js/admin.js"></script>
</body>
</html>
