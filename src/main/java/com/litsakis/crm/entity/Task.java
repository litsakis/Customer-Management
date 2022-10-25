package com.litsakis.crm.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@ManyToOne(cascade= {CascadeType.PERSIST , CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="title")
	private String title;
	
	@Column(name="taskdescription")
	private String taskDescription;
	
	@Column(name="creationdate")
	LocalDateTime  creationDate;
	
	@Column(name="status")
	private int statusId;

	
	public  Task () {}


	public Task(Customer customer, String title, String taskDescription, LocalDateTime creationDate, int statusId) {
		this.customer = customer;
		this.title = title;
		this.taskDescription = taskDescription;
		this.creationDate = creationDate;
		this.statusId = statusId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
}