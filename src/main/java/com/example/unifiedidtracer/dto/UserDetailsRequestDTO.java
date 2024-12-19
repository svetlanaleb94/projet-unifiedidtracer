package com.example.unifiedidtracer.dto;

import com.example.unifiedidtracer.core.model.UserDetails;

/**
 * Data Transfer Object (DTO) for holding user details required for ID generation.  
 * 
 * This class encapsulates user-specific information that serves as input for generating unique identifiers.
 */
public class UserDetailsRequestDTO {

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

	/**
	 * Converts the current DTO into a UserDetails model.  
	 * 
	 * @return An instance of UserDetails containing user-specific information for ID generation.
	 */
	public UserDetails toModel() {

		return new UserDetails(lastName, firstName, dateOfBirth);

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
