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
@Table(name = "oxi_reduce")
public class OxiReduceEquation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oxi_id")
	private Long oxiReduceId;

	@Column(name = "mol_reduce")
	private int molReduce;

	@Column(name = "reduce_equation")
	private String reduceEquation;

	@Column(name = "mol_oxi")
	private int molOxi;

	@Column(name = "oxi_equation")
	private String oxiEquation;

	@Column(name = "summary")
	private String summary;
	
	@JsonIgnore
	@OneToMany(mappedBy = "oxiReduceEquation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Equation> equations = new ArrayList<Equation>();

	
	public List<Equation> getEquations() {
		return equations;
	}

	public void setEquations(List<Equation> equations) {
		this.equations = equations;
	}

	public Long getOxiReduceId() {
		return oxiReduceId;
	}

	public void setOxiReduceId(Long oxiReduceId) {
		this.oxiReduceId = oxiReduceId;
	}

	public int getMolReduce() {
		return molReduce;
	}

	public void setMolReduce(int molReduce) {
		this.molReduce = molReduce;
	}

	public String getReduceEquation() {
		return this.reduceEquation;
	}

	public void setReduceEquation(String reduceEquation) {
		this.reduceEquation = reduceEquation;
	}

	public int getMolOxi() {
		return molOxi;
	}

	public void setMolOxi(int molOxi) {
		this.molOxi = molOxi;
	}

	public String getOxiEquation() {
		return oxiEquation;
	}

	public void setOxiEquation(String oxiEquation) {
		this.oxiEquation = oxiEquation;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
		;
	}

}
