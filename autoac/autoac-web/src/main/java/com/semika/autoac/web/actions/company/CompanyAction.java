/**
 * 
 */
package com.semika.autoac.web.actions.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.semika.autoac.dto.CompanyDTO;
import com.semika.autoac.model.Company;
import com.semika.autoac.service.api.internal.CompanyService;
import com.semika.autoac.web.actions.BaseAction;
import com.semika.autoac.web.common.WebConstants;

/**
 * @author Semika Siriwardana
 *
 */
@Namespace(WebConstants.SECURE_NAMESPACE)
@ParentPackage(WebConstants.STRUTS_PACKAGE)
@Results({@Result(name = CompanyAction.SUCCESS, location = "/jsp/company/company.jsp"), 
	      @Result(name = "json", type = "json")})
public class CompanyAction extends BaseAction implements ModelDriven<CompanyDTO> { 

	private static final long serialVersionUID = 1259154834462901894L;
	
	@Autowired
	private CompanyService companyService;
	
	private CompanyDTO dto = new CompanyDTO();
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public String execute() {
		List<Company> compList = companyService.findAllCompanies();
		request.setAttribute(SEARCH_RESULTS, compList); 
		return  SUCCESS;
	}

	public String save() {
		companyService.saveCompany(dto);
		return search();
	}
	
	public String delete() {
		companyService.deleteCompany(dto);
		return search(); 
	}
	
	public String search() {
		List<Company> compList = companyService.findAllCompanies();
		map.put(SEARCH_RESULTS, compList);
		return JSON;
	}

	@Override
	public CompanyDTO getModel() {
		return dto;
	}

	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
