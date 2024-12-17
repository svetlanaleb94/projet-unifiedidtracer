package com.example.unifiedidtracer.core.model;

/**
 * Represents a user's details for ID generation.
 */ 
public class UserDetails {	
	
	/**
	 * User's last name.
	 */
	private String lastName;
	/**
	 * User's first name.
	 */
	private String firstName;
	/**
	 * User's date of birth. Format : yyyy-MM-dd
	 */
	private String dateOfBirth; 
	
	public UserDetails(String lastName, String firstName, String dateOfBirth) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
