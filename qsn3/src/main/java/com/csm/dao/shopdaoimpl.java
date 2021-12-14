package com.csm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csm.entity.shop;

@Repository
public class shopdaoimpl implements shopdao {

	@Autowired
	EntityManager entityManager;
	@Override
	public void save(shop shop) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(shop);
		
	}

	@Override
	public List<shop> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<shop> query = currentSession.createQuery("from shop", shop.class);
		List<shop> list = query.getResultList();
		return list;
	}

	@Override
	public shop get(int shopid) {
		Session currentSession = entityManager.unwrap(Session.class);
		shop shop1 = currentSession.get(shop.class, shopid);
		return shop1;
	}

	@Override
	public void delete(int shopid) {
		Session currentSession = entityManager.unwrap(Session.class);
		shop shop1 = currentSession.get(shop.class, shopid);
			currentSession.delete(shop1);
		
	}

}
