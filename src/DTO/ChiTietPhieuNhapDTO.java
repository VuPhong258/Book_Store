/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class ChiTietPhieuNhapDTO {
    private int id_phieunhap;
    private int id_sach;
    private String tensach;
    private int soluongnhap;
    private String gianhap;
    
    public ChiTietPhieuNhapDTO(int id_phieunhap, int id_sach,String tensach, String gianhap,int soluongnhap) {
        this.id_phieunhap = id_phieunhap;
        this.id_sach = id_sach;
        this.tensach=tensach;
        this.gianhap = gianhap;
        this.soluongnhap = soluongnhap;
    }
     
    
    public ChiTietPhieuNhapDTO() {
    }

    public void setIdPhieuNhap(int id_phieunhap) {
        this.id_phieunhap = id_phieunhap;
    }

    public void setMasp(int id_sach) {
        this.id_sach = id_sach;
    }

    public void setSoLuongNhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public void setGiaNhap(String gianhap) {
        this.gianhap = gianhap;
    }
    public void setTenSach(String tensach) {
        this.tensach = tensach;
    }
    public int getIdPhieuNhap() {
        return id_phieunhap;
    }

    public int getIdSach() {
        return id_sach;
    }

    public int getSoLuongNhap() {
        return soluongnhap;
    }

    public String getGiaNhap() {
        return gianhap;
    }
    public String getTenSach() {
        return tensach;
    }
}
