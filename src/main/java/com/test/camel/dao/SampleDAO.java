package com.test.camel.dao;

import java.util.List;

import com.test.camel.model.Sample;

public interface SampleDAO {
	
	public void save(Sample s);
	
	public List<Sample> list();

}
