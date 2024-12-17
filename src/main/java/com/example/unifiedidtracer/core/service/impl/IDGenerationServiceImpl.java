package com.example.unifiedidtracer.core.service.impl;

import com.example.unifiedidtracer.core.model.*;
import com.example.unifiedidtracer.core.service.IDGenerationService;
import com.example.unifiedidtracer.utils.FormatDateUtil;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

/**
 * Implementation of the IDGenerationService.
 */
@Service
public class IDGenerationServiceImpl implements IDGenerationService {

	private List<IDCriteria> criteriaList;
	private int counter;

	public IDGenerationServiceImpl() {

		this.counter = 0;
	}

	/**
	 * Configures the ID generation criteria.
	 * 
	 * @param criteriaList List of criteria for ID generation.
	 */

	public void configureCriteria(List<IDCriteria> criteriaList) {
		this.criteriaList = criteriaList.stream().sorted((c1, c2) -> Integer.compare(c1.getOrder(), c2.getOrder()))
				.collect(Collectors.toList());
		IDCriteria counterCriteria = criteriaList.stream()
                .filter(criteria -> "counter".equals(criteria.getType()))
                .findFirst()
                .orElse(null);
		 if (counterCriteria != null) {
			 this.counter = counterCriteria.getInitialCounter();
		 }
		

	}

	/**
	 * Generates a unique identifier based on user details and configuration criteria.
	 * 
	 * @param userDetails Object containing user-specific information.
	 * @return A unique string identifier generated from the provided user details.
	 */
	public String generateID(UserDetails userDetails) {
		StringBuilder id = new StringBuilder();
		for (IDCriteria criteria : criteriaList) {
			switch (criteria.getType()) {
			case "lastName": {
				id.append(applyCriteria(userDetails.getLastName().toUpperCase(), criteria, false));
				break;
			}
			case "firstName": {

				id.append(applyCriteria(userDetails.getFirstName().toUpperCase(), criteria, false));
				break;
			}
			case "dateOfBirth": {
				id.append(
						applyCriteria(FormatDateUtil.formatDate(userDetails.getDateOfBirth(), criteria.getFormatDate()),
								criteria, true));
				break;
			}
			case "counter": {
				String formattedCounter = String.format("%0" + criteria.getCounterFormat() + "d", ++counter);
				id.append(applyCriteria(formattedCounter, criteria, true));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + criteria.getType());
			}
		}
		return id.toString();
	}

	private String applyCriteria(String value, IDCriteria criteria, boolean isTrancated) {
		String truncated = isTrancated ? value : value.substring(0, Math.min(value.length(), criteria.getLength()));
		return criteria.getPrefix() + truncated + criteria.getSuffix();
	}

}
