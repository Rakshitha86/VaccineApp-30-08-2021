package com.xworkz.vaccine.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.VaccineEntity;

@Repository
public class VaccineDAOImpl implements VaccineDAO {

	@Autowired
	private LocalSessionFactoryBean factory;

	public VaccineDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	public boolean saveEntity(VaccineEntity entity) {
		System.out.println("Invoked save()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getObject().openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			System.out.println("Data saved successfully");
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
	public VaccineEntity getByEmailId(String email) {
		System.out.println("invoked getByEmailId()");
		Session session = null;
		VaccineEntity entity = null;
		try {
			session = factory.getObject().openSession();
			Query query = session.getNamedQuery("getbyemail");
			query.setParameter("emailId", email);
			entity = (VaccineEntity) query.uniqueResult();
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
		return entity;
	}

	@Override
	public Integer getNoOfLoginAttempts(String email) {
		System.out.println("invoked getNoOfLoginAttempts()");
		Session session = null;
		try {
			session = factory.getObject().openSession();
			Query query = session.getNamedQuery("getByLoginAttempts");
			query.setParameter("emailId", email);
			Object result = query.uniqueResult();
			if (result != null) {
				Integer loginAttempts = (Integer) result;
				return loginAttempts;
			}
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

	@Override
	public String updateNoOfLoginAttemptsBymail(VaccineEntity entity) {

		System.out.println("invoked updateNoOfLoginAttempts()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getObject().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updatebyemailid");
			query.setParameter("email", entity.getEmail());
			query.setParameter("loginattempts", entity.getNoOfLoginAttempts());
			transaction.commit();
			query.executeUpdate();
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
		return "";
	}

	@Override
	public boolean updatePasswordBymail(VaccineEntity entity) {
		System.out.println("invoked updatePasswordBymail()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getObject().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updatepasswordbyemailid");
			query.setParameter("email", entity.getEmail());
			query.setParameter("password", entity.getPassword());
			transaction.commit();
			query.executeUpdate();
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
	public boolean updateLoginAttemptsBymail(VaccineEntity entity) {
		System.out.println("invoked updateLoginAttemptsBymail()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getObject().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateloginbyemailid");
			query.setParameter("email", entity.getEmail());
			query.setParameter("noofloginattempts", entity.getNoOfLoginAttempts());
			transaction.commit();
			query.executeUpdate();
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
}
