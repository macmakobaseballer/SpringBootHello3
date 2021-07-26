package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

	@Autowired
	private  HelloService service;
	
	@RequestMapping(value = "/hello")
	public String getHello() {

		//hello.htmlを呼び出す
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str,Model model) {
		
		//画面から受け取った文字列をModelに登録
		model.addAttribute("sample", str);
		
		//response.htmlに画面遷移
		return "hello/response";
	}

	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String id,Model model) {
		
		//1件検索
		Employee employee = service.getEmployee(id);
		
		model.addAttribute("employee", employee);
		

		//response.htmlに画面遷移
		return "hello/db";
	}
}
