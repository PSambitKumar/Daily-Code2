package com.example.springcrud.springmvccrud.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batchmaster")
public class BranchMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer BatchID;
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
	public Integer getBatchID() {
		return BatchID;
	}
	public void setBatchID(Integer batchID) {
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
	
	
	
	

	
}