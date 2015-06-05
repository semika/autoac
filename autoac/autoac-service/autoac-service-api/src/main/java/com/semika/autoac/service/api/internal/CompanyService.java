/**
 * 
 */
package com.semika.autoac.service.api.internal;

import java.util.List;

import com.semika.autoac.dto.CompanyDTO;
import com.semika.autoac.model.Company;

/**
 * @author Semika Siriwardana
 *
 */
public interface CompanyService {

	public Company findById(Long id);
	
	public List<Company> findAllCompanies();
	
	public void saveCompany(CompanyDTO dto);
	
	public void deleteCompany(CompanyDTO dto);
	
}
