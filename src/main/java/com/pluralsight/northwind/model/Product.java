package com.pluralsight.northwind.model;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private String quantityPerUnit;
    private double unitPrice;
    private double unitsInStock;
    private double unitsOnOrder;
    private double reorderLevel;
    private boolean discontinued;

    public Product(int productId, String productName, int supplierId, int categoryId, String quantityPerUnit, double unitPrice, double unitsInStock, double unitsOnOrder, double reorderLevel, boolean discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(double unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public double getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(double unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public double getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
