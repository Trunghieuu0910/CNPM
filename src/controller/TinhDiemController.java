/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Services.SuKienService;
import bean.HoKhauBean;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.HoKhau;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.SuKien;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class TinhDiemController implements Initializable {
    private final StageController sc = new StageController();
    @FXML
    private Button trangchu_btn;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Button hokhau_btn;
    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Button nhankhau_btn;
    @FXML
    private Pane thongke_pane;
    @FXML
    private Button thongke_btn;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Button quanlysh_btn;
    @FXML
    private Pane quanlysh_pane1;
    @FXML
    private Button quanlydiem_btn;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TableView<HoKhauBean> check_table;
    @FXML
    private TableColumn<HoKhauBean, String> sohokhau_col;
    @FXML
    private TableColumn<HoKhauBean, String> chuho_col;
    @FXML
    private TableColumn<HoKhauBean, CheckBox> check_col;
    
    private SuKienService SKService = new SuKienService();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        phan_quyen();
        try {
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(TinhDiemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TinhDiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            comboBox.getItems().addAll(SKService.getNameSukien());
        } catch (SQLException ex) {
            Logger.getLogger(TinhDiemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TinhDiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    private void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }
    
    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }
    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }
    @FXML
    void switchToTinhDiemScene(ActionEvent e) throws IOException {
        sc.switchToTinhDiemScene(e);
    }
    
    @FXML
    public void handleExit() {
        sc.handleExit();
    }
    
    @FXML
    public void handleLogout(ActionEvent e) throws IOException {
        sc.handleLogout(e);
    }
    public void phan_quyen() {
            hokhau_pane.setVisible(false);
            hokhau_pane.setManaged(false);
            
            nhankhau_pane.setVisible(false);
            nhankhau_pane.setManaged(false);
            
            thongke_pane.setVisible(false);
            thongke_pane.setManaged(false);
    }
    
    public void showTable() throws SQLException, ClassNotFoundException {
        sohokhau_col.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHoKhauModel().getMaHoKhau()));

        chuho_col.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getChuHo().getHoTen()));

        check_col.setCellValueFactory(new PropertyValueFactory<>("check"));
        
        check_table.setItems(new SuKienService().getABC());
        
        boolean item = check_table.getItems().get(0).getCheck().isSelected();
        System.out.println(item);
    }
    @FXML
    public void diemDanh() {
        check_table.getItems().forEach(element -> {
            if (element.getCheck().isSelected()) {
                System.out.println("123");
            }
        });
    }
}
