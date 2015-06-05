/**
 * 
 */
package com.semika.autoac.web.actions.model;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.semika.autoac.web.common.WebConstants;

/**
 * @author Semika Siriwardana
 *
 */
@Controller
@Namespace(WebConstants.SECURE_NAMESPACE)
@ParentPackage(WebConstants.STRUTS_PACKAGE)
@Results({@Result(name="success", location="/jsp/model/model.jsp"), 
	      @Result(name = "json", type = "json")}) 
public class ModelAction extends ActionSupport {

	private static final long serialVersionUID = -1622053616812319550L;

	public String execute() {
		return SUCCESS;
	}
}
