package com.csm;


import java.util.List;


public interface CityService {

	public List<CityEntity> findByState(int id);

}