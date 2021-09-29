package com.ashok.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.ashok.model.Product;

public class DroolsTest {

	public static void main(String[] args) throws Exception {
		DroolsTest test = new DroolsTest();
		test.executeDrools();
	}

	public void executeDrools() throws DroolsParserException, IOException {
		Product product = new Product();
		product.setType("diamond");

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		Reader reader = new InputStreamReader(resourceAsStream);

		PackageBuilder packageBuilder = new PackageBuilder();
		packageBuilder.addPackageFromDrl(reader);

		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		workingMemory.insert(product); //setting input data for rules execution
		
		workingMemory.fireAllRules(); //Rules will execute here

		System.out.println("The discount for the product " + product.getType() + " is " + product.getDiscount());
	}
}
