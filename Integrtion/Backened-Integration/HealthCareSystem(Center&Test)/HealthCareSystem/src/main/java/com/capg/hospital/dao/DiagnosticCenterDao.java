package com.capg.hospital.dao;


import com.capg.hospital.entity.DiagnosticCenter;



import org.springframework.data.jpa.repository.JpaRepository;

/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a DiagnosticCenterDao interface typically which extends the JpaRepository 
 *                which implements the method. 
 *                
 * Version        1.0
 * Created Date   06-MAY-2020 
 *
 ****************************************************************************************************/

public interface DiagnosticCenterDao extends JpaRepository<DiagnosticCenter, Integer> {
	


	
}


