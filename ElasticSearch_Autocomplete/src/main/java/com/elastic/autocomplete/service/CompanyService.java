package com.elastic.autocomplete.service;

import java.util.List;

import com.elastic.autocomplete.model.Company;

public interface CompanyService {

	public List<Company> getAllByName(String name);
}
