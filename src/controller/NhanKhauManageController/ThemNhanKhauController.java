/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.NhanKhauManageController;

import controller.LoginController;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class ThemNhanKhauController implements Initializable{
    private StageController sc = new StageController();

    
    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;
//    @FXML
//    private Button add_btn;
//    @FXML
//    private Button edit_btn;
//    @FXML
//    private Button hokhau_btn;
//    @FXML
//    private Button nhankhau_btn;

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }
    
    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    private void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }
    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
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
    
    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phan_quyen();
    }
    
    
}
