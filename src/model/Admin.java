/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class Admin   implements NhiemVu {
    
    public Admin(   ) {
    }

    @Override
    public void them_nhan_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void thay_doi_nhan_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void kiem_tra_lich_su() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void thong_ke() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xoa_nhan_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void them_ho_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void thay_doi_ho_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xoa_ho_khau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static User checkLogin(String input_account, String input_password) {
            String url = "jdbc:mysql://localhost:3306/nmcnpm";
            String user = "root";
            String password = "";
            String acount = "";
            String role = "";
            String sql = "select * from users where account = '" + input_account + "' ";
            try ( Connection conn = DriverManager.getConnection(url, user, password)) {
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    acount = result.getString("account");
                    password = result.getString("password");
                    role = result.getString("role");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!acount.equals(input_account)) {
                return null;
            } 
            else if (!password.equals(input_password)) {
                return null;
            }
            else return new User(acount, role);
//return "";
    }

    public ObservableList getFullHoKhau() {
        String url = "jdbc:mysql://localhost:3306/nmcnpm";
        String user = "root";
        String password = "";
        ObservableList ho_khau = FXCollections.observableArrayList();
        String sql = "select * from ho_khau ";
        try ( Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                ho_khau.add(new HoKhau(result.getInt("id"), result.getString("chu_ho"), result.getString("so_nha"), result.getString("ap"), result.getString("phuong"), result.getString("quan")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ho_khau;
    }
}
