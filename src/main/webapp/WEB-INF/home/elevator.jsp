<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elevator</title>
<link rel="stylesheet" href="/css/reset.css"/>
<link rel="stylesheet" href="/css/elevator.css"/>
<script type="text/javascript" src="/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="/js/elevatorCore.js"></script>
<script type="text/javascript" src="/js/elevator.js"></script>
</head>
<body>
	<div id="buttons">
		<input class="up" type="button" value="UP"/>
		<input class="down" type="button" value="DOWN"/>
		<input class="start" type="button" value="START"/>
		<input class="stop" type="button" value="STOP"/>
		<input class="excute" type="button" value="excute"/>
		<input class="floor" type="text" value ="5"/>
	</div>
	<div id="wrap">
		<div id="elevator"></div>
		<table class="elevator">
			<!--<thead>
				<tr>
					<th></th>
				</tr>
			</thead>-->
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>