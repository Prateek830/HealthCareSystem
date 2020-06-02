package com.capg.hospital.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capg.hospital.dao.DiagnosticCenterDao;
import com.capg.hospital.entity.DiagnosticCenter;
/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a service Implementation  class that implements the method of service class. 
 *                
 * Version        1.0
 * Created Date   07-MAY-2020 
 *
 ****************************************************************************************************/



@Service
@Transactional
public class CenterServiceImpl implements CenterService  {
	
        @Autowired
		private DiagnosticCenterDao diagnosticCenterDao;
        
        /**********************************************************************************************
    	 * Method       saveCenter
    	 * Description  To implement the method which save the centers.
    	 * 
    	 * Created By   Anjali Sharma
    	 * Created Date 07-MAY-2020
    	 * 
    	 *********************************************************************************************/
        @Override
		public DiagnosticCenter saveCenter(DiagnosticCenter center) {
			return diagnosticCenterDao.save(center);
		
		}
		/**********************************************************************************************
    	 * Method       getCenter
    	 * Description  To implement the method which lists all the centers.
    	 * 
    	 * Created By   Anjali Sharma
    	 * Created Date 07-MAY-2020
    	 * 
    	 *********************************************************************************************/
        
		
		@Override
		public List<DiagnosticCenter> getCenters(){
			return diagnosticCenterDao.findAll();
			}
		
		/**********************************************************************************************
    	 * Method       updateCenter
    	 * Description  To implement the method which update  the particular center.
    	 * 
    	 * Created By   Anjali Sharma
    	 * Created Date 08-MAY-2020
    	 * 
    	 *********************************************************************************************/
        
		@Override
		public DiagnosticCenter updateCenter(DiagnosticCenter center) {
			DiagnosticCenter existingCenter=diagnosticCenterDao.findById(center.getCenterId()).orElse(null);
			 existingCenter.setCenterName(center.getCenterName());
			 existingCenter.setListOftests(center.getListOftests());
		       
		        return diagnosticCenterDao.save(existingCenter);
		}
		
		/**********************************************************************************************
    	 * Method       delete
    	 * Description  To implement the method which deletes the particular centers
    	 * 
    	 * Created By   Anjali Sharma
    	 * Created Date 08-MAY-2020
    	 * 
    	 *********************************************************************************************/
        
	   @Override
		public DiagnosticCenter delete(Integer id) {
			diagnosticCenterDao.deleteById(id);
			return null;
			
		}
		
		
	
}
		


