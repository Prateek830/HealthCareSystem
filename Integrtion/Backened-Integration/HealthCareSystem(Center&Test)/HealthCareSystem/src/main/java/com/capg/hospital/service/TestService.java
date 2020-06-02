package com.capg.hospital.service;

import java.util.List;

import com.capg.hospital.entity.Test;


public interface TestService {
	
	public Test saveTest(Test test);
	public List<Test> saveTests(List<Test> test);
	
	public List<Test> getTests();
	public Test getTestByName(String name);
	public Test updateTest(Test test);
	public void delete(Integer Id) ;
	
}


