$(function() {
	$("#chemicalKeyWord").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			var keyWord = $.trim($("#chemicalKeyWord").val());
			if(!stringIsNullOrEmpty(keyWord)){
				window.location = baseURL + "/admin/chemical/search/" + keyWord + "/1";
			}
		}
	});
	$("#elementKeyWord").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			var keyWord = $.trim($("#elementKeyWord").val());
			if(!stringIsNullOrEmpty(keyWord)){
				window.location = baseURL + "/admin/element/search/" + keyWord + "/1";
			}
		}
	});
	$("#equationKeyWord").keyup(function(e) {
		var code = e.keyCode || e.which;
		if(code == 13){
			var keyWord = $.trim($("#equationKeyWord").val());
			if(!stringIsNullOrEmpty(keyWord)){
				window.location = baseURL + "/admin/equation/search/" + keyWord + "/1";
			}
		}
	});
});


$("#btnApproved").click(function() {
	var questionId = $("#questionId").val();
	var model = {
		questionId : questionId
	};
	$.ajax({
		url : baseURL + "/admin/question/approved",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(stringIsNullOrEmpty(data.errorMessage)){
				$("#btnCancelUpdate").click();
				window.location = window.location;
			} else {
				alert("Xuất hiện lỗi. Vui lòng liên hệ với quản trị.");
				console.log(data.errorMessage);
			}
		},
		error : function(msg) {
			alert("Xuất hiện lỗi. Vui lòng liên hệ với quản trị.");
			window.location = baseURL + "/admin";
		}
	});
});

function loadDetailsForQuestion(questionId) {
	var model = {
		questionId : questionId
	};
	$.ajax({
		url : baseURL + "/admin/question/loadDetails",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			$("#questionId").val(data.question.questionId);
			$("#fullName").val(data.question.user.fullName);
			$("#email").val(data.question.user.email);
			$("#title").val(data.question.title);
			$("#content").val(data.question.content);
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
}


function loadDetailsForElement(notation) {
	var model = {
		"notation" : notation
	};
	$.ajax({
		url : baseURL + "/admin/element/loadDetails",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			$("#notationUpdate").val(data.element.notation);
			$("#nameUpdate").val(data.element.name);
			$("#numberOfAtomicUpdate").val(data.element.numberOfAtomic);
			$("#atomicVolumeUpdate").val(data.element.atomicVolume);
			$("#classifyUpdate").val(data.element.classify);
			$("#groupUpdate").val(data.element.group);
			$("#cycleUpdate").val(data.element.cycle);
			$("#electronConfigurationUpdate").val(data.element.electronConfiguration);
			$("#layersUpdate").val(data.element.layers);
			$("#descriptionUpdate").val(data.element.description);
			$("#colorUpdate").val(data.element.color);
			$("#conditionUpdate").val(data.element.condition);
			$("#meltingTemperatureUpdate").val(data.element.meltingTemperature);
			$("#boilingTemperatureUpdate").val(data.element.boilingTemperature);
			$("#imgUpdate").val(data.element.img);
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
}

function loadDetailsForEquation(id) {
	var model = {
		"equationId" : id
	};
	$.ajax({
		url : baseURL + "/admin/equation/loadDetails",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			$("#equationIdUpdate").val(data.equation.equationId);
			$("#equationUpdate").val(data.equation.equation);
			$("#descriptionUpdate").val(data.equation.description);
			$("#conditionUpdate").val(data.equation.condition);
			$("#videoLinkUpdate").val(data.equation.videoLink);
			
			$("#ionEquationUpdate").val(
					data.equation.ionEquation);
			$("#ionShortcutUpdate").val(
					data.equation.shortcutIonEquation);
			$("#oxiEquationUpdate").val(
					data.equation.oxiEquation);
			$("#molOxiUpdate").val(data.equation.molOxi);
			$("#reduceEquationUpdate").val(
					data.equation.reduceEquation);
			$("#molReduceUpdate").val(
					data.equation.molReduce);
			$("#summaryUpdate")
					.val(data.equation.summary);
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
}

function loadDetailsForChemical(id) {
	var model = {
		"chemicalId" : id
	};
	$.ajax({
		url : baseURL + "/admin/chemical/loadDetails",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			$("#chemicalId").val(data.chemical.id);
			$("#chemicalNameUpdate").val(data.chemical.name);
			$("#differenceNameUpdate").val(data.chemical.differenceName);
			$("#formulaUpdate").val(data.chemical.formula);
			$("#quantityUpdate").val(data.chemical.quantity);
			$("#descriptionUpdate").val(data.chemical.description);
			$("#densityUpdate").val(data.chemical.density);
			$("#meltingTemperatureUpdate")
					.val(data.chemical.meltingTemperature);
			$("#boilingTemperatureUpdate")
					.val(data.chemical.boilingTemperature);
			$("#solubilityInWaterUpdate").val(data.chemical.solubilityInWater);
			$("#ignitionPointUpdate").val(data.chemical.ignitionPoint);
			$("#flavourUpdate").val(data.chemical.flavour);
			$("#imgUpdate").val(data.chemical.img);
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
}

$("#btnUpdateElement").click(function() {
	var notation = $.trim($("#notationUpdate").val());
	var name = $.trim($("#nameUpdate").val());
	var numberOfAtomic = $.trim($("#numberOfAtomicUpdate").val());
	var atomicVolume = $.trim($("#atomicVolumeUpdate").val());
	var classify = $.trim($("#classifyUpdate").val());
	var group = $.trim($("#groupUpdate").val());
	var cycle = $.trim($("#cycleUpdate").val());
	var electronConfiguration = $.trim($("#electronConfigurationUpdate").val());
	var layers = $.trim($("#layersUpdate").val());
	var description = $.trim($("#descriptionUpdate").val());
	var color = $.trim($("#colorUpdate").val());
	var condition = $.trim($("#conditionUpdate").val());
	var meltingTemperature = $.trim($("#meltingTemperatureUpdate").val());
	var boilingTemperature = $.trim($("#boilingTemperatureUpdate").val());
	var img = $.trim($("#imgUpdate").val());

	if (stringIsNullOrEmpty(notation)) {
		return;
	}

	var jsonData = {
		"notation" : notation,
		"name" : name,
		"numberOfAtomic" : numberOfAtomic,
		"atomicVolume" : atomicVolume,
		"classify" : classify,
		"group" : group,
		"cycle" : cycle,
		"electronConfiguration" : electronConfiguration,
		"layers" : layers,
		"description" : description,
		"color" : color,
		"condition" : condition,
		"meltingTemperature" : meltingTemperature,
		"boilingTemperature" : boilingTemperature,
		"img" : img
	};

	var model = {
		"element" : jsonData
	};
	$.ajax({
		url : baseURL + "/admin/element/update",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(!stringIsNullOrEmpty(data.errorMessage)){
				$("#updateElementMessage").css('display', 'block');
				$("#updateElementErrorMessage").html(data.errorMessage);
			} else {
				$("#updateElementMessage").css('display', 'none');
				$("#btnCancelUpdateElement").click();
				window.location = window.location;
			}
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
});

$("#btnUpdateChemical").click(function() {
	var chemicalId = $.trim($("#chemicalId").val());
	var chemicalName = $.trim($("#chemicalNameUpdate").val());
	var differenceName = $.trim($("#differenceNameUpdate").val());
	var formula = $.trim($("#formulaUpdate").val());
	var quantity = $.trim($("#quantityUpdate").val());
	var description = $.trim($("#descriptionUpdate").val());
	var density = $.trim($("#densityUpdate").val());
	var meltingTemperature = $.trim($("#meltingTemperatureUpdate").val());
	var boilingTemperature = $.trim($("#boilingTemperatureUpdate").val());
	var solubilityInWater = $.trim($("#solubilityInWaterUpdate").val());
	var ignitionPoint = $.trim($("#ignitionPointUpdate").val());
	var flavour = $.trim($("#flavourUpdate").val());
	var img = $.trim($("#imgUpdate").val());

	if (stringIsNullOrEmpty(chemicalName)) {
		return;
	}

	if (stringIsNullOrEmpty(formula)) {
		return;
	}

//	if (!isNumeric(quantity)) {
//		return;
//	}

	var jsonData = {
		"id" : chemicalId,
		"name" : chemicalName,
		"differenceName" : differenceName,
		"formula" : formula,
		"quantity" : quantity,
		"description" : description,
		"density" : density,
		"meltingTemperature" : meltingTemperature,
		"boilingTemperature" : boilingTemperature,
		"solubilityInWater" : solubilityInWater,
		"ignitionPoint" : ignitionPoint,
		"flavour" : flavour,
		"img" : img
	};

	var model = {
		"chemical" : jsonData
	};
	$.ajax({
		url : baseURL + "/admin/chemical/update",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(!stringIsNullOrEmpty(data.errorMessage)){
				$("#updateChemicalMessage").css('display', 'block');
				$("#updateChemicalErrorMessage").html(data.errorMessage);
			} else {
				$("#updateChemicalMessage").css('display', 'none');
				$("#btnCancelUpdateChemical").click();
				window.location = window.location; 
			}
			
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
});

$("#btnAddChemical").click(function() {
	var chemicalName = $.trim($("#chemicalName").val());
	var differenceName = $.trim($("#differenceName").val());
	var formula = $.trim($("#formula").val());
	var quantity = $.trim($("#quantity").val());
	var description = $.trim($("#description").val());
	var density = $.trim($("#density").val());
	var meltingTemperature = $.trim($("#meltingTemperature").val());
	var boilingTemperature = $.trim($("#boilingTemperature").val());
	var solubilityInWater = $.trim($("#solubilityInWater").val());
	var ignitionPoint = $.trim($("#ignitionPoint").val());
	var flavour = $.trim($("#flavour").val());
	var img = $.trim($("#img").val());

	if (stringIsNullOrEmpty(chemicalName)) {
		return;
	}

	if (stringIsNullOrEmpty(formula)) {
		return;
	}

//	if (!isNumeric(quantity)) {
//		return;
//	}

	var jsonData = {
		"name" : chemicalName,
		"differenceName" : differenceName,
		"formula" : formula,
		"quantity" : quantity,
		"description" : description,
		"density" : density,
		"meltingTemperature" : meltingTemperature,
		"boilingTemperature" : boilingTemperature,
		"solubilityInWater" : solubilityInWater,
		"ignitionPoint" : ignitionPoint,
		"flavour" : flavour,
		"img" : img
	};

	var model = {
		"chemical" : jsonData
	};
	$.ajax({
		url : baseURL + "/admin/chemical/add",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(!stringIsNullOrEmpty(data.errorMessage)){
				$("#addChemicalMessage").css('display', 'block');
				$("#addChemicalErrorMessage").html(data.errorMessage);
			} else {
				$("#addChemicalMessage").css('display', 'none');
				$("#btnCancelAddChemical").click();
				window.location = window.location; 
			}
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
});

$("#btnAddElement").click(function() {
	var notation = $.trim($("#notation").val());
	var name = $.trim($("#name").val());
	var numberOfAtomic = $.trim($("#numberOfAtomic").val());
	var atomicVolume = $.trim($("#atomicVolume").val());
	var classify = $.trim($("#classify").val());
	var group = $.trim($("#group").val());
	var cycle = $.trim($("#cycle").val());
	var electronConfiguration = $.trim($("#electronConfiguration").val());
	var layers = $.trim($("#layers").val());
	var description = $.trim($("#description").val());
	var color = $.trim($("#color").val());
	var condition = $.trim($("#condition").val());
	var meltingTemperature = $.trim($("#meltingTemperature").val());
	var boilingTemperature = $.trim($("#boilingTemperature").val());
	var img = $.trim($("#img").val());

	if (stringIsNullOrEmpty(notation)) {
		return;
	}

	var jsonData = {
		"notation" : notation,
		"name" : name,
		"numberOfAtomic" : numberOfAtomic,
		"atomicVolume" : atomicVolume,
		"classify" : classify,
		"group" : group,
		"cycle" : cycle,
		"electronConfiguration" : electronConfiguration,
		"layers" : layers,
		"description" : description,
		"color" : color,
		"condition" : condition,
		"meltingTemperature" : meltingTemperature,
		"boilingTemperature" : boilingTemperature,
		"img" : img
	};

	var model = {
		"element" : jsonData
	};
	$.ajax({
		url : baseURL + "/admin/element/add",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(!stringIsNullOrEmpty(data.errorMessage)) {
				$("#addElementMessage").css('display', 'block');
				$("#addElementErrorMessage").html(data.errorMessage);
			} else {
				$("#addElementMessage").css('display', 'none');
				$("#btnCancelAddElement").click();
				window.location = window.location;
			} 
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
});

$("#btnAddEquation").click(
function() {
	var equation = $.trim($("#equation").val());
	var description = $.trim($("#description").val());
	var condition = $.trim($("#condition").val());
	var videoLink = $.trim($("#videoLink").val());

	var ionEquation = $.trim($("#ionEquation").val());
	var ionShortcut = $.trim($("#ionShortcut").val());

	var molOxi = $.trim($("#molOxi").val());
	var oxiEquation = $.trim($("#oxiEquation").val());

	var molReduce = $.trim($("#molReduce").val());
	var reduceEquation = $.trim($("#reduceEquation").val());

	var summary = $.trim($("#summary").val());

	if (stringIsNullOrEmpty(equation)) {
		return;
	}

	if (stringIsNullOrEmpty(condition)) {
		return;
	}

	var jsonData = {
		"equation" : equation,
		"description" : description,
		"condition" : condition,
		"videoLink" : videoLink,
		"ionEquation" : ionEquation,
		"shortcutIonEquation" : ionShortcut,
		"molReduce" : molReduce, 
		"reduceEquation" : reduceEquation, 
		"molOxi" : molOxi, 
		"oxiEquation" : oxiEquation, 
		"summary" : summary
	};

	var model = {
		"equation" : jsonData
	};
	$.ajax({
		url : baseURL + "/admin/equation/add",
		type : "POST",
		data : JSON.stringify(model),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(!stringIsNullOrEmpty(data.errorMessage)){
				$("#addEquationMessage").css('display', 'block');
				$("#addEquationErrorMessage").html(data.errorMessage);
			} else {
				$("#addEquationMessage").css('display', 'none');
				$("#btnCancelAddEquation").click();
				window.location = window.location;	
			} 
		},
		error : function(msg) {
			alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
			window.location = baseURL + "/admin";
		}
	});
});

$("#btnUpdateEquation").click(
		function() {
			var equationId = $.trim($("#equationIdUpdate").val());
			var equation = $.trim($("#equationUpdate").val());
			var description = $.trim($("#descriptionUpdate").val());
			var condition = $.trim($("#conditionUpdate").val());
			var videoLink = $.trim($("#videoLinkUpdate").val());

			var ionEquation = $.trim($("#ionEquationUpdate").val());
			var ionShortcut = $.trim($("#ionShortcutUpdate").val());

			var molOxi = $.trim($("#molOxiUpdate").val());
			var oxiEquation = $.trim($("#oxiEquationUpdate").val());

			var molReduce = $.trim($("#molReduceUpdate").val());
			var reduceEquation = $.trim($("#reduceEquationUpdate").val());

			var summary = $.trim($("#summaryUpdate").val());

			if (stringIsNullOrEmpty(equation)) {
				return;
			}

			if (stringIsNullOrEmpty(condition)) {
				return;
			}
			
			var jsonData = {
				equationId : equationId,
				equation : equation,
				description : description,
				condition : condition,
				videoLink : videoLink,
				ionEquation : ionEquation,
				shortcutIonEquation : ionShortcut,
				molReduce : molReduce, 
				reduceEquation : reduceEquation, 
				molOxi : molOxi, 
				oxiEquation : oxiEquation, 
				summary : summary
			};

			var model = {
				"equation" : jsonData
			};
			$.ajax({
				url : baseURL + "/admin/equation/update",
				type : "POST",
				data : JSON.stringify(model),
				dataType : "json",
				contentType : "application/json",
				success : function(data) {
					if(!stringIsNullOrEmpty(data.errorMessage)){
						$("#updateEquationMessage").css('display, block');
						$("#updateEquationErrorMessage").html(data.errorMessage);
					} else {
						$("#updateEquationMessage").css('display, none');
						$("#btnCancelUpdateEquation").click();
						window.location = window.location;
					}
					
				},
				error : function(msg) {
					alert("Xuất hiện lỗi hệ thống. Vui lòng liên hệ với quản trị");
					window.location = baseURL + "/admin";
				}
			});
		});

function setFormVisible(id, value) {
	if (value) {
		$(id).css("display", "block");
	} else {
		$(id).css("display", "none");
	}
}

function isNumeric(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

function stringIsNullOrEmpty(source) {
	if(typeof(source) == 'undefined' || source == null|| source == "" || source == ''){
		return true;
	}
	return false;
}