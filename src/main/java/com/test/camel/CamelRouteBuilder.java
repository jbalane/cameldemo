package com.test.camel;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//from("activemq:queue:test.queue").to("stream:out");

	}

}
