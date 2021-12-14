package com.csm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopmaster")
public class shop {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopid;
	@Column
	private String shopname;
	
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", shopname=" + shopname + "]";
	}
	
}
