/**
 * 
 */
package com.semika.autoac.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semika.autoac.dto.UserDTO;
import com.semika.autoac.model.User;
import com.semika.autoac.persist.api.UserDAO;
import com.semika.autoac.service.api.internal.UserService;

/**
 * @author root
 *
 */
@Service
public class UserServiceImpl implements UserService { 
	
	@Autowired
	private UserDAO userDao;

	@Override
	public User findById(Long id) {
		return userDao.findById(id, false); 
	}

	@Override
	public List<User> findAllUsers() { 
		List<User> userList = userDao.findAll();
		for (User user:userList) {
			System.out.println(user.getUserName());
		}
		return userList;
	}

	@Override
	public void saveUser(UserDTO dto) { 
		
		if(dto.getId() == null){
			User user = new User();
			user.setUserName(dto.getUserName());
			user.setPassword(dto.getPassword());
			user.setVersion(dto.getVersion());
			user.setTelphone("+94772295070");
			userDao.saveOrUpdate(user);
		} else {
			//edit exsisting user
		}
	}

	@Override
	public void removeUser(UserDTO dto) {
		User user = userDao.findById(dto.getId(), true);
		userDao.removeUser(user);
	}
}
