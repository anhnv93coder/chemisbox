package com.chemisbox.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "chemistry_equation")
@IdClass(value = ChemistryEquation.ClassId.class)
public class ChemistryEquation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChemistryEquation() {
		numberOfAtomic = 1;
	}
	@Id
	@Column(name = "equation_id")
	private long equationId;

	@Column(name = "number_of_atomic", columnDefinition = "int default 100")
	private int numberOfAtomic;

	@Id
	@Column(name = "chemical_id")
	private long chemicalId;
	
	@Column(insertable = false, updatable = false)
	private String chemicalFormula;

	@Column(name = "chemical_typeof")
	private int chemicalTypeof;

	@Column(name = "`condition`")
	private String condition;

	public long getEquationId() {
		return equationId;
	}

	public String getChemicalFormula() {
		return chemicalFormula;
	}

	public void setChemicalFormula(String chemicalFormula) {
		this.chemicalFormula = chemicalFormula;
	}

	public void setEquationId(long equationId) {
		this.equationId = equationId;
	}

	public long getChemicalId() {
		return chemicalId;
	}

	public void setChemicalId(long chemicalId) {
		this.chemicalId = chemicalId;
	}

	public int getChemicalTypeof() {
		return chemicalTypeof;
	}

	public void setChemicalTypeof(int chemicalTypeof) {
		this.chemicalTypeof = chemicalTypeof;
	}

	public int getNumberOfAtomic() {
		return numberOfAtomic;
	}

	public void setNumberOfAtomic(int numberOfAtomic) {
		this.numberOfAtomic = numberOfAtomic;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	static class ClassId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private long equationId;
		private long chemicalId;

		public long getEquationId() {
			return equationId;
		}

		public void setEquationId(long equationId) {
			this.equationId = equationId;
		}

		public long getChemicalId() {
			return chemicalId;
		}

		public void setChemicalId(long chemicalId) {
			this.chemicalId = chemicalId;
		}

	}

}
