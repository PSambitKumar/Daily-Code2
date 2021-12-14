package com.csm;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("countryRepository")
public interface CountryRepository extends CrudRepository<Country, Integer> {

}