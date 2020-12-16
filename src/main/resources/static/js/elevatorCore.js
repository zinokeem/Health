/**
 * 
 */
function Elevator() {
	this.currentFloor; // 현재 층수
	this.count; // 층의 길이
	this.floorList; // 층 객체 리스트
	this.minFloor; // 최소 층
	this.maxFloor; // 최대 층
	this.status; // -1, 0, 1 내려감 중립 올라감 상태 표시
	this.init();
}

Elevator.prototype.init = function () {
	this.currentFloor = 1; // 현재 층수
	this.length = 5; // 층의 길이
	this.floorList = null; // 층 객체 리스트
	this.minFloor = 0; // 최소 층
	this.maxFloor = 0; // 최대 층
	this.status = 0; // -1, 0, 1 내려감 중립 올라감 상태 표시
	this.initFloor();
}

Elevator.prototype.reqData = function () {
	$.ajax({
		type: "GET",
		url: "/init",
		data: null
	}).done(function(data) {
		console.log("데이터 받기 성공");
		setData(data);
	}).fail(function(data) {
		console.log("데이터 받기 실패");
	});
}

Elevator.prototype.setData = function (data) {
	console.log(data);
}

Elevator.prototype.setEventHandler = function () {
	var thisObj = this;
	$('div#buttons input.up').click(function() {
		if (thisObj.currentFloor < thisObj.count) {
			thisObj.currentFloor++;
			thisObj.moveFloor(thisObj.count-thisObj.currentFloor);
		}
	});
	
	$('div#buttons input.down').click(function() {
		if (thisObj.currentFloor > 1) {
			thisObj.currentFloor--;
			thisObj.moveFloor(thisObj.count-thisObj.currentFloor);
		}
	});
	
	$('div#buttons input.start').click(function() {
		
	});
	
	$('div#buttons input.stop').click(function() {
	
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
		thisObj.count = value;
		thisObj.initFloor();
		thisObj.moveFloor(thisObj.count-1);
	});
}
Elevator.prototype.forTest = function() {
	var target = $('div#buttons input.floor');
	var value = target.val();
	this.count = value;
	this.initFloor();
	this.moveFloor(this.count-1);
}

Elevator.prototype.initFloor = function() {
	var target = $('.elevator tbody');
	target.children().remove();
	for (var i = this.count; i > 0; i--) {
		target.append("<tr><td>" + i + "층</td><td>대기 인원</td></tr>");
	}
	this.currentFloor = 1;
	this.setFloorPosition(this.count-1)
}

Elevator.prototype.setFloorPosition = function(index) {
	var targets = $('.elevator tbody').find('tr');
	targets.removeClass("on");
	targets.eq(index).first().addClass("on");
}

Elevator.prototype.moveFloor = function(index) {
	this.setFloorPosition(index);
	var target = $('.elevator tbody').find('tr.on');
	
	console.log($('div#elevator').offset().top + "," + target.offset().top);
	console.log("차이 " + ($('div#elevator').offset().top-target.offset().top));
	
	$('div#elevator').animate({
		top: target.offset().top
	},500);
	
	/*$('html').stop().animate({
    	scrollTop: target.offset().top - ($(window).height() / 2)
	},500);*/
}