package com.csm.Service;

import com.csm.Entity.Department;
import com.csm.Entity.Employee;

import java.util.List;

public interface MainService {
    public List<Department> getAllDepartment();
    public void saveDepartment(Department department);
    public List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);
}
