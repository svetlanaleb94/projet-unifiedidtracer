package com.example.unifiedidtracer.core.service;

import java.util.List;

import com.example.unifiedidtracer.core.model.IDCriteria;
import com.example.unifiedidtracer.core.model.UserDetails;
import com.example.unifiedidtracer.exceptions.InvalidCriteriaException;

/**
 * Service interface for ID generation.  
 * 
 * This interface defines the contract for implementing ID generation logic 
 * based on specific criteria or user details.
 */
public interface IDGenerationService {

	/**
	 * Generates a unique ID for a given user.
	 * 
	 * @param userDetails The user's details.
	 * @return The generated unique ID.
	 */

	String generateID(UserDetails userDetails);
	
	/**
	 * Configures the ID generation criteria.
	 * 
	 * @param criteriaList List of criteria for ID generation.
	 */
	void configureCriteria(List<IDCriteria> criteriaList) throws InvalidCriteriaException;

}
