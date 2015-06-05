/**
 * 
 */
package com.semika.autoac.persist.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.semika.autoac.model.User;
import com.semika.autoac.persist.api.UserDAO;
import com.semika.autoac.persist.impl.common.GenericHibernateDAO;

/**
 * @author root
 *
 */
@Repository
public class UserDAOImpl extends GenericHibernateDAO<User, Long> implements UserDAO {

	@Override
	public List<User> findByCriteria() {
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		super.makePersistent(user);
	}

	@Override
	public void removeUser(User user) {
		super.makeTransient(user);
	}

}
