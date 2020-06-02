package com.capg.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capg.hospital.entity.DiagnosticCenter;
import com.capg.hospital.exception.CenterException;
import com.capg.hospital.service.CenterService;

/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a Controller class typically used in 
 *                combination with annotated handler methods based on the Mapping annotation. 
 *                
 * Version        1.0
 * Created Date   06-MAY-2020 
 *
 ****************************************************************************************************/




@CrossOrigin(origins="http://localhost:4200")
@RestController


public class CenterController {
	@Autowired
	private CenterService service;
	
	/**********************************************************************************************
	 * Method       findAllCenters
	 * Description  To view all the centers inserted in the database
	 * 
	 * Created By   Anjali Sharma
	 * Created Date 06-MAY-2020
	 * 
	 *********************************************************************************************/
	@GetMapping("/centers")
	public ResponseEntity<List<DiagnosticCenter>> findAllCenters() {
		List<DiagnosticCenter> centerlist=service.getCenters();
	    return new ResponseEntity<List<DiagnosticCenter>> (centerlist,HttpStatus.OK);
	}
	
	/**********************************************************************************************
	 * Method       addCenter
	 * Description  To add the center in the database
	 * 
	 * Created By   Anjali Sharma
	 * Created Date 06-MAY-2020
	 * 
	 *********************************************************************************************/
	
	@PostMapping("/addcenter")
	public ResponseEntity<String> addCenter( @RequestBody DiagnosticCenter center) {
		
		
		service.saveCenter(center);
	    return new ResponseEntity<String>("Center Added",HttpStatus.OK);
		
	}
	
	/**********************************************************************************************
	 * Method       updateCenter
	 * Description  To update the centers details if required by the admin
	 * 
	 * Created By   Anjali Sharma
	 * Created Date 07-MAY-2020
	 * 
	 *********************************************************************************************/
	
	@PutMapping("/update")
    public ResponseEntity<String> updateCenter(@RequestBody DiagnosticCenter center) {
		service.updateCenter(center);
        return new ResponseEntity<String>("Updated",HttpStatus.OK); 
   }
	/**********************************************************************************************
	 * Method       delete
	 * Description  To delete the center given by particular id
	 * @throws CenterException-It is raised if the particular id which is to be deleted does not 
	 *                         exist in database
	 * 
	 * Created By   Anjali Sharma
	 * Created Date 07-MAY-2020
	 * 
	 *********************************************************************************************/
	@GetMapping("/centers")
	@DeleteMapping("/center/{Id}")
	public ResponseEntity<String>delete(@PathVariable Integer Id) throws CenterException{
	    try
	    {service.delete(Id);
	    return new ResponseEntity<String>("Center deleted", HttpStatus.OK);
	    
	    
	    }
	    catch(Exception ex) {
			throw new CenterException("ID No."+Id+" does not exists");
	    }
	    }
	}
	   
	    
	



