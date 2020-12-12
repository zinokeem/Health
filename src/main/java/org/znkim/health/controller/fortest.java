package org.znkim.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}