package com.capg.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hospital.dao.TestDao;
import com.capg.hospital.entity.Test;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testdao;
	
	public Test saveTest(Test test) {
		return testdao.save(test);
	}
	public List<Test> saveTests(List<Test> test){
		return testdao.saveAll(test);
	}
	
	public List<Test> getTests(){
		return testdao.findAll();
		}
	
	public Test updateTest(Test test) {
		Test existingTest=testdao.findById(test.getTestId()).orElse(null);
		 existingTest.setTestName(test.getTestName());
		
	       
	        return testdao.save(existingTest);
	}
	public void delete(Integer Id) {
		testdao.deleteById(Id);
		// TODO Auto-generated method stub
		
	}
	@Override
	public Test getTestByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


