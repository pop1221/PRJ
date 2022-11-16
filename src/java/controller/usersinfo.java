/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accountDBcontext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.account;
import model.objclass;

/**
 *
 * @author Admin
 */
public class usersinfo extends HttpServlet {

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
    ArrayList<account> list;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        accountDBcontext dao = new accountDBcontext();
        if(list == null || request.getSession().getAttribute("search")!=null || request.getParameter("search")!=null) {
            list = dao.loadAccount();
        }
        request.getSession().removeAttribute("search");
        ArrayList<account> newlist = new ArrayList<>();
        int index = 1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int pagezise = 8;
        int count = list.size();
        int startpage = index - 2;
        if (startpage <= 0) {
            startpage = 1;
        }
        int nummberpage = count / pagezise;
        if (count % pagezise != 0) {
            nummberpage++;
        }
        int endpage = index + 2;
        if (endpage > nummberpage) {
            endpage = nummberpage;
        }
        for (int i = pagezise * (index - 1); i <= pagezise * index - 1; i++) {
            if (i == count) {
                break;
            }
            newlist.add(list.get(i));
        }
        request.setAttribute("startpage", startpage);
        request.setAttribute("endpage", endpage);
        request.setAttribute("nummberpage", nummberpage);
        request.setAttribute("list", newlist);
        request.getRequestDispatcher("views/admin/usersinfo.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        accountDBcontext dao = new accountDBcontext();
        ArrayList<account> list = dao.loadAccount();
        for (account object : list) {
            System.out.println(object.getEmail());
        }
        if (username.length() != 0) {
            list.removeIf(a -> !a.getUssername().trim().contains(username.trim()));
        }
        if (email.length() != 0) {
            System.out.println(email);
            list.removeIf(a -> !a.getEmail().trim().contains(email.trim()));
        }
        if (list.isEmpty()) {
            request.setAttribute("alert", "Không tìm thấy");
            request.getRequestDispatcher("views/admin/searchclass.jsp").forward(request, response);
        }
        this.list = list;
        doGet(request, response);
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
