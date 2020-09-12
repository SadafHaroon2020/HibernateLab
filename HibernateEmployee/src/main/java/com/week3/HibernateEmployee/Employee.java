package com.week3.HibernateEmployee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mod3employee")
public class Employee {
	
	public Employee() {
	}
	
	 @Id
	    @GeneratedValue
	    @Column(name= "emp_id")
	    private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee( String firstName, String lastName, String company) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Mod3Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ "]";
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name="comapny")
	private String company;
	
	
	/*Table: Employee

Columns

- first_name : varchar

- last_name: varchar

- company : varchar

 

Create the database table.
Set up the Hibernate configuration file.
Create a Java class (entity) with Hibernate annotations.done
Develop a main application.
Develop code to save objects.
Develop code to retrieve an object by primary key.
Develop code to query objects to find employees for a given company.
Develop code to delete an object by primary key.*/

}
