package com.csm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batchmaster1")
public class Employee {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BatchID;
	@Column
	private String BatchDesc;
	@Column
	private String StartTime;
	@Column
	private String EndTime;
	@Column
	private String StartDate;
	@Column
	private String EndDate;
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
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	@Override
	public String toString() {
		return "Employee [BatchID=" + BatchID + ", BatchDesc=" + BatchDesc + ", StartTime=" + StartTime + ", EndTime="
				+ EndTime + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", getBatchID()=" + getBatchID()
				+ ", getBatchDesc()=" + getBatchDesc() + ", getStartTime()=" + getStartTime() + ", getEndTime()="
				+ getEndTime() + ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
}
