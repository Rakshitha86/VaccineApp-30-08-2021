package com.xworkz.vaccine.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.VaccineOTPService;
import com.xworkz.vaccine.service.VaccineOTPServiceImpl;
import com.xworkz.vaccine.service.VaccineRegisterServiceImpl;
import com.xworkz.vaccine.utility.EmailValidater;
import com.xworkz.vaccine.utility.RandomOTPGenerator;

@Controller
@RequestMapping("/")
public class VaccineOTPController {

	@Autowired
	private VaccineOTPService service;

	public static Integer generateOTP;

	public VaccineOTPController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping("/sendotp.do")
	public String ongetOTP() {
		System.out.println("Invoked ongetOTP()");
		return "GenerateOTP";

	}

	@GetMapping("/sendotp.do")
	public String getOTP(@RequestParam String email, Model model) {
		System.out.println("Invoked getOTP()");

		try {
			boolean result = service.validateEmail(email);
			if (result) {
				System.out.println("validation of email is successful");
				boolean validEmailAddress = EmailValidater.isValidEmailAddress(email);
				if (validEmailAddress) {
					boolean db = this.service.checkMailInDB(email);
					if (db) {
						System.out.println("Already exists" + db);
						model.addAttribute("Userexistmessage", "User already exists");
						return "GenerateOTP";
					} else {
						boolean outcome = this.service.sendOTP(email, generateOTP);
						if (outcome) {
							model.addAttribute("OTPsentmesssage", "OTP sent successfully enter your otp here");
							System.out.println("OTP generation successfull");
							return "VerifyOTP";
						} else {
							model.addAttribute("OTPsentmesssage", "OTP generation failed enter valid emailid");
							System.out.println("OTP generation not successfull");
							return "GenerateOTP";
						}
					}
					
				}else
				{
					Map<String, String> map = VaccineOTPServiceImpl.map;

					model.addAttribute("ErrorInTheFieldMail", map.get("MailId"));
				}
			}
		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return "GenerateOTP";
	}

	@GetMapping("/verifyotp.do")
	public String verifyOTP(@RequestParam Integer otp, Model model) {
		System.out.println("Invoked verifyOTP()");
		try {
			boolean result = service.validateOTP(otp);
			if (result) {
				boolean outcome = this.service.verifyOTP(otp);
				if (outcome) {
					System.out.println("OTP Verified successfully");
					model.addAttribute("OTPverification", "OTP verification successful register here");
					return "Register";
				} else {
					System.out.println("Invalid OTP");
					model.addAttribute("OTPverification", "OTP is Invalid,Enter valid OTP");
					return "VerifyOTP";
				}
			}
		} catch (

		Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return "VerifyOTP";
	}

}
