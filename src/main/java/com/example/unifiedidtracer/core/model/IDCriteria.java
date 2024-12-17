package com.example.unifiedidtracer.core.model;

/**
 * Model class representing the criteria for ID generation.  
 * 
 * This class defines the parameters and rules used to generate unique identifiers.
 */
public class IDCriteria {

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
	
	public IDCriteria(String type, int length, String prefix, String suffix, int order,String formatDate,  int initialCounter, int counterFormat) {
		this.type = type;
		this.length = length;
		this.prefix= prefix;
		this.suffix = suffix;
		this.order = order;
		this.formatDate = formatDate;
		this.initialCounter = initialCounter;
		this.counterFormat = counterFormat;
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

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	} 

}
