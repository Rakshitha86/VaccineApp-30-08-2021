package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.VaccineRegisterDTO;

public interface VaccineRegisterService {

	public boolean validateVaccineRegisterDTO(VaccineRegisterDTO dto);
	
	public String saveVaccineRegisterDTO(VaccineRegisterDTO dto);

}
