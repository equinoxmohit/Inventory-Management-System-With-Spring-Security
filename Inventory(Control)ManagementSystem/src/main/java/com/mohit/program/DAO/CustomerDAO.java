/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.DAO;

import com.mohit.program.entity.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface CustomerDAO {

    int insert(Customer customer) throws SQLException, ClassNotFoundException;

    List<Customer> customerList() throws SQLException, ClassNotFoundException;

}
