package com.chemisbox.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "element")
public class Element implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "notation", nullable = false, unique = true)
	private String notation;

	@Column(name = "name")
	private String name;

	@Column(name = "number_of_atomic")
	private float numberOfAtomic;

	@Column(name = "atomic_volume")
	private String atomicVolume;

	@Column(name = "classify")
	private String classify;

	@Column(name = "`group`")
	private String group;

	@Column(name = "cycle")
	private String cycle;

	@Column(name = "electron_configuration")
	private String electronConfiguration;

	@Column(name = "layers")
	private String layers;

	@Column(name = "description")
	private String description;

	@Column(name = "color")
	private String color;

	@Column(name = "`condition`")
	private String condition;

	@Column(name = "melting_temperature")
	private String meltingTemperature;

	@Column(name = "boiling_temperature")
	private String boilingTemperature;

	@Column(name = "img")
	private String img;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "edited_date")
	private Date editedDate;

	@Column(name = "last_user_modify")
	private String lastUserModify;

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

	public String getLastUserModify() {
		return lastUserModify;
	}

	public void setLastUserModify(String lastUserModify) {
		this.lastUserModify = lastUserModify;
	}

	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getNumberOfAtomic() {
		return numberOfAtomic;
	}

	public void setNumberOfAtomic(float numberOfAtomic) {
		this.numberOfAtomic = numberOfAtomic;
	}

	public String getAtomicVolume() {
		return atomicVolume;
	}

	public void setAtomicVolume(String atomicVolume) {
		this.atomicVolume = atomicVolume;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getElectronConfiguration() {
		return electronConfiguration;
	}

	public void setElectronConfiguration(String electron_configuration) {
		this.electronConfiguration = electron_configuration;
	}

	public String getLayers() {
		return layers;
	}

	public void setLayers(String layers) {
		this.layers = layers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
