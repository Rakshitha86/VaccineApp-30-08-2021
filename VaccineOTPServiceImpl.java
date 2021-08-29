package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.controller.VaccineOTPController;
import com.xworkz.vaccine.dao.VaccineDAO;
import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.utility.MailSender;
import com.xworkz.vaccine.utility.RandomOTPGenerator;

@Service
public class VaccineOTPServiceImpl implements VaccineOTPService {

	@Autowired
	private VaccineDAO dao;
	@Autowired
	private MailSender mailSender;

	private static Integer generateOTP;

	public static Map<String, String> map = new HashMap<String, String>();

	public VaccineOTPServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@Override
	public boolean validateEmail(String email) {
		System.out.println("Invoked validateEmail()");
		boolean flag = false;
		if (!email.isEmpty() && email != null) {
			System.out.println("valid emailid");
			flag = true;
		} else {
			System.out.println("invalid emailid");
			map.put("email", "Error in the field email");
		}
		return flag;
	}

	@Override
	public boolean validateOTP(Integer otp) {
		System.out.println("Invoked validateOTP()");
		boolean flag = false;
		if (otp != 0 && otp != null) {
			flag = true;
		} else {
			System.out.println("invalid otp");
			map.put("otp", "Error in the field otp");
		}
		return flag;
	}

	@Override
	public boolean verifyOTP(Integer otp) {
		System.out.println("Invoked verifyOTP()");
		boolean flag = false;
		if (VaccineOTPController.generateOTP.equals(otp)) {
			flag = true;

		} else {
			System.out.println("otp mismatch");
			map.put("otp", "enter valid otp");

		}
		return flag;
	}

	@Override
	public boolean sendOTP(String mail, Integer otp) {
		System.out.println("Invoked sendOTP()");
		try {
			if (!mail.isEmpty() && mail != null) {
				generateOTP = RandomOTPGenerator.generateOTP(4);
				System.out.println("OTP sent");
				mailSender.sendMail(mail, "OTP Generation", "OTP Sent Successfully " + otp);
				return true;
			} else {
				System.out.println("Unable to send OTP");
				return false;
			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return false;

	}

	@Override
	public boolean checkMailInDB(String mail) {
		System.out.println("Invoked checkMailInDB()");
		try {
			VaccineEntity entity = this.dao.getByEmailId(mail);
			if (Objects.nonNull(entity)) {
				if (entity.getEmail().equals(mail)) {
					System.out.println("username Already exist");
					return true;
				} else {
					System.out.println("Get otp by entering emailid");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("You have an exception in " + e.getMessage());
		}
		return false;

	}

}
