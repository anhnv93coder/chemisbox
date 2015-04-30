package com.chemisbox.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_answer")
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "answer_id")
	private int answerId;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name = "email")
	private User user;
	
	@Column(name = "votes")
	private int votes;
	
	@Column(name = "answer_date")
	private Date answer_date;
	
	@Column(name = "edited_date")
	private Date edited_date;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Date getAnswer_date() {
		return answer_date;
	}

	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}

	public Date getEdited_date() {
		return edited_date;
	}

	public void setEdited_date(Date edited_date) {
		this.edited_date = edited_date;
	}

}
