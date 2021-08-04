/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LaptopDAO;
import DTO.LaptopDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khang
 */
@WebServlet(name = "UserViewDetailServlet", urlPatterns = {"/UserViewDetailServlet"})
public class UserViewDetailServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.jsp";
    private final String VIEW_DETAIL_PAGE = "/WEB-INF/jsp/user/UserViewDetail.jsp";
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
        try {
            int id = Integer.parseInt(request.getParameter("id")); 
            String name = request.getParameter("txtlastname");
            String minPrice = request.getParameter("txtlastminprice");
            String maxPrice = request.getParameter("txtlastmaxprice");
            String minYear = request.getParameter("txtlastminyear");
            String maxYear = request.getParameter("txtlastmaxyear");
            String button = request.getParameter("btn");
            System.out.println(button);
            LaptopDAO dao = new LaptopDAO();
            LaptopDTO dto = dao.getLaptopById(id);
            
            if (dto != null) {
                
                request.setAttribute("Laptop", dto);
                request.setAttribute("lastSearchName", name);
                request.setAttribute("lastSearchMinPrice", minPrice);
                request.setAttribute("lastSearchMaxPrice", maxPrice);
                request.setAttribute("lastSearchMinYear", minYear);
                request.setAttribute("lastSearchMaxYear", maxYear);
                request.setAttribute("btn", button);
                url = VIEW_DETAIL_PAGE;
                
            }
        }
        catch (NamingException ex) {
            log ("UserViewDetailServlet's Naming Exception : " + ex.getMessage());
        } catch (SQLException ex) {
            log ("UserViewDetailServlet's SQL Exception : " + ex.getMessage());
        }        
        finally{
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
