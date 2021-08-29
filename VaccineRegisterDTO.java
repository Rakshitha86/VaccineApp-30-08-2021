package com.xworkz.vaccine.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class VaccineRegisterDTO {

	private String name;
	private String email;
	private long mobile;
	private String dateofbirth;
	private String address;
	private String gender;
	private String vaccineType;
	private String createPassword;
	private String confirmPassword;
}
