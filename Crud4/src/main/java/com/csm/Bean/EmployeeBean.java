package com.csm.Bean;

import java.sql.Date;

public class EmployeeBean {
	
	private int empid;
	private String empuname;
	private String emppass;
	private String empfname;
	private String emplname;
	private String empemail;
	private String empdept;
	private Date empdob;
		
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpuname() {
		return empuname;
	}
	public void setEmpuname(String empuname) {
		this.empuname = empuname;
	}
	public String getEmppass() {
		return emppass;
	}
	public void setEmppass(String emppass) {
		this.emppass = emppass;
	}
	public String getEmpfname() {
		return empfname;
	}
	public void setEmpfname(String empfname) {
		this.empfname = empfname;
	}
	public String getEmplname() {
		return emplname;
	}
	public void setEmplname(String emplname) {
		this.emplname = emplname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmpdept() {
		return empdept;
	}
	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}
	public Date getEmpdob() {
		return empdob;
	}
	public void setEmpdob(Date empdob) {
		this.empdob = empdob;
	}
	
	
}
