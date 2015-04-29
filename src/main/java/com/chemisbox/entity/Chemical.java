package com.chemisbox.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = "chemical")
public class Chemical implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chemical_id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "difference_name")
	private String differenceName;

	@Column(name = "formula")
	private String formula;

	@Column(name = "quantity", nullable = false, columnDefinition = "int default 100")
	private float quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "density")
	private String density;

	@Column(name = "melting_temperature")
	private String meltingTemperature;

	@Column(name = "boiling_temperature")
	private String boilingTemperature;

	@Column(name = "solubility_in_water")
	private String solubilityInWater;

	@Column(name = "ignition_point")
	private String ignitionPoint;

	@Column(name = "flavour")
	private String flavour;

	@Column(name = "img")
	private String img;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "edited_date")
	private Date editedDate;

	@Column(name = "last_user_modify")
	private String lastUserModify;

	public String getLastUserModify() {
		return lastUserModify;
	}

	public void setLastUserModify(String lastUserModify) {
		this.lastUserModify = lastUserModify;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDifferenceName() {
		return differenceName;
	}

	public void setDifferenceName(String differenceName) {
		this.differenceName = differenceName;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		this.density = density;
	}

	public String getMeltingTemperature() {
		return meltingTemperature;
	}

	public void setMeltingTemperature(String meltingTemperature) {
		this.meltingTemperature = meltingTemperature;
	}

	public String getBoilingTemperature() {
		return boilingTemperature;
	}

	public void setBoilingTemperature(String boilingTemperature) {
		this.boilingTemperature = boilingTemperature;
	}

	public String getSolubilityInWater() {
		return solubilityInWater;
	}

	public void setSolubilityInWater(String solubilityInWater) {
		this.solubilityInWater = solubilityInWater;
	}

	public String getIgnitionPoint() {
		return ignitionPoint;
	}

	public void setIgnitionPoint(String ignitionPoint) {
		this.ignitionPoint = ignitionPoint;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
