package com.chemisbox.entity;

import java.io.Serializable;

public class Element  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notation;
	private String name;
	private float numberOfAtomic;
	private String atomicValue;
	private String classify;
	private String group;
	private String cycle;
	private String electronConfiguration;
	private String layers;
	private String description;
	private String color;
	private String condition;
	private String meltingTemperature;
	private String boilingTemperature;
	private String img;

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

	public String getAtomicValue() {
		return atomicValue;
	}

	public void setAtomicValue(String atomicValue) {
		this.atomicValue = atomicValue;
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
