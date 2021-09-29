package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.model.EligibilityDetailModel;

@Service
public interface EligibilityDetailService {

	public EligibilityDetailModel findByCaseNum(Long caseNum);

}
