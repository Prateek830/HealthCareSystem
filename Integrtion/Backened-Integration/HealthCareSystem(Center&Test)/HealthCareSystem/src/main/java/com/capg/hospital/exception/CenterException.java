package com.capg.hospital.exception;


/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a CenterException which handles the exception 
 *                which occurs in center in the database. 
 *               
 *                
 * Version        1.0
 * Created Date   12-MAY-2020 
 *
 ****************************************************************************************************/



public class CenterException extends Exception {
	 private static final long serialVersionUID=1L;
	 /**********************************************************************************************
		 * Method       CenterException
		 * Description  It is the custom exception which displays the particular message
		 * 
		 * Created By   Anjali Sharma
		 * Created Date 12-MAY-2020
		 * 
		 *********************************************************************************************/
		
	 public CenterException(String message) {
		 super(message);
	 }
	}
