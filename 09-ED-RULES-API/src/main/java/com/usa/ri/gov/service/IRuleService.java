package com.usa.ri.gov.service;

import com.usa.ri.gov.bindings.IndvInfo;
import com.usa.ri.gov.bindings.PlanInfo;

public interface IRuleService {

	public PlanInfo executeRules(IndvInfo indvInfo);

}
