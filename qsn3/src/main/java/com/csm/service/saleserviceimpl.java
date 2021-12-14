package com.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.dao.saledao;
import com.csm.entity.sale;

@Service
public class saleserviceimpl implements saleservice {

	@Autowired
	saledao saledao1;
	
	@Transactional
	@Override
	public void save(sale sale1) {
		saledao1.save(sale1);

	}
	@Transactional
	@Override
	public List<sale> get() {
		return saledao1.get();
	}

}
