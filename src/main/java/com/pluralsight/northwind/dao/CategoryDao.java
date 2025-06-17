package com.pluralsight.northwind.dao;

import com.pluralsight.northwind.model.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private DataSource dataSource;

    public List<Category> getAllCategories() {
        String query = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                categories.add(
                        new Category(
                                rs.getInt("CategoryID"),
                                rs.getString("CategoryName"),
                                rs.getString("Description")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public Category getCategoryByID(int categoryId){
        String query = "SELECT * FROM categories WHERE CategoryID = ?";
        Category category = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, categoryId);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    category = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"), rs.getString("Description"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public void addNewCategory(Category category){
        String query = "INSERT INTO category(CategoryName) VALUES (?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, category.getCategoryName());

            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                category.setCategoryId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateCategory(Category category){
        String query = "UPDATE category SET CategoryName = ?, Description = ? WHERE CategoryID = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, category.getCategoryName());
                    ps.setString(2, category.getDescription());
                            ps.setInt(3, category.getCategoryId());


            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



}
