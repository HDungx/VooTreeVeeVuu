package com.VooTreeVeeVuu.adapters.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/test")
public class test {
	@GetMapping ("/admin")
	public String view () {
		return "Hello admin world";
	}

	@GetMapping ("/cus")
	public String viewA () {
		return "Hello cus";
	}
}
