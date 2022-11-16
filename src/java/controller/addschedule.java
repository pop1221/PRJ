/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accountDBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.objclass;

/**
 *
 * @author Admin
 */
public class addschedule extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.getRequestDispatcher("views/admin/addschedule.jsp").forward(request, response);
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
        String subjectid = request.getParameter("subjectid");
        String classid = request.getParameter("classid");
        String semester = request.getParameter("semester");
        String roomid = request.getParameter("roomid");
        String slotbooked = request.getParameter("slotbooked");
        String day = request.getParameter("day");
        accountDBcontext dao = new accountDBcontext();
        objclass o = dao.getobjclass(classid, subjectid);
        if (o != null) {
            request.setAttribute("alert", "Lịch học này đã tồn tại");
            doGet(request, response);
        } else {
            if (dao.getclass(classid) == null || dao.getsubject(subjectid) == null) {
                request.setAttribute("alert", "Không tồn tại môn học hoặc lớp này");
                doGet(request, response);
            } else {
                dao.addregister(classid, subjectid, semester);
                dao.addroom(roomid, slotbooked, day);
                request.getSession().setAttribute("search", "1");
                response.sendRedirect("search");
            }
        }
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
