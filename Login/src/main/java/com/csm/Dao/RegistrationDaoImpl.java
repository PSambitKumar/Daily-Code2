package com.csm.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.Entity.Registration;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(Registration login) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(login);
	}

	@Override
	public List<Registration> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Registration> query = currentSession.createQuery("from Login", Registration.class);
		List<Registration> list = query.getResultList();
		return list;
	}

	@Override
	public Registration get(int slno) {
		Session currentSession = entityManager.unwrap(Session.class);
		Registration employeeObj = currentSession.get(Registration.class, slno);
		return employeeObj;
	}

	@Override
	public void delete(int slno) {
		Session currentSession = entityManager.unwrap(Session.class);
		Registration employeeObj = currentSession.get(Registration.class, slno);
		currentSession.delete(employeeObj);
		
	}

}
