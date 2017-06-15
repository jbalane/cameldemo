package com.test.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelSample {
	
	//private Connection conn;

	public static void main(String[] args) throws Exception {
		
		CamelSample app = new CamelSample();
		app.camelTest();
		//app.hibernateTest();
		

	}
	
	/**
	 * camel test
	 * @throws Exception
	 */
	public void camelTest() throws Exception {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		CamelContext context = SpringCamelContext.springCamelContext(appContext);
		
		try{
			ProducerTemplate template = context.createProducerTemplate();
			context.start();
			
			//template.sendBody("activemq:test.queue", "Hello World!");
			
			String message = " Dog, Igloo, House, Egg, Goat, Cat, Ball, Apple, Fox";
			template.sendBodyAndHeader("file:C:\\Apps\\camel\\inbox", message, Exchange.FILE_NAME, "unsorted_camel_test.csv");
			
			Thread.sleep(3000);
		}finally{
			context.stop();
		}
		
	}

}
