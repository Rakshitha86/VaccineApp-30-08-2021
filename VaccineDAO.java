package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.VaccineEntity;

public interface VaccineDAO {

	public boolean saveEntity(VaccineEntity entity);

	public VaccineEntity getByEmailId(String email);

	public Integer getNoOfLoginAttempts(String email);
	
	public String updateNoOfLoginAttemptsBymail(VaccineEntity entity);
	
	public boolean updatePasswordBymail(VaccineEntity entity);
	
	public boolean updateLoginAttemptsBymail(VaccineEntity entity);
	
}
