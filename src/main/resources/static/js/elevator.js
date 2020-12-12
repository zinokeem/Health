/**
 * 
 */

let count = 100; // 총 층수
var currentFloor = 7; // 현재 층

function refresh() {
	$.ajax({
			type: "GET",
			url: "/init",
			data: null
		}).done(function(result) {
			console.log(result);
		}).fail(function(result) {
			console.log(result);
		});
}

function eventHandler() {
	$('div#buttons input.up').click(function() {
		if (currentFloor < count) {
			currentFloor++;
			moveFloor(count-currentFloor);
		}
	});
	
	$('div#buttons input.down').click(function() {
		if (currentFloor > 1) {
			currentFloor--;
			moveFloor(count-currentFloor);
		}
	});
	
	$('div#buttons input.excute').click(function() {
		$.ajax({
			type: "POST",
			url: "/test",
			data: {param:"hi"}
		}).done(function(result) {
			console.log("성공");
		}).fail(function(result) {
			console.log("실패");
		});
	});
	
	$('div#buttons input.floor').change(function(e) {
		var target = $(this);
		var value = target.val();
		count = value;
		initFloor();
		console.log(value);
	});
}

function initFloor() {
	var target = $('.elevator tbody');
	target.children().remove();
	for (var i = count; i > 0; i--) {
		target.append("<tr><td>" + i + "층</td><td>대기 인원</td></tr>");
	}
	currentFloor = 1;
	setFloorPosition(count-1)
}

function setFloorPosition(index) {
	var targets = $('.elevator tbody').find('tr');
	targets.removeClass("on");
	targets.eq(index).first().addClass("on");
}

function moveFloor(index) {
	setFloorPosition(index);
	var target = $('.elevator tbody').find('tr.on');
	$('html').stop().animate({
    	scrollTop: target.offset().top - ($(window).height() / 2)
	},500);
}

$(document).ready(function () {
	initFloor();
	eventHandler();
	setInterval(refresh, 1000);
});