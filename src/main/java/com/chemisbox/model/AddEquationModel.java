package com.chemisbox.model;

import java.io.Serializable;

import com.chemisbox.entity.Equation;
import com.chemisbox.entity.IonEquation;
import com.chemisbox.entity.OxiReduceEquation;

public class AddEquationModel extends ChemisboxModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6762587993487211433L;
	private Equation equation;
	private IonEquation ion;
	private OxiReduceEquation oxiReduce;

	public Equation getEquation() {
		return equation;
	}

	public void setEquation(Equation equation) {
		this.equation = equation;
	}

	public IonEquation getIon() {
		return ion;
	}

	public void setIon(IonEquation ion) {
		this.ion = ion;
	}

	public OxiReduceEquation getOxiReduce() {
		return oxiReduce;
	}

	public void setOxiReduce(OxiReduceEquation oxiReduce) {
		this.oxiReduce = oxiReduce;
	}

}
