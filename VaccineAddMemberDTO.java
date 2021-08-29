package com.xworkz.vaccine.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class VaccineAddMemberDTO {
	private String name;
	private long aadharNo;
	private String gender;
	private String vaccineType;
}
