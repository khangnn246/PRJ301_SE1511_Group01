/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LaptopDAO;
import DTO.LaptopDTO;
import DTO.LaptopError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SE140866
 */
public class EmployeeEditServlet extends HttpServlet {
    private final String LIST = "EmployeeLoadListServlet";
    private final String FORM = "/WEB-INF/jsp/employee/EmployeeLaptopInformation.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FORM; 
        LaptopError dtoErr = new LaptopError();
        
        LaptopDAO dao = new LaptopDAO();
        LaptopDTO dto = new LaptopDTO();
        int count = 0;
        boolean check = true;
        try {             
            String elid = request.getParameter("elid");
            
            if(Integer.parseInt(elid)!=0){
                request.setAttribute("dto", dao.getAllLaptop(Integer.parseInt(elid)).get(0));
            }

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String cpu = request.getParameter("cpu");
            String ram = request.getParameter("ram");
            String screen = request.getParameter("screen");
            String graphic = request.getParameter("graphic");
            String disk = request.getParameter("disk");
            String os = request.getParameter("os");
            String weight = request.getParameter("weight");
            String region = request.getParameter("region");
            String year = request.getParameter("year");

            if(request.getParameter("btn")!=null){//check valid
                dtoErr.setIdError(" ");
                dtoErr.setNameError(dao.checkName(name));
                dtoErr.setPriceError(dao.checkPrice(price));
                dtoErr.setCPUError(dao.checkCpu(cpu));
                dtoErr.setRamError(dao.checkRam(ram));
                dtoErr.setScreenError(dao.checkScreen(screen));
                dtoErr.setGraphicError(dao.checkGraphic(graphic));
                dtoErr.setDiskError(dao.checkDisk(disk));
                dtoErr.setOSError(dao.checkOs(os));
                dtoErr.setWeightError(dao.checkWeight(weight));
                dtoErr.setRegionError(dao.checkRegion(region));
                dtoErr.setYearError(dao.checkYear(year));
            }
            String[] w = dtoErr.toString().split("=");
            for(String i : w){
                check = i.equals(" ");
                if (check) count++;
            }
            request.setAttribute("dtoErr", dtoErr);
            
            if(count==12){
                dto = new LaptopDTO(Integer.parseInt(id), name, Float.parseFloat(price), cpu, ram, 
                        screen, graphic, disk, os, Float.parseFloat(weight), region, Integer.parseInt(year)); 
                if(Integer.parseInt(elid)==0){
                    dao.create(dto);
                }else{                    
                    dao.updateWithID(dto);
                }
                url = LIST;
            }else if(count!=12){                
                url = FORM;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println(url);
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
