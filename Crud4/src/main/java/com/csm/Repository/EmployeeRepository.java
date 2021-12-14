package com.csm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
