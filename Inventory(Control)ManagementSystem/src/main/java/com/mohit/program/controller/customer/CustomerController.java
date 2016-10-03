/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller.customer;

import com.mohit.program.DAO.CustomerDAO;
import com.mohit.program.DAO.ProductDAO;
import com.mohit.program.entity.Customer;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    
    @Autowired
    ProductDAO productDao;
    @Autowired
    CustomerDAO customerDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap map)
    {
        try{
        map.addAttribute("products", productDao.getAll(true));
        }catch(SQLException|ClassNotFoundException ex)
        {
        
        }
        return "customer/insert";
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Customer c)
    {
        try{
        if(customerDao.insert(c)>0)
        {
            return "redirect:/?success";
        }
        }catch(ClassNotFoundException|SQLException ex)
        {
        
        }
        return "redirect:/?error";
    }
}
