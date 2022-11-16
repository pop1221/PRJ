/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class account {
    private String ussername;
    private String password;
    private String email;
    private String deci;
    public account() {
    }

    public account(String ussername, String password, String email, String deci) {
        this.ussername = ussername;
        this.password = password;
        this.email = email;
        this.deci = deci;
    }

    public String getUssername() {
        return ussername;
    }

    public void setUssername(String ussername) {
        this.ussername = ussername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeci() {
        return deci;
    }

    public void setDeci(String deci) {
        this.deci = deci;
    }

    
    
}
