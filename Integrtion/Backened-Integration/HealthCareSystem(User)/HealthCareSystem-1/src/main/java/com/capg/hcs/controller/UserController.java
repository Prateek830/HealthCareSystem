package com.capg.hcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capg.hcs.entity.Users;
import com.capg.hcs.exception.UserException;
import com.capg.hcs.service.UserService;


/****************************
 *          @author          Prateek Pandey
 *          Description      It is a controller class that control all the methods for the registration 
           				 	 of new user, login the existing user in the database, view details 
           				 	 of all user, login for admin and deleting some user
                                         
  *         Version          1.0
  *         Created Date     12-May-2020
 ****************************/


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	/****************************
	 * Method: 					getAllUsers
     * Description: 			To show list of all users
     * Created By:              Prateek Pandey
     * Created Date:            12-May-2020                           
	 
	 ****************************/

	@GetMapping("/viewAllUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> userlist = userService.showAllUsers();
		return new ResponseEntity<List<Users>>(userlist, HttpStatus.OK);
	}

	/****************************
	 * Method: 					registerUser
     * Description: 			To register a new User
     * Created By:              Prateek Pandey
     * Created Date:            12-May-2020                           
	 
	 ****************************/
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Users> registerUser(@RequestBody Users user) throws UserException {
		Users savedUser = userService.saveUser(user);
		return new ResponseEntity<Users>(savedUser, HttpStatus.OK);
	}

	
	/****************************
	 * Method: 					loginUser
     * Description: 			To login an existing User
     * Created By:              Prateek Pandey
     * Created Date:            12-May-2020                           
	 
	 ****************************/
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Users> loginUser(@RequestBody Users user) throws UserException {
		Users loggedUser = userService.loginUser(user);
		return new ResponseEntity<Users>(loggedUser, HttpStatus.OK);

	}

	/****************************
	 * Method: 					admin
     * Description: 			To login as an admin
     * Created By:              Prateek Pandey
     * Created Date:            12-May-2020                           
	 
	 ****************************/
	
	@PostMapping("/admin")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> admin(@RequestBody Users user) throws UserException {
		String loggedAdmin = userService.loginAdmin(user);
		return new ResponseEntity<String>(loggedAdmin, HttpStatus.OK);

	}
	
	/****************************
	 * Method: 					deleteUser
     * Description: 			To delete an user
     * @throws UserException:   It is raised due to User ID not exists
     * Created By:              Prateek Pandey
     * Created Date:            12-May-2020                           
	 
	 ****************************/

	@DeleteMapping(value = "/deleteuser/{userId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) throws UserException {
		try {
			userService.deleteUser(userId);
			return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new UserException("User ID not exists");
		}
	}

}
