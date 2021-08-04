/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LaptopDAO;
import DTO.ShoppingCartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UserDeleteLaptopServlet", urlPatterns = {"/UserDeleteLaptopServlet"})
public class UserDeleteLaptopServlet extends HttpServlet {

    private final String ERROR_PAGE = "/WEB-INF/Error.jsp";
    private final String SUCCESS = "/WEB-INF/jsp/user/UserViewCart.jsp";

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
        float totalprice = Float.parseFloat(request.getParameter("totalprice"));
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            LaptopDAO dao = new LaptopDAO();
            HttpSession session = request.getSession();
            List<ShoppingCartDTO> list = (List<ShoppingCartDTO>) session.getAttribute("cart");
            int index = dao.checkExisting(id, list);
            if (index != -1) {
                if (list.size() > 1) {
                    totalprice -= list.get(index).getLaptop().getPrice()*list.get(index).getQuantity();
                    list.remove(list.get(index));
                    session.setAttribute("cart", list);
                    request.setAttribute("totalprice", totalprice);
                    
                } else if (list.size() == 1) {
                    list.remove(index);
                    // session.removeAttribute("cart");
                }
            }
            url = SUCCESS;
        } catch (NamingException ex) {
            log("UserDeleteLaptopServlet's Naming Exception: " + ex.getMessage());
        } catch (SQLException ex) {
            log("UserDeleteLaptopServlet's SQL Exception: " + ex.getMessage());
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
