/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhanKhau {
    private String ho_ten;
    private String ngay_sih;
    private String noi_sinh;
    private String nguyen_quan;
    private String dan_toc;
    private String nghe_nghiep;
    private String noi_lam_viec;
    private String CCCD;
    private String ngay_cap;
    private String noi_cap;
    private String ngay_dang_ki_thuong_tru;
    private String dia_chi_cu;

    public NhanKhau(String ho_ten, String ngay_sih, String noi_sinh, String nguyen_quan, String dan_toc, String nghe_nghiep, String noi_lam_viec, String CCCD, String ngay_cap, String noi_cap, String ngay_dang_ki_thuong_tru, String dia_chi_cu) {
        this.ho_ten = ho_ten;
        this.ngay_sih = ngay_sih;
        this.noi_sinh = noi_sinh;
        this.nguyen_quan = nguyen_quan;
        this.dan_toc = dan_toc;
        this.nghe_nghiep = nghe_nghiep;
        this.noi_lam_viec = noi_lam_viec;
        this.CCCD = CCCD;
        this.ngay_cap = ngay_cap;
        this.noi_cap = noi_cap;
        this.ngay_dang_ki_thuong_tru = ngay_dang_ki_thuong_tru;
        this.dia_chi_cu = dia_chi_cu;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public String getNgay_sih() {
        return ngay_sih;
    }

    public String getNoi_sinh() {
        return noi_sinh;
    }

    public String getNguyen_quan() {
        return nguyen_quan;
    }

    public String getDan_toc() {
        return dan_toc;
    }

    public String getNghe_nghiep() {
        return nghe_nghiep;
    }

    public String getNoi_lam_viec() {
        return noi_lam_viec;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getNgay_cap() {
        return ngay_cap;
    }

    public String getNoi_cap() {
        return noi_cap;
    }

    public String getNgay_dang_ki_thuong_tru() {
        return ngay_dang_ki_thuong_tru;
    }

    public String getDia_chi_cu() {
        return dia_chi_cu;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public void setNgay_sih(String ngay_sih) {
        this.ngay_sih = ngay_sih;
    }

    public void setNoi_sinh(String noi_sinh) {
        this.noi_sinh = noi_sinh;
    }

    public void setNguyen_quan(String nguyen_quan) {
        this.nguyen_quan = nguyen_quan;
    }

    public void setDan_toc(String dan_toc) {
        this.dan_toc = dan_toc;
    }

    public void setNghe_nghiep(String nghe_nghiep) {
        this.nghe_nghiep = nghe_nghiep;
    }

    public void setNoi_lam_viec(String noi_lam_viec) {
        this.noi_lam_viec = noi_lam_viec;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setNgay_cap(String ngay_cap) {
        this.ngay_cap = ngay_cap;
    }

    public void setNoi_cap(String noi_cap) {
        this.noi_cap = noi_cap;
    }

    public void setNgay_dang_ki_thuong_tru(String ngay_dang_ki_thuong_tru) {
        this.ngay_dang_ki_thuong_tru = ngay_dang_ki_thuong_tru;
    }

    public void setDia_chi_cu(String dia_chi_cu) {
        this.dia_chi_cu = dia_chi_cu;
    }
    
    
}
