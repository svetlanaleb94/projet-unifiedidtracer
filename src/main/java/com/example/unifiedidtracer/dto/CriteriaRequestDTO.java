package com.example.unifiedidtracer.dto;

import com.example.unifiedidtracer.core.model.IDCriteria;

/**
 * Data Transfer Object (DTO) for representing ID generation criteria.  
 * 
 * This class encapsulates the parameters and rules required for generating unique identifiers.
 */
public class CriteriaRequestDTO {

	/** e.g., lastName, firstName, dateOfBirth, counter */
	private String type;

	/** Maximum length for truncation */
	private int length;

	/** Prefix to add */
	private String prefix;

	/** Suffix to add */
	private String suffix;

	/** Order of application */
	private int order;
	
	/** Format date */
	private String formatDate;
	
	/** Initial value for the counter */
	private int initialCounter;
	
	/** Number of digits for the counter */
	private int counterFormat;

	/**
	 * Converts the current DTO into an IDCriteria model.  
	 * 
	 * @return An instance of IDCriteria representing the criteria for ID generation.
	 */
	public IDCriteria toModel() {

		return new IDCriteria(type, length, prefix, suffix, order, formatDate, initialCounter, counterFormat);

	}

}
