/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CheckoutDAO;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author khang
 */
@WebServlet(name = "UserViewDetailCartServlet", urlPatterns = {"/UserViewDetailCartServlet"})
public class UserViewDetailCartServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.jsp";
    private final String SUCCESS = "/WEB-INF/jsp/user/UserViewOrderDetail.jsp";
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
        String url = ERROR_PAGE;
        HttpSession session = request.getSession();
        try  {
            UserDTO user = (UserDTO) session.getAttribute("USER");
            int userId = user.getUserId();
            int orderId = Integer.parseInt(request.getParameter("id"));
            CheckoutDAO dao = new CheckoutDAO();
            ArrayList<OrderDetailDTO> list = dao.getOrderDetailById(orderId, userId);
            OrderDTO order = dao.getOrderByOrderId(orderId);
            float totalprice = order.getTotalprice();
            if (list != null){
                request.setAttribute("OrderDetailList", list);
                request.setAttribute("totalprice", totalprice);
                url = SUCCESS;
            }
        }
        catch (NamingException ex) {
            log ("UserViewDetailCartServlet's Naming Exception: " + ex.getMessage());
        } catch (SQLException ex) {
            log ("UserViewDetailCartServlet's SQL Exception: " + ex.getMessage());
        }        
        finally{
            request.getRequestDispatcher(url).forward(request, response);
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
