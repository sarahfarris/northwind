package com.pluralsight.northwind.dao;

import com.pluralsight.northwind.model.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
  //  private int productId;
  //    private String productName;
  //    private int supplierId;
  //    private int categoryId;
  //    private String quantityPerUnit;
  //    private double unitsInStock;
  //    private double unitsOnOrder;
  //    private double reorderLevel;
  //    private boolean discontinued;
  private DataSource dataSource;

  public ProductDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  // get all products
  public List<Product> getAllProducts() {
    String query = "SELECT * FROM products";
    List<Product> products = new ArrayList<>();
    try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        products.add(
            new Product(
                rs.getInt("ProductID"),
                rs.getString("ProductName"),
                rs.getInt("SupplierID"),
                rs.getInt("CategoryID"),
                rs.getString("QuantityPerUnit"),
                rs.getDouble("UnitPrice"),
                rs.getDouble("UnitsInStock"),
                rs.getDouble("UnitsOnOrder"),
                rs.getDouble("ReorderLevel"),
                rs.getBoolean("Discontinued")));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return products;
  }

  public Product getProductByID(int productId){
          String query = "SELECT * FROM products WHERE ProductID = ?";
          Product product = null;
          try (Connection connection = dataSource.getConnection();
               PreparedStatement ps = connection.prepareStatement(query);
               ) {
              ps.setInt(1, productId);
              try(ResultSet rs = ps.executeQuery()) {
                  while (rs.next()) {
                      product = new Product(rs.getInt("ProductID"), rs.getString("ProductName"));
              }
              }
          } catch (SQLException e) {
              System.out.println(e.getMessage());
          }
          return product;
  }

    public Product getProductByName(String productName){
        String query = "SELECT ProductName FROM products WHERE ProductName = ?";
        Product product = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, productName);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    product = new Product(rs.getString("ProductName"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public Product addNewProduct(Product product){
      String query = "INSERT INTO products(ProductName) VALUES (?)";
      try(Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      ) {
          ps.setString(1, product.getProductName());

          ps.executeUpdate();
          try(ResultSet rs = ps.getGeneratedKeys()) {
              rs.next();
              product.setProductId(rs.getInt(1));
          }
      } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
      return product;
    }

}
