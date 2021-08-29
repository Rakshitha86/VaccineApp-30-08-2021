package com.xworkz.vaccine.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.VaccineAddMemberEntity;
@Repository
public class VaccineAddMemberDAOImpl implements VaccineAddMemberDAO {

	@Autowired
	private LocalSessionFactoryBean factory;

	public VaccineAddMemberDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@Override
	public boolean saveEntity(VaccineAddMemberEntity entity) {
		System.out.println("Invoked save()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getObject().openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			System.out.println("Member Data saved successfully");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("You have exception in {} " + e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

	@Override
	public List<VaccineAddMemberEntity> fetchAllData() {
		System.out.println("Invoked fetchAllData()");
		Session session = null;
		try {
			session = factory.getObject().openSession();
			List list = session.getNamedQuery("getAllData").list();
			System.out.println("Data fetched successfully");
			return list;
		} catch (Exception e) {
			System.out.println("You have exception in {} " + e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return null;
	}

}
