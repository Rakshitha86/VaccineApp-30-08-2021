package com.xworkz.vaccine.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.VaccineRegisterDTO;
import com.xworkz.vaccine.service.VaccineRegisterService;
import com.xworkz.vaccine.service.VaccineRegisterServiceImpl;

@Controller
@RequestMapping("/")
public class VaccineRegisterController {

	@Autowired
	private VaccineRegisterService service;

	public VaccineRegisterController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping("/register.do")
	public String onClickRegister() {
		System.out.println("Invoked onRegister");
		return "Register";

	}

	@PostMapping("/register.do")
	public String onRegister(@ModelAttribute VaccineRegisterDTO dto, Model model) {
		System.out.println("Invoked onRegister" + dto);
		try {

			boolean result = this.service.validateVaccineRegisterDTO(dto);
			if (result) {
				System.out.println("Saving data into database");
				String outcome = this.service.saveVaccineRegisterDTO(dto);
				if(outcome != null) {
				model.addAttribute("Registermessage", "Successfully Registered login to proceed");
				System.out.println("Data is saved in database");
				return "Login";
			} else {
				Map<String, String> map = VaccineRegisterServiceImpl.map;

				model.addAttribute("ErrorInTheFieldName", map.get("Name"));
				model.addAttribute("ErrorInTheFieldMail", map.get("Mail"));
				model.addAttribute("ErrorInTheFieldNo", map.get("Phone"));
				model.addAttribute("ErrorInTheFieldDOB", map.get("DOB"));
				model.addAttribute("ErrorInTheFieldAddress", map.get("Address"));
				model.addAttribute("ErrorInTheFieldGender", map.get("Gender"));
				model.addAttribute("ErrorInTheFieldType", map.get("Type"));
				model.addAttribute("ErrorInTheFieldCreatePassword", map.get("Create"));
				model.addAttribute("ErrorInTheFieldConfirmPassword", map.get("Confirm"));

				System.out.println("Data is not saved in database");
				model.addAttribute("Registermessage", "Registration is not successfull");
				return "Register";
			}
			}

//			String result = service.saveVaccineRegisterDTO(dto);
//			if (result != null) {
//				model.addAttribute("Registermessage", "Successfully Registered login to proceed");
//				return "Login";
//			} else {
//				model.addAttribute("Registermessage", "Registration is not successfull");
//				return "Register";
//			}
		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return null;

	}

}
