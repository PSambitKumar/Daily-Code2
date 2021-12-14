package com.csm.service;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.dao.productdao;
import com.csm.entity.product;

@Service
public class productserviceimpl implements productservice {
	
	@Autowired
	productdao productdao1;

	@Transactional
	@Override
	public void save(product product1) {
		productdao1.save(product1);

	}

	@Transactional
	@Override
	public List<product> get() {
		return productdao1.get();
		}

	@Transactional
	@Override
	public product get(int productid) {
		return productdao1.get(productid);
	}

	@Transactional
	@Override
	public void delete(int productid) {
		productdao1.delete(productid);

	}

}
