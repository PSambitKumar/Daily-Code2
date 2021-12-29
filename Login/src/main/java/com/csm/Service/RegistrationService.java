package com.csm.Service;

import java.util.List;

import com.csm.Entity.Registration;

public interface RegistrationService {
	void save(Registration login);
	List<Registration> get();
	Registration get(int slno);
	void delete(int slno);
}
