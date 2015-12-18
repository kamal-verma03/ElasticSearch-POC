package com.elastic.autocomplete.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "companies", type = "company", shards = 1, replicas = 0, indexStoreType = "memory", refreshInterval = "-1")
public class Company {

	@Id
	private long companyID;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
