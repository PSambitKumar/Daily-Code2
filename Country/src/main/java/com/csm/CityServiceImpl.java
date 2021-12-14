package com.csm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<CityEntity> findByState(int id) {
		return cityRepository.findByState(id);
	}

}