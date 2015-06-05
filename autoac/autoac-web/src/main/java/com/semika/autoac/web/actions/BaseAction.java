/**
 * 
 */
package com.semika.autoac.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Semika Siriwardana
 *
 */
public class BaseAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -8209196735097293008L;

	protected HttpServletRequest request;
	
	protected String JSON = "json";
	
	protected String SEARCH_RESULTS = "searchResults";
	
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
