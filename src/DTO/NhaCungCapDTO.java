/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class NhaCungCapDTO {
        private int idNcc;
        private String tenncc;
        private String diachi;
        private String sodienthoai;
        
        public NhaCungCapDTO(){
        
        }
        
        public NhaCungCapDTO(int idNcc, String tenncc, String diachi, String sodienthoai){
            this.idNcc = idNcc;
            this.tenncc = tenncc;
            this.diachi = diachi;
            this.sodienthoai = sodienthoai;
        }
        
        public NhaCungCapDTO(String tenncc, String diachi, String sodienthoai){
            this.tenncc = tenncc;
            this.diachi = diachi;
            this.sodienthoai = sodienthoai;
        }
        
        public int getIdNcc(){
            return idNcc;
        }
        
        public void setIdNcc(int idNcc){
            this.idNcc = idNcc;
        }
        
        public String getTenNcc(){
            return tenncc;
        }
        
        public void setTenNcc(String tenncc) {
            this.tenncc= tenncc;
        }
        
        public String getDiaChi(){
            return diachi;
        }
        
        public void setDiaChi(String diachi){
            this.diachi = diachi;
        }
        
        public String getSoDienThoai(){
            return sodienthoai;
        }
        
        public void setSoDienThoai(String sodienthoai){
            this.sodienthoai = sodienthoai;
        }
        
}
