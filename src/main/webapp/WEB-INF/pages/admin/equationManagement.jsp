<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript">
	var baseURL = '${baseURL}';
</script>
	<section class="wrapper site-min-height">
		<h3>
			<i class="fa fa-angle-right"></i> Quản lý phương trình phản ứng hóa học
		</h3>
		<div class="row mt">
			<div class="col-lg-10 col-lg-offset-1" style="display: block;" id="equationTable">
				<div class="row clearfix">
					<div class="col-md-6">
						<form class="form-inline">
						  <div class="form-group has-success has-feedback">
						    <input type="text" class="form-control" id="inputSuccess4" aria-describedby="inputSuccess4Status"  placeholder="Nhập từ khóa" />
						    <span class="fa fa-search fa-lg form-control-feedback" aria-hidden="true"></span>
						    <span id="inputSuccess4Status" class="sr-only">(success)</span>
						  </div>
						</form>
					</div>
					<div class="col-md-6">
						<button class="btn btn-default pull-right"
								style="margin-bottom: 10px;" data-toggle="modal" data-target="#addEquationModal"><span class="fa fa-plus"></span>&nbsp;Thêm mới</button>
					</div>
				</div>
				<c:if test="${!empty equationMap.equationList}">
				<div class="panel panel-primary">
					<div class="panel-heading">
					    <h3 class="panel-title">Danh sách phương trình hóa học</h3>
					</div>
					<div class="panel-body">
					    <table class="table table-hover">
							<tr>
								<th>#</th>
								<th>Equation</th>
								<th>Điều kiện</th>
								<th>Mô tả</th>
								<!-- <th>Video link</th> -->
								<th>Ngày cập nhật</th>
								<th>Ngày thêm mới</th>
								<th>Người cập nhật gần đây</th>
								<th></th>
							</tr>
							<c:forEach items="${equationMap.equationList}" var="equation">
								<tr>
									<td>${equation.equationId}</td>
									<td>${equation.equation}</td>
									<td>${equation.condition}</td>
									<td>${equation.description}</td>
									<%-- <td>${equation.videoLink}</td> --%>
									<td>${equation.editedDate}</td>
									<td>${equation.createdDate}</td>
									<td>${equation.lastUserModify}</td>
									<td><%-- onclick="loadDetailsForEquation(${equation.equationId})" --%>
										<a href="#"  style="padding: 0 2px;" onclick="loadDetailsForEquation(${equation.equationId})" data-toggle="modal" data-target="#updateEquationModal"><i
											class="fa fa-pencil-square-o fa-lg" style="margin-top: 3px;"></i></a>
										<a href="delete/${equation.equationId}" style="padding: 0 2px;" onclick="return confirm('Bạn có chắc chắn muốn xóa?')"><i class="fa fa-trash-o fa-lg"></i></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<nav>
						<ul class="pagination pull-right">
							<li>
								<c:choose>
									<c:when test="${equationMap.currentPage > 1}">
										<a href="${baseURL}/admin/equation/${equationMap.currentPage - 1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
									</c:when>
									<c:otherwise>
										<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
									</c:otherwise>
								</c:choose>
							</li>
							<c:forEach var="index" begin="1" end="${equationMap.totalPage}">
								<c:choose>
									<c:when test="${index == equationMap.currentPage}">
										<li class="active"><a href="${baseURL}/admin/equation/${index}"><c:out value="${index}"/></a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${baseURL}/admin/equation/${index}"><c:out value="${index}"/></a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<li>
								<c:choose>
									<c:when test="${equationMap.currentPage < equationMap.totalPage}">
										<a href="${baseURL}/admin/equation/${equationMap.currentPage + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
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
			
			<div class="modal fade" id="updateEquationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Cập nhật phương trình hóa học</h4>
			      </div>
			      <form>
			      <div class="modal-body">
			        <div class="form-horizontal">
			        	<input type="hidden" id="equationIdUpdate"/>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Phương trình</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="equationUpdate" placeholder="Phương trình"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Mô tả</label>
							<div class="col-sm-9">
								<textarea class="form-control" id="descriptionUpdate" placeholder="Mô tả"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Điều kiện</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="conditionUpdate" placeholder="Điều kiện"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Video link</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="videoLinkUpdate" placeholder="Video link"/>
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Phương trình Ion</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="ionEquationUpdate" placeholder="Phương trình Ion"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Thu gọn</label>
							<div class="col-sm-9">
								<input class="form-control" id="ionShortcutUpdate" placeholder="Thu gọn"/>
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			      	<div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Quá trình oxi hóa</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="oxiEquationUpdate" placeholder="Quá trình oxi hóa"/>
							</div>
							<label for="inputPassword3" class="col-sm-2 control-label">Số mol</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="molOxiUpdate" placeholder="Mol"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Quá trình khử</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="reduceEquationUpdate" placeholder="Quá trình khử"/>
							</div>
							<label for="inputPassword3" class="col-sm-2 control-label">Số mol</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="molReduceUpdate" placeholder="Mol"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Thu gọn</label>
							<div class="col-sm-9">
								<input class="form-control" id="summaryUpdate" placeholder="Thu gọn" />
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelUpdateEquation" style="display:none;">Thoát</button>
			        <button type="reset" class="btn btn-default">Làm mới</button>
			        <button type="button" class="btn btn-primary" id="btnUpdateEquation">Cập nhật</button>
			      </div>
			      </form>
			    </div>
			  </div>
			</div>
			
			
			<div class="modal fade" id="addEquationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Thêm mới phương trình hóa học</h4>
			      </div>
			      <form>
			      <div class="modal-body">
			        <div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Phương trình</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="equation" placeholder="Phương trình"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Mô tả</label>
							<div class="col-sm-9">
								<textarea class="form-control" id="description" placeholder="Mô tả"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Điều kiện</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="condition" placeholder="Điều kiện"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Video link</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="videoLink" placeholder="Video link"/>
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Phương trình Ion</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="ionEquation" placeholder="Phương trình Ion"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Thu gọn</label>
							<div class="col-sm-9">
								<input class="form-control" id="ionShortcut" placeholder="Thu gọn"/>
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			      	<div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Quá trình oxi hóa</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="oxiEquation" placeholder="Quá trình oxi hóa"/>
							</div>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="molOxi" placeholder="Mol"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Quá trình khử</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="reduceEquation" placeholder="Quá trình khử"/>
							</div>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="molReduce" placeholder="Mol"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Thu gọn</label>
							<div class="col-sm-9">
								<input class="form-control" id="summary" placeholder="Thu gọn" />
							</div>
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelAddEquation" style="display:none;">Thoát</button>
			        <button type="reset" class="btn btn-default">Làm mới</button>
			        <button type="button" class="btn btn-primary" id="btnAddEquation">Thêm mới</button>
			      </div>
			      </form>
			    </div>
			  </div>
			</div>
		</div>
	</section>