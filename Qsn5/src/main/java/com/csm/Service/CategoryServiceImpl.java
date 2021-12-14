package com.csm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.Dao.CategoryDao;
import com.csm.Entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Transactional
	@Override
	public void save(Category category) {
		categoryDao.save(category);

	}

	@Transactional
	@Override
	public List<Category> get() {
		return categoryDao.get();
	}

	@Transactional
	@Override
	public Category get(int catid) {
		return categoryDao.get(catid);
	}

	@Transactional
	@Override
	public void delete(int catid) {
		categoryDao.delete(catid);

	}

}
