package com.csm.bean;

import java.util.Date;

public class BatchMasterDto {

	private int BatchID;
	private String BatchDesc;
	private String StartTime;
	private String EndTime;
	private Date StartDate;
	private Date EndDate;
	
	
	public int getBatchID() {
		return BatchID;
	}
	public void setBatchID(int batchID) {
		BatchID = batchID;
	}
	public String getBatchDesc() {
		return BatchDesc;
	}
	public void setBatchDesc(String batchDesc) {
		BatchDesc = batchDesc;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
}
