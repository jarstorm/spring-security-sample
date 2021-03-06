package com.minds.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Example controller.
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

	@GetMapping("/sayHello")
	@ResponseBody
	public String sayHello(HttpServletRequest request) {
		return "Hello";
	}
}
