package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CoBatchRunDetailsEntity;
import in.ashokit.entity.CoBatchSummaryEntity;
import in.ashokit.entity.CoPdfEntity;
import in.ashokit.entity.CoTriggersEntity;
import in.ashokit.model.CoBatchRunDetailsModel;
import in.ashokit.model.CoBatchSummaryModel;
import in.ashokit.model.CoPdfModel;
import in.ashokit.model.CoTriggersModel;
import in.ashokit.repository.CoBatchRunDetailsRepository;
import in.ashokit.repository.CoBatchSummaryRepository;
import in.ashokit.repository.CoPdfRepository;
import in.ashokit.repository.CoTriggersDao;
import in.ashokit.repository.CoTriggersRepository;

@Service("coBatchService")
public class CoBatchServiceImpl implements CoBatchService {

	@Autowired
	private CoBatchRunDetailsRepository coBatchRunDetailRepo;

	@Autowired
	private CoTriggersRepository coTrgRepository;

	@Autowired
	private CoTriggersDao coTrgDao;

	@Autowired
	private CoBatchSummaryRepository coBatchSummaryRepo;

	@Autowired
	private CoPdfRepository coPdfRepository;

	@Override
	public CoBatchRunDetailsModel insertBatchRunDetails(CoBatchRunDetailsModel model) {
		CoBatchRunDetailsEntity entity = new CoBatchRunDetailsEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setStartDate(new java.util.Date());
		CoBatchRunDetailsEntity savedEntity = coBatchRunDetailRepo.save(entity);

		// setting pk value to model
		model.setRunSeq(savedEntity.getRunSeq());
		return model;
	}

	@Override
	public CoBatchRunDetailsModel findByRunSeqNum(Integer runSeqNum) {
		CoBatchRunDetailsEntity entity = coBatchRunDetailRepo.findById(runSeqNum).get();
		CoBatchRunDetailsModel model = new CoBatchRunDetailsModel();
		BeanUtils.copyProperties(entity, model);
		return model;
	}

	@Override
	public List<CoTriggersModel> findPendingTriggers(Integer totalBuckets, Integer instanceNum) {
		List<CoTriggersEntity> entities = coTrgDao.findPendTrgrsWithOraHash("P", totalBuckets, instanceNum);
		List<CoTriggersModel> models = new ArrayList();
		for (CoTriggersEntity entity : entities) {
			CoTriggersModel model = new CoTriggersModel();
			BeanUtils.copyProperties(entity, model);
			models.add(model);
		}

		return models;
	}

	@Override
	public List<CoTriggersModel> findPendingTriggers() {
		List<CoTriggersEntity> entities = coTrgDao.findPendTrgrs("P");
		List<CoTriggersModel> models = new ArrayList<>();
		for (CoTriggersEntity entity : entities) {
			CoTriggersModel model = new CoTriggersModel();
			BeanUtils.copyProperties(entity, model);
			models.add(model);
		}

		return models;
	}

	@Override
	public CoPdfModel savePdf(CoPdfModel model) {
		CoPdfEntity entity = null;
		Integer pdfId = null;
		entity = new CoPdfEntity();
		// convert model to entity
		BeanUtils.copyProperties(model, entity);
		// call repository method
		pdfId = coPdfRepository.save(entity).getCoPdfId();
		model.setCoPdfId(pdfId);
		return model;
	}

	@Override
	public boolean updatePendingTrigger(CoTriggersModel model) {
		CoTriggersEntity trgEntity = coTrgRepository.findById(model.getTriggerId()).get();
		trgEntity.setUpdatedDate(new java.util.Date());
		trgEntity.setTriggerStatus("C");
		coTrgRepository.save(trgEntity);
		return true;
	}

	@Override
	public CoBatchRunDetailsModel updateBatchRunDetails(CoBatchRunDetailsModel model) {
		CoBatchRunDetailsEntity entity = new CoBatchRunDetailsEntity();
		BeanUtils.copyProperties(model, entity);
		coBatchRunDetailRepo.save(entity);
		return model;
	}

	@Override
	public CoBatchSummaryModel saveBatchSummary(CoBatchSummaryModel model) {
		CoBatchSummaryEntity entity = new CoBatchSummaryEntity();
		BeanUtils.copyProperties(model, entity);
		entity = coBatchSummaryRepo.save(entity);
		model.setSummaryId(entity.getSummaryId());
		return model;
	}

}
