package com.csm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csm.Dao.RegistrationDao;
import com.csm.Entity.Registration;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDao loginDao;
	
	@Override
	public void save(Registration login) {
		loginDao.save(login);

	}

	@Override
	public List<Registration> get() {
		return loginDao.get();
	}

	@Override
	public Registration get(int slno) {
		return loginDao.get(slno);
	}

	@Override
	public void delete(int slno) {
		loginDao.delete(slno);

	}

}
