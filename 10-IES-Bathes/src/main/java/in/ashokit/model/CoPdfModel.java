/**
 * 
 */
package in.ashokit.model;

import lombok.Data;

/**
 * @author vinay
 *
 */
@Data
public class CoPdfModel {
	Integer coPdfId;
	long caseNumber;
	byte[] pdfDocument;
	String planName;
	String PlanStatus;

}// CoPdfModel
