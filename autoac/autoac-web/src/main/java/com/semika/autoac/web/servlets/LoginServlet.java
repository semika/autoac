/**
 * 
 */
package com.semika.autoac.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.semika.autoac.service.api.internal.UserService;

/**
 * @author root
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService; 
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		userService.findById(new Long(100));
	}
}
