package com.xworkz.vaccine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.VaccineAddMemberDAO;
import com.xworkz.vaccine.dto.VaccineAddMemberDTO;
import com.xworkz.vaccine.entity.VaccineAddMemberEntity;

@Service
public class VaccineHomeServiceImpl implements VaccineHomeService {

	@Autowired
	private VaccineAddMemberDAO dao;

	public static Map<String, String> map = new HashMap<String, String>();

	public VaccineHomeServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@Override
	public boolean validateAddmemberDTO(VaccineAddMemberDTO dto) {
		boolean flag = false;
		try {
			if (dto != null) {
				System.out.println("memberdto is not null, can validate");

				String name = dto.getName();
				if (name != null && !name.isEmpty()) {
					System.out.println("name is valid");
					flag = true;
				} else {
					System.out.println("name is not valid");
					map.put("Fullname", "Enter valid name");
				}

				if (flag) {
					long aadharno = dto.getAadharNo();
					if (aadharno != 0 && aadharno > 1) {
						System.out.println("aadharno is valid");
						flag = true;
					} else {
						System.out.println("aadharno is not valid");
						map.put("Aadharno", "Enter valid aadharno");
					}
				}

				if (flag) {
					String gender = dto.getGender();
					if (gender != null && !gender.isEmpty()) {
						System.out.println("gender is valid");
						flag = true;
					} else {
						System.out.println("gender is not valid");
						map.put("gender", "Enter valid gender");
					}
				}
				if (flag) {
					String type = dto.getVaccineType();
					if (type != null && !type.isEmpty()) {
						System.out.println("type is valid");
						flag = true;
					} else {
						System.out.println("type is not valid");
						map.put("type", "Enter valid type");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return flag;

	}

	@Override
	public boolean saveAddmemberDTO(VaccineAddMemberDTO dto) {
		System.out.println("Invoked saveAddmemberDTO()");
		VaccineAddMemberEntity entity = new VaccineAddMemberEntity();
		try {
			BeanUtils.copyProperties(dto, entity);
			boolean result = dao.saveEntity(entity);
			if (result) {
				System.out.println("Members added successfully");
			} else {
				System.out.println("Members not added successfully");

			}

		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		}
		return false;
	}

	@Override
	public List<Object> getAddmemberDTO() {
		List<VaccineAddMemberEntity> fetchAllData = this.dao.fetchAllData();
		if (fetchAllData != null) {
			System.out.println("Fetched data successfully");
		} else {
			System.out.println(" unable to Fetch data");

		}

		return null;
	}

}
