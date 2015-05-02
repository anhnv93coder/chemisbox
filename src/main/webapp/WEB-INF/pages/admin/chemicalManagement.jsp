<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
	<section class="wrapper site-min-height">
		<h3>
			<i class="fa fa-angle-right"></i> Quản lý chất hóa học
		</h3>
		<div class="row mt">
			<div class="col-lg-10 col-lg-offset-1" style="display: block;" id="chemicalTable">
				<div class="row clearfix">
					<div class="col-md-6">
						<form class="form-inline">
						  <div class="form-group has-success has-feedback">
						    <input type="text" class="form-control" id="inputSuccess4" aria-describedby="inputSuccess4Status" placeholder="Nhập từ khóa"/>
						    <span class="fa fa-search fa-lg form-control-feedback" aria-hidden="true"></span>
						    <span id="inputSuccess4Status" class="sr-only">(success)</span>
						  </div>
						</form>
					</div>
					<div class="col-md-6">
						<button class="btn btn-default pull-right" style="margin-bottom: 10px;" data-toggle="modal" data-target="#addChemicalModal"><span class="fa fa-plus"></span>&nbsp;Thêm mới</button>
					</div>
				</div>
				<c:if test="${!empty chemicalMap.chemicalList}">
				<div class="panel panel-primary">
					<div class="panel-heading">
					    <h3 class="panel-title">Danh sách chất hóa học</h3>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<tr>
								<th>#</th>
								<th>Tên</th>
								<th>Tên khác</th>
								<th>Ký hiệu</th>
								<th>Khối lượng</th>
								<th></th>
							</tr>
							<c:forEach items="${chemicalMap.chemicalList}" var="chemical">
								<tr>
									<td>${chemical.id}</td>
									<td>${chemical.name}</td>
									<td>${chemical.differenceName}</td>
									<td>${chemical.formula}</td>
									<td>${chemical.quantity}</td>
									<td>
										<a href="#" onclick="loadDetailsForChemical(${chemical.id})"  data-toggle="modal" data-target="#updateChemicalModal" style="padding: 0 2px;"><i
											class="fa fa-pencil-square-o fa-lg" style="margin-top: 3px;"></i></a>
										<a href="${baseURL}/admin/chemical/delete/${chemical.id}" style="padding: 0 2px;" onclick="return confirm('Bạn có chắc chắn muốn xóa?')"><i class="fa fa-trash-o fa-lg"></i></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<nav>
							<ul class="pagination pull-right">
								<li>
									<c:choose>
										<c:when test="${chemicalMap.currentPage > 1}">
											<a href="${baseURL}/admin/chemical/${chemicalMap.currentPage - 1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
										</c:when>
										<c:otherwise>
											<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
										</c:otherwise>
									</c:choose>
								</li>
								<c:forEach var="index" begin="1" end="${chemicalMap.totalPage}">
									<c:choose>
										<c:when test="${index == chemicalMap.currentPage}">
											<li class="active"><a href="${baseURL}/admin/chemical/${index}"><c:out value="${index}"/></a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${baseURL}/admin/chemical/${index}"><c:out value="${index}"/></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li>
									<c:choose>
										<c:when test="${chemicalMap.currentPage < chemicalMap.totalPage}">
											<a href="${baseURL}/admin/chemical/${chemicalMap.currentPage + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
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
			
			
			<div class="modal fade" id="addChemicalModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Thêm mới chất hóa học</h4>
			      </div>
			      <div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-4 control-label">Tên chất</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="chemicalName"
										placeholder="Tên chất"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Tên gọi khác</label>
								<div class="col-sm-8">
									<textarea class="form-control" id="differenceName"
										placeholder="Tên gọi khác"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Công thức hóa học</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="formula"
										placeholder="Công thức hóa học"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Khối lượng</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="quantity"
										placeholder="Khối lượng"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Mô tả</label>
								<div class="col-sm-8">
									<textarea class="form-control" id="description"
										placeholder="Mô tả"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Tỷ trọng</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="density"
										placeholder="Tỷ trọng"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Nhiệt độ nóng chảy</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="meltingTemperature"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Nhiệt độ sôi</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="boilingTemperature"
										placeholder="Nhiệt độ sôi"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Độ hòa tan</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="solubilityInWater"
										placeholder="Độ hòa tan"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Điểm bắt lửa</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="ignitionPoint"
										placeholder="Điểm bắt lửa"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Mùi vị</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="flavour"
										placeholder="Mùi vị"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Link ảnh</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="img"
										placeholder="Link ảnh"/>
								</div>
							</div>
						</form>
			      </div>  
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelUpdate">Thoát</button>
			        <button type="button" class="btn btn-primary" id="btnAddChemical">Thêm mới</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			
			<div class="modal fade" id="updateChemicalModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Cập nhật chất hóa học</h4>
			      </div>
			      <div class="modal-body">
						<form class="form-horizontal" >
						<input type="hidden" class="form-control" id="chemicalId"/>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">Tên chất</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="chemicalNameUpdate"
									placeholder="Tên chất"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Tên gọi khác</label>
							<div class="col-sm-8">
								<textarea class="form-control" id="differenceNameUpdate"
									placeholder="Tên gọi khác"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Công thức hóa học</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="formulaUpdate"
									placeholder="Công thức hóa học"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Khối lượng</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="quantityUpdate"
									placeholder="Khối lượng"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Mô tả</label>
							<div class="col-sm-8">
								<textarea class="form-control" id="descriptionUpdate"
									placeholder="Mô tả"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Tỷ trọng</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="densityUpdate"
									placeholder="Tỷ trọng"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Nhiệt độ nóng chảy</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="meltingTemperatureUpdate"
									placeholder="Nhiệt độ nóng chảy"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Nhiệt độ sôi</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="boilingTemperatureUpdate"
									placeholder="Nhiệt độ sôi"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Độ hòa tan</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="solubilityInWaterUpdate"
									placeholder="Độ hòa tan"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Điểm bắt lửa</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="ignitionPointUpdate"
									placeholder="Điểm bắt lửa"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Mùi vị</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="flavourUpdate"
									placeholder="Mùi vị"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">Link ảnh</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="imgUpdate"
									placeholder="Link ảnh"/>
							</div>
						</div>
					</form>
			      </div>  
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelUpdate">Thoát</button>
			        <button type="button" class="btn btn-primary" id="btnAddChemical">Cập nhật</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</section>
