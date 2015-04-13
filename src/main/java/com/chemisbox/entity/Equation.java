package com.chemisbox.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(name = "callGetEquationByChemical", query = "CALL getEquationByChemical(:chemical, :typeOf)", resultClass = Equation.class),

	@NamedNativeQuery(name = "callGetEquationsByLeftRight", query = "CALL getEquationByLeftAndRightChemical(:leftChemical, :rightChemical)", resultClass = Equation.class),
		
	@NamedNativeQuery(name = "callGetEquationBy2Chemical", query = "CALL getEquationBy2Chemical(:chemical1, :chemical2, :typeOf)", resultClass = Equation.class),
	
	@NamedNativeQuery(name = "callGetEquationBy3Chemical", query = "CALL getEquationBy3Chemical(:chemical1, :chemical2, :chemical3, :typeOf)", resultClass = Equation.class)

})
@Embeddable
@Entity
@Table(name = "equation", catalog = "chemisbox")
public class Equation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equation_id", unique = true, nullable = false)
	private Long equationId;

	@Column(name = "`desc`")
	private String description;

	@Column(name = "equation")
	private String equation;

	@Column(name = "`condition`")
	private String condition;

	@Column(name = "video_link")
	private String videoLink;

	@ManyToOne
	@JoinColumn(name = "ion_id")
	private IonEquation ionEquation;

	@ManyToOne
	@JoinColumn(name = "oxi_id")
	private OxiReduceEquation oxiReduceEquation;

	public Long getEquationId() {
		return equationId;
	}

	public void setEquationId(Long equationId) {
		this.equationId = equationId;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public IonEquation getIonEquation() {
		return ionEquation;
	}

	public void setIonEquation(IonEquation ionEquation) {
		this.ionEquation = ionEquation;
	}

	public OxiReduceEquation getOxiReduceEquation() {
		return oxiReduceEquation;
	}

	public void setOxiReduceEquation(OxiReduceEquation oxiReduceEquation) {
		this.oxiReduceEquation = oxiReduceEquation;
	}

}
