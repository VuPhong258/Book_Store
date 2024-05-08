/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class TaiKhoanDTO {
        private int idTaiKhoan;
        private String tendangnhap;
        private String matkhau;
        private int loaitaikhoan;
        private int idNhanVien;
        private String tenquyen;
        private int trangthai;
        
        public TaiKhoanDTO(){
        
        }
        
        public TaiKhoanDTO(int idTaiKhoan, String tendangnhap, String matkhau, int loaitaikhoan, int idNhanVien, String tenquyen,int trangthai){
            this.idTaiKhoan = idTaiKhoan;
            this.tendangnhap = tendangnhap;
            this.matkhau = matkhau;
            this.loaitaikhoan = loaitaikhoan;
            this.idNhanVien = idNhanVien;
            this.tenquyen = tenquyen;
            this.trangthai = trangthai;
        }
        
         public TaiKhoanDTO(int idTaiKhoan, String tendangnhap, String matkhau, String tenquyen, int idNhanVien){
            this.idTaiKhoan = idTaiKhoan;
            this.tendangnhap = tendangnhap;
            this.matkhau = matkhau;
            this.tenquyen = tenquyen;
            this.idNhanVien = idNhanVien;
        }
         
          public TaiKhoanDTO(String tendangnhap, String matkhau, String tenquyen, int idNhanVien){
            this.tendangnhap = tendangnhap;
            this.matkhau = matkhau;
            this.tenquyen = tenquyen;
            this.idNhanVien = idNhanVien;
        }
         
         
        public int getIdTaiKhoan(){
            return idTaiKhoan;
        }
        
        public void setIdTaiKhoan(int idTaiKhoan){
            this.idTaiKhoan = idTaiKhoan;
        }
        
        public String getTenDangNhap(){
            return tendangnhap;
        }
        
        public void setTenDangNhap(String tendangnhap){
            this.tendangnhap = tendangnhap;
        }
        
         public String getMatKhau(){
            return matkhau;
        }
        
        public void setMatKhau(String matkhau){
            this.matkhau = matkhau;
        }
        
        public int getLoaiTaiKhoan(){
            return loaitaikhoan;
        }
        
        public void setLoaiTaiKhoan(int loaitaikhoan){
            this.loaitaikhoan = loaitaikhoan;
        }
        
        public int getIdNhanVien(){
            return idNhanVien;
        }
        
        public void setIdNhanVien(int idNhanVien){
            this.idNhanVien = idNhanVien;
        }
        
        public int getTrangThai(){
            return trangthai;
        }
        
        public void setTrangThai(int trangthai){
            this.trangthai   = trangthai;
        }
       
         public String getTenQuyen(){
            return tenquyen;
        }
        
        public void setTenQuyen(String tenquyen){
            this.tenquyen   = tenquyen;
        }
}
