/**
 * 
 */
package com.semika.autoac.web.actions.make;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.semika.autoac.web.actions.BaseAction;
import com.semika.autoac.web.common.WebConstants;

/**
 * @author Semika Siriwardana
 *
 */
@Namespace(WebConstants.SECURE_NAMESPACE)
@ParentPackage(WebConstants.STRUTS_PACKAGE)
@Results({@Result(name = MakeAction.SUCCESS, location = "/jsp/make/make.jsp")})
public class MakeAction extends BaseAction{

	private static final long serialVersionUID = -4562405328246104350L;
	
	public String execute() {
		
		return SUCCESS;
	}
}
