package com.capg.hospital.service;

import java.util.List;
import com.capg.hospital.entity.DiagnosticCenter;
/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a Service interface that provides the methods for adding new centers, deleting 
 *                centers and updating centers and further implemented by service implementation class.
 *                
 *                
 * Version        1.0
 * Created Date   07-MAY-2020 
 *
 ****************************************************************************************************/



public interface CenterService {
	
	public DiagnosticCenter saveCenter(DiagnosticCenter center); 
	
	
	public List<DiagnosticCenter> getCenters();
	
	public DiagnosticCenter updateCenter(DiagnosticCenter center);
	
	  
   

	public DiagnosticCenter delete(Integer id);

	
	
	
}
	