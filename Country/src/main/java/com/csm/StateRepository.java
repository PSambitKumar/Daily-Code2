package com.csm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("stateRepository")
public interface StateRepository extends CrudRepository<State, Integer> {

	@Query("select new com.csm.StateEntity(id, name) from State where country.id = :id")
	public List<StateEntity> findByCountry(@Param("id") int id);

}