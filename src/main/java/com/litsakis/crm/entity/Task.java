package com.litsakis.crm.entity;

import java.time.Instant;
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

import org.hibernate.annotations.CreationTimestamp;

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
	
    @CreationTimestamp
	@Column(name="creationdate")
	private Instant  creationDate;
	
	@Column(name="status")
	private int statusId;

	
	public  Task () {}


	public Task(Customer customer, String title, String taskDescription, Instant creationDate, int statusId) {
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
	
	/*public String getCustomerName() {
		return customer.getLastName()+" "+customer.getFirstName();
	}*/

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

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	 
	 
	
}