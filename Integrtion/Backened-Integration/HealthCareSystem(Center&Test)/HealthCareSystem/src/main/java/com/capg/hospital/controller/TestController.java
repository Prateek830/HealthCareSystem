package com.capg.hospital.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hospital.entity.Test;
import com.capg.hospital.service.TestService;


@CrossOrigin(origins="http://localhost:4200")
@RestController


public class TestController {
	@Autowired
	private TestService service;
	@GetMapping("/Tests")
	public List<Test> findAllTests() {
	    return service.getTests();
	}
	@PostMapping("/add")
	public Test addTest(@RequestBody Test test) {
	    return service.saveTest(test);
	}
	

	
	@PutMapping("/updateT")
    public Test updateTest(@RequestBody Test test) {
        return service.updateTest(test);
}
	@DeleteMapping("/test/{Id}")
	public void delete(@PathVariable Integer Id) {
	    service.delete(Id);
	}
}


