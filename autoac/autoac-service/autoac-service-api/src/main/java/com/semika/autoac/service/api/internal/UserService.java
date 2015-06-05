/**
 * 
 */
package com.semika.autoac.service.api.internal;

import java.util.List;

import com.semika.autoac.dto.UserDTO;
import com.semika.autoac.exceptions.AUTOACServiceException;
import com.semika.autoac.model.User;

/**
 * @author root
 *
 */
public interface UserService {

	public User findById(Long id) throws AUTOACServiceException;
	
	public List<User> findAllUsers() throws AUTOACServiceException;
	
	public void saveUser(UserDTO dto) throws AUTOACServiceException;
	
	public void removeUser(UserDTO dto) throws AUTOACServiceException;
}
