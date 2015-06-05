/**
 * 
 */
package com.semika.autoac.dto;

import java.io.Serializable;

/**
 * @author Semika Siriwardana
 *
 */
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -5129800693429047587L;
	
	protected String errorMessage;
	
	private String status = "success";

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
