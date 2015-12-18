package com.elastic.autocomplete.index;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.elastic.autocomplete.helper.ElasticHelper;

public class AddCompaniesTest {

	@Test
	public void testIndexContent() throws Exception {
		InputStream is = AddCompaniesTest.class.getResourceAsStream("companies-list.txt");
		Assert.assertTrue(ElasticHelper.indexFileContent(is));
	}
}
