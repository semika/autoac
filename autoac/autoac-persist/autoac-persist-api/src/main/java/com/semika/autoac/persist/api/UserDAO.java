/**
 * 
 */
package com.semika.autoac.persist.api;

import java.util.List;

import com.semika.autoac.exceptions.AUTOACDataAccessException;
import com.semika.autoac.model.User;
import com.semika.autoac.persist.api.common.GenericDAO;

/**
 * @author root
 *
 */
public interface UserDAO extends GenericDAO<User, Long> { 

	public List<User> findByCriteria() throws AUTOACDataAccessException;
	
	public void saveOrUpdate(User user) throws AUTOACDataAccessException;
	
	public void removeUser(User user) throws AUTOACDataAccessException;
}
