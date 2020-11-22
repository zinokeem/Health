/**
 * 
 */

$(Document).ready(function () {
	setSelectBox();
	eventHanler();
});

function setSelectBox() {
	var html = "";
	for (var loop = 1; loop <= 20; loop++) {
		html += "<option value='" + loop + "'>" + loop + "</option>";
	}
	$("#repsBox").append(html);
}

function eventHanler() {
	$("#submit").click(function() {
		var weight = $("#weight")[0].value;
		var reps = $("#repsBox")[0].value;
		
		var result = Math.round(calc.getOneRep2(weight, reps));
		
		$("#result")[0].value = result;
	});
}

var calc = new Calculator();

function Calculator() {
	this.description = "tools";
}
Calculator.prototype.getOneRep = function(weight, reps) {
	if (reps == 1) {
		return weight;
	}
	var result = weight * 0.025 * reps;
	result = weight + result;
	return result;
}
Calculator.prototype.getOneRep2 = function(weight, reps) {
	var result = weight / (1.0278 - (0.0278 * reps));
	return result;
}