package com.usa.ri.gov.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.stereotype.Service;

import com.usa.ri.gov.bindings.IndvInfo;
import com.usa.ri.gov.bindings.PlanInfo;

@Service
public class SNAPRulesExecutor implements IRuleService {

	@Override
	public PlanInfo executeRules(IndvInfo indvInfo) {
		PlanInfo planInfo = null;
		try {
			InputStream is = getClass().getResourceAsStream("/com/ed/rules/SNAP.drl");
			Reader reader = new InputStreamReader(is);

			PackageBuilder packageBuilder = new PackageBuilder();
			packageBuilder.addPackageFromDrl(reader);

			org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();

			RuleBase ruleBase = RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulesPackage);

			// Firing Rules
			WorkingMemory workingMemory = ruleBase.newStatefulSession();
			workingMemory.insert(indvInfo);
			workingMemory.fireAllRules();
			planInfo = indvInfo.getPlanInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return planInfo;
	}
}
