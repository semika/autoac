/**
 * 
 */
package com.semika.autoac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Semika Siriwardana
 *
 */
@MappedSuperclass
public class Versioned implements Serializable{

	private static final long serialVersionUID = 8348943562086143311L;
	
	@Version
	@Column(name = "OPTLOCK")
	private Integer version;

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
