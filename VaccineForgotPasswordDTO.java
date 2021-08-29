package com.xworkz.vaccine.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class VaccineForgotPasswordDTO {

	private String mail;

	private String createPassword;

	private String confirmPassword;

}
