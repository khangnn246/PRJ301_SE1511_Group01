/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UserDAO;
import DTO.UserDTO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author khang
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private final String LOGIN_SUCCESS = "";
    private final String LOGIN_ADMIN_SUCCESS = "/WEB-INF/jsp/AdminList.jsp";
    private final String LOGIN_PAGE = "Login.jsp";
    private final String LOGIN_USER_SUCCESS = "/WEB-INF/UserPage.jsp";
    private final String LOGIN_FAIL = "/WEB-INF/Error.jsp";
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
        String url = LOGIN_FAIL;
        try {
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            UserDTO dto = dao.getdto(username, password);
            
            if (dto != null){
                session.setAttribute("USER", dto);
//                if (dto.getRole() == 1){
//                    url = LOGIN_ADMIN_SUCCESS;
//                }
//                else if (dto.getRole() == 2){
//                    url = LOGIN_USER_SUCCESS;
//                }
            url = LOGIN_SUCCESS;
            }
            else {
                request.setAttribute("ErrorLogin", "Invalid username or Password");
                url = LOGIN_PAGE;
                
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            log ("LoginServlet's SQL exception: " + ex.getMessage());
        } catch (NamingException ex) {
            log ("LoginServlet's Naming exception: " + ex.getMessage());
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
