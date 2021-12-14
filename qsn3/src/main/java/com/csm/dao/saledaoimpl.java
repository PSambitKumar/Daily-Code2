package com.csm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.entity.sale;

@Repository
public class saledaoimpl implements saledao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(sale sale1) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(sale1);

	}

	@Override
	public List<sale> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<sale> query = currentSession.createQuery("from sale", sale.class);
		List<sale> list = query.getResultList();
		return list;
	}

	
}
