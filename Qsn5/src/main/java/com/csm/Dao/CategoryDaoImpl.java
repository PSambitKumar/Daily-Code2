package com.csm.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.Entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(Category category) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(category);
		
	}

	@Override
	public List<Category> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Category> query = currentSession.createQuery("from Category", Category.class);
		List<Category> list = query.getResultList();
		return list;
	}

	@Override
	public Category get(int catid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Category employeeObj = currentSession.get(Category.class, catid);
		return employeeObj;
	}

	@Override
	public void delete(int catid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Category employeeObj = currentSession.get(Category.class, catid);
		currentSession.delete(employeeObj);
		
	}



}
