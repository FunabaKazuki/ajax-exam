package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/passcheck")
public class CheckPassApiController {
	
	@RequestMapping("")
	public String index() {
		return "input_pass";
	}
	
	@ResponseBody
	@RequestMapping(value = "/check" , method = RequestMethod.POST)
	public Map<String, String> check(String pass,String pass2){
		System.out.println(pass);
		System.out.println(pass2);
		Map<String, String> map = new HashMap<>();
		String duplicateMessage = null;
		String duplicateMessage2 = null;
		if(pass.length()<=7) {
			duplicateMessage ="パスワードは8文字以上にしてください";
		}else {
			duplicateMessage ="パスワード入力OK";
		}
		if(pass.equals(pass2)) {
			duplicateMessage2 ="確認用パスワード入力OK";
		}else {
			duplicateMessage2 ="パスワード不一致";
		}
		
		map.put("duplicateMessage", duplicateMessage);
		map.put("duplicateMessage2", duplicateMessage2);
		
		return map;
		
		
	}

}
