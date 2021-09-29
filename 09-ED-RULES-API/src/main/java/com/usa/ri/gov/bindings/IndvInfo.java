package com.usa.ri.gov.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IndvInfo {

	private String indvFirstName;
	private String indvLastName;
	private String indvDob;
	private String planName;
	private String isEmployed;
	
	private PlanInfo planInfo;

}
