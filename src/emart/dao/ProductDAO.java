/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductDAO {
     public static String getNextProductId()throws SQLException{
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(P_ID)from products;");
        rs.next();
        String ProductId=rs.getString(1);
        if(ProductId==null){
            return "P101";
        }
        int Productno=Integer.parseInt(ProductId.substring(1));
        Productno=Productno+1;
        return "P"+Productno;
    }
     public static boolean addProduct(ProductPojo p) throws SQLException{
          Connection con=DBConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("Insert into products values(?,?,?,?,?,?,?,'Y')");
           ps.setString(1,p.getProdutId());
           ps.setString(2,p.getProductName());
           ps.setString(3,p.getProductCompany());
           ps.setDouble(4, p.getProductPrice());
           ps.setDouble(5,p.getOurPrice());
           ps.setInt(6,p.getTax());
           ps.setInt(7,p.getQuenitity());
           return ps.executeUpdate()==1;     
     }
     public static List<ProductPojo> getProductDetails() throws SQLException{
          Connection con=DBConnection.getConnection();
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select * from products where status='Y' order by p_id");
          ArrayList<ProductPojo> productsList=new ArrayList<>();
          while(rs.next()){
              ProductPojo p=new ProductPojo();
              p.setProdutId(rs.getString(1));
              p.setProductName(rs.getString(2));
              p.setProductCompany(rs.getString(3));
              p.setProductPrice(rs.getDouble(4));
              p.setOurPrice(rs.getDouble(5));
              p.setTax(rs.getInt(6));
              p.setQuenitity(rs.getInt(7));
              productsList.add(p);
     }
          return productsList;
     }
     public static boolean deleteProduct(String productId) throws SQLException{
          Connection con=DBConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("Update products set Status='N' where p_id=?");
           ps.setString(1, productId);
           return ps.executeUpdate()==1;
     }
     public static boolean updateProduct(ProductPojo p) throws SQLException{
         Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("update products set p_name=?, P_COMPANYNAME=? ,P_PRICE=?, OUR_PRICE=?,p_Tax=?,quantity=? where p_id=?");    
           ps.setString(1,p.getProductName());
           ps.setString(2,p.getProductCompany());
           ps.setDouble(3, p.getProductPrice());
           ps.setDouble(4,p.getOurPrice());
           ps.setInt(5,p.getTax());
           ps.setInt(6,p.getQuenitity());
           ps.setString(7,p.getProdutId());
            return ps.executeUpdate()==1;
     }
     public static ProductPojo getProductDetails(String id) throws SQLException{
          Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("select * from products where p_id=? and status='y'");  
          ps.setString(1, id);
          ResultSet rs=ps.executeQuery();
          ProductPojo p=new ProductPojo();
          if(rs.next())
          {
              p.setProdutId(rs.getString(1));
              p.setProductName(rs.getString(2));
              p.setProductCompany(rs.getString(3));
              p.setProductPrice(rs.getDouble(4));
              p.setOurPrice(rs.getDouble(5));
              p.setTax(rs.getInt(6));
              p.setQuenitity(rs.getInt(7));
          }
          return p;
     }
     public static boolean updateStocks(List<ProductPojo> productList ) throws SQLException{
        Connection con=DBConnection.getConnection();
        int x=0;
        PreparedStatement ps=con.prepareStatement(" Update products set quantity=quantity-? where p_id=? ");  
        for(ProductPojo p:productList){
            ps.setInt(1, p.getQuenitity());
            ps.setString(2,p.getProdutId());
            int row=ps.executeUpdate();
            if(row!=0){
                x++;
            }
        }
        return x==productList.size();
     }
         
    
}
