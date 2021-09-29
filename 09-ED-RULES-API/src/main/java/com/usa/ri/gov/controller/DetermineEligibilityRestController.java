package com.usa.ri.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ri.gov.bindings.IndvInfo;
import com.usa.ri.gov.bindings.PlanInfo;
import com.usa.ri.gov.service.DetermineEligibilityService;

@RestController
public class DetermineEligibilityRestController {

	@Autowired
	private DetermineEligibilityService eligService;

	@PostMapping(
		value = "/rules", 
		produces = { "application/xml", "application/json" },
		consumes= {"application/xml", "application/json"}
	)
	public PlanInfo checkPlanEligibility(@RequestBody IndvInfo indvInfo) {
		PlanInfo planInfo = eligService.determineEligibility(indvInfo);
		return planInfo;
	}
}
