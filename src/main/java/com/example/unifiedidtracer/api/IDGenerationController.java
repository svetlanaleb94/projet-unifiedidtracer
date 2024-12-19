package com.example.unifiedidtracer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.unifiedidtracer.core.service.IDGenerationService;
import com.example.unifiedidtracer.dto.*;
import com.example.unifiedidtracer.exceptions.InvalidCriteriaException;

/**
 * REST controller for managing ID generation.
 */
@RestController
@RequestMapping("/api/idgeneration")
public class IDGenerationController {

	@Autowired
	private IDGenerationService idGenerationService;

	/**
	 * Endpoint to configure ID generation criteria.
	 * 
	 * @param criteriaList List of criteria for ID generation.
	 * @return Success message.
	 */
	@PostMapping("/configure")
	public String configureCriteria(@RequestBody List<CriteriaRequestDTO> criteriaList) {
		String result = "ID generation criteria configured successfully.";
		try {
			idGenerationService.configureCriteria(criteriaList.stream().map(CriteriaRequestDTO::toModel).toList());
		} catch (InvalidCriteriaException e) {
			result = "An exception has occurred during criteria creation. Please review the criteria.";
		}
		return result;
	}

	/**
	 * Endpoint to generate an ID for a user.
	 * 
	 * @param userDetailsRequest User details.
	 * @return Generated ID.
	 */

	@PostMapping("/generate")
	public String generateID(@RequestBody UserDetailsRequestDTO userDetailsRequest) {
		return idGenerationService.generateID(userDetailsRequest.toModel());
	}
	
	
	/**
	 * Endpoint to provide help information about the API.
	 * 
	 * @return A message containing API usage instructions.
	 */
	@GetMapping("/help")
    public String help(){
        return "<html>API offers services<br>"
        		+ "\r\n"
        		+ " <br><b>/configure</b>  - configure the numbering criteria by WebService\r\n"
        		+ "\r\n"
        		+ " <br><b>/generate</b>  - generate a number according to the data of a registrant (last name / first name / date of birth (yyyy-MM-dd)/ counter) by WebService</html>";
    }

}
