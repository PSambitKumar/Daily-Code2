package com.csm.dao;

import java.util.List;

import com.csm.entity.product;

public interface productdao {
	void save(product product1);
	List<product> get();
	product get(int productid);
	void delete(int productid);
}
