package com.graphql_java_generator.non_spring_app;

import java.util.Date;

public class NonSpringApp {

	public static void main(String[] args) throws Exception {
		// A basic demo of input parameters
		Date date = new Date(2019 - 1900, 12 - 1, 20);

		// For this simple sample, we execute a direct query. But prepared queries are recommended.
		// Please note that input parameters are mandatory for list or input types.
		System.out.println(
				"Executing query: '{id name publiclyAvailable topics(since: &param){id}}', with input parameter param of value '"
						+ date + "'");
		System.out.println(NonSpringWithSpringGraphQLConfApp.getQueryTypeExecutor()
				.boards("{id name publiclyAvailable topics(since: &param){id}}", "param", date));
		System.out.println("Normal end of the application");
	}

}
