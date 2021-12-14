package com.csm.Service;

import java.util.List;

import com.csm.Entity.Category;

public interface CategoryService {
	
	
	void save(Category category);
	List<Category> get();
	Category get(int catid);
	void delete(int catid);
}
