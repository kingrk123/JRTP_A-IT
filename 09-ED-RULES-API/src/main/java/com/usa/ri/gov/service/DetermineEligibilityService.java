package com.usa.ri.gov.service;

import java.lang.reflect.Method;

import org.apache.catalina.ssi.ResponseIncludeWrapper;
import org.springframework.stereotype.Service;

import com.usa.ri.gov.bindings.IndvInfo;
import com.usa.ri.gov.bindings.PlanInfo;

@Service("eligService")
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(IndvInfo indvInfo) {
		String planName = indvInfo.getPlanName();
		PlanInfo planInfo = null;

		/*if (planName.equals("SNAP")) {
			SNAPRulesExecutor snap = new SNAPRulesExecutor();
			return snap.executeRules(indvInfo);
		} else if (planName.equals("CCAP")) {
			CCAPRulesExecutor ccap = new CCAPRulesExecutor();
			return ccap.executeRules(indvInfo);
		} else if (planName.equals("MEDICAID")) {
			MedicaidRulesExecutor medicaid = new MedicaidRulesExecutor();
			return medicaid.executeRules(indvInfo);
		}*/
		
		try {
			String clzName = "com.usa.ri.gov.service." + planName + "RulesExecutor";
			
			Class<?> clz = Class.forName(clzName);
			
			Method method = clz.getDeclaredMethod("executeRules", IndvInfo.class);
			
			Object object = clz.newInstance();
			
			planInfo =  (PlanInfo) method.invoke(object, indvInfo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return planInfo;
	}
}
