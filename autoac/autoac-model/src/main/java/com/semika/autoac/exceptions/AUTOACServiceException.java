/**
 * 
 */
package com.semika.autoac.exceptions;

/**
 * @author Semika Siriwardana
 *
 */
public class AUTOACServiceException extends AUTOACException {

	private static final long serialVersionUID = 470252583577377463L;
	
	public AUTOACServiceException(){
		super();
	}

	public AUTOACServiceException(String message){
		super(message);
	}
}
