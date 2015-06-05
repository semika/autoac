/**
 * 
 */
package com.semika.autoac.persist.api;

import java.util.List;

import com.semika.autoac.exceptions.AUTOACDataAccessException;
import com.semika.autoac.model.Company;
import com.semika.autoac.persist.api.common.GenericDAO;

/**
 * @author Semika Siriwardana
 *
 */
public interface CompanyDAO extends GenericDAO<Company, Long> { 
	
	public List<Company> findByCriteria() throws AUTOACDataAccessException;
	
	public void saveOrUpdate(Company company) throws AUTOACDataAccessException;
	
	public void removeCompany(Company company) throws AUTOACDataAccessException;
}
