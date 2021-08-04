/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBHelper;
import DTO.LaptopDTO;
import DTO.ShoppingCartDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author khang
 */
public class LaptopDAO {
    private List<LaptopDTO> list = null;
    private String sql = "";
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private LaptopDTO dto = null;
    boolean check = false;
    
    public ArrayList<LaptopDTO> SearchLaptop (String name , float minPrice, float maxPrice, int minYear, int maxYear) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        ArrayList<LaptopDTO> laptopList = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select LaptopID,Price,Name,CPU,Ram,Screen,Graphic,Disk,OS,Weight,Region,Year "
                        + "from Laptop "
                        + "where name like ? or (Price > ? and Price < ?) or (Year > ? and Year < ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%"+name+"%");
                ps.setFloat(2, minPrice);
                ps.setFloat(3, maxPrice);
                ps.setInt(4, minYear);
                ps.setInt(5, maxYear);
                rs = ps.executeQuery();
                laptopList = new ArrayList();
                while (rs.next()){
                    int id = rs.getInt("LaptopID");
                    float price = rs.getFloat("Price");
                    String laptopname = rs.getString("Name");
                    String CPU = rs.getString("CPU");
                    String ram = rs.getString("Ram");
                    String Screen = rs.getString("Screen");
                    String graphic = rs.getString("Graphic");
                    String disk = rs.getString("Disk");
                    String OS = rs.getString("OS");
                    float weight = rs.getFloat("Weight");
                    String region = rs.getString("Region");
                    int year = rs.getInt("Year");
                    LaptopDTO dto = new LaptopDTO(id, laptopname, price, CPU, ram, Screen, graphic, disk, OS, weight, region, year);
                    laptopList.add(dto);
                }
                return laptopList;
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
    public boolean CreateLaptop () throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        try {

            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "";
                
                while (rs.next()){
                    
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
        return false;
    }
    public LaptopDTO getLaptopById (int id) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select LaptopID,Price,Name,CPU,Ram,Screen,Graphic,Disk,OS,Weight,Region,Year "
                        + "from Laptop "
                        + "where LaptopID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                
                if (rs.next()){
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    String CPU = rs.getString("CPU");
                    String Ram = rs.getString("Ram");
                    String Screen = rs.getString("Screen");
                    String Graphic = rs.getString("Graphic");
                    String Disk = rs.getString("Disk");
                    String OS = rs.getString("OS");
                    float weight = rs.getFloat("Weight");
                    String region = rs.getString("Region");
                    int year = rs.getInt("Year");
                    LaptopDTO dto = new LaptopDTO(id, name, price, CPU, Ram, Screen, Graphic, Disk, OS, weight, region, year);
                    return dto;
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
    public ArrayList<LaptopDTO> getAllLaptop () throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        ArrayList<LaptopDTO> lapList = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select LaptopID,Price,Name,CPU,Ram,Screen,Graphic,Disk,OS,Weight,Region,Year "
                        + "from Laptop ";
                        
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                lapList = new ArrayList<>();
                while (rs.next()){
                    int id = rs.getInt("LaptopID");
                    float price = rs.getFloat("Price");
                    String name = rs.getString("Name");
                    String CPU = rs.getString("CPU");
                    String Ram = rs.getString("Ram");
                    String Screen = rs.getString("Screen");
                    String Graphic = rs.getString("Graphic");
                    String Disk = rs.getString("Disk");
                    String OS = rs.getString("OS");
                    float weight = rs.getFloat("Weight");
                    String region = rs.getString("Region");
                    int year = rs.getInt("Year");
                    LaptopDTO dto = new LaptopDTO(id, name, price, CPU, Ram, Screen, Graphic, Disk, OS, weight, region, year);
                    lapList.add(dto);
                }
                return lapList;
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
    public ArrayList<LaptopDTO> searchLaptopByName (String name) throws NamingException, SQLException{
        Connection con = null ;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        ArrayList<LaptopDTO> lapList = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null){
                String sql = "select LaptopID,Price,Name,CPU,Ram,Screen,Graphic,Disk,OS,Weight,Region,Year "
                        + "from Laptop "
                        + "where Name like ?";
                        
                ps = con.prepareStatement(sql);
                ps.setString(1, "%"+name+"%");
                rs = ps.executeQuery();
                lapList = new ArrayList<>();
                while (rs.next()){
                    int id = rs.getInt("LaptopID");
                    float price = rs.getFloat("Price");
                    String lapname = rs.getString("Name");
                    String CPU = rs.getString("CPU");
                    String Ram = rs.getString("Ram");
                    String Screen = rs.getString("Screen");
                    String Graphic = rs.getString("Graphic");
                    String Disk = rs.getString("Disk");
                    String OS = rs.getString("OS");
                    float weight = rs.getFloat("Weight");
                    String region = rs.getString("Region");
                    int year = rs.getInt("Year");
                    LaptopDTO dto = new LaptopDTO(id, lapname, price, CPU, Ram, Screen, Graphic, Disk, OS, weight, region, year);
                    lapList.add(dto);
                }
                return lapList;
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
    public int checkExisting (int id, List<ShoppingCartDTO> cart) throws NamingException, SQLException{
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getLaptop().getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void closeConnection() throws SQLException{
        if(con != null)con.close();
        if(pstm != null)pstm.close();
        if(rs != null)rs.close();
    }
    
    public List<LaptopDTO> getAllLaptop(int ID) throws Exception{
        if(ID == 0){
            sql = "select * from Laptop";
        }else{
            sql = "select * from Laptop where LaptopID = " + ID;
        }
        try{
            con = DBHelper.makeConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                dto = new LaptopDTO();
                dto.setId(rs.getInt(1));
                dto.setPrice(rs.getFloat(2));
                dto.setName(rs.getString(3));
                dto.setCPU(rs.getString(4));
                dto.setRam(rs.getString(5));
                dto.setScreen(rs.getString(6));
                dto.setGraphic(rs.getString(7));
                dto.setDisk(rs.getString(8));
                dto.setoS(rs.getString(9));
                dto.setWeight(rs.getFloat(10));
                dto.setRegion(rs.getString(11));
                dto.setYear(rs.getInt(12));
                list.add(dto);
            }
        }finally{
            closeConnection();
        }
        return list;
    }
    public LaptopDTO getLaptopByID(int ID){
        String sql = "select * from Laptop where LaptopID = "+ID;
        try{
            con = DBHelper.makeConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            LaptopDTO dto= new LaptopDTO();
            dto.setId(rs.getInt(1));
            dto.setPrice(rs.getFloat(2));
            dto.setName(rs.getString(3));
            dto.setCPU(rs.getString(4));
            dto.setRam(rs.getString(5));
            dto.setScreen(rs.getString(6));
            dto.setGraphic(rs.getString(7));
            dto.setDisk(rs.getString(8));
            dto.setoS(rs.getString(9));
            dto.setWeight(rs.getFloat(10));
            dto.setRegion(rs.getString(11));
            dto.setYear(rs.getInt(12));
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto;
    }
    
    public boolean create(LaptopDTO dto) throws Exception{
        sql = "insert into Laptop values ("
                + dto.getPrice() +", '"
                + dto.getName() +"', '"
                + dto.getCPU()+"', '"
                + dto.getRam() +"', '"
                + dto.getScreen() +"', '"
                + dto.getGraphic() +"', '"
                + dto.getDisk() +"', '"
                + dto.getoS()+"', "
                + dto.getWeight() +", '"
                + dto.getRegion() +"', "
                + dto.getYear() +")";
        try{
            con = DBHelper.makeConnection();
            pstm = con.prepareStatement(sql);
            check = pstm.executeUpdate() != 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateWithID(LaptopDTO dto) throws Exception{
        sql = "update Laptop set Price = "
                + dto.getPrice() +", Name = '"
                + dto.getName() +"', CPU = '"
                + dto.getCPU()+"', Ram = '"
                + dto.getRam() +"', Screen = '"
                + dto.getScreen() +"', Graphic = '"
                + dto.getGraphic() +"', Disk = '"
                + dto.getDisk() +"', OS = '"
                + dto.getoS()+"', Weight = "
                + dto.getWeight() +", Region = '"
                + dto.getRegion() +"', Year = "
                + dto.getYear() +" where LaptopID = "
                + dto.getId() +"";
        try{
            con = DBHelper.makeConnection();
            pstm = con.prepareStatement(sql);
            check = pstm.executeUpdate() != 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteWithID(int ID) throws Exception{
        sql = "delete from Laptop where LaptopID = "
                + ID +";";
        try{
            con = DBHelper.makeConnection();
            pstm = con.prepareStatement(sql);
            check = pstm.executeUpdate() != 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public String checkName(String name){
        String text = name.trim();
        if(text.isEmpty())return"Name is not empty";
        return " ";
    }
    
    public String checkPrice(String price){
        String text = price.trim();
        if(text.isEmpty())return"Price is not empty";        
        try {            
            Float.parseFloat(price);
        } catch (Exception e) {
            return"Price must be number";
        }
        return " ";
    }
    
    public String checkCpu(String cpu){
        String text = cpu.trim().toLowerCase();
        if(text.isEmpty())return"CPU is not empty";
        return " ";
    }
    
    public String checkRam(String ram){
        String text = ram.trim();
        if(text.isEmpty())return "Ram is not empty";
        return " ";
    }
    
    public String checkScreen(String screen){
        String text = screen.trim();
        if(text.isEmpty())return "Screen is not empty";
        return " ";
    }
    
    public String checkGraphic(String graphic){
        String text = graphic.trim();
        if(text.isEmpty())return "Graphics is not empty";
        return " ";
    }
    
    public String checkDisk(String disk){
        String text = disk.trim();
        if(text.isEmpty())return"Disk is not empty";
        return " ";
    }
    
    public String checkOs(String os){
        String text = os.trim();
        if(text.isEmpty())return"OS is not empty";
        return " ";
    }
    
    public String checkWeight(String weight){
        String text = weight.trim();
        if(text.isEmpty())return"Weight is not empty";        
        try {            
            Float.parseFloat(weight);
        } catch (Exception e) {
            return"Weight must be number";
        }
        return " ";
    }
    
    public String checkRegion(String region){
        String text = region.trim();
        if(text.isEmpty())return"Region is not empty";
        return " ";
    }
    
    public String checkYear(String year){
        String text = year.trim();
        if(text.isEmpty())return"Year is not empty";        
        try {            
            Integer.parseInt(year);
        } catch (Exception e) {
            return"Year must be number";
        }
        return " ";
    }
    
    public String checkID(String id){
        return " ";
    }
    
    public String checkDto(String dto){
        String[] s = dto.split("=");
        return checkID("") + "=" + checkName(s[1]) + "=" + checkPrice(s[2]) + "=" +
                checkCpu(s[3]) + "=" + checkRam(s[4]) + "=" + checkScreen(s[5]) + "=" +
                checkGraphic(s[6]) + "=" + checkDisk(s[7]) + "=" + checkOs(s[8]) + "=" +
                checkWeight(s[9]) + "=" + checkRegion(s[10]) + "=" + checkYear(s[11]);
    }
    //public checkValid

    public List<LaptopDTO> getAllLaptop(int idsearch, String namesearch) throws Exception {
            sql = "select * from laptop where Name like ? ";
            if(idsearch != -1){
                sql = sql + "and LaptopID = ?";
            }
            try{
                con = DBHelper.makeConnection();
                pstm = con.prepareStatement(sql);
                pstm.setString(1, "%" + namesearch + "%");
                if(idsearch != -1){
                    pstm.setInt(2, idsearch);
                }
                rs = pstm.executeQuery();
                list = new ArrayList<>();
                while(rs.next()){
                    dto = new LaptopDTO();
                    dto.setId(rs.getInt(1));
                    dto.setPrice(rs.getFloat(2));
                    dto.setName(rs.getString(3));
                    dto.setCPU(rs.getString(4));
                    dto.setRam(rs.getString(5));
                    dto.setScreen(rs.getString(6));
                    dto.setGraphic(rs.getString(7));
                    dto.setDisk(rs.getString(8));
                    dto.setoS(rs.getString(9));
                    dto.setWeight(rs.getFloat(10));
                    dto.setRegion(rs.getString(11));
                    dto.setYear(rs.getInt(12));
                    list.add(dto);
                }
            }finally{
                closeConnection();
            }
            return list;       
    }
}
