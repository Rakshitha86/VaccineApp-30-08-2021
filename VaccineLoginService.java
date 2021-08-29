package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.VaccineLoginDTO;

public interface VaccineLoginService {

	public boolean validate(VaccineLoginDTO dto);

	public String Login(VaccineLoginDTO dto);

	public String checkLoginAttempts(String mail);

}
