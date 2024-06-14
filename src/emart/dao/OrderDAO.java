/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class OrderDAO {
 public static String getNextOrderId()throws SQLException{
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(order_id)from orders");
        rs.next();
        String orderId=rs.getString(1);
        if(orderId==null){
            return "O-101";
        }
        int ordno=Integer.parseInt(orderId.substring(2));
         ordno++;
        return "O-"+ordno;
    }
    public static boolean addOrder(ArrayList<ProductPojo> al,String ordId)throws SQLException{
         Connection con=DBConnection.getConnection();
         PreparedStatement ps=con.prepareStatement("Insert into orders values(?,?,?,?)");
         int count=0;
         for(ProductPojo p:al){
             ps.setString(1,ordId);
             ps.setString(2,p.getProdutId());
             ps.setInt(3, p.getQuenitity());
             ps.setString(4, UserProfile.getUserId());
             count=count+  ps.executeUpdate();
         }
         return count==al.size();
    }
        
}
