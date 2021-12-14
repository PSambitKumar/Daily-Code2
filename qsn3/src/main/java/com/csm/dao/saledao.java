package com.csm.dao;

import java.util.List;

import com.csm.entity.sale;

public interface saledao {
	
	void save(sale sale1);
	List<sale> get();
}
