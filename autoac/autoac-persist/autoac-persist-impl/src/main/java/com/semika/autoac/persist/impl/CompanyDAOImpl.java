/**
 * 
 */
package com.semika.autoac.persist.impl;

import java.util.List;

import com.semika.autoac.exceptions.AUTOACDataAccessException;
import com.semika.autoac.model.Company;
import com.semika.autoac.persist.api.CompanyDAO;
import com.semika.autoac.persist.impl.common.GenericHibernateDAO;

/**
 * @author Semika Siriwardana
 *
 */
public class CompanyDAOImpl extends GenericHibernateDAO<Company, Long> implements CompanyDAO {

	@Override
	public List<Company> findByCriteria() throws AUTOACDataAccessException {
		return null;
	}

	@Override
	public void removeCompany(Company company) throws AUTOACDataAccessException {
		super.makeTransient(company);
	}

	@Override
	public void saveOrUpdate(Company company) throws AUTOACDataAccessException {
		super.makePersistent(company);
	}

}
