/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller.product;

import com.mohit.program.DAO.ProductDAO;
import com.mohit.program.entity.Product;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductDAO productDao;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return "product/insert";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Product p) {
        try {
            if (productDao.insert(p) > 0) {
                return "redirect:/displayproduct?success";
            } 
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return "redirect:/?error";
    }
}
