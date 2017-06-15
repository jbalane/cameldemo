package com.test.camel.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class SortingProcessor implements Processor{
	
	public void process(Exchange exchange) throws Exception {
		
		//get incoming message
		String inMessage = exchange.getIn().getBody(String.class);
		System.out.println("BEFORE SORTING: " + "{" + inMessage + "}");
		
		//convert into list
		List<String> list = new ArrayList<String>(Arrays.asList(inMessage.split(",")));
		
		//sort list
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			sb.append(it.next()).append(",");
			
		}
		
		//create sorted message
		String outMessage = sb.toString();
		System.out.println("AFTER SORTING: " + "{" + outMessage + "}");
		
		Message out = exchange.getOut();
		out.setBody(outMessage);
		out.setHeader(Exchange.FILE_NAME, "sorted_camel_test.csv");
		
	}

}
