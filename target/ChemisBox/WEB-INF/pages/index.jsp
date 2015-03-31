<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/navbar-fixed-top/ -->
<html lang="en">
<head>
<jsp:include page="viewBase/header.jsp"></jsp:include>

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="viewBase/menu.jsp"></jsp:include>
	<!--Banner-->
	<div class="background-img">
		<div class="container" style="margin-top: 50px;">
			<div class="row" style="margin-top: 70px; margin-bottom: 100px">
				<h1 class="text-center banner-name">
					<i class="fa fa-cube fa-lg"></i>ChemisBox
				</h1>
				<h1 class="text-center banner-name" style="padding-bottom: 50px">Công
					cụ tìm kiếm kiến thức hóa học</h1>
					<div class="col-xs-8 input-group input-group-lg"
						style="margin: 30px auto 0;">
						<input id="key-word" class="form-control input-lg"
							placeholder="Tìm kiếm tại đây" /> <span class="input-group-btn"><button
								class="btn btn-default" id="btn-search">Tìm kiếm</button></span>
					</div>
			</div>

		</div>

	</div>
	<!--Other-->
	
	<div class="container" style="padding: 50px 0; display: none;"  id="result-block" >
		<div class="row">

			<div class="col-md-7">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>
							<i class="fa fa-flask fa-lg"></i> Phản ứng
						</h4>
					</div>
					<div class="panel-body" id="equation-list"></div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="panel panel-info">
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
	
	<div class="jumbotron">
	<jsp:include page="viewBase/loader.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-4 text-center">
				<h1>
					<i class="fa fa-star fa-3x"></i>
				</h1>
				<p>
					<a class="description">Dễ dàng tìm kiếm</a>
				</p>
			</div>
			<div class="col-md-4 text-center">
				<h1>
					<i class="fa fa-cloud-upload fa-3x"></i>
				</h1>
				<p>
					<a class="description">Luôn cập nhật thêm những kiến thức về
						hóa học</a>
				</p>
			</div>
			<div class="col-md-4 text-center">
				<h1>
					<i class="fa fa-file-code-o fa-3x"></i>
				</h1>
				<p>
					<a class="description">Kiểm tra kiến thức bằng những câu hỏi</a>
				</p>
			</div>
		</div>
	</div>
	<!--Purpose-->
	<div class="background-img" style="padding: 70px 0 70px 0">
		<div class="container">
			<h1 class="text-center header">Website ra đời với mục đích hỗ
				trợ các bạn học sinh, sinh viên có một công cụ hỗ trợ học hóa học
				tốt nhất.</h1>
			<br />
			<h1 class="text-center header">
				<i class="fa fa-rocket fa-3x"></i>
			</h1>
		</div>
	</div>
	
	<jsp:include page="viewBase/footer.jsp"></jsp:include>

</body>

</html>