/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author Acer
 */
public class ThongKeNccDTO {
        int id_ncc;
    String tenncc;
    int soluong;
    long tongtien;

public ThongKeNccDTO() {
    }
    public ThongKeNccDTO(int id_ncc, String tenncc, int soluong, long tongtien) {
        this.id_ncc = id_ncc;
        this.tenncc = tenncc;
        this.soluong = soluong;
        this.tongtien = tongtien;
}
  

    public int getMancc() {
        return id_ncc;
    }
 
    public void setMakh(int id_ncc) {
        this.id_ncc = id_ncc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
 
    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

}
