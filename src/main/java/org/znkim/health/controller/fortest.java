package org.znkim.health.controller;

import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.znkim.health.biz.ElevatorLogic;

import lombok.extern.log4j.Log4j2;

@Controller
public class fortest {	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/elevator")
	public String elevator() {
		return "elevator";
	}
	
	@GetMapping("/test")
	public String test(@RequestParam String data) {
		ElevatorLogic el = new ElevatorLogic();
		el.excute();
		return "data is " + data;
	}
}