/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ThongKeController implements Initializable {
    private StageController sc = new StageController();

    @FXML
    private AnchorPane pane1;
    @FXML
    private Pane genderChartPane; 
    @FXML
    private Pane ageChartPane;
    @FXML
    private Pane emptyPane; 
    
    @FXML
    private Button trangchu_btn;
    @FXML
    private Button hokhau_btn;
    @FXML
    private Button nhankhau_btn;
    @FXML
    private Button thongke_btn;
    @FXML
    private Button quanlysh_btn;
    @FXML
    private PieChart pie_chart;
    @FXML
    private BarChart<String, Integer> bar_chart;
    @FXML
    private ComboBox choice_box;
    @FXML
    private Button thongke_button;
    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        phan_quyen();
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Nam", 58),
                new PieChart.Data("Nữ", 45)
        );
        pie_chart.setData(pieChartData);
        
        String[] options = {"Theo giới tính", "Theo tuổi"};
        choice_box.getItems().addAll(options);
             
        XYChart.Series sr = new XYChart.Series();
        sr.getData().add(new XYChart.Data("Nam", 20));
        sr.getData().add(new XYChart.Data("Nữ", 40));        
        sr.getData().add(new XYChart.Data("Other", 40));

        
        bar_chart.getData().addAll(sr);
    }    

    @FXML
    private void switchToTrangChuScene(ActionEvent event) throws IOException {
        sc.switchToTrangChuScene(event);
    }

    @FXML
    private void switchToHoKhauScene(ActionEvent event) throws IOException {
        sc.switchToHoKhauScene(event);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent event) throws IOException {
        sc.switchToNhanKhauScene(event);
    }
    
    @FXML
    private void handleAction(ActionEvent event) {
        if (event.getSource() == thongke_button && choice_box.getValue() == "Theo giới tính") {
            genderChartPane.toFront();
        }
        else if (event.getSource() == thongke_button && choice_box.getValue() == "Theo tuổi") {
            ageChartPane.toFront();
        }
    }
    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }
    
    @FXML
    public void handleExit() {
        sc.handleExit();
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
