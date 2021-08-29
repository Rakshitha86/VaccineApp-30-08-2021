package com.xworkz.vaccine.service;

import java.util.Map;

public interface VaccineOTPService {
	
	public boolean validateEmail(String email);

	public boolean validateOTP(Integer otp);

	public boolean verifyOTP(Integer otp);

	public boolean sendOTP(String mail, Integer generateOTP);

	public boolean checkMailInDB(String mail);
}
