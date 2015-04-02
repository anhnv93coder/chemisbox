<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="base/head.jsp"></jsp:include>

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
					<a class="navbar-brand" href="index.html"
						data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a>
				</h1>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" data-0="margin-top:20px;"
					data-300="margin-top:5px;">
					<li class="active"><a href="/ChemisBox/">Trang chủ</a></li>
					<li><a href="#section-works">Bảng Tuần Hoàn</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<jsp:include page="base/header.jsp"></jsp:include>
	<!-- about -->
	<section class="section appear clearfix section-contact-bg"
		id="result-block" style="display: none">
		<div class="container">

			<div class="row mar-bot40">
				<div class="col-md-offset-3 col-md-6">
					<div class="section-header">
						<h2 class="section-heading animated" data-animation="bounceInUp"><a>Kết
							quả</a></h2>
					</div>
				</div>
			</div>

			<div class="row mar-bot40">
				<div class="col-md-7">
					<div class="panel panel-info">
						<div class="panel-heading">
							<i class="fa fa-list-ol fa-2x"></i> <span style="font-size: 30px;">Phản ứng</span>
						</div>
						<div class="panel-body" id="equation-list">
							
						</div>
					</div>
				</div>
				<div class="col-md-5">
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
		var ion = {ionId: '${myData.ionEquation.ionId}', ionEquation : '${myData.ionEquation.ionEquation}', shortcutIonEquation : '${myData.ionEquation.shortcutIonEquation}'};
		var oxi = {oxiReduceId : '${myData.oxiReduceEquation.oxiReduceId}', molReduce : '${myData.oxiReduceEquation.molReduce}'
				,reduceEquation : '${myData.oxiReduceEquation.reduceEquation}', molOxi : '${myData.oxiReduceEquation.molOxi}' 
				,oxiEquation : '${myData.oxiReduceEquation.oxiEquation}', summary : '${myData.oxiReduceEquation.summary}'};
		
		var result = {condition : '${myData.condition}', description : '${myData.description}', equation : '${myData.equation}'
				,equationId : '${myData.equationId}', ionEquation : ion, oxiReduceEquation : oxi, videoLink : '${myData.videoLink}'};
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
	<!-- section footer -->
</body>
</html>