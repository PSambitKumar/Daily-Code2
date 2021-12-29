package com.csm.Dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.Entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);
		
	}

}
