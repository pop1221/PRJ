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
import jakarta.servlet.http.HttpSession;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.account;

/**
 *
 * @author Admin
 */
public class forget extends HttpServlet {

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
        request.getRequestDispatcher("views/forgetpassword.jsp").forward(request, response);
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
    
    public String getRandom() {
        Random random = new Random();
        int a = random.nextInt(999999);
        return String.format("%06d", a);
    }
    
   

    private account checkEmail(String email) {
        for (account list : dao.loadAccount()) {
            if ((list.getEmail() + " ").trim().equals(email)) {
                return list;
            }
        }
        return null;
    }

    private String sendEmail(String emailto) {
        String a = getRandom(); 
        String nameEmail = "hungnmhe160227@fpt.edu.vn";
        String passEmail = "nmh8122002";
        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(nameEmail, passEmail);
            }
        });
        try {
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(nameEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(emailto));
            mess.setSubject("Forget password");
            mess.setContent("Please click this link to reset your password: " + a, "text/html");
            Transport.send(mess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailto = request.getParameter("email");
        accountDBcontext acc = new accountDBcontext();
        account email = checkEmail(emailto);
        String alert = null;
        if (email == null) {
            alert = "Email không được đăng kí";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("views/forgetpassword.jsp").forward(request, response);
        } else {
            String a = sendEmail(emailto);
            request.getSession().setAttribute("code", a);
            request.getSession().setMaxInactiveInterval(300);
            request.getSession().setAttribute("emailto", emailto);
            response.sendRedirect("code");
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
