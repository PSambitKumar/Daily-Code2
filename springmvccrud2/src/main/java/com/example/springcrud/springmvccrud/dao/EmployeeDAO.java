package com.example.springcrud.springmvccrud.dao;

import java.util.List;

import com.example.springcrud.springmvccrud.model.BranchMaster;

public interface EmployeeDAO {

	List<BranchMaster> get();

	BranchMaster get(int id);

	void save(BranchMaster employee);

	void delete(int id);
}