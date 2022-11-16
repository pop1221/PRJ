/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class forum {
    private String username;
    private String title;
    private String content;
    private String pin;
    private int STT;
    private boolean checkacc; // kiểm tra tài khoản

    public forum() {
    }

    public forum(String username, String content, int STT) {
        this.username = username;
        this.content = content;
        this.STT = STT;
    }
    
    public forum(String username, String title, String content, String pin, int STT) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.pin = pin;
        this.STT = STT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public boolean isCheckacc() {
        return checkacc;
    }

    public void setCheckacc(boolean checkacc) {
        this.checkacc = checkacc;
    }
    
}
