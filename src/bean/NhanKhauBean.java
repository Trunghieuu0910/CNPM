package bean;

import java.util.ArrayList;
import java.util.List;

import model.ChungMinhThuModel;
import model.GiaDinhModel;
import model.NhanKhauModel;
import model.TieuSuModel;

/**
 *
 * @author Hai
 */
public class NhanKhauBean {
    private NhanKhauModel nhanKhauModel;
    private ChungMinhThuModel chungMinhThuModel;
    private List<TieuSuModel> listTieuSuModels;
    private List<GiaDinhModel> listGiaDinhModels;

    
    public NhanKhauBean(NhanKhauModel nhanKhauModel, ChungMinhThuModel chungMinhThuModel, List<TieuSuModel> listTieuSuModels, List<GiaDinhModel> listGiaDinhModels) {
        this.nhanKhauModel = nhanKhauModel;
        this.chungMinhThuModel = chungMinhThuModel;
        this.listTieuSuModels = listTieuSuModels;
        this.listGiaDinhModels = listGiaDinhModels;
    }

    public NhanKhauBean(NhanKhauModel nhanKhauModel, ChungMinhThuModel chungMinhThuModel) {
        this.nhanKhauModel = nhanKhauModel;
        this.chungMinhThuModel = chungMinhThuModel;
    }
    
    public NhanKhauBean() {
        this.nhanKhauModel = new NhanKhauModel();
        this.chungMinhThuModel = new ChungMinhThuModel();
        this.listGiaDinhModels = new ArrayList<>();
        this.listTieuSuModels = new ArrayList<>();
    }
    
    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public ChungMinhThuModel getChungMinhThuModel() {
        return chungMinhThuModel;
    }

    public void setChungMinhThuModel(ChungMinhThuModel chungMinhThuModel) {
        this.chungMinhThuModel = chungMinhThuModel;
    }

    public List<TieuSuModel> getListTieuSuModels() {
        return listTieuSuModels;
    }

    public void setListTieuSuModels(List<TieuSuModel> listTieuSuModels) {
        this.listTieuSuModels = listTieuSuModels;
    }

    public List<GiaDinhModel> getListGiaDinhModels() {
        return listGiaDinhModels;
    }

    public void setListGiaDinhModels(List<GiaDinhModel> listGiaDinhModels) {
        this.listGiaDinhModels = listGiaDinhModels;
    }
    
    @Override
    public String toString() {
        String res =  "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Th??ng tin c?? b???n:"
                + "<p>H??? t??n: <b>" + nhanKhauModel.getHoTen() + "</p>"
                + "<p>N??m sinh: <b>" + nhanKhauModel.getNamSinh() + "</p>"
                + "<p>Gi???i t??nh: <b>" + nhanKhauModel.getGioiTinh() + "</p>"
                + "<p>Nguy??n Qu??n: <b>" + nhanKhauModel.getNguyenQuan()+ "</p>"
                + "<p>D??n t???c: <b>" + nhanKhauModel.getDanToc()+ "</p>"
                + "<p>T??n gi??o: <b>" + nhanKhauModel.getTonGiao()+ "</p>"
                + "<p>Qu???c t???ch: <b>" + nhanKhauModel.getQuocTich()+ "</p>"
                + "<p>S??? CMT: <b>" + chungMinhThuModel.getSoCMT()+ "</p>"
                + "<h4>Ti???u s???<table>"
                + "<tr>"
                + "<th>T??? ng??y</th>"
                + "<th>?????n ng??y</th>"
                + "<th>?????a ch???</th>"
                + "<th>N??i l??m vi???c</th>"
                + "</tr>";
        for (TieuSuModel tieuSuModel: listTieuSuModels) {
            res += "<tr>"
                    + "<td>"
                    + tieuSuModel.getTuNgay().toString()
                    + "</td>"
                    + "<td>"
                    + tieuSuModel.getDenNgay().toString()
                    + "</td>"
                    + "<td>"
                    + tieuSuModel.getDiaChi()
                    + "</td>"
                    + "<td>"
                    + tieuSuModel.getNoiLamViec()
                    + "</td>"
                    + "</tr>";
        }
        res += "</table><h4>Gia ????nh<table>"
                + "<tr>"
                + "<th>H??? t??n</th>"
                + "<th>Ng??y sinh</th>"
                + "<th>Gi???i t??nh</th>"
                + "<th>Quan h??? v???i nh??n kh???u</th>"
                + "<th>Ngh??? nghi???p</th>"
                + "<th>?????a ch??? hi???n t???i</th>"
                +"</tr>";
        for (GiaDinhModel giaDinhModel: listGiaDinhModels) {
            res += "<tr>"
                    + "<td>"
                    + giaDinhModel.getHoTen()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getNamSinh().toString()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getGioiTinh()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getQuanHeVoiNhanKhau()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getNgheNghiep()
                    + "</td>"
                    + "<td>"
                    + giaDinhModel.getDiaChiHienTai()
                    + "</td>"
                    +"</tr>";
        }
        res +=  "</table>"
                + "</div></html>";
        return res;
    }
}
