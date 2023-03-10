/* 
    Created on : Oct 22, 2022
    Author     : Nguyen Manh Phuong - Bui Anh Tuan
    Teacher    : Trinh Thanh Trung
    Class      : Nhap mon cong nghe phan mem - code: 136813
 */
package controller.NhanKhauManageController;

import model.*;
import Services.NhanKhauService;
import controller.LoginController;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**
 *
 * @author Admin
 */
public class DangKyTamTruController implements Initializable {

    private StageController sc = new StageController();
    private NhanKhauService nhanKhauService = new NhanKhauService();

    private DangKyTamTruController controller;
    private TamTruModel tamTruModel;

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;

    @FXML
    private TextField soCMT_TextField;

    @FXML
    private Pane check_pane;

    @FXML
    private TextField maGiayTamTru_TextField;

    @FXML
    private TextField soDienThoai_TextField;

    @FXML
    private DatePicker tuNgay_DatePicker;

    @FXML
    private DatePicker denNgay_DatePicker;

    @FXML
    private TextArea lyDo_TextArea;

    @FXML
    private Button check_Button;

    @FXML
    private Button dangKyTamTru_Button;

    @FXML
    public void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    public void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    public void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    public void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    public void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }

    @FXML
    public void switchToThemNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToThemNhanKhauScene(e);
    }

    @FXML
    public void switchToDangKyTamVangScene(ActionEvent e) throws IOException {
        sc.switchToDangKyTamVangScene(e);
    }

    @FXML
    public void switchToDangKyTamTruScene(ActionEvent e) throws IOException {
        sc.switchToDangKyTamTruScene(e);
    }

    @FXML
    public void switchToKhaiTuScene(ActionEvent e) throws IOException {
        sc.switchToKhaiTuScene(e);
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

    public boolean checkCMT() {
        if (soCMT_TextField.getText().trim() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Vui l??ng nh???p s??? CMT");
            alert.show();
            return false;
        } else if (soCMT_TextField.getText().trim().length() < 12 || soCMT_TextField.getText().trim().length() > 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Vui l??ng nh???p ????ng ?????nh d???ng CMT");
            alert.show();
            return false;
        } else {
            int res = nhanKhauService.checkCMT(soCMT_TextField.getText().trim());
            if (res == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("S??? CMT kh??ng t???n t???i!");
                alert.show();
                check_pane.setVisible(false);
                return false;
            } else {
                check_pane.setVisible(true);
                maGiayTamTru_TextField.setDisable(false);
                soDienThoai_TextField.setDisable(false);
                tuNgay_DatePicker.setDisable(false);
                denNgay_DatePicker.setDisable(false);
                lyDo_TextArea.setDisable(false);
                return true;
            }
        }
    }

    private boolean checkThongTinTamTru() {
        if (maGiayTamTru_TextField.getText().trim().isEmpty()
                || soDienThoai_TextField.getText().trim().isEmpty()
                || lyDo_TextArea.getText().trim().isEmpty()
                || tuNgay_DatePicker.getValue() == null
                || denNgay_DatePicker.getValue() == null) {
            return false;
        }
        return true;
    }

    @FXML
    public void dangKyTamTru() throws SQLException {
        try {
            if (checkThongTinTamTru()) {
                TamTruModel tamTruModel = new TamTruModel();
                tamTruModel.setMaGiayTamTru(this.maGiayTamTru_TextField.getText().trim());
                tamTruModel.setID(39);
                tamTruModel.setSoDienThoaiNguoiDangKy(this.soDienThoai_TextField.getText().trim());

                tamTruModel.setTuNgay(java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()));
                tamTruModel.setDenNgay(java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()));
                tamTruModel.setLyDo(this.lyDo_TextArea.getText().trim());
                boolean res = nhanKhauService.addNew(new TamTruModel(39,
                        maGiayTamTru_TextField.getText().trim(),
                        soDienThoai_TextField.getText().trim(),
                        java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()), java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()),
                        lyDo_TextArea.getText().trim()));
                if (res && checkCMT()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Th??ng b??o");
                    alert.setHeaderText("Th??nh c??ng!");
                    alert.show();

                    resetInput();

                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("Vui l??ng nh???p ?????y ????? th??ng tin!");
                alert.show();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phan_quyen();

        check_pane.setVisible(false);

        maGiayTamTru_TextField.setDisable(true);
        soDienThoai_TextField.setDisable(true);
        tuNgay_DatePicker.setDisable(true);
        denNgay_DatePicker.setDisable(true);
        lyDo_TextArea.setDisable(true);
    }

    public void resetInput() {
        soCMT_TextField.setText("");
        maGiayTamTru_TextField.setText("");
        soDienThoai_TextField.setText("");
        tuNgay_DatePicker.setValue(null);
        denNgay_DatePicker.setValue(null);
        lyDo_TextArea.setText("");
        check_pane.setVisible(false);

        maGiayTamTru_TextField.setDisable(true);
        soDienThoai_TextField.setDisable(true);
        tuNgay_DatePicker.setDisable(true);
        denNgay_DatePicker.setDisable(true);
        lyDo_TextArea.setDisable(true);
    }

    @FXML
    public void checkFieldPress(KeyEvent e) {
        check_pane.setVisible(false);

        maGiayTamTru_TextField.setDisable(true);
        soDienThoai_TextField.setDisable(true);
        tuNgay_DatePicker.setDisable(true);
        denNgay_DatePicker.setDisable(true);
        lyDo_TextArea.setDisable(true);
    }

    @FXML
    public void cancelAction(ActionEvent e) throws IOException {
        if (alertcancel() == 1) {
            sc.switchToNhanKhauScene(e);
        }
    }

    public int alertcancel() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("X??c nh???n");
        alert.setHeaderText("C???nh b??o");
        alert.setContentText("B???n c?? ch???c ch???n mu???n tho??t kh??ng?");

        ButtonType buttonTypeOne = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            return 1;
        } else {
            return 0;
        }
    }

}
