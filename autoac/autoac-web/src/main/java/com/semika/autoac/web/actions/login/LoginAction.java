/**
 * 
 */
package com.semika.autoac.web.actions.login;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.semika.autoac.model.User;
import com.semika.autoac.service.api.internal.UserService;
import com.semika.autoac.web.common.WebConstants;

/**
 * @author root
 *
 */
@Controller
@Namespace(WebConstants.PUBLIC_NAMESPACE)
@Results({@Result(name=LoginAction.SUCCESS, location="/jsp/login/login.jsp")})
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 7383992544290674922L;
	
	@Autowired
	private UserService userService;
	
	public String execute() {
		User user = userService.findById(new Long(1));
		List<User> userList = userService.findAllUsers();
		return SUCCESS;
	}
}
