package com.richmejia.futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/redirect.do")
	public String searchHandler() {
		String redirectUrl = "login.jsp";

		return new String("redirect:" + redirectUrl);
	}
}
