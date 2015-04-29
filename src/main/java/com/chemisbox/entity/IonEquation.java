package com.chemisbox.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ion_equation")
public class IonEquation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ion_id")
	private Long ionId;

	@Column(name = "ion_equation")
	private String ionEquation;

	@Column(name = "shortcut_ion_equation")
	private String shortcutIonEquation;

	/*@JsonIgnore
	@OneToMany(mappedBy = "ionEquation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Equation> equations = new ArrayList<Equation>();*/

	public IonEquation() {
		// TODO Auto-generated constructor stub
	}

	public IonEquation(String ionEquation, String shortcutIonEquation) {
		super();
		this.ionEquation = ionEquation;
		this.shortcutIonEquation = shortcutIonEquation;
	}

	/*
	public List<Equation> getEquations() {
		return equations;
	}

	public void setEquations(List<Equation> equations) {
		this.equations = equations;
	}*/

	public Long getIonId() {
		return ionId;
	}

	public void setIonId(Long ionId) {
		this.ionId = ionId;
	}

	public String getIonEquation() {
		return ionEquation;
	}

	public void setIonEquation(String ionEquation) {
		this.ionEquation = ionEquation;
	}

	public String getShortcutIonEquation() {
		return shortcutIonEquation;
	}

	public void setShortcutIonEquation(String shortcutIonEquation) {
		this.shortcutIonEquation = shortcutIonEquation;
	}

}
