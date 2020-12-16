package org.znkim.health.controller;

import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.znkim.health.biz.ElevatorLogic;
import org.znkim.health.model.ElevatorModel;

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
	
	@RequestMapping(value = "/init" , method = RequestMethod.GET)
	@ResponseBody
	public ElevatorModel getServerData() {
		ElevatorLogic el = new ElevatorLogic();
		return el.getServerData();
	}
	
	@RequestMapping(value = "/test" , method = RequestMethod.POST)
	@ResponseBody
	public ElevatorModel excute(/*@RequestParam String param*/) {
		ElevatorLogic el = new ElevatorLogic();
		el.excute();
		return el.getServerData();
	}
}