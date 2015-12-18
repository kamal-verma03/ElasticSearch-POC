package com.elastic.autocomplete.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.elastic.autocomplete.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public List<Company> getAllByName(String name) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
				QueryBuilders.matchQuery("name", name)).build();
		
		return elasticsearchTemplate.queryForList(searchQuery, Company.class);
	}

}
