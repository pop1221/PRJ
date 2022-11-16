/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import controller.post;
import java.util.ArrayList;
import model.account;
import model.forum;
import model.objclass;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {
        accountDBcontext dao = new accountDBcontext();
        for (account list : dao.loadAccount()) {
            if (list.getUssername().trim().equals("a2") && list.getPassword().trim().equals("a2")) {
                System.out.println(list);
            }
        }
    }
}
