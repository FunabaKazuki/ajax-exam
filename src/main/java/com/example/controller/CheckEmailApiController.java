package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/checkemail")
public class CheckEmailApiController {

	@RequestMapping("")
	public String index() {
		return "input_email";
	}

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public Map<String, String> check(String email) {
		Map<String, String> map = new HashMap<>();
		String duplicateMessage = null;

		if ("iga@sample.com".equals(email)) {
			duplicateMessage = "「" + email + "」は既に登録されているメールアドレスです";
		} else {
			duplicateMessage = "「" + email + "」は登録されていません";
		}
		map.put("duplicateMessage", duplicateMessage);
		return map;
	}
}
