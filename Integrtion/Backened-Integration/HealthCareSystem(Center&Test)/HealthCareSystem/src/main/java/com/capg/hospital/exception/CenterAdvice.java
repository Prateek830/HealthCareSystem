package com.capg.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a ControllerAdvice class  which uses the ExceptionHandler annotation
 *                to hanlde the custom exception. 
 *               
 *                
 * Version        1.0
 * Created Date   13-MAY-2020 
 *
 ****************************************************************************************************/


@ControllerAdvice
public class CenterAdvice {
	@ExceptionHandler(value= {CenterException.class})
	/**********************************************************************************************
	 * Method       handleException1
	 * Description  To handle the exception and displaying particular HTTP Status message.
	 * 
	 * Created By   Anjali Sharma
	 * Created Date 13-MAY-2020
	 * 
	 *********************************************************************************************/

	public ResponseEntity<String> handleException1(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
