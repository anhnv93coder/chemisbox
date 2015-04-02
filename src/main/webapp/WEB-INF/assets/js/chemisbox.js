/**
 * 
 */

var RESULT_CHARACTER = "&nbsp;&nbsp;&nbsp;<a><i class='fa fa-long-arrow-right'></i></a>&nbsp;&nbsp;&nbsp;";

document.addEventListener('DOMContentLoaded', function() {
	
	$('#equation-block-list').ready(function () {
		$(this).find(".show-oxi").click(function(){
			alert("Ok");
			var flag = $(this).attr("id");
			if(flag === '1' || flag === 1){
				$(this).children().removeClass("fa-caret-down");
				$(this).children().addClass("fa-caret-up");
				$(this).parent().find("#oxiEquation").show(1000);
				$(this).attr("id", 0);
			}else{
				$(this).children().removeClass("fa-caret-up");
				$(this).children().addClass("fa-caret-down");
				$(this).parent().find("#oxiEquation").hide(1000);
				$(this).attr("id", 1);
			}
		});
    });
	
	$("#keyWord").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			getEquation();
		}
	});
	
	$("#btnSearch").click(function(e) {
		e.preventDefault();
		getEquation();
	});
	
	
});


function fillChemical(chemical) {
	if(!stringIsNullOrEmpty(chemical.img)){
		$("#chemicalImg").css("display", "block");
		$("#chemicalImg").attr("src", chemical.img);
	}
	$("#chemicalName").append(chemical.name);
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
	$("#chemicalName").append(element.name);
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
		var res = inParam.formula.match(/[A-Za-z()]+[0-9]*/g);
		if(res != null && res.length > 0){
			var temp = "";
			for(var i = 0; i < res.length; i++){
				var number = res[i].match(/[0-9]+/g);
				temp += res[i].replace(number, '<sub>' + number + '</sub>');
			}
			inParam.formula = temp;
		}
		
		if (inParam.numberOfAtomic == '1') {
			chemicalStr = inParam.formula + inParam.condition;
		} else {
			chemicalStr = inParam.numberOfAtomic + inParam.formula
					+ inParam.condition;
		}
		if (inParam.typeOf === 1) {
			inputChemical += chemicalStr + "&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;";
		} else {
			outputChemical += chemicalStr + "&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;";
		}
	});
	inputChemical = $
			.trim(inputChemical.substring(0, inputChemical.length - 37));
	outputChemical = $.trim(outputChemical.substring(0,
			outputChemical.length - 37));
	var master = inputChemical + RESULT_CHARACTER + outputChemical
	master = master.replace("+", "<a><i class='fa fa-plus'></i></a>");
	return master;
}

function formatOxiReduceForDisplay(source){
	var res = source.match(/(d)*(\w)+(\d)*[+−]?/g);
	if(res != null && res.length > 0){
		var temp = "";
		for(var i = 0; i < res.length; i++){
		     var number = res[i].match(/[n]?(\d)?[+−]{1}/g);
		         temp = res[i].replace(number, '<sup>' + number + '</sup>');
		         source = source.replace(res[i], temp);
		 }
	}
//	source = source.replace('/+/g', " <a><i class='fa fa-plus'></i></a> ");
	source = source.replace(/ /g, '&nbsp;&nbsp;&nbsp;');
	source = source.replace(/=/g, "<a><i class='fa fa-long-arrow-right'></i></a>");

	return source;
}


function mergeOxiReduceEquation(data) {
	var oxiEquation = "<a id='1' class='show-oxi'><i class='fa fa-caret-down'> Phản ứng oxi hóa - khử</i></a>"
		+ "<blockquote id='oxiEquation' style='display: none;'>" 
		+ "<p class='equation'>" + formatOxiReduceForDisplay(data.reduceEquation) + "</p>"
		+ "<p class='equation'>" + formatOxiReduceForDisplay(data.oxiEquation) + "</p>"
		+ "</blockquote>";
	return oxiEquation;
}


function fillResult(data){
	var i = 0;
	$("#result-block").css("display", "block");
	
	//
	if (data.element != null) {
		fillElement(data.element);
	} else if (data.chemical != null) {
		fillChemical(data.chemical);
	}else{
		//$("#chemicalImg").css("display", "none");
		$("#chemicalAndElementBlock").css("display", "none");
	}
	
	//
	if(data.equationList != null && data.equationList.length > 0){
		$("#equation-list").append("<p class='bg-danger'>&nbsp;<i class='fa fa-search'></i>&nbsp;&nbsp;Bạn đang tìm phản ứng liên quan đến: " + data.keyWord + "</p>");
		$.each(data.equationList, function(key, value) {
			var equation = JSON.parse(value.equation);
			$.each(equation, function(index,chemicals) {
				var oxiEquation = mergeOxiReduceEquation(value.oxiReduceEquation);
				$("#equation-list").append(
					"<blockquote id='#equation-block-list'><p class='equation'><span class='badge'>" + (++i) + "</span>&nbsp;"
					+ mergeChemicalToEquation(chemicals)
					+ "</p><footer style='padding-bottom:15px;'>"+ value.condition+ "</footer>"  + oxiEquation + "</blockquote><hr/>");
			});
		});
	}else{
		$("#equation-list").html(
				"<div class='alert alert-warning' id='error-msg' role='alert'><i class='fa fa-frown-o'></i> <strong>Xin lỗi!</strong> Không tìm thấy phản ứng nào của <strong>"
				+ data.keyWord + "</strong></div>");
	}
	scrollToElement("#result-block", 2000);
}

function getEquation() {
	var keyWord = $("#keyWord").val().trim();
	$("#chemicalImg").removeAttr("src");
	$("#chemicalImg").css("display", "none");
	$("#equation-list").empty();
	$("#chemical-info").empty();
	$("#chemicalName").empty();
	$.ajax({
		url : '/ChemisBox/search/' + keyWord,
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
				fillResult(data);				
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

var scrollToElement = function(el, ms) {
	var speed = (ms) ? ms : 600;
	$('html,body').animate({
		scrollTop : $(el).offset().top
	}, speed);
}

function stringIsNullOrEmpty(source){
	return (!source || source == undefined);
}
