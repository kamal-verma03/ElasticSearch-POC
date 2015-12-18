package com.elastic.autocomplete.index;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.elastic.autocomplete.helper.ElasticHelper;

public class IndexTest {

	@Test
	public void testIndexContent() throws Exception {
		InputStream is = IndexTest.class.getResourceAsStream("check.txt");
		Assert.assertTrue(ElasticHelper.indexFileContent(is));
	}
}
