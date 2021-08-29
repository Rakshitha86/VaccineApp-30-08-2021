package com.xworkz.vaccine.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.VaccineForgotPasswordDTO;
import com.xworkz.vaccine.service.VaccineForgotPasswordService;
import com.xworkz.vaccine.service.VaccineForgotPasswordServiceImpl;
import com.xworkz.vaccine.service.VaccineOTPService;

@Controller
@RequestMapping("/")
public class VaccineForgotPasswordController {

	@Autowired
	private VaccineForgotPasswordService service;

	@Autowired
	private VaccineOTPService otpService;

	public VaccineForgotPasswordController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");

	}

	@RequestMapping("/forgotpassword.do")
	public String onReset() {
		System.out.println("Invoked onReset");
		return "ForgotPassword";

	}
	@PostMapping("/forgotpassword.do")
	public String onReset(@ModelAttribute VaccineForgotPasswordDTO dto, Model model) {
		System.out.println("Invoked onReset()");
		try {
			boolean result = this.otpService.checkMailInDB(dto.getMail());
			if (result) {
				boolean outcome = this.service.validateForgotPassword(dto);
				if (outcome) {
					boolean resetPassword = this.service.resetPassword(dto);
					if (resetPassword) {
						this.service.resetNoOfLoginAttempts(dto.getMail());
						System.out.println("Reset Successful can login");
						return "Login";
					} else {

						Map<String, String> map = VaccineForgotPasswordServiceImpl.map;

						model.addAttribute("ErrorInTheFieldMail", map.get("Name"));
						model.addAttribute("ErrorInTheFieldCreate", map.get("Create"));
						model.addAttribute("ErrorInTheFieldConfirm", map.get("Confirm"));

						System.out.println("Reset not Successful");
						return "ForgotPassword";
					}
				}
			}
		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return "ForgotPassword";

	}

}
