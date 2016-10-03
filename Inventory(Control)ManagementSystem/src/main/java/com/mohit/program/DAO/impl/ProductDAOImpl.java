/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.DAO.impl;

import com.mohit.program.DAO.ProductDAO;
import com.mohit.program.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value = "productDao")
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Product p) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_product(product_name,cost_price,selling_price,quantity_available,status)" + "VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            p.getProductName(),
            p.getCostPrice(),
            p.getSellingPrice(),
            p.getQuantityAvailable(),
            p.isStatus()
        });
    }

    @Override
    public List<Product> getAll(boolean availability) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_product WHERE 1=1 ";

        if (availability) {
            sql += " AND status=1 ";
        }

        return jdbcTemplate.query(sql, new RowMapper<Product>() {

            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setCostPrice(rs.getString("cost_price"));
                p.setSellingPrice(rs.getString("selling_price"));
                p.setQuantityAvailable(rs.getInt("quantity_available"));
                p.setAddedDate(rs.getDate("added_date"));
                p.setModifiedDate(rs.getDate("modified_date"));
                p.setStatus(rs.getBoolean("status"));
                return p;
            }
        });
    }

    @Override
    public int update(Product p) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tbl_product SET product_name=?,cost_price=?,selling_price=?,quantity_available=?,status=? WHERE product_id=?";
        return jdbcTemplate.update(sql, new Object[]{
            p.getProductName(),
            p.getCostPrice(),
            p.getSellingPrice(),
            p.getQuantityAvailable(),
            p.isStatus(),
            p.getId()
        });
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from tbl_product WHERE product_id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public Product getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_product WHERE product_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Product>() {

            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setCostPrice(rs.getString("cost_price"));
                p.setSellingPrice(rs.getString("selling_price"));
                p.setQuantityAvailable(rs.getInt("quantity_available"));
                p.setAddedDate(rs.getDate("added_date"));
                p.setModifiedDate(rs.getDate("modified_date"));
                p.setStatus(rs.getBoolean("status"));
                return p;
            }
        });
    }

}
