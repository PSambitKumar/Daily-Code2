package com.example.springcrud.springmvccrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springcrud.springmvccrud.model.BranchMaster;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<BranchMaster> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<BranchMaster> query = currentSession.createQuery("from Employee", BranchMaster.class);
		List<BranchMaster> list = query.getResultList();
		return list;
	}

	@Override
	public BranchMaster get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		BranchMaster employeeObj = currentSession.get(BranchMaster.class, id);
		return employeeObj;
	}

	@Override
	public void save(BranchMaster employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		BranchMaster employeeObj = currentSession.get(BranchMaster.class, id);
		currentSession.delete(employeeObj);
	}

}