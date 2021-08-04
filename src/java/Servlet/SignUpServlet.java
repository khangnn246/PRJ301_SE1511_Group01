/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UserDAO;
import DTO.UserError;
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
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    private final String SIGN_UP_PAGE = "SignUp.jsp";
    private final String ERROR_PAGE = "/WEB-INF/Error.jsp";
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
            boolean valid = true;
            int userId = -1;
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String name = request.getParameter("txtname");
            String phone = request.getParameter("txtphone");
            String address = request.getParameter("txtaddress");
            UserError error = new UserError();
            System.out.println(phone);
            if (username.trim().isEmpty()){
                error.setUsernameError("Please input username");
                valid = false;
            }
            if (password.trim().isEmpty()){
                error.setPasswordError("Please input password");
                valid = false;
            }
            if (name.trim().isEmpty()){
                error.setNameError("Please input name");
                valid = false;
            }
            if (address.trim().isEmpty()){
                valid = false;
                error.setAddressError("Please input Address");
            }
            if (phone.trim().isEmpty()){                
                valid = false;
                error.setPhoneError("Phone must be a number");
            }
            if (!phone.matches("[0-9]{10}")){
                valid = false;
                error.setPhoneError("Phone must contain 10 digits");
            }
            UserDAO dao = new UserDAO();
            if (valid){
                int role = 2;                
                userId = dao.createUser(username, password, role, name, phone, address);
                if (userId != -1){
                    request.setAttribute("SUCCESS", "Sign Up Success");
                }
            }
            else {
                request.setAttribute("errorobj", error);               
            }
            url = SIGN_UP_PAGE;
        }
         catch (NamingException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
