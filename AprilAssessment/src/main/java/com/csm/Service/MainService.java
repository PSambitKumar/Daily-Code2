package com.csm.Service;

import com.csm.Entity.OrderMaster;
import com.csm.Entity.ProductMaster;

import java.util.List;

public interface MainService {
    public List<ProductMaster> getAllProductList();
    public List<OrderMaster> getAllOrderList();
    public void saveOrderMaster(OrderMaster orderMaster);
    public void deleteOrder(int orderId);
    public OrderMaster getOrderMaster(int orderId);
}
