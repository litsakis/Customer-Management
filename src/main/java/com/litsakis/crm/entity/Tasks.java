package com.litsakis.crm.entity;

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
	
	@Column(name="taskdescr")
	private String taskdescr;
	
	public  Tasks () {}

	public Tasks(int cusid, String title, String taskdescr) {
		this.cusid = cusid;
		this.title = title;
		this.taskdescr = taskdescr;
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
		return taskdescr;
	}

	public void setTaskdescr(String taskdescr) {
		this.taskdescr = taskdescr;
	}
	
	
	
	
}
