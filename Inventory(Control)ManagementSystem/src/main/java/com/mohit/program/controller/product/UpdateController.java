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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/updateproduct")
public class UpdateController {

    @Autowired
    ProductDAO productDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doGet(@PathVariable("id") int id, ModelMap map) {
        try {
            Product p = productDao.getById(id);
            if (p != null) {
                map.addAttribute("product", p);
                return "product/update";
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return "redirect:/?error";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String doPost(Product p) {
        try {
            if (productDao.update(p) > 0) {
                return "redirect:/displayproduct?success";
            } else {
                return "redirect:/?error";
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return "redirect:/?error";
    }

}
