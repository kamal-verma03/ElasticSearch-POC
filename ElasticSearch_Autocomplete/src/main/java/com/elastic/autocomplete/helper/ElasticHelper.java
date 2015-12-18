package com.elastic.autocomplete.helper;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ElasticHelper {

	private static Node node = null;

	public static Client createClient() {
		node = nodeBuilder().clusterName("my-App-Cluster").node().start();
		Client client = node.client();
		return client;

	}

	public static void closeNode() {
		node.close();
	}

	public static boolean indexFileContent(InputStream stream)
			throws Exception, IOException {
		try {

			com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client
					.create();

			WebResource webResource = client
					.resource("http://localhost:9200/companies/company/");

			ClientResponse response = null;
			String name = null;
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					stream));
			long startTime = System.currentTimeMillis();
			while ((name = bReader.readLine()) != null) {

				String jsonDoc = "{" + " \"name\":" + '"' + name + '"' + "}";
				response = webResource.type("application/json").post(
						ClientResponse.class, jsonDoc);

			}

			long endTime = System.currentTimeMillis();

			if (response.getStatus() != 201) {
				throw new Exception("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			System.out.println(response.getEntity(String.class));
			System.out.print("Time took : ");
			System.out.println(endTime - startTime);
		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}
		return true;
	}

}
