/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class SanPhamDTO {
            private int id_sanpham;
            private String tensanpham;
            private String tentacgia;
            private String dongia;
            private int soluong;
            private  String loaisach;
            private String hinhanh;
            
           public SanPhamDTO(){
               
           }
           
           public SanPhamDTO(int id_sanpham, String tensanpham, String tentacgia, String dongia, int soluong, String loaisach, String hinhanh){
               this.id_sanpham = id_sanpham;
               this.tensanpham = tensanpham;
               this.tentacgia = tentacgia;
               this.dongia = dongia;
               this.soluong = soluong;
               this.loaisach = loaisach;
               this.hinhanh = hinhanh;
           }
           
           public SanPhamDTO(String tensanpham, String tentacgia, String dongia, int soluong, String loaisach, String hinhanh){
                this.tensanpham = tensanpham;
               this.tentacgia = tentacgia;
               this.dongia = dongia;
               this.soluong = soluong;
               this.loaisach = loaisach;
               this.hinhanh = hinhanh;
           }
           
           public int getIdSanPham(){
               return id_sanpham;
           }
           
           public void setIdSanPham(int id_sanpham){
               this.id_sanpham = id_sanpham;
           }
           
           public String getTenSanPham(){
               return tensanpham;
           }
           
           public void setTenSanPham(String tensanpham){
               this.tensanpham = tensanpham;
           }
           
           public String getTenTacGia(){
               return tentacgia;
           }
           
           public void setIdTacGia(String tentacgia){
               this.tentacgia = tentacgia;
           }
           
           public String getDonGia(){
               return dongia;
           }
           
           public void setDonGia(String dongia){
               this.dongia= dongia;
           }
           
           public int getSoLuong(){
               return soluong;
           }
           
           public void setSoLuong(int soluong){
               this.soluong = soluong;
           }
           
           public String getHinhAnh(){
               return hinhanh;
           }
           
           public void setHinhAnh(String hinhanh){
               this.hinhanh = hinhanh;
           }
           
           public String getLoaiSach(){
               return loaisach;
           }
           
           public void setLoaiSach(String loaisach){
               this.loaisach = loaisach;
           }
}
