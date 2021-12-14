package com.csm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("cityRepository")
public interface CityRepository extends CrudRepository<City, Integer> {

	@Query("select new com.csm.CityEntity(id, name) from City where state.id = :id")
	public List<CityEntity> findByState(@Param("id") int id);

}