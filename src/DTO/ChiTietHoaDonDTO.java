/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.SanPhamBUS;

/**
 *
 * @author Acer
 */
public class ChiTietHoaDonDTO {
    private int id_hoadon;
    private int id_sach;
    private int soluongmua;
    private String giaban;

    public ChiTietHoaDonDTO(int id_hoadon, int id_sach, int soluongmua) {
        this.id_hoadon = id_hoadon;
        this.id_sach = id_sach;
        this.soluongmua = soluongmua;
    }

    public ChiTietHoaDonDTO(int id_hoadon, int id_sach, int soluongmua, String giaban) {
        this.id_hoadon = id_hoadon;
        this.id_sach = id_sach;
        this.soluongmua = soluongmua;
        this.giaban = giaban;
    }

    public ChiTietHoaDonDTO() {
    }

    public int getIdHoaDon() {
        return id_hoadon;
    }

    public int getIdSach() {
        return id_sach;
    }

    public int getSoLuongMua() {
        return soluongmua;
    }

    public String getGiaBan() {
        return giaban;
    }

    public void setIdHoaDon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public void setIdSach(int id_sach) {
        this.id_sach = id_sach;
    }

    public void setSoLuongMua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public void setGiaBan(String giaban) {
        this.giaban = giaban;
    }
    
    public void setGiaBan(){        //method này tính tổng tiền của 1 hàng trong chi tiết hóa đơn
        StringBuilder result = new StringBuilder();
        SanPhamDTO spDTO = new SanPhamBUS().selectByID(this.id_sach);
        float giaBan = Float.parseFloat(spDTO.getDonGia().substring(0, spDTO.getDonGia().length() - 3));
        giaBan *= this.getSoLuongMua();
        result.append(giaBan);
        int decimalIndex = result.length() - Float.toString(giaBan).indexOf('.');
        while(decimalIndex <= 3) {
            result.append('0');
            decimalIndex++;
        }
        result.append("VNĐ");
        this.giaban = result.toString();
    }
}
