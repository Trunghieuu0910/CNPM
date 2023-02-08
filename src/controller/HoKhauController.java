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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 *
 * @author Admin
 */
public class HoKhauController implements Initializable {

    private final StageController sc = new StageController(); 
    
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
    
    private final String[] find_by = {"Tìm theo số hộ khẩu", "Tìm theo chủ hộ"};
    

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }
    @FXML
    void switchToThemHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToThemHoKhauScene(e);
    }
    
    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    void switchToDetailScene(ActionEvent e) throws IOException {
        sc.switchToDetailScene();
    }
    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }
    
    @FXML
    public void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirm?");
        alert.setHeaderText("A  ");
        alert.setContentText("Xóa hộ khẩu này?");
        
        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        alert.initModality(Modality.NONE);
        alert.showAndWait();
    }
    
    @FXML
    public void handleExit() {
        sc.handleExit();
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
