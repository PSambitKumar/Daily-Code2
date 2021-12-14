package com.csm.Dao;

import java.util.List;

import com.csm.Entity.Category;

public interface CategoryDao {
	
	
	void save(Category category);
	List<Category> get();
	Category get(int catid);
	void delete(int catid);
	
}
