/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller.product;

import com.mohit.program.DAO.ProductDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/deleteproduct")
public class DeleteController {
    
    @Autowired
    ProductDAO productDao;
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String doGet(@PathVariable("id") int id)
    {
        try{
        if(productDao.delete(id)>0)
        {
            return "redirect:/displayproduct?success";
        }
        }catch(SQLException|ClassNotFoundException ex)
        {
        
        }
        return "redirect:/?error";
    }
}
