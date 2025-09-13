package com.learn.springbootjdbc6.Repository;

import com.learn.springbootjdbc6.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private DbConnection dbConnection;

    @Override
    public Product addProduct(Product product) {
        Connection connection = dbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("insert into product values(?,?,?,?)");
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setFloat(3, product.getProductPrice());
            stmt.setDate(4, java.sql.Date.valueOf(product.getManufactureDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        Connection connection = dbConnection.getConnection();
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from product");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setManufactureDate(rs.getDate("manufacturedDate").toLocalDate());
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Product searchProductById(int productId) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from product where id=?");
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setManufactureDate(rs.getDate("manufacturedDate").toLocalDate());
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void deleteProductById(int productId) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from product where id=?");
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> searchByPrice(float minPrice, float maxPrice) {
        Connection connection = dbConnection.getConnection();
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from product where price between ? and ?");
            stmt.setFloat(1, minPrice);
            stmt.setFloat(2, maxPrice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setManufactureDate(rs.getDate("manufacturedDate").toLocalDate());
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
