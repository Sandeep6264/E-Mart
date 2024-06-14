/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emart.pojo;

public class UserProfile {
    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserProfile.userId = userId;
    }

    public static String getEmpId() {
        return empId;
    }

    public static void setEmpId(String empId) {
        UserProfile.empId = empId;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserProfile.password = password;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        UserProfile.userType = userType;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }
    private static String userId;
    private static String empId;
    private static String password;
    private static String userType;
    private static String userName;

    public static void setUsertype(String usertype) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void setUserid(String userid) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
    
}
