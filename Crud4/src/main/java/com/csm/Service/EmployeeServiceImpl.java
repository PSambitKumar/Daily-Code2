package com.csm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.Bean.EmployeeBean;
import com.csm.Entity.Employee;
import com.csm.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(EmployeeBean Empbean) {
		String result = "";
		try {
			Employee emp = new Employee();
			
			Employee getResult = employeeRepository.save(emp);
			
			if(getResult != null) {
				result = "Success";
			}
			else {
				result = "Fail";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
