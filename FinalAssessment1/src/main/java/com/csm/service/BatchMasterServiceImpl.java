package com.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.bean.BatchMasterDto;
import com.csm.entity.BatchMaster;
import com.csm.repository.BatchMasterRepository;


@Service
public class BatchMasterServiceImpl implements BatchMasterService {

	@Autowired
	BatchMasterRepository employeeRepository;
	
	@Override
	public String saveEmployee(BatchMasterDto dto) {
		String res="";
		try {
			BatchMaster emp=new BatchMaster();
			emp.setName(dto.getName());
			BatchMaster resEmp = employeeRepository.save(emp);
			if(resEmp != null)
				res="sucess";
			else
				res="fail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<BatchMasterDto> getAllEmployee() {
		List<BatchMasterDto> eList=new ArrayList<>();
		BatchMasterDto bean=null;
		try {
			List<BatchMaster> empObjList = employeeRepository.findAll();
			for (BatchMaster employee : empObjList) {
				bean=new BatchMasterDto();
				bean.setEmpId(employee.getEmpId());
				bean.setName(employee.getName());
				eList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}

}
