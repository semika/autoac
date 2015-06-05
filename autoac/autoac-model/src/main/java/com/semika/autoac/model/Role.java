/**
 * 
 */
package com.semika.autoac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author root
 *
 */
@Entity
@Table(name= "ROLE")
public class Role extends Audited implements Serializable {

	private static final long serialVersionUID = 2671555907865135542L;
	
	@Id
	@SequenceGenerator(name = "role_seq", sequenceName = "role_seq")
	@GeneratedValue(generator = "role_seq", strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column(name="NAME") 
	private String name;
	
	@Column(name="DESCRIPTION") 
	private String description;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
}
