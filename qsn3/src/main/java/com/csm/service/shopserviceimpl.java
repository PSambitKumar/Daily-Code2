package com.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.dao.shopdao;
import com.csm.entity.shop;

@Service
public class shopserviceimpl implements shopservice {

	@Autowired
	shopdao shopdao1;
	
	@Transactional
	@Override
	public void save(shop shop1) {
		shopdao1.save(shop1);

	}

	@Transactional
	@Override
	public List<shop> get() {
		return shopdao1.get();
	}
	
	@Transactional
	@Override
	public shop get(int shopid) {
		return shopdao1.get(shopid);
	}

	@Transactional
	@Override
	public void delete(int shopid) {
		shopdao1.delete(shopid);

	}

}
