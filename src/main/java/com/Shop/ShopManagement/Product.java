package com.Shop.ShopManagement;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String pname;
    private double price;
    private String description;
    private String category;
    private String productImageurl;

    public Product() {}

    public Product(String pname, double price, String description,
                   String category, String productImageurl) {
        this.pname = pname;
        this.price = price;
        this.description = description;
        this.category = category;
        this.productImageurl = productImageurl;
    }

    public int getPid() { return pid; }
    public String getPname() { return pname; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getProductImageurl() { return productImageurl; }

    public void setPid(int pid) { this.pid = pid; }
    public void setPname(String pname) { this.pname = pname; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setProductImageurl(String productImageurl) {
        this.productImageurl = productImageurl;
    }
}
