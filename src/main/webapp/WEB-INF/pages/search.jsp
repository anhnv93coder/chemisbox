<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.chemisbox.constant.ChemisboxConstant" %>
<html>
<head>
<jsp:include page="base/head.jsp"></jsp:include>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript">
	var baseURL = '${baseURL}';
	var currentPage = 0;
	var oldKeyWord = '${searchModel.keyWord}';
	var eIndex = 1;
	var maxSize = <%= ChemisboxConstant.EQUATION_RECORD_NUMBER_IN_RESULT %>;
</script>
</head>

<body>
	<section id="header" class="appear"></section>
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
					<a class="navbar-brand" href="${baseURL}"
						data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a>
				</h1>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" data-0="margin-top:20px;"
					data-300="margin-top:5px;">
					<li class="active"><a href="${baseURL}">Trang chủ</a></li>
					<li><a href="#section-works">Bảng Tuần Hoàn</a></li>
					<li><a href="#" data-toggle="modal" data-target="#guiModal">Hướng dẫn</a></li>
					<li><a href="${baseURL}/forum">Diễn đàn</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
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

	<section class="featured">
		<div class="container">
			<div class="row mar-bot40">
				<div class="col-md-6 col-md-offset-3">
	
					<div class="align-center">
						<i class="fa fa-flask fa-5x mar-bot20"></i>
						<h2 class="slogan">ChemisBox</h2>
						<p>Công cụ hỗ trợ học hóa học</p>
					</div>
					<div class="col-md-12"
						style="margin: 30px auto 0; float: none; margin: 0 auto;">
						<div class="form-inline">
							<input id="keyWord" type="text" class="form-control" placeholder="Nhập từ khóa"
								style="width: 83%;" value="${searchModel.keyWord}"/>
							<button id="btnSearch" type="button" class="btn btn-default">Tìm kiếm</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- about -->
	<section class="section appear clearfix bg-white"
		id="result-block" style="display: none">
		<div class="container">
		
			<div class="modal fade bs-example-modal-sm" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-sm">
			    <div class="modal-content ">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">Phản hồi</h4>
			      </div>
			      <div class="modal-body">
			      	<div id="successMessage" class="alert alert-success" role="alert" style="display: none">Chúng tôi xin cảm ơn vì những đóng góp của bạn <i class="fa fa-thumbs-o-up fa-lg"></i></div>
			        <div id="feedbackForm">
			          <div class="form-group">
			            <label for="recipient-name" class="control-label">Email:</label>
			            <input type="email" class="form-control" id="email" required="required"/>
			          </div>
			          <div class="form-group">
			            <label for="message-text" class="control-label">Nội dung phản hồi:</label>
			            <textarea class="form-control" id="message-text" rows="4" id="content"  required="required"></textarea>
			          </div>
			          <button type="button" class="btn btn-danger" id="btnSendFeedBack"><i class="fa fa-envelope-o fa-lg"></i>&nbsp;Gửi</button>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>

			<div class="row mar-bot40">
				<div class="col-md-offset-3 col-md-6">
					<div class="section-header">
						<h2 class="section-heading animated" data-animation="bounceInUp"><a>Kết
							quả</a></h2>
					</div>
				</div>
			</div>

			<div class="row mar-bot40">
				<div class="col-md-8">
					<div class="panel panel-info">
						<div class="panel-heading">
							<i class="fa fa-list-alt fa-2x"></i> <span style="font-size: 30px;">Phản ứng</span>
						</div>
						<div class="panel-body">
							<div id="equation-list"></div>
							<div class='col-md-4 col-md-offset-4' id="divViewMore">
								<button id='btnViewMore' type='button' style='margin: auto 25%;' class='btn btn-info'>
									<i class='fa fa-cog fa-spin'></i>&nbsp;Xem thêm
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-info" id="chemicalAndElementBlock">
						<div class="panel-heading">
							<i class="fa fa-info fa-2x"></i> <span style="font-size: 30px;" id="chemicalName"></span>
						</div>
						<img src="" alt="..." class="img-rounded center-block"
							id="chemicalImg" style="display: none; margin-top: 10px" />
						<div class="panel-body" id="chemical-info"></div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- /about -->

	<!-- section periodic-table -->
	<jsp:include page="base/periodic-table.jsp"></jsp:include>
	<!-- section periodic-table -->

	<!-- section footer -->
	<jsp:include page="base/footer.jsp"></jsp:include>
	<script type="text/javascript">
	var listResult = [];
	<c:forEach var="myData" items="${searchModel.equationList}" >
		
		var result = {condition : '${myData.condition}', description : '${myData.description}', equation : '${myData.equation}'
			,equationId : '${myData.equationId}', videoLink : '${myData.videoLink}', ionEquation : '${myData.ionEquation}'
			, shortcutIonEquation : '${myData.shortcutIonEquation}', molReduce : '${myData.molReduce}', reduceEquation : '${myData.reduceEquation}'
			, molOxi : '${myData.molOxi}', oxiEquation : '${myData.oxiEquation}', summary : '${myData.summary}'};
		listResult.push(result);
	</c:forEach>
	
	var tempElement = '${searchModel.element}';
	var tempChemical = '${searchModel.chemical}';
	var elementVar = null;
	var chemicalVar = null;
	if(tempElement != ''){
		elementVar = {notation : '${searchModel.element.notation}', name : '${searchModel.element.name}', numberOfAtomic : '${searchModel.element.numberOfAtomic}'
				, atomicVolume : '${searchModel.element.atomicVolume}', classify : '${searchModel.element.classify}', group  : '${searchModel.element.group}'
				, cycle  : '${searchModel.element.cycle}', electronConfiguration : '${searchModel.element.electronConfiguration}', layers : '${searchModel.element.layers}'
				, description : '${searchModel.element.description}', color : '${searchModel.element.color}', condition : '${searchModel.element.condition}'
				, meltingTemperature : '${searchModel.element.meltingTemperature}', boilingTemperature : '${searchModel.element.boilingTemperature}'
				, img : '${searchModel.element.img}'};
		
	}else if(tempChemical != ''){
		chemicalVar = {id : '${searchModel.chemical.id}', name : '${searchModel.chemical.name}', differenceName : '${searchModel.chemical.differenceName}'
				, formula : '${searchModel.chemical.formula}', quantity : '${searchModel.chemical.quantity}', description : '${searchModel.chemical.description}'
				, density : '${searchModel.chemical.density}', meltingTemperature : '${searchModel.chemical.meltingTemperature}'
				, boilingTemperature : '${searchModel.chemical.boilingTemperature}', solubilityInWater : '${searchModel.chemical.solubilityInWater}'
				, ignitionPoint : '${searchModel.chemical.ignitionPoint}', flavour : '${searchModel.chemical.flavour}', img : '${searchModel.chemical.img}'};
	}
	
	
	var data = {equationList : listResult, chemical : chemicalVar, element : elementVar, keyWord : '${searchModel.keyWord}'};
	
	fillResult(data);
	
	
</script>
</body>
</html>