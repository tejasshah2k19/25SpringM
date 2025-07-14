package com.bean;

import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeBean {

	@NotBlank(message = "Please Enter FirstName")
	@Pattern(regexp = "[a-zA-Z]+",message = "Please Enter Valid FirstName")
	String firstName;

	@NotBlank(message = "Please Enter LastName")
	String lastName;

	@NotBlank(message = "Please Enter Email")
	@Email(message = "Invalid Email Format") // XXX@XXX
	String email;
	@NotBlank(message = "Please Enter Password")
	String password;

	@NotBlank(message = "Please Confirm Password")
	String confirmPassword;

	@NotNull(message = "Please Enter 4-digit MPIN")
	@Digits(integer = 4, fraction = 0, message = "MPIN must be digits only")
	@Min(value = 1000, message = "MPIN must be 4 digits")
	@Max(value = 9999, message = "MPIN must be 4 digits")
	Integer mpin;

	@NotBlank(message = "Please Select Gender")
	String gender;

	@Size(min = 2, message = "Select at least two hobbies")
	private List<String> hobby;

	@NotBlank(message = "Please Select City")
	String city;

	public boolean isPasswordMatching() {
		return password != null && password.equals(confirmPassword);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Integer getMpin() {
		return mpin;
	}

	public void setMpin(Integer mpin) {
		this.mpin = mpin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
