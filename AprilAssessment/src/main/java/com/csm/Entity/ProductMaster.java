package com.csm.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_master")
public class ProductMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_Id;
    private String name;
    private double unit_price;
    private int product_qty;

    public int getProduct_Id() {
        return product_Id;
    }
    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    public int getProduct_qty() {
        return product_qty;
    }
    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }


}
