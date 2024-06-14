/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.dao;
import java.sql.Connection;
import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class EmployeeDAO {
    public static String getNextEmpId()throws SQLException{
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(empid)from employees;");
        rs.next();
        String empid=rs.getString(1);
        int empno=Integer.parseInt(empid.substring(1));
        empno=empno+1;
        return "E"+empno;
 
    }
    public static boolean addEmp(EmployeePojo emp)throws SQLException{
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setString(1, emp.getEmpid());
        ps.setString(2,emp.getEmpName());
        ps.setString(3,emp.getJob());
        ps.setDouble(4,emp.getSalary());
        int result=ps.executeUpdate();
        return result==1;
    }
    public static  List<EmployeePojo> getAllEmployees()throws SQLException{
         Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by empid ;");
         ArrayList<EmployeePojo>empList=new ArrayList<EmployeePojo>();
         while(rs.next()){
             EmployeePojo emp=new EmployeePojo();
             emp.setEmpid(rs.getString(1));
             emp.setEmpName(rs.getString(2));
             emp.setJob(rs.getString(3));
             emp.setSalary(rs.getDouble(4));
             empList.add(emp);
         }
         return empList;
    }
    public static List<String>  addEmpId()throws SQLException{
         Connection con=DBConnection.getConnection();
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("select EMPID from employees order by empid ;");
         ArrayList<String>AllId=new ArrayList<String>();
         while(rs.next()){
              AllId.add(rs.getString(1));
         }
         return AllId;
         
    }
    public static EmployeePojo setData(String empId)throws SQLException{
         Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("select * from employees where empid=?");
          ps.setString(1, empId);
            ResultSet rs=ps.executeQuery();
            EmployeePojo emp=null;
             rs.next();
             emp=new EmployeePojo();
            emp.setEmpid(rs.getString(1));
            emp.setEmpName(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
         
         return emp;    
    }

    public static boolean updateData(EmployeePojo e)throws SQLException{
        
         Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("update employees set EMPNAME=? ,JOB=? ,SALARY=? where EMPID=? ");
           ps.setString(1, e.getEmpName());
           ps.setString(2,e.getJob());
           ps.setDouble(3, e.getSalary());
           ps.setString(4,e.getEmpid());
           int a=ps.executeUpdate();
           if(a==0)
               return false;
           else{
                  boolean result=UserDAO.isUserPresent(e.getEmpid());
                  if(result==false)
                      return true;
                   ps=con.prepareStatement("update users set username=? ,usertype=? where EMPID=? ");
                 ps.setString(1, e.getEmpName());
                 ps.setString(2,e.getJob());
                 ps.setString(3,e.getEmpid());
                 int y= ps.executeUpdate();
                 return y==1;
           }
    }
    public static boolean deleteEmployee(String empid) throws SQLException{
         Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("delete from employees  where EMPID=? ");
          ps.setString(1, empid);
          int x=ps.executeUpdate();
          return x==1;
    }
    
        
}
        
        


        
        
        
    

