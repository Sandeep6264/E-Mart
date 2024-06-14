/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public class UserDAO {
    
    public static boolean validateUser(UserPojo user)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where USERID=? and PASSWORD=? and USERTYPE=?");
          
         ps.setString(1,user.getUserId());
         ps.setString(2,user.getPassword());
         ps.setString(3, user.getUserType());
         ResultSet rs=ps.executeQuery();
         if(rs.next()){
                UserProfile.setUserName(rs.getString(5));
               return true;
         }
         return false;   
    }
    public static boolean isUserPresent(String empid)throws SQLException{
          Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("select * from users where EMPID=? ");
          
         ps.setString(1,empid);
         ResultSet rs=ps.executeQuery();
         return rs.next();
    }
}
