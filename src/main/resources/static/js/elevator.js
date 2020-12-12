/**
 * 
 */

let count = 15;

function setFloor() {
	console.log("target");
	var target = $('.elevator tbody');
	target.children().remove();
	for (var i = count; i > 0; i--) {
		target.append("<tr><td>" + i + "층</td></tr>");
	}
}

$(document).ready(function () {
	setFloor();
});