/**
 * 
 */

function getChemical(chemical) {
	$.ajax({
		url : '/ChemisBox/chemical/search/' + chemical,
		type : 'GET',
		headers: {'accept': 'application/json', 'Content-Type' : 'application/json; charset=utf-8'},
		dataType: 'json',
		data: {},
		success : function(data) {
			$("#chemical-info").empty();
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Tên chính</dt><dd>"
							+ data.name + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Tên khác</dt><dd>"
							+ data.differenceName + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Công thức</dt><dd>"
							+ data.formula + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Khối lượng (M)</dt><dd>"
							+ data.quantity + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Mô tả</dt><dd>"
							+ data.description + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Tỷ trọng</dt><dd>"
							+ data.density + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
							+ data.meltingTemperature + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
							+ data.boilingTemperature + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Độ hòa tan</dt><dd>"
							+ data.solubilityInWater + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Điểm bắt lửa</dt><dd>"
							+ data.ignitionPoint + "</dd></dl>");
			$("#chemical-info").append(
					"<dl class='dl-horizontal'><dt>Mùi</dt><dd>" + data.flavour
							+ "</dd></dl>");
		},
		error : function(msg) {
			alert(msg.message);
		}
	});
}

function getElement(keyWord) {
	var deferred = $.Deferred();
	$.ajax({
		url : '/ChemisBox/element/search/' + keyWord,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(data) {
			if (!data || data == null) {
				deferred.resolve(false);
			} else {
				$("#chemical-info").empty();
				$("#chemicalImg").css("display", "block");
				$("#chemicalImg").attr("src", data.img);
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Ký hiệu</dt><dd>"
								+ data.notation + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Tên gọi</dt><dd>"
								+ data.name + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Số nguyên tử</dt><dd>"
								+ data.numberOfAtomic + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Khối lượng nguyên tử</dt><dd>"
								+ data.atomicValue + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Phân loại</dt><dd>"
								+ data.classify + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Nhóm</dt><dd>"
								+ data.group + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Chu kỳ</dt><dd>"
								+ data.cycle + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Cấu hình electron</dt><dd>"
								+ data.electronConfiguration + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Lớp</dt><dd>"
								+ data.layers + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Mô tả</dt><dd>"
								+ data.description + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Màu sắc</dt><dd>"
								+ data.color + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Trạng thái</dt><dd>"
								+ data.condition + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
								+ data.meltingTemperature + "</dd></dl>");
				$("#chemical-info").append(
						"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
								+ data.boilingTemperature + "</dd></dl>");
				deferred.resolve(true);
			}
		},
		error : function(msg) {
			console.log("error");
			deferred.resolve(false);
		}
	});
	return deferred.promise();
}



function getEquation(chemical) {
	$.ajax({
		url : '/ChemisBox/equation/search/' + chemical,
		dataType: "json",
		contentType: "application/json",
		type : 'GET',
		success : function(data) {
			if (data.equationList == null) {
				$("#equation-list")
						.html(
								"<div class='alert alert-warning' id='error-msg' role='alert'><i class='fa fa-frown-o'></i> <strong>Xin lỗi!</strong> Không tìm thấy phản ứng nào của <strong>"
										+ chemical + "</strong></div>");
			} else {
				$.each(data.equationList, function(key, value) {
					console.log(value.condition);
					var equation = JSON.parse(value.equation);
					$.each(equation, function(index, chemicals) {
						$.each(chemicals, function(i, chemical) {
							console.log(chemical.typeOf);
						});
					});
//					chemicals
					/*$("#equation-list").append(
							"<blockquote><p class='equation'>"
									+ value.equation + "</p><footer>"
									+ value.condition
									+ "</footer></blockquote><hr/>");*/
				});
			}
		},
		error : function(data) {
			alert(JSON.stringify(data));
		}
	});
}

function getCycleEquation(leftKeyWord, rightKeyWord) {
	$.ajax({
		url : '/ChemisBox/equation/search/' + leftKeyWord + '/' + rightKeyWord,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(data) {
			if (data.length == 0) {
				$("#equation-list").html("<div class='alert alert-warning' id='error-msg' role='alert'><i class='fa fa-frown-o'></i> <strong>Xin lỗi!</strong> Không tìm thấy phản ứng nào của <strong>"
										+ chemical + "</strong></div>");
			} else {
				$.each(data, function(key, value) {
					$("#equation-list").append("<blockquote><p class='equation'>"
									+ value.equation + "</p><footer>"
									+ value.condition
									+ "</footer></blockquote><hr/>");
				});
			}
		},
		error : function(msg) {
			alert(msg.message);
		}
	});
}

$(document).ready(function() {

	$("#btn-search").click(function(e) {
		e.preventDefault();
		$("#loader").css("display", "block");
		$("#equation-list").empty();
		var keyWord = $("#key-word").val().trim();
		$("#result-block").css("display", "block");
		getEquation(keyWord);
		//getCycleEquation('Na', 'NaH');
		/*var elementPromise = getElement(finalKeyWord);
		elementPromise.done(function(data) {
			if (!data) {
				getChemical(finalKeyWord);
			}
			$("#loader").css("display", "none");
			scrollToElement("#result-block", 2000);
		});*/
		
	});
});

var scrollToElement = function(el, ms) {
	var speed = (ms) ? ms : 600;
	$('html,body').animate({
		scrollTop : $(el).offset().top
	}, speed);
}
