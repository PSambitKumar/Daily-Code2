package com.csm.dao;

import java.util.List;

import com.csm.entity.shop;

public interface shopdao {
	void save(shop shop);
	List<shop> get();
	shop get(int shopid);
	void delete(int shopid);
}
