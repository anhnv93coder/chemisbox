<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	<section class="wrapper site-min-height">
		<h3>
			<i class="fa fa-angle-right"></i> Quản lý câu hỏi
		</h3>
		<div class="row mt">
			<div class="col-lg-10 col-lg-offset-1" style="display: block;" id="equationTable">
				<div class="row clearfix" style="margin-bottom: 10px">
					<div class="col-md-6">
						<form class="form-inline">
						  <div class="form-group has-success has-feedback">
						    <input type="text" class="form-control" id="inputSuccess4" aria-describedby="inputSuccess4Status"  placeholder="Nhập từ khóa" />
						    <span class="fa fa-search fa-lg form-control-feedback" aria-hidden="true"></span>
						    <span id="inputSuccess4Status" class="sr-only">(success)</span>
						  </div>
						</form>
					</div>
				</div>
				<c:if test="${!empty questionMap.questionList}">
				<div class="panel panel-primary">
					<div class="panel-heading">
					    <h3 class="panel-title">Danh sách câu hỏi chưa được xác minh</h3>
					</div>
					<div class="panel-body">
					    <table class="table table-hover">
							<tr>
								<th>Tiêu đề</th>
								<th>Nội dung</th>
								<th>Ngày gửi</th>
								<th>Ngày cập nhật</th>								<th>Người gửi</th>
								<th></th>
							</tr>
							<c:forEach items="${questionMap.questionList}" var="question">
								<tr>
									<td>${question.title}</td>
									<td>${question.content}</td>
									<td>${question.createdDate}</td>
									<td>${question.editedDate}</td>
									<td>${question.user.email}</td>
									<td>
										<a href="#"  style="padding: 0 2px;" onclick="loadDetailsForQuestion(${question.questionId})" data-toggle="modal" data-target="#approveQuestionModal"><i
											class="fa fa-pencil-square-o fa-lg" style="margin-top: 3px;"></i></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<nav>
						<ul class="pagination pull-right">
							<li>
								<c:choose>
									<c:when test="${questionMap.currentPage > 1}">
										<a href="${baseURL}/admin/question/${questionMap.currentPage - 1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
									</c:when>
									<c:otherwise>
										<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
									</c:otherwise>
								</c:choose>
							</li>
							<c:forEach var="index" begin="1" end="${questionMap.totalPage}">
								<c:choose>
									<c:when test="${index == questionMap.currentPage}">
										<li class="active"><a href="${baseURL}/admin/question/${index}"><c:out value="${index}"/></a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${baseURL}/admin/question/${index}"><c:out value="${index}"/></a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<li>
								<c:choose>
									<c:when test="${questionMap.currentPage < questionMap.totalPage}">
										<a href="${baseURL}/admin/question/${questionMap.currentPage + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
									</c:when>
									<c:otherwise>
										<a aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</nav>
					</div>
				</div>
				</c:if>
			</div>
			
			<div class="modal fade" id="approveQuestionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Xác minh câu hỏi</h4>
			      </div>
			      <div class="modal-body">
			        <div class="form-horizontal">
			        	<input type="hidden" value="" id="questionId"/>
			        	<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Người gửi</label>
							<div class="col-sm-9">
								<input type="text" disabled="disabled" class="form-control" id="fullName" placeholder="Phương trình"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" disabled="disabled"  id="email" placeholder="Phương trình"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Tiêu đề</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" disabled="disabled"  id="title" placeholder="Phương trình"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Nội dung</label>
							<div class="col-sm-9">
								<textarea class="form-control" disabled="disabled" id="content" placeholder="Mô tả" rows="5"></textarea>
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelUpdate">Thoát</button>
			        <button type="button" class="btn btn-primary" id="btnApproved">Cho phép hiển thị</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</section>