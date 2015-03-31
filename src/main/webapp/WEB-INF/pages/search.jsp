<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<jsp:include page="viewBase/header.jsp"></jsp:include>
</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="viewBase/menu.jsp"></jsp:include>
	<!--Banner-->
	<div class="background-img">
		<div class="container" style="margin-top: 50px; margin-bottom: 70px">
			<div class="row" style="margin-top: 50px; margin-bottom: 70px">
				<div class="col-xs-8 input-group input-group-lg"
					style="margin: 30px auto 0;">
					<!--<p><i class="fa fa-cube fa-lg"></i>ChemisBox</p>-->
					<span class="input-group-addon"><i class="fa fa-cube fa-lg"></i>ChemisBox</span>
					<input class="form-control input-lg" placeholder="Tìm kiếm tại đây"
						id="key-word" /> <span class="input-group-btn"><button
							class="btn btn-default" id="btnSearch">
							<i class="fa fa-search fa-lg"></i> Tìm kiếm
						</button></span>
				</div>
			</div>

		</div>
	</div>

	<!--Other-->
	<div class="container" style="padding-bottom: 50px">
		<div class="row">

			<div class="col-md-7">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-flask fa-lg"></i> Phản ứng
						</h4>
					</div>
					<div class="panel-body" id="equation-list"></div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-info fa-lg"></i> Natri
						</h4>
					</div>
					<img src="" alt="..." class="img-rounded center-block" id="chemicalImg" style="display: none; margin-top: 10px"/>
					<div class="panel-body" id="chemical-info">
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="viewBase/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript
        ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/chemisbox.js"></script>
</body>

</html>