/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accountDBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.account;

/**
 *
 * @author Admin
 */
public class changePassword extends HttpServlet {

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
        request.getRequestDispatcher("views/changePassword.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    accountDBcontext dao;

    public void init() {
        dao = new accountDBcontext();
    }
    
    private account checkLogin(String username) {
        for (account list : dao.loadAccount()) {
            if (list.getUssername().trim().equals(username)) {
                return list;
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String repassword = request.getParameter("repassword");
        account account = (account)request.getSession().getAttribute("account");
        if (account != null) {
            if (!oldpassword.equals(checkLogin(account.getUssername().trim()).getPassword().trim())) {
                request.setAttribute("alert", "Sai mật khẩu cũ");
                doGet(request, response);
            } else {
                if (!newpassword.equals(repassword)) {
                    request.setAttribute("alert", "Sai mật khẩu nhập lại");
                    doGet(request, response);
                } else {
                    dao.changePass(account.getEmail(), repassword);
                    request.getSession().removeAttribute("account");
                    response.sendRedirect("login");
                }
            }
        } else {
            request.setAttribute("alert", "Bạn chưa đăng nhập");
                doGet(request, response);
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
