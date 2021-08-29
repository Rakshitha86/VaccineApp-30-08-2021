
package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.VaccineDAO;
import com.xworkz.vaccine.dto.VaccineLoginDTO;
import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.utility.EncryptionDecryption;
import com.xworkz.vaccine.utility.MailSender;

@Service
public class VaccineLoginServiceImpl implements VaccineLoginService {

	@Autowired
	private VaccineDAO dao;

	@Autowired
	private EncryptionDecryption helper;


	public static Map<String, String> map = new HashMap<String, String>();

	public VaccineLoginServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@Override
	public boolean validate(VaccineLoginDTO dto) {
		boolean flag = false;
		try {
			if (dto != null) {
				System.out.println("dto is not null, can validate");

				String username = dto.getUsername();
				if (username != null && !username.isEmpty()) {
					System.out.println("username is valid");
					flag = true;
				} else {
					System.out.println("username is not valid");
					map.put("UserName", "Enter valid UserName");
				}
				if(flag) {
				String password = dto.getPassword();
				if (password != null && !password.isEmpty())
					System.out.println("password is valid");
				flag = true;
			} else {
				System.out.println("password is not valid");
				map.put("Password", "Enter valid Password");
			}
			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}

		return flag;

	}

	@Override
	public String Login(VaccineLoginDTO dto) {
		System.out.println("inside {}");
		try {

			VaccineEntity entity = dao.getByEmailId(dto.getUsername());

			if (Objects.nonNull(entity)) {
				String dbemail = entity.getEmail();
				String dbpassword = helper.decrypt(entity.getPassword());
				if (dto.getUsername().equals(dbemail) && dto.getPassword().equals(dbpassword)) {
					System.out.println("Username and Password is matching");
					return "LoginSuccess";
				} else {
					System.out.println("Username and Password is not matching");
					return "Login";
				}

			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return "Login";
	}

	@Override
	public String checkLoginAttempts(String mail) {
		VaccineEntity entity = dao.getByEmailId(mail);
		try {
			int loginAttempts = dao.getNoOfLoginAttempts(mail);
			if (loginAttempts <= 3) {
				System.out.println("Login Successfull");
				return "LoginSuccess";
			} else {
				loginAttempts++;
				dao.updateNoOfLoginAttemptsBymail(entity);
				System.out.println("Account has been blocked due to many login attempts ");
				return "Login";
			}

		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return "Login";
	}

}
