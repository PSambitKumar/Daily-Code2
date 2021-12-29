package com.csm.Dao;

import java.util.List;
import com.csm.Entity.Registration;

public interface RegistrationDao {
	void save(Registration login);
	List<Registration> get();
	Registration get(int slno);
	void delete(int slno);
}
