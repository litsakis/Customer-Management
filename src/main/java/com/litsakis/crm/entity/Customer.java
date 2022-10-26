package com.litsakis.crm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Customer {

 
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="customer",
			cascade= {CascadeType.PERSIST , CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH})
	/*@OneToMany(
			cascade= {CascadeType.PERSIST , CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH})*/
	private List<Task> tasks;
	
	//define constructors
	public Customer() {}
 
	public Customer(String firstNAme, String lastName, String email) {
		this.firstName = firstNAme;
		this.lastName = lastName;
		this.email = email;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}
