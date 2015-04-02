<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="base/head.jsp"></jsp:include>

</head>

<body>
	<section id="header" class="appear"></section>
	<jsp:include page="base/menu.jsp"></jsp:include>

	<section class="featured">
	<div class="container">
		<div class="row mar-bot40">
			<div class="col-md-6 col-md-offset-3">

				<div class="align-center">
					<i class="fa fa-flask fa-5x mar-bot20"></i>
					<h2 class="slogan">ChemisBox</h2>
					<p>Write something</p>
				</div>
				<div class="col-md-12"
					style="margin: 30px auto 0; float: none; margin: 0 auto;">
					<form:form class="form-inline" action="search" modelAttribute="searchModel">
						<form:input id="key-word" class="form-control" placeholder="Place"
							style="width: 85%;" path="keyWord" />
						<button type="submit" class="btn btn-default">Search</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- services -->
	<section id="section-services" class="section pad-bot30 bg-white">
	<div class="container">
		<div class="row mar-bot40">
			<div class="col-lg-4">
				<div class="align-center">
					<i class="fa fa-refresh fa-spin fa-5x mar-bot20"></i>
					<h4>Cập nhật thường xuyên</h4>
					<p>Thường xuyên cập nhật các công thức, phương trình hóa học</p>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="align-center">
					<i class="fa fa-terminal fa-5x mar-bot20"></i>
					<h4>Dễ dàng tìm kiếm</h4>
					<p>Giao diện thân thiện, dễ dàng sử dụng</p>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="align-center">
					<i class="fa fa-bolt fa-5x mar-bot20"></i>
					<h4>Tương tác với người dùng</h4>
					<p>Luôn ghi nhận những đóng góp của người dùng để ứng dụng ngày
						một hoàn thiện hơn.</p>
				</div>
			</div>

		</div>

	</div>
	</section>

	<!-- spacer section:testimonial -->
	<section id="testimonials" class="section"
		data-stellar-background-ratio="0.5">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="align-center">
					<div class="testimonial pad-top40 pad-bot40 clearfix">
						<i class="fa fa-cloud fa-5x"
							style="color: #777; font-size: 120px;"></i>
						<h3>ChemisBox là một website có một lượng lớn dữ liệu về hóa
							học để cung cấp tối đa nhu cầu của người sử dụng, đặc biệt là học
							sinh, sinh viên.</h3>
					</div>

				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- section periodic -->

	<jsp:include page="base/periodic-table.jsp"></jsp:include>

	<!-- section works -->

	<!-- about -->

	<jsp:include page="base/about.jsp"></jsp:include>

	<!-- /about -->

	<!-- contact -->

	<jsp:include page="base/contact.jsp"></jsp:include>

	<!-- contact -->

	<!-- map -->
	<section id="section-map" class="clearfix">
	<div id="map"></div>
	</section>

	<!-- footer -->
	<jsp:include page="base/footer.jsp"></jsp:include>
	<!-- contact -->

	<script type="text/javascript">
		// When the window has finished loading create our google map below
/* 		google.maps.event.addDomListener(window, 'load', init);

		function init() {
			// Basic options for a simple Google Map
			// For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
			var mapOptions = {
				// How zoomed in you want the map to start at (always required)
				zoom : 11,
				// The latitude and longitude to center the map (always required)
				center : new google.maps.LatLng(40.6700, -73.9400), // New York

				// How you would like to style the map. 
				// This is where you would paste any style found on Snazzy Maps.
				styles : [ {
					featureType : "all",
					elementType : "all",
					stylers : [ {
						invert_lightness : true
					}, {
						saturation : 10
					}, {
						lightness : 30
					}, {
						gamma : 0.5
					}, {
						hue : "#1C705B"
					} ]
				} ]
			};

			// Get the HTML DOM element that will contain your map 
			// We are using a div with id="map" seen below in the <body>
			var mapElement = document.getElementById('map');

			// Create the Google Map using out element and options defined above
			var map = new google.maps.Map(mapElement, mapOptions);
		} */
	</script>
</body>
</html>