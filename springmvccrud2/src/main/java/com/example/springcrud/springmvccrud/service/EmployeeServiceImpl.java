package com.example.springcrud.springmvccrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springcrud.springmvccrud.dao.EmployeeDAO;
import com.example.springcrud.springmvccrud.model.BranchMaster;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<BranchMaster> get() {
		return employeeDAO.get();
	}

	@Transactional
	@Override
	public BranchMaster get(int id) {
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(BranchMaster employee) {
		employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
	}

}