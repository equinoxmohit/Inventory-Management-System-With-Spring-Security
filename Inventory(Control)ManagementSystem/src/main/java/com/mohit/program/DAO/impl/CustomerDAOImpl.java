/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.DAO.impl;

import com.mohit.program.DAO.CustomerDAO;
import com.mohit.program.entity.Customer;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value = "customerDao")
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public int insert(Customer customer) throws SQLException, ClassNotFoundException {
       String sql="INSERT INTO tbl_customer(first_name,last_name,contact_number,address,product_id)"+"VALUES(?,?,?,?,?)";
       return jdbcTemplate.update(sql, new Object[]{
           customer.getFirstName(),
           customer.getLastName(),
           customer.getContactNumber(),
           customer.getAddress(),
           customer.getProduct().getId()
       });
    }

    @Override
    public List<Customer> customerList() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
