package com.capg.hospital.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.hospital.entity.Test;

public interface TestDao extends JpaRepository<Test, Integer> {

	Optional<Test> findById(Integer integer);

	//Test findByName(String name);
	
	}


