package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.EligibilityDetailEntity;
import in.ashokit.model.EligibilityDetailModel;
import in.ashokit.repository.EligibilityDetailsRepository;

@Service("edDetailService")
public class EligibilityDetailServiceImpl implements EligibilityDetailService {

	@Autowired
	private EligibilityDetailsRepository eligRepository;

	@Override
	public EligibilityDetailModel findByCaseNum(Long caseNum) {
		EligibilityDetailEntity entity = eligRepository.findByCaseNum(caseNum);
		EligibilityDetailModel model = null;
		if (entity != null) {
			model = new EligibilityDetailModel();
			BeanUtils.copyProperties(entity, model);
		}

		return model;
	}

}
