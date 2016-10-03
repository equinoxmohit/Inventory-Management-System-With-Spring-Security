/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.DAO.impl;

import com.mohit.program.DAO.SupplierDAO;
import com.mohit.program.entity.Supplier;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value="supplierDao")
public class SupplierDAOImpl implements SupplierDAO{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO tbl_supplier(first_name,last_name,contact_number,address,product_id)"+"VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            supplier.getFirstName(),
            supplier.getLastName(),
            supplier.getContactNumber(),
            supplier.getAddress(),
            supplier.getProduct().getId()
        });
    }

    @Override
    public List<Supplier> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
