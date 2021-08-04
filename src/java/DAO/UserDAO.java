/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DBUtils.DBHelper;
import DTO.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
/**
 *
 * @author khang
 */
public class UserDAO {
    public UserDTO getdto (String username , String password) throws SQLException, NamingException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select UserID ,Username, Password, Name, Role,Phone, Address  "
                        + "from Users "
                        + "where Username = ? and Password = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()){
                    int id = rs.getInt("UserID");
                    String usernamelogin = rs.getString("Username");
                    String passwordlogin = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String name = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    UserDTO dto = new UserDTO(id, usernamelogin, passwordlogin, role, name, phone, address);
                    return dto ;
                }
            }
        } 
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
    
    public UserDTO getUserById (int userId) throws SQLException, NamingException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select UserID ,Username, Password, Name, Role,Phone, Address  "
                        + "from Users "
                        + "where UserID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                if (rs.next()){
                    int id = rs.getInt("UserID");
                    String usernamelogin = rs.getString("Username");
                    String passwordlogin = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String name = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    UserDTO dto = new UserDTO(id, usernamelogin, passwordlogin, role, name, phone, address);
                    return dto ;
                }
            }
        } 
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
    
    public ArrayList<UserDTO> SearchAllUser () throws NamingException, SQLException {
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        ArrayList userlist = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select UserID,Username,Password,Role,Name,Phone,Address "
                        + "from Users ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                userlist = new ArrayList();
                while (rs.next()){
                    int id = rs.getInt("UserID");
                    String usernamelogin = rs.getString("Username");
                    String passwordlogin = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String name = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    UserDTO dto = new UserDTO(id, usernamelogin, passwordlogin, role, name, phone, address);
                    userlist.add(dto);
                }
                return userlist;
            }
        } 
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
    public ArrayList<UserDTO> SearchAllUser (String name, String fullName) throws NamingException, SQLException {
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        ArrayList userlist = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select UserID,Username,Password,Role,Name,Phone,Address "
                        + "from Users "
                        + "where Username like ? and Name like ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + fullName+"%");
                rs = ps.executeQuery();
                userlist = new ArrayList();
                while (rs.next()){
                    int id = rs.getInt("UserID");
                    String usernamelogin = rs.getString("Username");
                    String passwordlogin = rs.getString("Password");
                    int role = rs.getInt("Role");
                    String username = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    UserDTO dto = new UserDTO(id, usernamelogin, passwordlogin, role, username, phone, address);
                    userlist.add(dto);
                }
                return userlist;
            }
        } 
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
    public boolean UpdateUser (UserDTO dto) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "update Users "
                        + "set Username = ?, Password = ?, Role = ?, Name = ?, Phone = ?, Address = ? "
                        + "where UserID = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getUsername());
                ps.setString(2, dto.getPassword());
                ps.setInt(3, dto.getRole());
                ps.setString(4, dto.getName());
                ps.setString(5, dto.getPhone());
                ps.setString(6, dto.getAddress());
                ps.setInt(7, dto.getUserId());
                if (ps.executeUpdate() > 0){
                    return true;
                }
            }
        } 
        finally{
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
    public boolean DeleteUser (int id) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "delete from Users "
                        + "where UserID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0){
                    return true;
                }
            }
        } 
        finally{
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
    public int createUser (String username,String password,int role,String name,String phone,String Address) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userId = -1;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "insert into Users "
                        + "values (?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, role);
                ps.setString(4, name);
                ps.setString(5, phone);
                ps.setString(6, Address);
                ps.executeUpdate();
                
                sql = "select @@IDENTITY as UserID";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()){
                    userId = rs.getInt("UserID");
                    System.out.println(userId);
                    return userId;
                }
            }
        } 
        finally{
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
            if (rs != null){
                rs.close();
            }
        }
        return userId;
    }
}
