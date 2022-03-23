package com.csm.Controller;

import com.csm.Entity.OrderMaster;
import com.csm.Service.MainService;
import jdk.jfr.internal.tool.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/orderManagement")
    public String orderManagement(Model model){
        model.addAttribute("productList", mainService.getAllProductList());
        model.addAttribute("orderList", mainService.getAllOrderList());
        model.addAttribute("order", new OrderMaster());
        return "orderManagement";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(Model model, OrderMaster orderMaster){
        mainService.saveOrderMaster(orderMaster);
        System.out.println(orderMaster);
        model.addAttribute("productList", mainService.getAllProductList());
        model.addAttribute("orderList", mainService.getAllOrderList());
        model.addAttribute("order", new OrderMaster());
        return "orderManagement";
    }
    @GetMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId, Model model){
        mainService.deleteOrder(orderId);
        model.addAttribute("productList", mainService.getAllProductList());
        model.addAttribute("orderList", mainService.getAllOrderList());
        model.addAttribute("order", new OrderMaster());
        return "orderManagement";
    }

    @GetMapping("/editOrder/{orderId}")
    public String editOrder(@PathVariable int orderId, Model model){
        OrderMaster orderMaster = mainService.getOrderMaster(orderId);
        model.addAttribute("productList", mainService.getAllProductList());
        model.addAttribute("orderList", mainService.getAllOrderList());
        model.addAttribute("order", orderMaster);
        return "orderManagement";
    }
}
