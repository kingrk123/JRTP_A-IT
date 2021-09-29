package in.ashokit.service;

import java.util.List;

import in.ashokit.model.CoBatchRunDetailsModel;
import in.ashokit.model.CoBatchSummaryModel;
import in.ashokit.model.CoPdfModel;
import in.ashokit.model.CoTriggersModel;

public interface CoBatchService {

	// Before starting batch this method should execute
	public CoBatchRunDetailsModel insertBatchRunDetails(CoBatchRunDetailsModel model);

	public CoBatchRunDetailsModel findByRunSeqNum(Integer runSeqNum);

	// After batch started we need to read triggers which are in pending
	public List<CoTriggersModel> findPendingTriggers(Integer totalBuckets, Integer instanceNum);

	public List<CoTriggersModel> findPendingTriggers();

	// after trigger is processed insert pdf
	public CoPdfModel savePdf(CoPdfModel model);

	// after processing completed mark trigger as completed
	public boolean updatePendingTrigger(CoTriggersModel model);

	// update batch execution status as EN
	public CoBatchRunDetailsModel updateBatchRunDetails(CoBatchRunDetailsModel model);

	// Insert Batch summary with totalTrgs,succTrgsrs,failureTrgs
	public CoBatchSummaryModel saveBatchSummary(CoBatchSummaryModel model);

}
