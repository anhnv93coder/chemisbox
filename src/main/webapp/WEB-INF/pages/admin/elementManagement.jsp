<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript">
	var baseURL = '${baseURL}';
</script>
	<section class="wrapper site-min-height">
		<h3>
			<i class="fa fa-angle-right"></i> Quản lý nguyên tố hóa học
		</h3>
		<div class="row mt">
			<div class="col-lg-10 col-lg-offset-1" style="display: block;" id="elementTable">
				<div class="row clearfix">
					<div class="col-md-6">
							<div class="form-inline">
							  <div class="form-group has-success has-feedback">
							    <input type="text" class="form-control" id="elementKeyWord" aria-describedby="inputSuccess4Status"  placeholder="Nhập từ khóa" value="${elementMap.keyWord}" />
							    <span class="fa fa-search fa-lg form-control-feedback" aria-hidden="true"></span>
							    <span id="inputSuccess4Status" class="sr-only">(success)</span>
							  </div>
							</div>
						</div>
					<div class="col-md-6">
							<button class="btn btn-default pull-right"
						style="margin-bottom: 10px;" data-toggle="modal" data-target="#addElementModal"><span class="fa fa-plus"></span>&nbsp;Thêm mới</button>
					</div>
				</div>
					
				<c:if test="${not empty elementMap.elementList}">
				<div class="panel panel-primary">
					<div class="panel-heading">
					    <h3 class="panel-title">Danh sách nguyên tố hóa học</h3>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<tr>
								<th>Ký hiệu</th>
								<th>Tên</th>
								<th>Khối lượng nguyên tử</th>
								<th>Cấu hình electron</th>
								<th>Ngày tạo</th>
								<th>Ngày thay đổi</th>
								<th>Người thay đổi</th>
								<th></th>
							</tr>
							<c:forEach items="${elementMap.elementList}" var="element">
								<tr>
									<td>${element.notation}</td>
									<td>${element.name}</td>
									<td>${element.atomicVolume}</td>
									<td>${element.electronConfiguration}</td>
									<td>${element.createdDate}</td>
									<td>${element.editedDate}</td>
									<td>${element.lastUserModify}</td>
									<td>
										<a href="#" onclick="loadDetailsForElement('${element.notation}')"  data-toggle="modal" data-target="#updateElementModal" style="padding: 0 2px;"><i
											class="fa fa-pencil-square-o fa-lg" style="margin-top: 3px;"></i></a>
										<a href="${baseURL}/admin/element/delete/${element.notation}" style="padding: 0 2px;" onclick="return confirm('Bạn có chắc chắn muốn xóa?')"><i class="fa fa-trash-o fa-lg"></i></a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<nav>
							<ul class="pagination pull-right">
								<li>
									<c:choose>
										<c:when test="${elementMap.currentPage > 1}">
											<a href="${baseURL}${elementMap.currentUrl}${elementMap.keyWord}/${elementMap.currentPage - 1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
										</c:when>
										<c:otherwise>
											<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a>
										</c:otherwise>
									</c:choose>
								</li>
								<c:forEach var="index" begin="1" end="${elementMap.totalPage}">
									<c:choose>
										<c:when test="${index == elementMap.currentPage}">
											<li class="active"><a href="${baseURL}${elementMap.currentUrl}${elementMap.keyWord}/${index}"><c:out value="${index}"/></a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${baseURL}${elementMap.currentUrl}${elementMap.keyWord}/${index}"><c:out value="${index}"/></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li>
									<c:choose>
										<c:when test="${elementMap.currentPage < elementMap.totalPage}">
											<a href="${baseURL}${elementMap.currentUrl}${elementMap.keyWord}/${elementMap.currentPage + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
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
				<c:if test="${empty elementMap.elementList}">
					<h4>Không có dữ liệu</h4>
				</c:if>
			</div>
			
			<div class="modal fade" id="addElementModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Thêm mới nguyên tố hóa học</h4>
			      </div>
			      <form class="form-horizontal">
			      <div class="modal-body">
			      			<div class="alert alert-warning alert-dismissible" role="alert" id="addElementMessage" style="display:none">
								<i class="fa fa-frown-o fa-2x"></i>&nbsp;<span id="addElementErrorMessage"></span>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-4 control-label">Ký hiệu</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="notation"
										placeholder="Tên chất"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Tên gọi</label>
								<div class="col-sm-8">
									<textarea class="form-control" id="name"
										placeholder="Tên gọi khác"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Số nguyên tử</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="numberOfAtomic"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Khối lượng nguyên tử</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="atomicVolume"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Phân loại</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="classify"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Nhóm</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="group"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Chu kỳ</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cycle"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Cấu hình electron</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="electronConfiguration"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Lớp</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="layers"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Mô tả</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="description"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Màu sắc</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="color"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Trạng thái</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="condition"
										placeholder="Nhiệt độ nóng chảy"/>
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
								<label for="inputPassword3" class="col-sm-4 control-label">Link ảnh</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="img"
										placeholder="Link ảnh"/>
								</div>
							</div>
						
			      </div>  
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelAddElement" style="display:none;">Thoát</button>
			        <button type="reset" class="btn btn-default">Làm mới</button>
			        <button type="button" class="btn btn-primary" id="btnAddElement">Thêm mới</button>
			      </div>
			      </form>
			    </div>
			  </div>
			</div>
			
			
			<div class="modal fade" id="updateElementModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Cập nhật chất hóa học</h4>
			      </div>
			      <form class="form-horizontal">
			      <div class="modal-body">
						<div class="alert alert-warning alert-dismissible" role="alert" id="updateElementMessage" style="display:none">
								<i class="fa fa-frown-o fa-2x"></i>&nbsp;<span id="updateElementErrorMessage"></span>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-4 control-label">Ký hiệu</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="notationUpdate"
										placeholder="Tên chất"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Tên gọi</label>
								<div class="col-sm-8">
									<textarea class="form-control" id="nameUpdate"
										placeholder="Tên gọi khác"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Số nguyên tử</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="numberOfAtomicUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Khối lượng nguyên tử</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="atomicVolumeUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Phân loại</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="classifyUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Nhóm</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="groupUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Chu kỳ</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cycleUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Cấu hình electron</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="electronConfigurationUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Lớp</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="layersUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Mô tả</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="descriptionUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Màu sắc</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="colorUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">Trạng thái</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="conditionUpdate"
										placeholder="Nhiệt độ nóng chảy"/>
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
								<label for="inputPassword3" class="col-sm-4 control-label">Link ảnh</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="imgUpdate"
										placeholder="Link ảnh"/>
								</div>
							</div>
						
			      </div>  
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCancelUpdateElement" style="display:none;">Thoát</button>
			        <button type="reset" class="btn btn-default">Làm mới</button>
			        <button type="button" class="btn btn-primary" id="btnUpdateElement">Cập nhật</button>
			      </div>
			      </form>
			    </div>
			  </div>
			</div>
		</div>
	</section>
