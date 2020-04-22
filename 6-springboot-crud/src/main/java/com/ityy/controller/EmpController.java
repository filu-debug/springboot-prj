package com.ityy.controller;

import com.ityy.dao.DepartmentDao;
import com.ityy.dao.EmployeeDao;
import com.ityy.entities.Department;
import com.ityy.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public ModelAndView getAllEmp(ModelAndView mv){
        Collection<Employee> empList = employeeDao.getAll();
        mv.setViewName("list");
        mv.addObject("empList",empList);
        return mv;
    }

    /**
     * 前往添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deptnoList",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee emp){
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    /**
     * 修改前的回显操作
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public ModelAndView toUpdatePage(@PathVariable("id") Integer id,ModelAndView mv){
        Employee empupdate = employeeDao.get(id);
        mv.addObject("empupdate",empupdate);
        Collection<Department> departments = departmentDao.getDepartments();
        mv.addObject("departments",departments);
        mv.setViewName("emp/update");
        return mv;
    }

    @PutMapping("/emp")
    public String update(Employee emp){
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String update(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
