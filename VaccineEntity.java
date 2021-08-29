package com.xworkz.vaccine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vaccine_table")
@NamedQueries({ @NamedQuery(name = "getbyemail", query = "select ve from VaccineEntity as ve where ve.email=:emailId"),
		@NamedQuery(name = "updatebyemailid", query = "update VaccineEntity as ve set ve.noOfLoginAttempts=:loginattempts where ve.email=:email"),
		@NamedQuery(name = "getByLoginAttempts", query = "select ve.noOfLoginAttempts from VaccineEntity as ve where ve.email=:emailId"),
		@NamedQuery(name = "updatepasswordbyemailid", query = "update VaccineEntity as ve set ve.password=:password where ve.email=:email"),
		@NamedQuery(name = "updateloginbyemailid", query = "update VaccineEntity as ve set ve.noOfLoginAttempts=:noofloginattempts where ve.email=:email") })

public class VaccineEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private long mobile;

	@Column(name = "DOB")
	private String dateofbirth;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "VACCINETYPE")
	private String vaccineType;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "LOGIN_ATTEMPTS")
	private int noOfLoginAttempts;

}
