package com.xworkz.vaccine.service;

import java.util.List;

import com.xworkz.vaccine.dto.VaccineAddMemberDTO;

public interface VaccineHomeService {
	
	public boolean validateAddmemberDTO(VaccineAddMemberDTO dto);

	public boolean saveAddmemberDTO(VaccineAddMemberDTO dto);

	public List<Object> getAddmemberDTO();
}
