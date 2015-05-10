/**
 * 
 */

var RESULT_CHARACTER = "&nbsp;&nbsp;&nbsp;<a><i class='fa fa-long-arrow-right'></i></a>&nbsp;&nbsp;&nbsp;";

$(function() {
	
	$("#btnViewMore").click(function() {
		currentPage++;
		getEquation();
	});
	
	$('.feedback').tooltip();
	
	$("#keyWord").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			eIndex = 1;
			currentPage = 0;
			getEquation();
		}
	});
	
	$("#btnSearch").click(function(e) {
		e.preventDefault();
		eIndex = 1;
		currentPage = 0;
		getEquation();
	});
	
	$('.feedback').click(function(e) {
		$("#feedbackForm").css("display", "block");
		$("#successMessage").css("display", "none");
		$("#btnSendFeedBack").css("display", "block");
	});
		
	$("#btnSendFeedBack").click(function(e) {
		$("#feedbackForm").css("display", "none");
		$("#btnSendFeedBack").css("display", "none");
		
		var email = $.trim($("#email").val());
		var content = $.trim($("#content").val());
		
		var d = new Date();
		
		var feedback = {"email" : email, "description" : content};
		var model = {"feedback" : feedback};
		
		$.ajax({
			url : 'feedback',
			dataType : "json",
			contentType : "application/json",
			type : 'POST',
			data : JSON.stringify(model),
			success : function(data) {
				if(!stringIsNullOrEmpty(data.errorMessage)){
					alert(data.errorMessage);
				}else{
					$("#successMessage").css("display", "block");
				}
			},
			error : function(data) {
				alert(JSON.stringify(data));
			}
		});
		
	});
});



function showOxi(id, equationBlock) {
	
	if(false == $(id).parent().parent().find(equationBlock).is(':visible')){
		$(id).children().removeClass("fa-caret-down");
		$(id).children().addClass("fa-caret-up");
		$(id).parent().parent().find(equationBlock).show(250);
	}else{
		$(id).children().removeClass("fa-caret-up");
		$(id).children().addClass("fa-caret-down");
		$(id).parent().parent().find(equationBlock).hide(250);
	}
}

function showVideo(id, equationBlock) {
	
	if(false == $(id).parent().parent().find(equationBlock).is(':visible')){
		$(id).parent().parent().find(equationBlock).show(250);
	}else{
		$(id).parent().parent().find(equationBlock).hide(250);
	}
}

function fillChemical(chemical) {
	if(!stringIsNullOrEmpty(chemical.img)){
		$("#chemicalImg").css("display", "block");
		$("#chemicalImg").attr("src", chemical.img);
	}
	if(stringIsNullOrEmpty(chemical.name)){
		$("#chemicalName").append(chemical.formula);
	}else{
		$("#chemicalName").append(chemical.name);
	}
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Tên chính</dt><dd>" + chemical.name
					+ "</dd></dl>");
	if(!stringIsNullOrEmpty(chemical.differenceName)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Tên khác</dt><dd>"
						+ chemical.differenceName + "</dd></dl>");
	}
			
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Công thức</dt><dd>"
					+ chemical.formula + "</dd></dl>");
	$("#chemical-info").append(
			"<dl class='dl-horizontal'><dt>Khối lượng (M)</dt><dd>"
					+ chemical.quantity + "</dd></dl>");
	
	if(!stringIsNullOrEmpty(chemical.description)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Mô tả</dt><dd>"
						+ chemical.description + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.density)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Tỷ trọng</dt><dd>"
						+ chemical.density + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.meltingTemperature)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
						+ chemical.meltingTemperature + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.boilingTemperature)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
						+ chemical.boilingTemperature + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.solubilityInWater)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Độ hòa tan</dt><dd>"
						+ chemical.solubilityInWater + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.ignitionPoint)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Điểm bắt lửa</dt><dd>"
						+ chemical.ignitionPoint + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(chemical.flavour)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Mùi</dt><dd>" + chemical.flavour
						+ "</dd></dl>");
	}
}


function fillElement(element) {
	if(!stringIsNullOrEmpty(element.img)){
		$("#chemicalImg").css("display", "block");
		$("#chemicalImg").attr("src", element.img);
	}
	if(!stringIsNullOrEmpty(element.name)){
		$("#chemicalName").html(element.name);
	}else{
		$("#chemicalName").html(element.notation);
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
	if(!stringIsNullOrEmpty(element.meltingTemperature)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Nhiệt độ nóng chảy</dt><dd>"
						+ element.meltingTemperature + "</dd></dl>");
	}
	
	if(!stringIsNullOrEmpty(element.boilingTemperature)){
		$("#chemical-info").append(
				"<dl class='dl-horizontal'><dt>Nhiệt độ sôi</dt><dd>"
						+ element.boilingTemperature + "</dd></dl>");
	}
	
}


function mergeChemicalToEquation(chemicals) {
	var inputChemical = "";
	var outputChemical = "";
	var baseURLDetail = baseURL + "/detail"; 
	$.each(chemicals, function(i, inParam) {
		var chemicalStr = "";
		var formulaTemp = "";
		
		// replace number by <sub>number</sub>
		var res = inParam.formula.match(/[A-Za-z()]+[0-9]*/g);
		if(res != null && res.length > 0){
			var temp = "";
			for(var i = 0; i < res.length; i++){
				var number = res[i].match(/[0-9]+/g);
				temp += res[i].replace(number, '<sub>' + number + '</sub>');
			}
			formulaTemp = temp;
		}
		
		// replace (condition) by <sub>(condition)</sub>
		var conditionRes = inParam.condition.match(/\({1}[catốtanốtchấtlỏngrắnkhídungdịchrấtloãngđậmđặc\s]+\){1}/g);
		if(conditionRes != null && conditionRes.length > 0){
			for(var i = 0; i < conditionRes.length; i++){
				inParam.condition = inParam.condition.replace(conditionRes[i], "<sub>" + conditionRes[i] + "</sub>") 
			}
		}
		
		if (inParam.numberOfAtomic == '1') {
			chemicalStr = formulaTemp + $.trim(inParam.condition);
		} else {
			chemicalStr = inParam.numberOfAtomic + formulaTemp
					+ $.trim(inParam.condition);
		}
		
		chemicalStr = "<a href='" + baseURLDetail + "/" + inParam.formula + "'>" + chemicalStr + "</a>";
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
	master = master.replace(/[+]/g, "<a><i class='fa fa-plus'></i></a>");
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

function formatIonForDisplay(source){
	var res = source.match(/(d)*(\w)+(\d)*[+−]?/g);
	if(res != null && res.length > 0){
		var temp = "";
		for(var i = 0; i < res.length; i++){
		     var number = res[i].match(/[n]?(\d)?[+−]{1}/g);
		         temp = res[i].replace(number, '<sup>' + number + '</sup>');
		         source = source.replace(res[i], temp);
		 }
	}

	 res = source.match(/(\w)+(\d)+ <sup>/g);
    if(res != null && res.length > 0){
         for(var i = 0; i < res.length ; i++){
              var temp = res[i].replace(' ', '');
              source = source.replace(res[i], temp);
         }
    }
	
//	source = source.replace('/+/g', " <a><i class='fa fa-plus'></i></a> ");
	source = source.replace(/ /g, '&nbsp;&nbsp;&nbsp;');
	source = source.replace(/=/g, "<a><i class='fa fa-long-arrow-right'></i></a>");

	return source;
}


function mergeOxiReduceEquation(data) {
	var oxiEquation = "<p class='equation-title'><a class='show-oxi' onclick='showOxi(this, \"#oxiEquation\")'><i class='fa fa-caret-down' href='#'> Phương trình oxi hóa - khử</i></a></p>"
		+ "<blockquote id='oxiEquation' style='display: none;'>" 
		+ "<p class='equation'>Quá trình khử:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + formatOxiReduceForDisplay(data.reduceEquation) + "</p>"
		+ "<p class='equation' style='border-bottom: 1px solid;'>Quá trình oxi hóa:&nbsp;" + formatOxiReduceForDisplay(data.oxiEquation) + "</p>"
		+ "<p class='equation'>" + formatOxiReduceForDisplay(data.summary) + "</p>"
		+ "</blockquote>";
	return oxiEquation;
}

function mergeIonEquation(data) {
	var ionEquation = "<p  class='equation-title'><a class='show-ion' onclick='showOxi(this, \"#ionEquation\")'><i class='fa fa-caret-down'  href='#'> Phương trình ion</i></a></p>"
		+ "<blockquote id='ionEquation' style='display: none;'>" 
		+ "<p class='equation'>" + formatIonForDisplay(data.ionEquation) + "</p>"
		+ "<p class='equation'>" + formatIonForDisplay(data.shortcutIonEquation) + "</p>"
		+ "</blockquote>";
	return ionEquation;
}

function fillResult(data){
	$("#result-block").css("display", "block");
	$("#chemicalAndElementBlock").css("display", "block");
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
	if(data.equationList != null && data.equationList.length > 0) {
		if(data.keyWord.localeCompare(oldKeyWord) != 0 && currentPage == 0){
			$("#equation-list").append("<p class='bg-danger'>&nbsp;<i class='fa fa-search'></i>&nbsp;&nbsp;Bạn đang tìm phản ứng liên quan đến: " + data.keyWord + "</p>");
		}
		
		if(data.equationList.length < maxSize) {
			$("#divViewMore").css("display", "none");
		} else {
			$("#divViewMore").css("display", "block");
		}
		
		$.each(data.equationList, function(key, value) {
			var equation = JSON.parse(value.equation);
			$.each(equation, function(index,chemicals) {
			
				var oxiEquation = "";
				if(!stringIsNullOrEmpty(value.reduceEquation) 
						&& !stringIsNullOrEmpty(value.oxiEquation) 
						&& !stringIsNullOrEmpty(value.summary)) {
					oxiEquation = mergeOxiReduceEquation(value);
				}
				
				var ionEquation = "";
				if(!stringIsNullOrEmpty(value.ionEquation) && !stringIsNullOrEmpty(value.shortcutIonEquation)) {
					ionEquation = mergeIonEquation(value);
				}
				
				var videoBlock = "";
				if(!stringIsNullOrEmpty(value.videoLink)){
					videoBlock = "<p class='show-video'><a class='show-video' onclick='showVideo(this, \"#videoBlock\")'><i class='fa fa-video-camera'></i> Xem video</a></p>"
								+"<div id='videoBlock' class='embed-responsive embed-responsive-4by3' style='display: none;'>"
								+"<iframe class='embed-responsive-item' src='" + value.videoLink + "'></iframe></div>";
				}
				
				$("#equation-list").append(
					"<blockquote id='#equation-block-list'><p class='equation'><span class='badge'>" + (eIndex++) + "</span>&nbsp;"
					+ mergeChemicalToEquation(chemicals)
					+ "<a href='#' class='feedback pull-right' data-toggle='modal' data-target='#exampleModal' data-toggle='tooltip' data-placement='right' title='Phản hồi'>" 
					+ "<i class='fa fa-comment'></i></a></p><footer style='padding-bottom:15px;'>"+ value.condition+ "</footer>"  + oxiEquation + ionEquation + videoBlock +"</blockquote><hr/>");
			});
		});
	} else {
		if(currentPage == 0){
			$("#equation-list").html(
					"<div class='alert alert-warning' id='error-msg' role='alert'><i class='fa fa-frown-o'></i> <strong>Xin lỗi!</strong> Không tìm thấy phản ứng nào của <strong>"
					+ data.keyWord + "</strong></div>");
		} else {
			$("#divViewMore").css("display", "none");
		}
	}
	if(currentPage == 0){
		scrollToElement("#result-block", 400);
	}
}



function getEquation() {
	var keyWord = $.trim($("#keyWord").val());
	 
	$("#chemicalImg").removeAttr("src");
	$("#chemicalImg").css("display", "none");
	if(currentPage == 0 || keyWord.localeCompare(oldKeyWord) != 0){
		$("#equation-list").empty();
		oldKeyWord = keyWord;
	}
	$("#chemical-info").empty();
	$("#chemicalName").empty();
	
	var model = {currentPage : currentPage, keyWord : keyWord};
	
	$.ajax({
//		url : '/ChemisBox/search/' + keyWord,
		url : '/ChemisBox/search/',
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(model),
		type : 'POST',
		success : function(data) {
			if (data != null) {
				if(data.equationList == null && data.element == null && data.chemical == null){
					$("#result-block").css("display", "none");
					alert("Không tìm thấy kết quả.");
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

var scrollToElement = function(el, ms) {
	var speed = (ms) ? ms : 600;
	$('html,body').animate({
		scrollTop : $(el).offset().top
	}, speed);
}

function stringIsNullOrEmpty(source) {
	if(typeof(source) == 'undefined' || source == null|| source == "" || source == ''){
		return true;
	}
	return false;
}
