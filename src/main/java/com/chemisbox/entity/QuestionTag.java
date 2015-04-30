package com.chemisbox.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_question_tag")
@IdClass(value = QuestionTag.ClassId.class)
public class QuestionTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@Id
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	static class ClassId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Question question;
		private Tag tag;

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public Tag getTag() {
			return tag;
		}

		public void setTag(Tag tag) {
			this.tag = tag;
		}

	}

}
