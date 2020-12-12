/**
 * 
 */

let count = 7;
var currentFloor = 1;

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
}

function initFloor() {
	var target = $('.elevator tbody');
	target.children().remove();
	for (var i = count; i > 0; i--) {
		target.append("<tr><td>" + i + "층</td></tr>");
	}
	currentFloor = 1;
	moveFloor(7-1)
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