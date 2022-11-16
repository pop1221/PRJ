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
import model.account;

/**
 *
 * @author Admin
 */
public class regis extends HttpServlet {

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
        request.getRequestDispatcher("views/register.jsp").forward(request, response);
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
    
    private account checkUsername(String username) {
        for (account list : dao.loadAccount()) {
            if(list.getUssername().trim().equals(username)) {
                return list;
            }
        }
        return null;
    }  // kiểm tra xem usernawm này đã tồn tại chưa
    
    private account checkEmail(String email) {
        for (account list : dao.loadAccount()) {
            if ((list.getEmail() + " ").trim().equals(email)) {
                return list;
            }
        }
        for (account object : dao.loadAccount()) {
            
        }
        return null;
    } // kiểm tra xem enail này đã được đăng kí chưa
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        accountDBcontext acc = new accountDBcontext();
        account account = new account();
        account.setUssername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setDeci("0");
        String alert;
        if(checkEmail(email)!=null) {
            request.setAttribute("alert", "Email đã được đăng kí");
            doGet(request, response);
        } // email đã được đăng kí
        if(!password.equals(repassword)) {
            alert = "sai mật khẩu nhập lại";
            request.setAttribute("alert", alert);
            doGet(request, response);
        } // sai mât khẩu nhập lại
        if(checkUsername(username) == null) {
            acc.register(account);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        } // đăng kí thành công
        else {
            alert = "tên đăng kí đã được dùng";
            request.setAttribute("alert", alert);
            doGet(request, response);
        } // username đã tồn tại
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
