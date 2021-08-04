/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UserDAO;
import DTO.UserDTO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author khang
 */
@WebServlet(name = "UserUpdateServlet", urlPatterns = {"/UserUpdateServlet"})
public class UserUpdateServlet extends HttpServlet {
    private final String ERROR_PAGE = "Error.jsp";
    private final String SUCCESS = "/WEB-INF/jsp/user/UserViewProfile.jsp";
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
        HttpSession session = request.getSession();
        String url = ERROR_PAGE;
        try  {
            UserError error = new UserError();
            boolean valid = true;
            UserDAO dao = new UserDAO();
            UserDTO user = (UserDTO) session.getAttribute("USER");
            int id = user.getUserId();
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
            String fullName = request.getParameter("txtfullname");
            String phone = request.getParameter("txtphone");
            String address = request.getParameter("txtaddress");
            System.out.println(phone);
            if (username.trim().isEmpty()){
                valid = false;
                error.setUsernameError("Please input Username");
            }
            if (password.trim().isEmpty()){
                valid = false;
                error.setPasswordError("Please input Password");
            }
            if (fullName.trim().isEmpty()){
                valid = false;
                error.setNameError("Please input Name");
            }
            if (phone.trim().isEmpty()){
                valid = false;
                error.setPhoneError("Phone must be a number");
            }
            if (!phone.matches("[0-9]{10}")){
                valid = false;
                System.out.println(phone);
                error.setPhoneError("Phone must contain 10 digits");
            }
            if (address.trim().isEmpty()){
                valid = false;
                error.setAddressError("Please input Address");
            }
            System.out.println(valid);
            if (valid){
                UserDTO users = new UserDTO(id, username, password, 2, fullName, phone, address);
                boolean check = dao.UpdateUser(users);
                if (check){
                    UserDTO userupdate = dao.getUserById(id);
                    session.setAttribute("USER", userupdate);
                    request.setAttribute("Updatesuccess", "Information Updated");
                }
            }
            else {
                request.setAttribute("Fail", "Update Fail");
                request.setAttribute("Error", error);
                url = SUCCESS;
            }
            url = SUCCESS;
        }
        catch (NamingException ex) {
            Logger.getLogger(UserUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
