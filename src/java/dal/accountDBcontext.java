/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import controller.post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.account;
import model.forum;
import model.objclass;

/**
 *
 * @author Admin
 */
public class accountDBcontext {

    public String status;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public accountDBcontext() {
        try {
            con = new DBIcontext().getConnection();
        } catch (Exception e) {
            status = "error connection" + e.getMessage();
        }
    }

    public ArrayList<account> loadAccount() {
        ArrayList<account> AccList = new ArrayList<account>();
        String sql = "select * from account_HE160227";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccList.add(new account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            status = "Error " + e.getMessage();
        }
        return AccList;
    }

    public ArrayList<objclass> loadObjClass() {
        ArrayList<objclass> objclasslist = new ArrayList<>();
        String sql = "select subject.id, subject.name, subject.semester, class.id, class.[total student], register.semester, room.id, room.[slot booked], room.day, [total slot] from class, register, room, subject where subject.id like register.[id subject] and class.id like register.[id class] and register.STT = room.STT";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                objclasslist.add(new objclass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return objclasslist;
    }

    public ArrayList<objclass> loadclass() {
        ArrayList<objclass> classlist = new ArrayList<>();
        String sql = "select * from class_HE160227";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                classlist.add(new objclass(rs.getString(1), rs.getInt(2)));
            }
        } catch (Exception e) {
        }
        return classlist;
    }

    public ArrayList<objclass> loadSubject() {
        ArrayList<objclass> subjectlist = new ArrayList<>();
        String sql = "select * from subject_HE160227 order by semester asc";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                subjectlist.add(new objclass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
        }
        return subjectlist;
    }

    public ArrayList<forum> loadpost() {
        ArrayList<forum> forumlist = new ArrayList<>();
        String sql = "select * from forum_HE160227 order by pin desc";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                forumlist.add(new forum(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return forumlist;
    }
    
    public ArrayList<forum> loadcomment() {
        String sql = "select * from comment_HE160227";
        ArrayList<forum> commentlist = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                commentlist.add(new forum(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
        }
        return commentlist;
    }

    public objclass getobjclass(String classid, String subjectid) {
        String sql = "select subject.id, subject.name, subject.semester, class.id, class.[total student], register.semester, room.id, room.[slot booked], room.day, [total slot] from class, register, room, subject where subject.id like register.[id subject] and class.id like register.[id class] and register.STT = room.STT and subject.id = ? and class.id = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectid);
            ps.setString(2, classid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new objclass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public objclass getclass(String classid) {
        String sql = "select * from class_HE160227 where id = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new objclass(rs.getString(1), rs.getInt(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public objclass getsubject(String subjectid) {
        String sql = "select * from subject_HE160227 where id = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new objclass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public forum getforum(String STT) {
        String sql = "select * from forum_HE160227 where STT = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, STT);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new forum(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }   
    
    public ArrayList<forum> getforum1(String username) {
        String sql = "select * from forum_HE160227 where username = ?";
        ArrayList<forum> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new forum(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public String checkclass(String classid) {
        String sql = "select STT from register_HE160227 where [id class] = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String checksubject(String subjectid) {
        String sql = "select STT from register_HE160227 where [id subject] = ?";
        try {
            con = new DBIcontext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void register(account acc) {
        String sql = "INSERT INTO [account_HE160227]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[decentralization])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUssername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getDeci());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void changePass(String email, String pass) {
        String sql = "UPDATE [dbo].[account_HE160227]\n"
                + "   SET [password] = ?\n"
                + " WHERE email = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void changeEmail(String email, String username) {
        String sql = "UPDATE [dbo].[account_HE160227]\n"
                + "   SET [email] = ?\n"
                + " WHERE username = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteroom(String classid, String subjectid) {
        String sql = "delete from room_HE160227 where STT = (select STT from register where [id class] = ? and [id subject] = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.setString(2, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteregister(String classid, String subjectid) {
        String sql = "delete from register_HE160227 where [id class] = ? and [id subject] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.setString(2, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteclass(String classid) {
        String sql = "delete from class_HE160227 where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deletesubject(String subjectid) {
        String sql = "delete from subject_HE160227 where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteforum(String STT) {
        String sql = "delete from forum_HE160227 where STT = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, STT);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deletecmt(String STT) {
        String sql = "delete comment_HE160227 where STT = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, STT);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteuser(String username) {
        String sql = "delete account_HE160227 where username = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void addclass(String classid, String totalstudent) {
        String sql = "insert into class values(?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.setString(2, totalstudent);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addsubject(String subjectid, String subjectname, String totalslot, String semester) {
        String sql = "insert into subject values(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectid);
            ps.setString(2, subjectname);
            ps.setString(3, totalslot);
            ps.setString(4, semester);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addregister(String classid, String subjectid, String semester) {
        String sql = "insert into register values(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.setString(2, subjectid);
            ps.setString(3, semester);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addroom(String roomid, String slot, String day) {
        String sql = "insert into room values(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, roomid);
            ps.setString(2, slot);
            ps.setString(3, day);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addforum(String username, String title, String text) {
        String sql = "insert into forum(username,title,text) values (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, title);
            ps.setString(3, text);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void addcomment(String username, String content, String STT) {
        String sql = "insert into comment values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, content);
            ps.setString(3, STT);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateroom(String roomid, String slotbooked, String day, String classid, String subjectid) {
        String sql = "update room set id = ?, [slot booked] = ?, day = ? where STT = (select STT from register where [id class] = ? and [id subject] = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, roomid);
            ps.setString(2, slotbooked);
            ps.setString(3, day);
            ps.setString(4, classid);
            ps.setString(5, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateregister(String semester, String classid, String subjectid) {
        String sql = "update register set semester = ? where [id class] = ? and [id subject] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, semester);
            ps.setString(2, classid);
            ps.setString(3, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateclass(String totalstudent, String classid) {
        String sql = "update class set [total student] = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, totalstudent);
            ps.setString(2, classid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updatesubject(String subjectname, String totalslot, String semester, String subjectid) {
        String sql = "update subject set name = ?, [total slot] = ?, semester = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, subjectname);
            ps.setString(2, totalslot);
            ps.setString(3, semester);
            ps.setString(4, subjectid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void updateforum(String title, String text, String STT) {
        String sql = "update forum set title = ?, text = ? where STT = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, text);
            ps.setString(3, STT);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void updatepin(String pin, String STT) {
        String sql = "update forum set pin = ? where STT = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pin);
            ps.setString(2, STT);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void setadmin(String defi, String username) {
        String sql = "update account_HE160227 set decentralization = ? where username = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, defi);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        
    }
}
