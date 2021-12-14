package com.csm.service;

import java.util.List;

import com.csm.entity.shop;

public interface shopservice {
	void save(shop shop1);
	List<shop> get();
	shop get(int shopid);
	void delete(int shopid);
}
