<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<section id="footer" class="section footer">
	<div class="container">
		<div class="row animated opacity mar-bot20" data-andown="fadeIn"
			data-animation="animation">
			<div class="col-sm-12 align-center">
				<ul class="social-network social-circle">
					<li><a href="#" class="icoRss" title="Rss"><i
							class="fa fa-rss"></i></a></li>
					<li><a href="#" class="icoFacebook" title="Facebook"><i
							class="fa fa-facebook"></i></a></li>
					<li><a href="#" class="icoTwitter" title="Twitter"><i
							class="fa fa-twitter"></i></a></li>
					<li><a href="#" class="icoGoogle" title="Google +"><i
							class="fa fa-google-plus"></i></a></li>
					<li><a href="#" class="icoLinkedin" title="Linkedin"><i
							class="fa fa-linkedin"></i></a></li>
				</ul>
			</div>
		</div>

		<div class="row align-center copyright">
			<div class="col-sm-12">
				<p>
					Copyright &copy; 2015 ChemisBox - by <a href="#">Nguyen Viet
						Anh</a>
				</p>
			</div>
		</div>
	</div>

</section>
<a href="#header" class="scrollup"><i class="fa fa-chevron-up"></i></a>

<script src="${baseURL}/assets/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="${baseURL}/assets/js/jquery.js" type="text/javascript"></script>
<script src="${baseURL}/assets/js/jquery.easing.1.3.js"></script>
<script src="${baseURL}/assets/js/bootstrap.min.js"></script>
<script src="${baseURL}/assets/js/jquery.isotope.min.js"></script>
<script src="${baseURL}/assets/js/jquery.nicescroll.min.js"></script>
<script src="${baseURL}/assets/js/fancybox/jquery.fancybox.pack.js"></script>
<script src="${baseURL}/assets/js/skrollr.min.js"></script>
<script src="${baseURL}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="${baseURL}/assets/js/jquery.localscroll-1.2.7-min.js"></script>
<script src="${baseURL}/assets/js/jquery.autocomplete.min.js"></script>
<script src="${baseURL}/assets/js/stellar.js"></script>
<script src="${baseURL}/assets/js/jquery.appear.js"></script>
<script src="${baseURL}/assets/js/validate.js"></script>
<script src="${baseURL}/assets/js/main.js"></script>
<script src="${baseURL}/assets/js/periodic.js"></script>
<script src="${baseURL}/assets/js/chemisbox.js"></script>
<script>
	var isset = false;
	$(document).ready(function() {
		$("#key-word").autocomplete({
			serviceUrl: '${pageContext.request.contextPath}/getData',
			paramName: "keyWord",
			delimiter: ",",
			transformResult: function(response) {
				var data = $.parseJSON(response);
				return {      	
				//must convert json to javascript object before process
					suggestions: $.map(data.suggestList, function(item) {
						return { value: item};
					})
				};
		 	}
		});
		
		$("#key-word").keyup(function() {
			if(!isset){
				$(".autocomplete-suggestions").css("min-width", $(".autocomplete-suggestions").width() + 4);	
				isset = true;
			}	
		});
		
		
		
	});
</script>