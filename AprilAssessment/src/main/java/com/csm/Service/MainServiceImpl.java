package com.csm.Service;

import com.csm.Entity.OrderMaster;
import com.csm.Entity.ProductMaster;
import com.csm.Repository.OrderRepository;
import com.csm.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<ProductMaster> getAllProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<OrderMaster> getAllOrderList() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrderMaster(OrderMaster orderMaster) {
        orderRepository.save(orderMaster);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderMaster getOrderMaster(int orderId) {
        OrderMaster orderMaster = orderRepository.getById(orderId);
        return orderMaster;
    }
}
