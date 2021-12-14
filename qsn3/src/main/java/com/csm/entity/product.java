package com.csm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productmaster1")
public class product {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	@Column
	private String productname;
	@Column
	private int productrate;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductrate() {
		return productrate;
	}
	public void setProductrate(int productrate) {
		this.productrate = productrate;
	}
	@Override
	public String toString() {
		return "product [productid=" + productid + ", productname=" + productname + ", productrate=" + productrate
				+ "]";
	}
	
	

}
