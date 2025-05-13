package com.luminous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/item")
    public String itemPage() {
        return "item"; // item.html 호출
    }

    @GetMapping("/")
    public String indexPage() {
        return "index"; // index.html 호출
    }
	

}
