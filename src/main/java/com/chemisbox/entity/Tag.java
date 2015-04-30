package com.chemisbox.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_tag")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tag_id")
	private int tagId;
	
	@Column(name = "tag_name")
	private String tagName;
	
	@Column(name = "created_date")
	private Date createdDate;

	@JsonIgnore
	@OneToMany(mappedBy = "tag", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<QuestionTag> questionTagList = new ArrayList<QuestionTag>();
	
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
