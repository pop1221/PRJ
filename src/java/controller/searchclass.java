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
import java.util.ArrayList;
import model.account;
import model.objclass;

/**
 *
 * @author Admin
 */
public class searchclass extends HttpServlet {

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
    accountDBcontext dao = new accountDBcontext();
    ArrayList<objclass> list;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String search = (String)request.getSession().getAttribute("search");
        if(search == null) {
            search = "0";
        }
        System.out.println(search);
        if(request.getParameter("search")!=null || list == null || search.equals("1")) {
            list = dao.loadclass();
        }
        request.getSession().removeAttribute("search");
        String role = "0";
        String link;
        account account = (account)request.getSession().getAttribute("account");
        if(account!=null) {
            role = account.getDeci();
        }
        if(role.equals("1")) {
            link = "views/admin/searchclass.jsp";
        } else {
            link = "views/seeclass.jsp";
        }
        ArrayList<objclass> newlist = new ArrayList<>();
        int index = 1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int pagezise = 7;
        int count = list.size();
        int startpage = index - 2;
        if(startpage <= 0) {
            startpage = 1;
        }
        int nummberpage = count / pagezise;
        if (count % pagezise != 0) {
            nummberpage++;
        }
        int endpage = index + 2;
        if(endpage > nummberpage) {
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
        for (objclass object : list) {
            if(dao.checkclass(object.getClassid())==null) {
                object.setCheck(true);
            }
        }
        request.setAttribute("list", newlist);
        request.getRequestDispatcher(link).forward(request, response);
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
        String classid = request.getParameter("classid");
        String totalstudent = request.getParameter("totalstudent");
        accountDBcontext dao = new accountDBcontext();
        ArrayList<objclass> list = dao.loadclass();
        if(classid.length() != 0) {
            list.removeIf(a -> !a.getClassid().trim().contains(classid.trim()));
        }
        if(totalstudent.length() != 0) {
            list.removeIf(a -> a.getTotalstudent() != Integer.parseInt(totalstudent));
        }
        if(list.isEmpty()) {
            request.setAttribute("alert", "Không tìm thấy");
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
