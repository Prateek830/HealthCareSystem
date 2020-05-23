package com.capg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcs.entity.Users;

/****************************
 *          @author          Prateek Pandey
 *          Description      It is a interface that extends the JPA Repository to 
 *          				 use inbuilt functions for JPA. 
                                         
  *         Version          1.0
  *         Created Date     9-May-2020
 ****************************/


public interface UserRepository extends JpaRepository<Users, Integer>{
	public Users findByEmailId(String emailId);
	public Users findByEmailIdAndUserPassword(String emailId, String userPassword); 

}
