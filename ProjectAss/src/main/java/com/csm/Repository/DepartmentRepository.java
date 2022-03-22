package com.csm.Repository;

import com.csm.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
}
