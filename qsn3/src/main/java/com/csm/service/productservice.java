package com.csm.service;

import java.util.List;

import com.csm.entity.product;

public interface productservice {
	void save(product product1);
	List<product> get();
	product get(int productid);
	void delete(int productid);
}
