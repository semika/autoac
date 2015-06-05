/**
 * 
 */
package com.semika.autoac.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Semika Siriwardana
 *
 */
@Entity
@Table(name = "VEHICLE_MODEL_YEAR")
public class VehicleModelYear extends Audited implements Serializable {

	private static final long serialVersionUID = 7977260933461398378L;
	
	@Id
	@SequenceGenerator(name = "vmoy_seq", sequenceName = "vmoy_seq")
	@GeneratedValue(generator = "vmoy_seq", strategy = GenerationType.AUTO) 
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MODEL_ID")
	private VehicleModel model;
	
	@Temporal(TemporalType.DATE)
	private Date manufacturedYear;
	
	@ManyToMany
	@JoinTable(name = "VEHICLE_MODEL_OPTION", 
			   joinColumns = @JoinColumn(name = "MODEL_YEAR_ID"), 
			   inverseJoinColumns = @JoinColumn(name="OPT_ID"))
	private List<VehicleOption> modelOptions; 

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
	 * @return the model
	 */
	public VehicleModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(VehicleModel model) {
		this.model = model;
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
}
