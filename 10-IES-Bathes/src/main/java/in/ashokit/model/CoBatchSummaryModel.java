package in.ashokit.model;

import lombok.Data;

@Data()
public class CoBatchSummaryModel {
	private Integer summaryId;
	private String batchName;
	private Long totalTriggerProcessed;
	private Long failureTriggerCount;
	private Long successTriggerCount;

}// BatchSummaryModel
