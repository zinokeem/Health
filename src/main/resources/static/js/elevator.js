/**
 * 
 */

let count = 100; // 총 층수
var currentFloor = 7; // 현재 층

function eventHandler() {
	$('div#buttons input.up').click(function() {
		if (currentFloor < count) {
			currentFloor++;
			moveFloor(count-currentFloor);
		}
		
		var target = $('.elevator tbody').find('td.on');
		$('html').animate({
	    	scrollTop: target.offset().top
		},500);
	});
	
	$('div#buttons input.down').click(function() {
		if (currentFloor > 1) {
			currentFloor--;
			moveFloor(count-currentFloor);
		}
		
		var target = $('.elevator tbody').find('td.on');
		$('html').animate({
	    	scrollTop: target.offset().top
		},500);
	});
	
	$('div#buttons input.excute').click(function() {
		$.ajax({
			type: "GET",
			url: "/test",
			data: null
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
		target.append("<tr><td>" + i + "층</td></tr>");
	}
	currentFloor = 1;
	moveFloor(count-1)
}

function moveFloor(index) {
	var targets = $('.elevator tbody').find('td');
	targets.removeClass("on");
	targets.eq(index).addClass("on");
}

$(document).ready(function () {
	initFloor();
	eventHandler();
});