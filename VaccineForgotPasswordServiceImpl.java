package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.VaccineDAO;
import com.xworkz.vaccine.dto.VaccineForgotPasswordDTO;
import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.utility.EncryptionDecryption;

@Service
public class VaccineForgotPasswordServiceImpl implements VaccineForgotPasswordService {

	@Autowired
	private VaccineDAO dao;

	@Autowired
	private EncryptionDecryption helper;

	public static Map<String, String> map = new HashMap<String, String>();

	public VaccineForgotPasswordServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");

	}

	@Override
	public boolean validateForgotPassword(VaccineForgotPasswordDTO dto) {
		boolean flag = false;
		try {
			if (dto != null) {
				System.out.println("dto is not null, can validate");

				String mail = dto.getMail();
				if (mail != null && !mail.isEmpty()) {
					System.out.println("mail is valid");
					flag = true;
				} else {
					System.out.println("mail is not valid");
					map.put("Mail", "Enter valid UserName");
				}
				if(flag) {
				String crepass = dto.getCreatePassword();
				if (crepass != null && !crepass.isEmpty()) {
					System.out.println("crepass is valid");
					flag = true;
				} else {
					System.out.println("crepass is not valid");
					map.put("Create", "Enter valid Password");
				}
				}
				if(flag) {
				String conpass = dto.getConfirmPassword();
				if (conpass != null && !conpass.isEmpty())
					System.out.println("conpass is valid");
				flag = true;
			} else {
				System.out.println("conpass is not valid");
				map.put("Confirm", "Enter valid Password");
			}
			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean resetPassword(VaccineForgotPasswordDTO dto) {
		System.out.println("inside {}");
		VaccineEntity entity = new VaccineEntity();
		try {
			entity.setPassword(helper.encrypt(dto.getCreatePassword()));
			boolean result = dao.updatePasswordBymail(entity);
			if (result) {
				System.out.println("Password Updated Successfully");
				return true;
			} else {
				System.out.println("Password not Updated");
				return false;
			}

		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean resetNoOfLoginAttempts(String mail) {
		System.out.println("inside {}");
		VaccineEntity entity = new VaccineEntity();
		try {
			boolean result = dao.updateLoginAttemptsBymail(entity);
			if (result) {
				System.out.println("Login Attempts Updated Successfully");
				return true;
			} else {
				System.out.println("Login Attempts not Updated");
				return false;
			}

		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}

		return false;
	}

}
