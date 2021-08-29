package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.VaccineDAO;
import com.xworkz.vaccine.dto.VaccineRegisterDTO;
import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.utility.EncryptionDecryption;
import com.xworkz.vaccine.utility.MailSender;

@Service
public class VaccineRegisterServiceImpl implements VaccineRegisterService {
	@Autowired
	private MailSender mailSender;

	@Autowired
	private VaccineDAO dao;

	@Autowired
	private EncryptionDecryption helper;


	public static Map<String, String> map = new HashMap<String, String>();

	public VaccineRegisterServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@Override
	public boolean validateVaccineRegisterDTO(VaccineRegisterDTO dto) {
		boolean flag = false;
		try {
			if (dto != null) {
				System.out.println("dto is not null, can validate");

				String name = dto.getName();
				if (name != null && !name.isEmpty()) {
					System.out.println("name is valid");
					flag = true;
				} else {
					System.out.println("name is not valid");
					map.put("Name", "Enter valid name");
//					flag = false;
				}
				if (flag) {
					String mail = dto.getEmail();
					if (mail != null && !mail.isEmpty()) {
						System.out.println("mailid is valid");
						flag = true;
					} else {
						System.out.println("mailid is not valid");
						map.put("Mail", "Enter valid mailid");
//						flag = false;
					}
				}

				if (flag) {
					long no = dto.getMobile();
					if (no != 0 && no > 1) {
						System.out.println("no is valid");
						flag = true;
					} else {
						System.out.println("no is not valid");
						map.put("Phone", "Enter valid phone no");
//						flag = false;
					}
				}
				if (flag) {
					String dob = dto.getDateofbirth();
					if (dob != null && !dob.isEmpty()) {
						System.out.println("dob is valid");
						flag = true;
					} else {
						System.out.println("dob is not valid");
						map.put("DOB", "Enter valid dob");
//						flag = false;
					}
				}
				if (flag) {
					String address = dto.getAddress();
					if (address != null && !address.isEmpty()) {
						System.out.println("address is valid");
						flag = true;
					} else {
						System.out.println("address is not valid");
						map.put("Address", "Enter valid address");
//						flag = false;
					}
				}
				if (flag) {
					String gender = dto.getGender();
					if (gender != null && !gender.isEmpty()) {
						System.out.println("gender is valid");
						flag = true;
					} else {
						System.out.println("gender is not valid");
						map.put("Gender", "Enter valid gender");
//						flag = false;
					}
				}
				if (flag) {
					String type = dto.getVaccineType();
					if (type != null && !type.isEmpty()) {
						System.out.println("type is valid");
						flag = true;
					} else {
						System.out.println("type is not valid");
						map.put("Type", "Enter valid type");
//						flag = false;
					}
				}
				if (flag) {
					String crepass = dto.getCreatePassword();
					if (crepass != null && !crepass.isEmpty()) {
						System.out.println("Password is valid");
						flag = true;
					} else {
						System.out.println("password is not valid");
						map.put("Create", "Enter valid password");
//						flag = false;
					}
				}
				if (flag) {
					String conpass = dto.getConfirmPassword();
					if (conpass != null && !conpass.isEmpty()) {
						System.out.println("Entered password is valid");
						flag = true;
					} else {
						System.out.println("Entered password is not valid");
						map.put("Confirm", "password is invalid");
//						flag = false;
					}
				}
//				if (flag) {
//					String crepass = dto.getCreatePassword();
//					String conpass = dto.getConfirmPassword();
//					if (crepass.equals(conpass)) {
//						System.out.println("Entered password is valid");
//						flag = true;
//					} else {
//						System.out.println("Entered password is not valid");
//						flag = false;
//					}
//				}

			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return flag;
	}

	public String saveVaccineRegisterDTO(VaccineRegisterDTO dto) {
		System.out.println("Invoked saveVaccineRegisterDTO()");
		VaccineEntity entity = new VaccineEntity();
		entity.setNoOfLoginAttempts(0);
		try {
			BeanUtils.copyProperties(dto, entity);
			entity.setPassword(helper.encrypt(dto.getCreatePassword()));
			boolean result = dao.saveEntity(entity);
			if (result) {
				System.out.println("successful" + dto);
				mailSender.sendMail(entity.getEmail(), "Successfully Registered",
						"Registration Successfull for the Vaccination");
			} else {
				System.out.println("Registration not successful");

			}

		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}

		return "";
	}

}
