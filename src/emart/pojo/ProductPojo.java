/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.pojo;

/**
 *
 * @author HP
 */
public class ProductPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public ProductPojo(){
    }

    public ProductPojo(String produtId, String productName, String productCompany, double productPrice, double ourPrice, int tax, int quenitity,double total) {
        this.produtId = produtId;
        this.productName = productName;
        this.productCompany = productCompany;
        this.productPrice = productPrice;
        this.ourPrice = ourPrice;
        this.tax = tax;
        this.quenitity = quenitity;
        this.total=total;
    }

    public String getProdutId() {
        return produtId;
    }

    public void setProdutId(String produtId) {
        this.produtId = produtId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQuenitity() {
        return quenitity;
    }

    public void setQuenitity(int quenitity) {
        this.quenitity = quenitity;
    }
     private String produtId;
     private String productName;
     private String productCompany;
     private double productPrice;
     private double ourPrice;
     private int tax;
     private int quenitity;
     private double total;
     
    
}
