package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

	@RequestMapping(value = "/hello")
	public String index() {

		//hello.htmlを呼び出す
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str,Model model) {
		model.addAttribute("sample", str);

		//response.htmlに画面遷移
		return "hello/response";
	}
}
