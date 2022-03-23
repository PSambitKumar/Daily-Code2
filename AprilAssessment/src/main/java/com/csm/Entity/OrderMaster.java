package com.csm.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_master")
public class OrderMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_Id;
    private int product_Id;
    private Date order_date;
    private int order_qty;

    public int getProduct_Id() {
        return product_Id;
    }
    public void setProduct_Id(int product_Id) {
        this.product_Id = product_Id;
    }
    public int getOrder_Id() {
        return order_Id;
    }
    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    public int getOrder_qty() {
        return order_qty;
    }
    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }

}
