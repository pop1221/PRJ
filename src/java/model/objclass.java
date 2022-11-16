/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class objclass {
    private String subjectid;
    private String subjectname;
    private String classid;
    private int totalstudent;
    private String semester;
    private String roomid;
    private String slotbooked;
    private String day;
    private int totalslot;
    private int kihoc;
    private boolean check;

    public objclass() {
    }

    public objclass(String classid, int totalstudent) {
        this.classid = classid;
        this.totalstudent = totalstudent;
    }

    public objclass(String subjectid, String subjectname, int totalslot, int kihoc) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.totalslot = totalslot;
        this.kihoc = kihoc;
    }
    
    public objclass(String subjectid, String subjectname,int kihoc, String classid, int totalstudent, String semester, String roomid, String slotbooked, String day, int totalslot) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.kihoc = kihoc;
        this.classid = classid;
        this.totalstudent = totalstudent;
        this.semester = semester;
        this.roomid = roomid;
        this.slotbooked = slotbooked;
        this.day = day;
        this.totalslot = totalslot;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getKihoc() {
        return kihoc;
    }

    public void setKihoc(int kihoc) {
        this.kihoc = kihoc;
    }
    
    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getSlotbooked() {
        return slotbooked;
    }

    public void setSlotbooked(String slotbooked) {
        this.slotbooked = slotbooked;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    } 

    public int getTotalslot() {
        return totalslot;
    }

    public void setTotalslot(int totalslot) {
        this.totalslot = totalslot;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "objclass{" + "subjectid=" + subjectid + ", subjectname=" + subjectname + ", classid=" + classid + ", totalstudent=" + totalstudent + ", semester=" + semester + ", roomid=" + roomid + ", slotbooked=" + slotbooked + ", day=" + day + ", totalslot=" + totalslot + ", kihoc=" + kihoc + ", check=" + check + '}';
    }
        
}
