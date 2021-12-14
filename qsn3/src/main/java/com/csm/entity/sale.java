package com.csm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class sale {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno; 
	@Column
	private int shopid;
	@Column(name = "prodid")
	private int intprodid;
	@Column
	private int qty;
	@Column
	private int amount;
	
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getIntprodid() {
		return intprodid;
	}
	public void setIntprodid(int intprodid) {
		this.intprodid = intprodid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "sale [slno=" + slno + ", shopid=" + shopid + ", intprodid=" + intprodid + ", qty=" + qty + ", amount="
				+ amount + "]";
	}
	
	

}
