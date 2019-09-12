package com.poc;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	@Size(min=1,message="required") 
	private String name;
	
	@Size(min=1,message="required") 
	@Email(message="required") 
	private String email;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Past
	private Date dateOfBirth;
	
	@Size(min=3,max=10,message="length must be between 3 and 10") 
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(String name, String email, Date dateOfBirth, String password) {
		super();
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ "]";
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
