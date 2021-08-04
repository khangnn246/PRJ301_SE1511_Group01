/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LaptopDAO;
import DAO.UserDAO;
import DTO.LaptopDTO;
import DTO.LaptopError;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author congt
 */
public class UserListServlet extends HttpServlet {

    private final String ERROR_PAGE = "Error.jsp";
    private final String USER_SEARCH_PAGE = "/WEB-INF/jsp/user/UserPage.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;
        String button = request.getParameter("btn");
        
        try {
            LaptopDAO dao = new LaptopDAO();
            String name = request.getParameter("txtlaptopname");
            String minPrice = request.getParameter("txtminprice");
            String maxPrice = request.getParameter("txtmaxprice");
            String minYear = request.getParameter("txtminyear");
            String maxyear = request.getParameter("txtmaxyear");
            
            if ("Search".equals(button)) {
                int valid = 1 ;
                HttpSession session = request.getSession();
                UserDTO dto = (UserDTO) session.getAttribute("USER");

                LaptopError lapError = new LaptopError();
                if (!minPrice.isEmpty() && !minPrice.matches("[0-9]+")  && !minPrice.trim().isEmpty() ) {                    
                            valid = 0;
                        lapError.setPriceError("Price must be a number");
                        
                }
                if (!minYear.isEmpty() && !minYear.trim().isEmpty() && !minYear.trim().matches("[0-9]+")) {                  
                            valid = 0;
                        lapError.setYearError("Year must be a number");
                        
                }
                if (!maxPrice.isEmpty() && !maxPrice.matches("[0-9]+")  && !maxPrice.trim().isEmpty()) {                    
                            valid = 0;
                        lapError.setPriceError("Price must be a number");
                        
                }
                if (!maxyear.isEmpty() && !maxyear.matches("[0-9]+") && !maxyear.trim().isEmpty()) {                    
                            valid = 0;
                        lapError.setYearError("Year must be a number");
                        
                }
//                if (minYear == "" && maxyear == ""){
//                minYear = "0"; maxyear = "0";
//                }
//                if (minPrice == "" && maxPrice == ""){
//                    minPrice = "0"; maxPrice = "0";
//                }
              
                name = name.trim();
                
                if (valid == 1) {
                    if (minPrice.trim().isEmpty()) minPrice="0";
                    if (maxPrice.trim().isEmpty()) maxPrice = "0";
                    if (minYear.trim().isEmpty()) minYear = "0";
                    if (maxyear.trim().isEmpty()) maxyear = "0";
                    float minPrice1 = Float.parseFloat(minPrice);
                    float maxPrice1 = Float.parseFloat(maxPrice);
                    int minYear1 = Integer.parseInt(minYear);
                    int maxYear1 = Integer.parseInt(maxyear);
                    ArrayList<LaptopDTO> lapList = dao.SearchLaptop(name, minPrice1, maxPrice1, minYear1, maxYear1);
                    request.setAttribute("LapList", lapList);
                } else if (valid == 0) {
                    request.setAttribute("ErrorInput", lapError);
                }
            } else if ("SearchAllLaptop".equals(button)) {
                ArrayList<LaptopDTO> fullList = dao.getAllLaptop();
                request.setAttribute("LapList", fullList);
            } else if (button == null){
                ArrayList<LaptopDTO> fullList = dao.getAllLaptop();
                request.setAttribute("LapList", fullList);
                System.out.println("a");
            } else {
                ArrayList<LaptopDTO> fullList = dao.getAllLaptop();
                request.setAttribute("LapList", fullList);
            }
            url = USER_SEARCH_PAGE;
        } catch (NamingException ex) {
            log("UserSearch's naming exception: " + ex.getMessage());
        } catch (SQLException ex) {
            log("UserSearch's SQL exception: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
