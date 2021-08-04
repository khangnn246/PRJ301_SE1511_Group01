/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LaptopDAO;
import DTO.LaptopDTO;
import DTO.ShoppingCartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "UserAddItemToCart", urlPatterns = {"/UserAddItemToCart"})
public class UserAddItemToCart extends HttpServlet {

    private final String ERROR = "Error.jsp";
    private final String USER_SEARCH_CONTROLLER = "UserListServlet";

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
        int id = Integer.parseInt(request.getParameter("txtLaptopId"));
        String name = request.getParameter("lastname");
        String minPrice = request.getParameter("lastminprice");
        String maxPrice = request.getParameter("lastmaxprice");
        String minYear = request.getParameter("lastminyear");
        String maxYear = request.getParameter("lastmaxyear");
        String button = request.getParameter("lastbtn");
        String url = ERROR;
        try {
            LaptopDAO dao = new LaptopDAO();
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") == null) {
                List<ShoppingCartDTO> cart = new ArrayList<>();
                LaptopDTO dto = dao.getLaptopById(id);
                ShoppingCartDTO shoppingcart = new ShoppingCartDTO(dto, 1);
                cart.add(shoppingcart);
                session.setAttribute("cart", cart);
            } else {
                List<ShoppingCartDTO> cart = (List<ShoppingCartDTO>) session.getAttribute("cart");
                int index = dao.checkExisting(id, cart);
                if (index == -1) {
                    LaptopDTO dto = dao.getLaptopById(id);
                    ShoppingCartDTO shoppingCart = new ShoppingCartDTO(dto, 1);
                    cart.add(shoppingCart);
                } else {
                    int quantity = cart.get(index).getQuantity() + 1;
                    cart.get(index).setQuantity(quantity);
                }
                session.setAttribute("cart", cart);
            }
            url = "UserListServlet?"
                    + "&btn="+button
                    + "&txtlaptopname="+name
                    + "&txtminprice="+minPrice
                    + "&txtmaxprice="+maxPrice
                    + "&txtminyear="+minYear
                    + "&txtmaxyear="+maxYear
                    + "&btn="+button;
        } catch (NamingException ex) {
            log ("UserAddItemToCartServlet's Naming Exception: " + ex.getMessage());
        } catch (SQLException ex) {
            log ("UserAddItemToCartServlet's SQL Exception: " + ex.getMessage());
        } 
        finally {
            response.sendRedirect(url);
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
