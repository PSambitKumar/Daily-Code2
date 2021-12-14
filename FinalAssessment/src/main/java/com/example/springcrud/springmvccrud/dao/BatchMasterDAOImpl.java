package com.example.springcrud.springmvccrud.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springcrud.springmvccrud.model.BatchMaster;

@Repository
public class BatchMasterDAOImpl implements BatchMasterDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(BatchMaster batch) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(batch);
	}

}