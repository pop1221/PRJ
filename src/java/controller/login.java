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
import jakarta.servlet.http.HttpSession;
import model.account;

/**
 *
 * @author Admin
 */
public class login extends HttpServlet {

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
        if (request.getSession().getAttribute("account") != null) {
            response.sendRedirect("home");
        } else {
            // get user, pass ở session
            if (request.getSession().getAttribute("username") != null) {
                request.setAttribute("username", request.getSession().getAttribute("username"));
            }
            if (request.getSession().getAttribute("password") != null) {
                request.setAttribute("password", request.getSession().getAttribute("password"));
            }
            // set user , pass vào login form
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    accountDBcontext dao = new accountDBcontext();

    String encodepass(String pass) {
        String encode = "";
        for (int i = 0; i < pass.length(); i++) {
            encode += "*";
        }
        return encode;
    }  // mã hóa password :))))))

    private account checkLogin(String username, String password) {
        for (account list : dao.loadAccount()) {
            if (list.getUssername().trim().equals(username) && list.getPassword().trim().equals(password)) {
                return list;
            }
        }
        return null;
    } // kiểm tra login

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        account account = checkLogin(username, password);
        if (account == null) {
            request.setAttribute("alert", "Tài khoản không tồn tại");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        } else {
            //lưu accoint lên session
            if (check != null) {
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);
            }
            request.getSession().setAttribute("account", account);
            response.sendRedirect("home");
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
