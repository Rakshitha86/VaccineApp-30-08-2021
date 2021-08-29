package com.xworkz.vaccine.controller;


import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.VaccineLoginDTO;
import com.xworkz.vaccine.service.VaccineLoginService;
import com.xworkz.vaccine.service.VaccineLoginServiceImpl;
import com.xworkz.vaccine.service.VaccineOTPService;
import com.xworkz.vaccine.service.VaccineRegisterServiceImpl;

@Controller
@RequestMapping("/")
public class VaccineLoginController {

	@Autowired
	private VaccineLoginService service;

	@Autowired
	private VaccineOTPService otpService;


	public VaccineLoginController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping("/login.do")
	public String onloginClick() {
		System.out.println("Invoked onloginClick");
		return "Login";

	}

	@PostMapping("/login.do")
	public String onLogin(@ModelAttribute VaccineLoginDTO dto, Model model) {
		System.out.println("Invoked onLogin");
		try {
			boolean validate = this.service.validate(dto);
			if (validate) {
				boolean outcome = this.otpService.checkMailInDB(dto.getUsername());
				if (outcome) {
					String loginAttempts = service.checkLoginAttempts(dto.getUsername());
					if (loginAttempts != null) {
						String result = this.service.Login(dto);
						if (result != null) {
							System.out.println("Login successful");
							model.addAttribute("Loginmessage", "Login Successful");
							model.addAttribute("Username",dto.getUsername());
							return "Home";

						} else {
							Map<String, String> map = VaccineLoginServiceImpl.map;

							model.addAttribute("ErrorInTheFieldUserName", map.get("UserName"));
							model.addAttribute("ErrorInTheFieldPassword", map.get("Password"));
							
							System.out.println("Login not successful");
							model.addAttribute("Loginmessage", "User is blocked");
							return "Login";
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return null;

	}
}
