package com.elifnur.springexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("elif")
	String hello() {
		String a="Hello";
		return a;
	}
	
    @GetMapping("hello/{username}")
	String hello2(@PathVariable(name="username") String username) {
		return "Hello" + username;
	}
}
