package com.csm.service;

import java.util.List;

import com.csm.entity.sale;

public interface saleservice {
	void save(sale sale1);
	List<sale> get();
}
