package com.csm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catid;
	
	@Column
	private String catname;

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catname=" + catname + "]";
	}
	
}
