<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<section class="wrapper site-min-height">
		<div class="col-lg-12 main-chart">
            <div class="row mtbox">
           		<div class="col-md-4 box0">
           			<div class="box1">
			  			<a><i class="fa fa-fire fa-5x"></i></a>
			  			<h3>${dashboardModel.elementCounter}</h3>
			  			<h3>Nguyên tố hóa học đã cập nhật</h3>
               		</div>
                 </div>
                 <div class="col-md-4 box0">
                 	<div class="box1">
				 		<a><i class="fa fa-flask fa-5x"></i></a>
				 		<h3>${dashboardModel.chemicalCounter}</h3>
				 		<h3>Chất hóa học đã cập nhật</h3>
                 	</div>
                 </div>
                 <div class="col-md-4 box0">
                	<div class="box1">
				  		<a><i class="fa fa-cog fa-spin fa-5x"></i></a>
				 		<h3>${dashboardModel.equationCounter}</h3>
				 		<h3>Phản ứng hóa học đã cập nhật</h3>
                	</div>
                 </div>
        	</div>
        	<div class="row mtbox">
           		<div class="col-md-4 box0">
           			<div class="box1">
			  			<a><i class="fa fa-question-circle fa-5x"></i></a>
			  			<h3>${dashboardModel.questionCounter}</h3>
			  			<h3>Câu hỏi đã được người dùng gửi</h3>
               		</div>
                 </div>
                 <div class="col-md-4 box0">
                 	<div class="box1">
				 		<a><i class="fa fa-spinner fa-spin fa-5x"></i></a>
				 		<h3>${dashboardModel.questionIsNotApprovedCounter}</h3>
				 		<h3>Câu hỏi chờ xác minh nội dung</h3>
                 	</div>
                 </div>
                 <div class="col-md-4 box0">
                	<div class="box1">
				  		<a><i class="fa fa-users fa-5x"></i></a>
				 		<h3>${dashboardModel.userCounter}</h3>
				 		<h3>Tài khoản thành viên</h3>
                	</div>
                 </div>
        	</div>
       </div>      
	</section>
