/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

public class PhieuNhapDTO {

    private int id_phieunhap;
    private String ngaynhap;
    private String tenncc;
    private int id_nhanvien; 
    private String tongtien;
    private int trangthai;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int id_phieunhap, String ngaynhap, String tenncc, int id_nhanvien, String tongtien, int trangthai) {
        this.id_phieunhap = id_phieunhap;
        this.ngaynhap = ngaynhap;
        this.tenncc = tenncc;
        this.id_nhanvien = id_nhanvien;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }
    
    public PhieuNhapDTO(String ngaynhap, String tenncc, int id_nhanvien, String tongtien, int trangthai) {    
        this.ngaynhap = ngaynhap;
        this.tenncc = tenncc;
        this.id_nhanvien = id_nhanvien;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public int getIdPhieuNhap() {
        return id_phieunhap;
    }

    public String getNgayNhap() {
        return ngaynhap;
    }

    public String getTenNhaCungCap() {
        return tenncc;
    }

    public int getIdNV() {
        return id_nhanvien;
    }

    public String getTongTien() {
        return tongtien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setIdPhieuNhap(int id_phieunhap) {
        this.id_phieunhap = id_phieunhap;
    }

    public void setNgayNhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setTenNhaCungCap(String tenncc) {
        this.tenncc = tenncc;
    }

    public void setIdNV(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public void setTongTien(String tongtien) {
        this.tongtien = tongtien;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
