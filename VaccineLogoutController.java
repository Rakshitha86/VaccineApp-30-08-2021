package com.xworkz.vaccine.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VaccineLogoutController {

	public VaccineLogoutController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		req.getSession(false).invalidate();
		return "Login";

	}
}
