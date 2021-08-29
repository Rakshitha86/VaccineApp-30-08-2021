package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.VaccineForgotPasswordDTO;

public interface VaccineForgotPasswordService {
	
	boolean validateForgotPassword(VaccineForgotPasswordDTO dto);

	boolean resetPassword(VaccineForgotPasswordDTO dto);

	boolean resetNoOfLoginAttempts(String mail);
}
