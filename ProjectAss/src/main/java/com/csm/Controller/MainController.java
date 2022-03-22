package com.csm.Controller;

import com.csm.Entity.Department;
import com.csm.Entity.Employee;
import com.csm.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/departmentManagement")
    public String departmentManagement(Model model){
        model.addAttribute("department", new Department());
        model.addAttribute("departmentList", mainService.getAllDepartment());
        return "departmentManagement";
    }

    @PostMapping(value = "/saveDepartment")
    public String saveDepartment(Model model, Department department){
        mainService.saveDepartment(department);
        model.addAttribute("department", new Department());
        model.addAttribute("departmentList", mainService.getAllDepartment());
        return "departmentManagement";
    }

    @GetMapping(value = "/employeeManagement")
    public String employeeManagement(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", mainService.getAllEmployee());
        model.addAttribute("departmentList", mainService.getAllDepartment());
        return "employeeManagement";
    }

    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(Model model, Employee employee){
        mainService.saveEmployee(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", mainService.getAllEmployee());
        model.addAttribute("departmentList", mainService.getAllDepartment());
        return "employeeManagement";
    }
}
