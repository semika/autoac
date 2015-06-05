/**
 * 
 */
package com.semika.autoac.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Semika Siriwardana
 *
 */
@Entity
@Table(name="County") 
public class Country extends Audited implements Serializable {

	private static final long serialVersionUID = -7828516977395328932L;
	
	@Id
	@SequenceGenerator(name = "con_seq", sequenceName = "con_seq")
	@GeneratedValue(generator = "con_seq", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME") 
	private String name;
	
	@OneToMany(mappedBy = "country") 
	private List<VehicleMake> vehicleMakes;

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
	 * @return the vehicleMakes
	 */
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakes;
	}

	/**
	 * @param vehicleMakes the vehicleMakes to set
	 */
	public void setVehicleMakes(List<VehicleMake> vehicleMakes) {
		this.vehicleMakes = vehicleMakes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
	
}
