package com.xworkz.vaccine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.VaccineAddMemberDTO;
import com.xworkz.vaccine.service.VaccineHomeService;
import com.xworkz.vaccine.service.VaccineHomeServiceImpl;

@Controller
@RequestMapping("/")
public class VaccineHomeController {

	@Autowired
	private VaccineHomeService service;

	public VaccineHomeController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping("/addmember.do")
	public String onAddMemberClicked() {
		System.out.println("Invoked onAddMember()");
		return "AddMemberDetails";
	}

	@RequestMapping("/addmemberdetails.do")
	public String onAddMember(@ModelAttribute VaccineAddMemberDTO dto, Model model) {
		System.out.println("Invoked onAddMember()" + dto);
		try {

			boolean result = this.service.validateAddmemberDTO(dto);
			if (result) {
				boolean outcome = this.service.saveAddmemberDTO(dto);
				if (outcome) {
					List<Object> addmemberDTO = this.service.getAddmemberDTO();
					if (addmemberDTO != null) {
						model.addAttribute("Listofmembermessage","Data fetched successfully");
						model.addAttribute("List",addmemberDTO);
						return "ListOfMembers";

					} else {
						Map<String, String> map = VaccineHomeServiceImpl.map;

						model.addAttribute("ErrorInTheFieldFullname", map.get("Fullname"));
						model.addAttribute("ErrorInTheFieldAadharno", map.get("Aadharno"));
						model.addAttribute("ErrorInTheFieldgender", map.get("gender"));
						model.addAttribute("ErrorInTheFieldtype", map.get("type"));
						return "AddMemberDetails";
					}
				}
			}

		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return null;

	}
}
