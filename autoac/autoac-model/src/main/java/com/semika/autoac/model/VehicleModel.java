/**
 * 
 */
package com.semika.autoac.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Semika Siriwardana
 *
 */
@Entity
@Table(name = "VEHICLE_MODEL")
public class VehicleModel implements Serializable {

	private static final long serialVersionUID = 8842985708238477234L;

	@Id
	@SequenceGenerator(name = "vmo_seq", sequenceName = "vmo_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vmo_seq")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "NUMBER") 
	private String modelNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="MANUFACTURE_YEAR") 
	private Date manufacturedYear;
	
	@ManyToOne
	@JoinColumn(name = "MAKE_ID")
	private VehicleMake make;
	
	@OneToMany(mappedBy = "model")
	private List<VehicleModelYear> modleYears;
	
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

	/**
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber the modelNumber to set
	 */
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * @return the manufacturedYear
	 */
	public Date getManufacturedYear() {
		return manufacturedYear;
	}

	/**
	 * @param manufacturedYear the manufacturedYear to set
	 */
	public void setManufacturedYear(Date manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}

	/**
	 * @return the make
	 */
	public VehicleMake getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(VehicleMake make) {
		this.make = make;
	}

	/**
	 * @return the modleYears
	 */
	public List<VehicleModelYear> getModleYears() {
		return modleYears;
	}

	/**
	 * @param modleYears the modleYears to set
	 */
	public void setModleYears(List<VehicleModelYear> modleYears) {
		this.modleYears = modleYears;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleModel [id=" + id + ", manufacturedYear="
				+ manufacturedYear + ", modelNumber=" + modelNumber + ", name="
				+ name + "]";
	}
	
}
