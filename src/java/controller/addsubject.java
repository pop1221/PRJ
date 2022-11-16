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
public class addsubject extends HttpServlet {

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
        request.getRequestDispatcher("views/admin/addsubject.jsp").forward(request, response);
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
        String subjectname = request.getParameter("subjectname");
        String totalslot = request.getParameter("totalSlot");
        String semester = request.getParameter("semester");
        accountDBcontext dao = new accountDBcontext();
        objclass o = dao.getsubject(subjectid);
        try {
            Integer.parseInt(totalslot);
            Integer.parseInt(semester);
        } catch (NumberFormatException e) {
            request.setAttribute("alert", "Vui lòng nhập đúng định dạng đữ liệu");
            doGet(request, response);
        }
        if (o != null) {
            request.setAttribute("alert", "Môn học này đã tồn tại");
            doGet(request, response);
        } else {
            dao.addsubject(subjectid, subjectname, totalslot, semester);
            request.getSession().setAttribute("search", "1");
            response.sendRedirect("searchsubject");
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
