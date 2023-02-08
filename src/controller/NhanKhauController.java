/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Admin
 */
public class NhanKhauController implements Initializable{
      private StageController sc = new StageController();

//    @FXML
//    private Button add_btn;
//    @FXML
//    private Button edit_btn;
//    @FXML
//    private Button hokhau_btn;
//    @FXML
//    private Button nhankhau_btn;
    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;
    @FXML
    private ComboBox<String> choice_box;
    private final String[] find_by = {"Tìm theo tên", "Tìm theo CCCD"};
    
    @FXML
    private void switchToThemNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToThemNhanKhauScene(e);
    }
    
    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Choice box
        choice_box.getItems().addAll(find_by);
        
        phan_quyen();
    }
    
    public void phan_quyen() {
        if (LoginController.user.getRole().equals("to_truong")) {
            quanlysh_pane.setVisible(false);
            quanlysh_pane.setManaged(false);
        }
        if (LoginController.user.getRole().equals("can_bo")) {
            hokhau_pane.setVisible(false);
            hokhau_pane.setManaged(false);
            
            nhankhau_pane.setVisible(false);
            nhankhau_pane.setManaged(false);
            
            thongke_pane.setVisible(false);
            thongke_pane.setManaged(false);
        } 
    }
}
