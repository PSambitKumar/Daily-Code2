package com.example.springcrud.springmvccrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springcrud.springmvccrud.dao.BatchMasterDAO;
import com.example.springcrud.springmvccrud.model.BatchMaster;

@Service
public class BatchMaterServiceImpl implements BatchMasterService {

	@Autowired
	BatchMasterDAO batchMasterDAO;
	
	@Transactional
	@Override
	public void save(BatchMaster batchmaster) {
		batchMasterDAO.save(batchmaster);
	}
}
