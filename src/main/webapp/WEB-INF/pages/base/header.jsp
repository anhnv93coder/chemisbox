<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
						<input id="keyWord" class="form-control" placeholder="Nhập từ khóa"
							style="width: 85%;" value="${searchModel.keyWord}"/>
						<button id="btnSearch" type="button" class="btn btn-default">Search</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</section>