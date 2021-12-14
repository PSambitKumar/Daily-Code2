package com.csm;


public interface CountryService {

	public Iterable<Country> findAll();

	public Country find(int id);

}