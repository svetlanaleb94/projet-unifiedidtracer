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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public int getInitialCounter() {
		return initialCounter;
	}

	public void setInitialCounter(int initialCounter) {
		this.initialCounter = initialCounter;
	}

	public int getCounterFormat() {
		return counterFormat;
	}

	public void setCounterFormat(int counterFormat) {
		this.counterFormat = counterFormat;
	}

}
