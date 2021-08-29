package com.xworkz.vaccine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "addmember_table")
@NamedQuery(name = "getAllData", query = "from VaccineAddMemberEntity ve")
public class VaccineAddMemberEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBERID")
	private int memberID;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AADHARNO")
	private long aadharNo;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "VACCINETYPE")
	private String vaccineType;
}
