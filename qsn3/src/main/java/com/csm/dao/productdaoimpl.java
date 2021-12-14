package com.csm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.entity.product;
import com.csm.entity.shop;

@Repository
public class productdaoimpl implements productdao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public void save(product product1) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product1);

	}

	@Override
	public List<product> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<product> query = currentSession.createQuery("from product", product.class);
		List<product> list = query.getResultList();
		return list;
	}

	@Override
	public product get(int productid) {
		Session currentSession = entityManager.unwrap(Session.class);
		product product1 = currentSession.get(product.class, productid);
		return product1;
	}

	@Override
	public void delete(int productid) {
		Session currentSession = entityManager.unwrap(Session.class);
		product product1 = currentSession.get(product.class, productid);
			currentSession.delete(product1);

	}

}
