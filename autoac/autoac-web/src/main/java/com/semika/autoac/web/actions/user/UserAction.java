package com.semika.autoac.web.actions.user;

/**
 * 
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.semika.autoac.dto.UserDTO;
import com.semika.autoac.model.User;
import com.semika.autoac.service.api.internal.UserService;
import com.semika.autoac.web.actions.BaseAction;
import com.semika.autoac.web.common.WebConstants;

/**
 * @author root
 *
 */
@Namespace(WebConstants.SECURE_NAMESPACE)
@ParentPackage(WebConstants.STRUTS_PACKAGE) 
@Results({
    @Result(name="success", location="/jsp/user/user.jsp"),
    @Result(name="json", type="json")
})
public class UserAction extends BaseAction implements ModelDriven<UserDTO> { 
	
	private static final long serialVersionUID = -9103843439708377240L;
	
	private UserDTO dto = new UserDTO();
	
	@Autowired
	private UserService userService;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public String execute() {
		List<User> userList = userService.findAllUsers();
		request.setAttribute(SEARCH_RESULTS, userList); 
		return  SUCCESS;
	}
	
	public String search() {
		List<User> userList = userService.findAllUsers();
		map.put(SEARCH_RESULTS, userList);
		return JSON;
	}
	
	public String save() {
		userService.saveUser(dto);
		return search();
	}

	public String delete(){
		userService.removeUser(dto);
		return search();
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public UserDTO getModel() {
		return dto;
	}
}
