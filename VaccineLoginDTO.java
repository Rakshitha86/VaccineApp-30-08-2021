package com.xworkz.vaccine.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class VaccineLoginDTO {

	private String username;
	private String password;

}
