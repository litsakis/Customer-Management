package com.litsakis.crm.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="cusid")
	private int cusid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="taskdescription")
	private String taskDescription;
	
	@Column(name="creationDate")
	LocalDateTime  creationDate;
	
	public  Tasks () {}

	public Tasks(int cusid, String title, String taskdescr) {
		this.cusid = cusid;
		this.title = title;
		this.taskDescription = taskdescr;
		this.creationDate=LocalDateTime.now();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskdescr() {
		return taskDescription;
	}

	public void setTaskdescr(String taskdescr) {
		this.taskDescription = taskdescr;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	
}
