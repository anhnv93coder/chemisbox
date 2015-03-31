/**
 * 
 */

var RESULT_CHARACTER = " = ";

function fillChemical(chemical) {
	if(!stringIsNullOrEmpty(chemical.img)){
		$("#chemicalImg").css("display", "block");
		$("#chemicalImg").attr("src", chemical.img);
	}
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Tên chính</dt><dd>" + chemical.name
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Tên khác</dt><dd>"
					+ chemical.differenceName + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Công thức</dt><dd>"
					+ chemical.formula + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Khối lượng (M)</dt><dd>"
					+ chemical.quantity + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Mô tả</dt><dd>"
					+ chemical.description + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Tỷ trọng</dt><dd>"
					+ chemical.density + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
					+ chemical.meltingTemperature + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
					+ chemical.boilingTemperature + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Độ hòa tan</dt><dd>"
					+ chemical.solubilityInWater + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Điểm bắt lửa</dt><dd>"
					+ chemical.ignitionPoint + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Mùi</dt><dd>" + chemical.flavour
					+ "</dd></dl>");

}

function fillElement(element) {
	if(!stringIsNullOrEmpty(element.img)){
		$("#chemicalImg").css("display", "block");
		$("#chemicalImg").attr("src", element.img);
	}
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Ký hiệu</dt><dd>" + element.notation
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Tên gọi</dt><dd>" + element.name
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Số nguyên tử</dt><dd>"
					+ element.numberOfAtomic + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Khối lượng nguyên tử</dt><dd>"
					+ element.atomicVolume + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Phân loại</dt><dd>" + element.classify
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Nhóm</dt><dd>" + element.group
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Chu kỳ</dt><dd>" + element.cycle
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Cấu hình electron</dt><dd>"
					+ element.electronConfiguration + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Lớp</dt><dd>" + element.layers
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Mô tả</dt><dd>" + element.description
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Màu sắc</dt><dd>" + element.color
					+ "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Trạng thái</dt><dd>"
					+ element.condition + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
					+ element.meltingTemperature + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
					+ element.boilingTemperature + "</dd></dl>");
}

function mergeChemicalToEquation(chemicals) {
	var inputChemical = "";
	var outputChemical = "";
	$.each(chemicals, function(i, inParam) {
		var chemicalStr = "";
		if (inParam.numberOfAtomic == '0') {
			chemicalStr = inParam.formula + inParam.condition;
		} else {
			chemicalStr = inParam.numberOfAtomic + inParam.formula
					+ inParam.condition;
		}
		if (inParam.typeOf === 1) {
			inputChemical += chemicalStr + " + ";
		} else {
			outputChemical += chemicalStr + " + ";
		}
	});
	inputChemical = $
			.trim(inputChemical.substring(0, inputChemical.length - 2));
	outputChemical = $.trim(outputChemical.substring(0,
			outputChemical.length - 2));
	var master = inputChemical + RESULT_CHARACTER + outputChemical
	return master;
}

function getEquation() {
	var keyWord = $("#key-word").val().trim();
	$("#chemicalImg").removeAttr("src");
	$("#chemicalImg").css("display", "none");
	$("#equation-list").empty();
	$("#chemical-info").empty();
	$.ajax({
		url : '/ChemisBox/equation/search/' + keyWord,
		dataType : "json",
		contentType : "application/json",
		type : 'GET',
		success : function(data) {
			if (data != null) {
				
				if(data.equationList == null && data.element == null && data.chemical == null){
					$("#result-block").css("display", "none");
					alert("Khong tim thay");
					return;
				}
				
				$("#result-block").css("display", "block");
				
				//
				if (data.element != null) {
					fillElement(data.element);
				} else if (data.chemical != null) {
					fillChemical(data.chemical);
				}else{
					$("#chemicalImg").css("display", "none");
					$("#chemical-info").html("<h2>Ko tim thay cong thuc: </h2>" + data.keyWord);
				}
				
				//
				if(data.equationList != null){
					$.each(data.equationList, function(key, value) {
						var equation = JSON.parse(value.equation);
						$.each(equation, function(index,chemicals) {
							$("#equation-list").append("<blockquote><p class='equation'>"
								+ mergeChemicalToEquation(chemicals)
								+ "</p><footer>"
								+ value.condition
								+ "</footer></blockquote><hr/>");
						});
					});
				}else{
					$("#equation-list").html(
							"<div class='alert alert-warning' id='error-msg' role='alert'><i class='fa fa-frown-o'></i> <strong>Xin lỗi!</strong> Không tìm thấy phản ứng nào của <strong>"
							+ keyWord + "</strong></div>");
				}
				scrollToElement("#result-block", 2000);
				
			}
		},
		error : function(data) {
			alert(JSON.stringify(data));
		}
	});
}

function getCycleEquation(leftKeyWord, rightKeyWord) {
	$.ajax({
		url : '/ChemisBox/equation/search/' + leftKeyWord + '/'+ rightKeyWord,
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

	$("#key-word").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			getEquation();
		}
	});
	
	$("#btn-search").click(function(e) {
		e.preventDefault();
		getEquation();
	});
});



var scrollToElement = function(el, ms) {
	var speed = (ms) ? ms : 600;
	$('html,body').animate({
		scrollTop : $(el).offset().top
	}, speed);
}

function stringIsNullOrEmpty(source){
	return (!source || source == undefined);
}
