package com.elastic.autocomplete.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elastic.autocomplete.model.Company;

@Repository
public interface CompanyRepository extends ElasticsearchRepository<Company, Long> {

	Company getByName(String name);

}
