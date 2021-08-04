/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DTO.ShoppingCartDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "UserViewCartServlet", urlPatterns = {"/UserViewCartServlet"})
public class UserViewCartServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.jsp";
    private final String VIEW_CART_PAGE = "/WEB-INF/jsp/user/UserViewCart.jsp";
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
        String url =ERROR_PAGE;
        HttpSession session = request.getSession();
        float totalprice = 0;
        try  {
            String name = request.getParameter("txtlastname");
            String minPrice = request.getParameter("lastminprice");
            String maxPrice = request.getParameter("lastmaxprice");
            String minYear = request.getParameter("lastminyear");
            String maxYear = request.getParameter("lastmaxyear");
            String btn = request.getParameter("lastbtn");
            
            List<ShoppingCartDTO> cart = (List<ShoppingCartDTO>) session.getAttribute("cart");
            if (cart != null){
            for (ShoppingCartDTO shoppingCartDTO : cart) {
                int count = shoppingCartDTO.getQuantity();
                totalprice += shoppingCartDTO.getLaptop().getPrice()*count;
            }
        }
            request.setAttribute("txtlastname", name);
            request.setAttribute("txtlastminprice", minPrice);
            request.setAttribute("txtlastmaxprice", maxPrice);
            request.setAttribute("txtlastminyear", minYear);
            request.setAttribute("txtlastmaxyear", maxYear);
            request.setAttribute("lastbtn", btn);
            request.setAttribute("totalprice", totalprice);
            url = VIEW_CART_PAGE;
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
