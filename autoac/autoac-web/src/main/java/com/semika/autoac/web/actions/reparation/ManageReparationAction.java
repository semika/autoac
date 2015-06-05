package com.semika.autoac.web.actions.reparation;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.semika.autoac.web.actions.BaseAction;
import com.semika.autoac.web.common.WebConstants;

@Namespace(WebConstants.SECURE_NAMESPACE)
@ParentPackage(WebConstants.STRUTS_PACKAGE)
@Results({@Result(name = ManageReparationAction.SUCCESS, location = "/jsp/reparation/manageReparation.jsp"),
		  @Result(name = "json", type = "json")})
public class ManageReparationAction extends BaseAction{

	private static final long serialVersionUID = 3354951900252637340L;

	public String execute() {
		
		return SUCCESS;
	}
}
