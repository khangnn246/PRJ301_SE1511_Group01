/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBUtils.DBHelper;
import DTO.LaptopDTO;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.UserDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
/**
 *
 * @author khang
 */
public class CheckoutDAO {
    public int createOrder (int userId, String address, float totalprice) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into Orders "
                + "values (?,?,?)";
        int orderId  = -1;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setString(2, address);
                ps.setFloat(3, totalprice);
                ps.executeUpdate();
                
                sql = "select @@IDENTITY as OrderID";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()){
                    orderId = rs.getInt("OrderID");
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
        return orderId;
    }
    public boolean createOrderDetail (int orderId,int laptopId,int quantity) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into OrderDetail(orderId, quantity, laptopid) "
                + "values (?,?,?)";
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                ps = con.prepareStatement(sql);
                ps.setInt(1, orderId);
                ps.setInt(2,quantity );
                ps.setInt(3, laptopId);
                int i =  ps.executeUpdate();
                if (i > 0) return true;
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
        return false;
    }
    public ArrayList<OrderDTO> getOrderById (int userid) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<OrderDTO> list = null;
        UserDAO userdao = new UserDAO();
        String sql = "select OrderID,UserID,Address,TotalPrice "
                + "from Orders "
                + "where UserID = ?";
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                list = new ArrayList<>();
                ps = con.prepareStatement(sql);
                ps.setInt(1, userid);
                rs = ps.executeQuery();
                while (rs.next()){
                    int orderId = rs.getInt("OrderID");
                    int userId = rs.getInt("UserID");
                    UserDTO userdto = userdao.getUserById(userId);
                    String address = rs.getString("Address");
                    float totalprice = rs.getFloat("TotalPrice");
                    OrderDTO dto = new OrderDTO(orderId,userdto, address, totalprice);
                    list.add(dto);
                }
                return list;
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
    public OrderDTO getOrderByOrderId (int orderId) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select OrderID,UserID,Address,TotalPrice "
                + "from Orders "
                + "where OrderID = ?";
        OrderDTO order = null;
        UserDAO dao = new UserDAO();
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                
                ps = con.prepareStatement(sql);
                ps.setInt(1, orderId);
                rs = ps.executeQuery();
                if (rs.next()){
                    int userId = rs.getInt("UserID");
                    UserDTO userdto = dao.getUserById(userId);
                    String address = rs.getString("Address");
                    float totalprice = rs.getFloat("TotalPrice");
                    order = new OrderDTO(orderId,userdto, address, totalprice);
                }
                return order;
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
    public ArrayList<OrderDetailDTO> getOrderDetailById (int orderId, int userid) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<OrderDetailDTO> list = null;
        LaptopDAO lapdao = new LaptopDAO();
        String sql = "select OrderDetailID, OrderID, Quantity, LaptopID "
                + "from OrderDetail "
                + "where OrderID = ?";
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                list = new ArrayList<>();
                ps = con.prepareStatement(sql);
                ps.setInt(1,orderId);
                rs = ps.executeQuery();
                while (rs.next()){
                    int cartDetailId = rs.getInt("OrderDetailID");
                    OrderDTO order = getOrderByOrderId(orderId);
                    int quantity = rs.getInt("Quantity");
                    int laptopId = rs.getInt("LaptopID");
                    LaptopDTO laptop = lapdao.getLaptopById(laptopId);
                    OrderDetailDTO orderdetaildto = new OrderDetailDTO(cartDetailId,laptop, order, quantity);
                    list.add(orderdetaildto);
                }
                return list;
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
}
