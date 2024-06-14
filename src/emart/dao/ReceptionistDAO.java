/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.util.Map;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReceptionistDAO {
    public static HashMap<String,String>getNonRegisteredReceptionists() throws SQLException{
       
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select empid,empname from employees where job='Receptionist' and empid not in (select empid from users where usertype='receptionist')");
        HashMap<String,String>receptionistList=new HashMap<>();
        while(rs.next()){
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionistList.put(id, name);
     }
        return receptionistList;
     }
    public static boolean addReceptionist(UserPojo user)throws SQLException{
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Insert into users values(?,?,?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2, user.getEmpid());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getUserType());
        ps.setString(5,user.getUserName());
        int n=ps.executeUpdate();
        return n==1; 
    }
    public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
        
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("Select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");
        ArrayList<ReceptionistPojo> al=new ArrayList();
        while(rs.next()){
            ReceptionistPojo recep=new ReceptionistPojo();
            recep.setEmpid(rs.getString(1));
            recep.setEmpname(rs.getString(2));
            recep.setUserid(rs.getString(3));
            recep.setJob(rs.getString(4));
            recep.setSal((rs.getDouble(5)));
            al.add(recep);
        }
        return al;
        }
//     public static boolean deleteEmployee(String empid) throws SQLException{
//          Connection con=DBConnection.getConnection();
//             Statement st=con.createStatement();
//             
//       }
    public static Map<String,String>GetReceptionistId()throws SQLException{   
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select userid,username from users where usertype='Receptionist' order by userid");
        HashMap<String,String>receptionistList=new HashMap<>();
         while(rs.next()){
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionistList.put(id, name);
     }
         return receptionistList;
    }
    public static boolean updatePassword(String name,String password,String userId)throws SQLException{  
         Connection con=DBConnection.getConnection();
        PreparedStatement ps;
        ps = con.prepareStatement("update users set password=? ,username= ? where userid=?");
        ps.setString(1,password);
        ps.setString(2, name);
        ps.setString(3, userId);
        return ps.executeUpdate()==1;
    }
    public static ArrayList<String>getAllReceptionistUserId()throws SQLException{
         Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select userid from users where usertype='Receptionist' order by userid");
        ArrayList<String> al=new ArrayList<String>();
         while(rs.next()){
             al.add(rs.getString(1));
         }
         return al;
    }
     public static boolean deleteReceptionist(String userid)throws SQLException{
          Connection con=DBConnection.getConnection();
        PreparedStatement ps;
        ps = con.prepareStatement("delete from users where userid=?");
         ps.setString(1, userid);
          return ps.executeUpdate()==1;
     }
     public static HashMap<String,String>getAllReceptionstId()throws SQLException{
         Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select userid,username from users where usertype='Receptionist' order by userid");
        HashMap<String,String> al=new HashMap<String,String>();
        while(rs.next()){
            al.put(rs.getString(1),rs.getString(2));
        }
         System.out.println(al);
        return al;
        
     }
}
