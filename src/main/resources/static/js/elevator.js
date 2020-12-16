/**
 * 
 */

var elevator = new Elevator(); // 엘리베이터 객체

/* 새로고침 */
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

function shortcut() {
	$('html').keyup(function(e) {
		if (event.keyCode == 38) {
			$('div#buttons input.up').trigger( "click" );
		} else if (event.keyCode == 40) {
			$('div#buttons input.down').trigger( "click" );
		}
		console.log(event.keyCode);
	});
}


$(document).ready(function () {
	elevator.init();
	elevator.setEventHandler();
	elevator.forTest();
	shortcut();
	//elevator.setInterval(refresh, 1000);
});