package com.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserBean {

	@Pattern(regexp  = "[a-zA-Z]+")
	@NotBlank(message = "Please Enter FirstName")
	private String firstName;
	
	@Pattern(regexp = "[a-zA-Z]+")
	@NotBlank(message = "Please Enter LastName")
	private String lastName;
	
	@Pattern(regexp = "[a-zA-Z0-9_]+@[a-zA-Z]\\.[a-zA-Z]{2,3}")
	private String email;
	
	@Length(min = 8,max = 25,message = "Password must be >=8 and <=25 in length")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
