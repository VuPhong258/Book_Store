/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class HoaDonDTO {

    private int id_hoadon;
    private String ngaylaphoadon;
    private String tongtien;
    private int id_nhanvien;
    private int id_khachang;
    private int trangthai;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int id_hoadon, String ngaylaphoadon, String tongtien, int id_nhanvien, int id_khachang, int trangthai) {
        this.id_hoadon = id_hoadon;
        this.ngaylaphoadon = ngaylaphoadon;
        this.tongtien = tongtien;
        this.id_nhanvien = id_nhanvien;
        this.id_khachang = id_khachang;
        this.trangthai = trangthai;
    }
    
     public HoaDonDTO(int id_hoadon, int id_nhanvien, int id_khachang, String ngaylaphoadon, String tongtien) {
        this.id_hoadon = id_hoadon;
        this.ngaylaphoadon = ngaylaphoadon;
        this.tongtien = tongtien;
        this.id_nhanvien = id_nhanvien;
        this.id_khachang = id_khachang;
    }

    public int getIdHoaDon() {
        return id_hoadon;
    }

    public String getNgayLapHoaDon() {
        return ngaylaphoadon;
    }

    public String getTongTien() {
        return tongtien;
    }

    public int getIdNv() {
        return id_nhanvien;
    }

    public int getIdKh() {
        return id_khachang;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setIdHoaDon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public void setNgayLapHoaDon(String ngaylaphoadon) {
        this.ngaylaphoadon = ngaylaphoadon;
    }

    public void setTongTien(String tongtien) {
        this.tongtien = tongtien;
    }

    public void setIdNv(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public void setIdKh(int id_khachang) {
        this.id_khachang = id_khachang;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
