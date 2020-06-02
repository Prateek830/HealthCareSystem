package com.capg.hcs.service;

import java.util.List;

import com.capg.hcs.entity.Users;
import com.capg.hcs.exception.UserException;

/****************************
 *          @author          Prateek Pandey
 *          Description      It is a service interface that provides the interface for services for the registration 
           				 	 of new user, login the existing user in the database, view details 
           				 	 of all user,login for admin and deleting some user
                                         
  *         Version          1.0
  *         Created Date     10-May-2020
 ****************************/


public interface UserService {
	public Users saveUser(Users user) throws UserException;

	public List<Users> showAllUsers();

	public void deleteUser(Integer userId);

	public Users loginUser(Users user) throws UserException;
	
	public String loginAdmin(Users user) throws UserException;
}
