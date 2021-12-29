package com.csm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.Dao.StudentDao;
import com.csm.Entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Transactional
	public void save(Student student) {
		
		studentDao.save(student);
		
	}

}
