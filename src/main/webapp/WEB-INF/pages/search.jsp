<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
   <jsp:include page="base/head.jsp"></jsp:include>
    
</head>

<body>
    <section id="header" class="appear"></section>
    <div class="navbar navbar-fixed-top" role="navigation" data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="fa fa-bars color-white"></span>
                </button>
                <h1><a class="navbar-brand" href="index.html" data-0="line-height:90px;" data-300="line-height:50px;">ChemisBox</a></h1>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                    <li class="active"><a href="/ChemisBox/">Trang chủ</a></li>
                    <li><a href="#section-works">Bảng Tuần Hoàn</a></li>
                </ul>
            </div><!--/.navbar-collapse -->
        </div>
    </div>

    <jsp:include page="base/header.jsp"></jsp:include>
<!-- about -->
<section class="section appear clearfix section-contact-bg" id="result-block" style="display: none" >
    <div class="container">

        <div class="row mar-bot40">
            <div class="col-md-offset-3 col-md-6">
                <div class="section-header">
                    <h2 class="section-heading animated" data-animation="bounceInUp">Kết quả</h2>
                </div>
            </div>
        </div>

        <div class="row mar-bot40">
            <div class="col-md-7">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                            <i class="fa fa-list-ol fa-3x"></i> Phản ứng
                    </div>
                    <div class="panel-body" id="equation-list"></div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                            <i class="fa fa-info fa-3x"></i> 
                    </div>
                    <img src="" alt="..." class="img-rounded center-block" id="chemicalImg" style="display: none; margin-top: 10px"/>
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
<script src="assets/js/chemisbox.js"></script>
<!-- section footer -->
</body>
</html>