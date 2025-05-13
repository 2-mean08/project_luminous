package com.luminous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@GetMapping("/register")
	public String itemRegisterFrom() {
		return "/item/register";
	}

}
