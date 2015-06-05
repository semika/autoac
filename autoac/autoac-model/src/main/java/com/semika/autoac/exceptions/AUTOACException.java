/**
 * 
 */
package com.semika.autoac.exceptions;

/**
 * @author Semika Siriwardana
 *
 */
public class AUTOACException extends RuntimeException {
	
	private static final long serialVersionUID = -6920643431063078905L;
	
	protected String message = null;
	
	public AUTOACException(){
		super();
	}
	
	public AUTOACException(String message) {
		super(message);
	}
}
