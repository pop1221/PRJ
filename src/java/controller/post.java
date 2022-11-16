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
import java.sql.Array;
import java.util.ArrayList;
import model.account;
import model.forum;

/**
 *
 * @author Admin
 */
public class post extends HttpServlet {

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
        String username = "";
        String role = "2";
        String link = "";
        account account = (account)request.getSession().getAttribute("account");
        if(account!=null) {
            role = account.getDeci();
            username = account.getUssername();
        }
        if(role.equals("1")) {
            link = "views/admin/postadmin.jsp";
        } 
        if (role.equals("0")){
            link = "views/post.jsp";
        }
        if(role.equals("2")) {
            link = "views/login.jsp";
        }
        accountDBcontext dao = new accountDBcontext();
        ArrayList<forum> list = dao.loadpost();
        System.out.println(list);
        ArrayList<forum> newlist = new ArrayList<>();
        ArrayList<forum> commentlist = dao.loadcomment();
        for (forum o : list) {
            if(o.getUsername().trim().equals(username.trim())) {
                o.setCheckacc(true);
                newlist.add(o);
            }
        }
        for (forum o : list) {
            if(!o.getUsername().trim().equals(username.trim())) {
                newlist.add(o);
            }
        }
        ArrayList<forum> newlist1 = new ArrayList<>();
        
        // phân trang
        int index = 1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int pagezise = 10;
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
            newlist1.add(newlist.get(i));
        }
        request.setAttribute("index", index);
        request.setAttribute("startpage", startpage);
        request.setAttribute("endpage", endpage);
        request.setAttribute("nummberpage", nummberpage);
        request.setAttribute("username", username);
        request.setAttribute("commentlist", commentlist);
        request.setAttribute("list", newlist1);
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
        accountDBcontext dao = new accountDBcontext();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        account account = (account)request.getSession().getAttribute("account");
        String username = account.getUssername();
        System.out.println("title:"+title);
        System.out.println("content:"+content);
        System.out.println("user:"+username);
        dao.addforum(username, title, content);
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
