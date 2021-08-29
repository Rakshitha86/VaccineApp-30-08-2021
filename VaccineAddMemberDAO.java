package com.xworkz.vaccine.dao;

import java.util.List;

import com.xworkz.vaccine.entity.VaccineAddMemberEntity;

public interface VaccineAddMemberDAO {
	
	public boolean saveEntity(VaccineAddMemberEntity entity);

	public List<VaccineAddMemberEntity> fetchAllData();
}
