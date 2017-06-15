package com.test.camel.bean;

import java.util.ArrayList;
import java.util.List;

import com.test.camel.dao.SampleDAO;
import com.test.camel.model.Sample;

import scala.actors.threadpool.Arrays;

public class PersistenceBean {
	
	private SampleDAO dao;

	@SuppressWarnings("unchecked")
	public void persist(String body){
		
		List<String> list = new ArrayList<String>(Arrays.asList(body.split(",")));
		
		for(String l: list){
			Sample s = new Sample(l.trim());
			dao.save(s);
		}
		
		//output the results
		List<Sample> result = dao.list();
		for(Sample r: result){
			System.out.println("Record " + r.getId() + ": " + r.toString());
		}
		
	}

	public SampleDAO getDao() {
		return dao;
	}

	public void setDao(SampleDAO dao) {
		this.dao = dao;
	}
	
}
