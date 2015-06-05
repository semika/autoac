/**
 * 
 */
package com.semika.autoac.web.actions.reparation;

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
@Results({@Result(name = "success", location = "/jsp/reparation/createReparation.jsp"),
	      @Result(name = "json", type = "json")})
public class CreateReparationAction extends BaseAction {

	private static final long serialVersionUID = 2597832349723062700L;
	
	public String execute() {
		
		return SUCCESS;
	}

}
