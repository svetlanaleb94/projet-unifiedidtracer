package com.example.unifiedidtracer;



import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unifiedidtracer.core.model.IDCriteria;
import com.example.unifiedidtracer.core.model.UserDetails;
import com.example.unifiedidtracer.core.service.IDGenerationService;
import com.example.unifiedidtracer.exceptions.InvalidCriteriaException;

@SpringBootTest
class UnifiedidtracerApplicationTests {

	@Autowired
	private IDGenerationService service;	
	
	@Test
	void testIdGenerationServiceTestCases1() {
		List<IDCriteria> criteriaList = List.of(
	            new IDCriteria("lastName", 3, "", "-", 1,"", 0, 0),
	            new IDCriteria("firstName", 4, "", "_", 2,"", 0, 0),
	            new IDCriteria("dateOfBirth", 0, "", "", 3,"YYYY", 0, 0),
	            new IDCriteria("counter", 0, "C", "", 4,"",10, 5)
	        );
		
		try {
			service.configureCriteria(criteriaList);
		} catch (InvalidCriteriaException e) {
			Assert.assertNotNull(e.getMessage());
		}
		UserDetails userDetails = new UserDetails("Marc", "PASSAU", "1974-04-24");
		Assert.assertEquals("MAR-PASS_1974C00011", service.generateID(userDetails));
		
		userDetails = new UserDetails("Svetlana", "LEBEDEVA", "1985-04-24");
		Assert.assertEquals("SVE-LEBE_1985C00012", service.generateID(userDetails));
	}
	
	@Test
	 void testIdGenerationServiceTestCases2() { 
		List<IDCriteria> criteriaList = List.of(
	            new IDCriteria("lastName", 3, "", "-", 2,"", 0, 0),
	            new IDCriteria("firstName", 4, "", "_", 1,"", 0, 0),
	            new IDCriteria("dateOfBirth", 0, "N", "", 4,"YYYY", 0, 0),
	            new IDCriteria("counter", 0, "C", "", 3,"",7, 5)
	        );
		UserDetails userDetails = new UserDetails("Isaac", "ANTOINE", "1992-04-24");
		try {
			service.configureCriteria(criteriaList);
		} catch (InvalidCriteriaException e) {
			Assert.assertNotNull(e.getMessage());
		}
		Assert.assertEquals("ANTO_ISA-C00008N1992", service.generateID(userDetails));
		
	}
}
