package com.salespoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping({"/",""})
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/productos")
	public String goProductos() {
		return "productos";
	}
	
}
