/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import bean.HoKhauBean;
import controller.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.SuKien;

/**
 *
 * @author Admin
 */
public class SuKienService {
    public void ThemSuKien(String name, String place, String content, String time, Label check) throws SQLException, ClassNotFoundException {
        Connection conn = MysqlConnection.getMysqlConnection();
        PreparedStatement pst = null;
        String sql = "insert into su_kien (name, place, content,time) values(?,?,?,?)";
        try  {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, place);
            pst.setString(3, content);
            System.out.println(time);
            pst.setString(4, time);
            pst.execute();
            check.setText("Thêm sự kiện thành công!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ObservableList getSuKien() throws SQLException, ClassNotFoundException {
        Connection conn = MysqlConnection.getMysqlConnection();
        ObservableList su_kien = FXCollections.observableArrayList();
        ResultSet result = null;
        String sql = "select * from su_kien ";
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                su_kien.add(new SuKien(result.getString("id"), result.getString("name"), result.getString("place"), result.getString("time"), result.getString("content")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return su_kien;
    }

    public List<String> getNameSukien() throws SQLException,ClassNotFoundException {
        Connection conn = MysqlConnection.getMysqlConnection();
        List<String> listName = new ArrayList<>();
        String sql = "select name from su_kien";
        try  {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                listName.add(result.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listName;
    }
    
    public ObservableList getABC () throws SQLException, ClassNotFoundException {
        Connection conn = MysqlConnection.getMysqlConnection();
        ObservableList res = FXCollections.observableArrayList();
        String sql = "SELECT * from ho_khau as hk join nhan_khau as nk on nk.ID = hk.idChuHo";
        try  {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                HoKhauModel hk;
                hk = new HoKhauModel(result.getInt("id"), result.getString("maHoKhau"), result.getInt("idChuHo"), result.getString("maKhuVuc"),result.getString("diaChi"), result.getDate("ngayLap"), result.getDate("ngayChuyenDi"), result.getString("lyDoChuyen"), result.getInt("nguoiThucHien"));
                NhanKhauModel nk;
                nk = new NhanKhauModel(result.getInt("ID"), result.getString("maNhanKhau"), result.getString("hoTen"), result.getString("bietDanh"), result.getDate("namSinh"), result.getString("gioiTinh"), result.getString("noiSinh"),result.getString("nguyenQuan"),result.getString("danToc"),result.getString("tonGiao"),result.getString("quocTich"),result.getString("soHoChieu"),result.getString("noiThuongTru"),result.getString("diaChiHienNay"),result.getString("trinhDoHocVan"),result.getString("trinhDoChuyenMon"), null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, null, null);
                res.add(new HoKhauBean(hk, nk, new CheckBox()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
