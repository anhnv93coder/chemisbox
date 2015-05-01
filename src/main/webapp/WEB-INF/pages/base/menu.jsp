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
				<li><a href="#" data-toggle="modal" data-target="#guiModal">Hướng dẫn</a></li>
				<li><a href="${baseURL}/forum">Forum</a></li>
			</ul>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="guiModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Hướng dẫn</h4>
      </div>
      <div class="modal-body">
      	<table class="table table-striped">
			<tr>
				<th>#</th>
				<th>Loại tìm kiếm</th>
				<th>Ví dụ</th>
				<th>Từ khóa</th>
			</tr>
			<tr>
				<td rowspan="2">1</td>
				<td rowspan="2" margin: auto 0;">Chất hóa học hoặc nguyên tố</td>
				<td>Tìm kiếm Natri</td>
				<td>Na hoặc Natri</td>
			</tr>
			<tr>
				<td>Tìm kiếm Natri Clorua</td>
				<td>NaCl hoặc Natri Clorua</td>
			</tr>
			<tr>
				<td rowspan="4">2</td>
				<td rowspan="4">Phương trình hóa học</td>
				<td>Tìm kiếm phương trình liên quan đến Natri là chất tham gia</td>
				<td>Na</td>
			</tr>
			<tr>
				<td>Tìm kiếm phương trình liên quan đến Natri là chất sản phẩm</td>
				<td>=Na</td>
			</tr>
			<tr>
				<td>Tìm kiếm phương trình liên quan đến Natri và Flo là chất tham gia</td>
				<td>Na + F2</td>
			</tr>
			<tr>
				<td>Tìm kiếm phương trình liên quan đến Natri và Flo là chất sản phẩm</td>
				<td>=Na + F2</td>
			</tr>
		</table>
      </div>
    </div>
  </div>
</div>