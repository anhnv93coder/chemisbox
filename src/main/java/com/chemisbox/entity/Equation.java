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

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
		@NamedNativeQuery(name = "callGetEquation", query = "CALL getEquation(:chemical, :startIndex, :pageSize)", resultClass = Equation.class),

		@NamedNativeQuery(name = "callGetEquationByChemical", query = "CALL getEquationByChemical(:chemical, :typeOf, :startIndex, :pageSize)", resultClass = Equation.class),

		@NamedNativeQuery(name = "callGetEquationsByLeftRight", query = "CALL getEquationByLeftAndRightChemical(:leftChemical, :rightChemical)", resultClass = Equation.class),

		@NamedNativeQuery(name = "callGetEquationBy2Chemical", query = "CALL getEquationBy2Chemical(:chemical1, :chemical2, :typeOf, :startIndex, :pageSize)", resultClass = Equation.class),

		@NamedNativeQuery(name = "callGetEquationBy3Chemical", query = "CALL getEquationBy3Chemical(:chemical1, :chemical2, :chemical3, :typeOf, :startIndex, :pageSize)", resultClass = Equation.class)

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

	@Column(name = "ion_equation")
	private String ionEquation;

	@Column(name = "shortcut_ion_equation")
	private String shortcutIonEquation;

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

	@Column(name = "active")
	private int active;

	@Column(name = "created_date", insertable = false, updatable = false)
	private Date createdDate;

	@Column(name = "edited_date", insertable = false)
	private Date editedDate;

	@Column(name = "last_user_modify")
	private String lastUserModify;

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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

	public String getLastUserModify() {
		return lastUserModify;
	}

	public void setLastUserModify(String lastUserModify) {
		this.lastUserModify = lastUserModify;
	}

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

	public int getMolReduce() {
		return molReduce;
	}

	public void setMolReduce(int molReduce) {
		this.molReduce = molReduce;
	}

	public String getReduceEquation() {
		return reduceEquation;
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
	}

}
