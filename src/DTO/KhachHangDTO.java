/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class KhachHangDTO {
            private int id_khachhang;
            private String hoten;
            private String ngaysinh;
            private String diachi;
            private String sodienthoai;
            private  String email; 
            
            public KhachHangDTO(){
                
            }
            
            public KhachHangDTO(int id_khachhang, String hoten, String ngaysinh, String diachi, String sodienthoai, String email){
                this.id_khachhang = id_khachhang;
                this.hoten = hoten;
                this.ngaysinh = ngaysinh;
                this.diachi = diachi;
                this.sodienthoai = sodienthoai;
                this.email = email;
            }
            
            public KhachHangDTO( String hoten, String ngaysinh, String diachi, String sodienthoai, String email){
                this.hoten = hoten;
                this.ngaysinh = ngaysinh;
                this.diachi = diachi;
                this.sodienthoai = sodienthoai;
                this.email = email;
            }
            
            public int getIdKhachHang(){
               return id_khachhang;
           }
           
           public void setIdKhachHang(int id_khachhang){
               this.id_khachhang = id_khachhang;
           }
           
           public String getHoTen(){
               return hoten;
           }
           
           public void setHoTen(String hoten){
               this.hoten = hoten;
           }
           
           public String getNgaySinh(){
               return ngaysinh;
           }
           
           public void setNgaySinh(String ngaysinh){
               this.ngaysinh = ngaysinh;
           }
           
           public String getDiaChi(){
               return diachi;
           }
           
           public void setDiaChi(String diachi){
               this.diachi= diachi;
           }
           
           public String getSoDienThoai(){
               return sodienthoai;
           }
           
           public void setSoDienThoai(String sodienthoai){
               this.sodienthoai = sodienthoai;
           }
           
           public String getEmail(){
               return email;
           }
           
           public void setEmail(String email){
               this.email = email;
           }
}
