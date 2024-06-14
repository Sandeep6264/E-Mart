/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class DBConnection {
    private static Connection conn;
    static
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","Sandeep@123");
           JOptionPane.showMessageDialog(null,"Connection opened successfully !","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Error in Opening Connection","DB Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
               conn.close();
               JOptionPane.showMessageDialog(null,"Connection closed successfully !","Success",JOptionPane.INFORMATION_MESSAGE);
         
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Error in closing Connection","DB Error",JOptionPane.ERROR_MESSAGE);
  
            e.printStackTrace();
        }
    }
}
