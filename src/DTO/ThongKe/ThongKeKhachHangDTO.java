/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author Acer
 */
public class ThongKeKhachHangDTO {
    int id_khachhang;
    String tenkh;
    int soluongphieu;
    long tongtien;

    public ThongKeKhachHangDTO() {
    }

    public ThongKeKhachHangDTO(int id_khachhang, String tenkh, int soluongphieu, long tongtien) {
        this.id_khachhang = id_khachhang;
        this.tenkh = tenkh;
        this.soluongphieu = soluongphieu;
        this.tongtien = tongtien;
    }

    public int getMakh() {
        return id_khachhang;
    }

    public void setMakh(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getSoluongphieu() {
        return soluongphieu;
    }

    public void setSoluongphieu(int soluongphieu) {
        this.soluongphieu = soluongphieu;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }
}
