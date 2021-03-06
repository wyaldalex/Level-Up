package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the quizzes database table.
 * 
 */
@Entity
@NamedQuery(name="Quizzes.findAll", query="SELECT q FROM Quizzes q")
public class Quizzes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_quiz")
	private int idQuiz;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private int status;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Questions
	@OneToMany(mappedBy="quizze")
	private List<Questions> questions;

	//bi-directional many-to-one association to ProgrammingLanguage
	@ManyToOne
	@JoinColumn(name="id_language")
	private ProgrammingLanguage programmingLanguage;

	//bi-directional many-to-one association to QuizLevels
	@ManyToOne
	@JoinColumn(name="id_level")
	private QuizLevels quizLevel;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_amin")
	private Users user;

	//bi-directional many-to-one association to Tests
	@OneToMany(mappedBy="quizze")
	private List<Tests> tests;

	public Quizzes() {
	}

	public int getIdQuiz() {
		return this.idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Questions> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public Questions addQuestion(Questions question) {
		getQuestions().add(question);
		question.setQuizze(this);

		return question;
	}

	public Questions removeQuestion(Questions question) {
		getQuestions().remove(question);
		question.setQuizze(null);

		return question;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return this.programmingLanguage;
	}

	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public QuizLevels getQuizLevel() {
		return this.quizLevel;
	}

	public void setQuizLevel(QuizLevels quizLevel) {
		this.quizLevel = quizLevel;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Tests> getTests() {
		return this.tests;
	}

	public void setTests(List<Tests> tests) {
		this.tests = tests;
	}

	public Tests addTest(Tests test) {
		getTests().add(test);
		test.setQuizze(this);

		return test;
	}

	public Tests removeTest(Tests test) {
		getTests().remove(test);
		test.setQuizze(null);

		return test;
	}

}