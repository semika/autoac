/**
 * 
 */
package com.semika.autoac.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semika.autoac.dto.CompanyDTO;
import com.semika.autoac.model.Company;
import com.semika.autoac.persist.api.CompanyDAO;
import com.semika.autoac.service.api.internal.CompanyService;

/**
 * @author Semika Siriwardana
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDao;

	@Override
	public List<Company> findAllCompanies() { 
		return companyDao.findAll();
	}

	@Override
	public Company findById(Long id) {
		return null;
	}

	@Override
	public void saveCompany(CompanyDTO dto) {
		
		Company company = null;

		if (dto.getId() == null) { // New company
			company = new Company();
			company.setName(dto.getName());
			company.setAddressLineOne(dto.getAddressLineOne());
			company.setAddressLineTwo(dto.getAddressLineTwo());
			company.setTelephone(dto.getTelephone());
			company.setFax(dto.getFax());
			company.setVersion(dto.getVersion());
		} else {
			company = companyDao.findById(dto.getId(), true);
		}
		companyDao.saveOrUpdate(company);
	}

	@Override
	public void deleteCompany(CompanyDTO dto) {
		Company company = companyDao.findById(dto.getId(), true);
		companyDao.makeTransient(company);
	}

}
