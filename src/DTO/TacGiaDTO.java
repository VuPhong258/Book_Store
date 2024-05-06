/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class TacGiaDTO {
        private String tentacgia;
        private String namsinh;
        
        public TacGiaDTO(){
            
        }
        
        public TacGiaDTO( String tentacgia, String namsinh){
            this.tentacgia = tentacgia;
            this.namsinh = namsinh;
        }
        
        public TacGiaDTO(String namsinh){
            this.namsinh = namsinh;
        }
        
        public String getTenTacGia(){
            return tentacgia;
        }
        
        public void setTenTacGia(String tentacgia){
            this.tentacgia = tentacgia;
        }
        
        public String getNamSinh(){
            return namsinh;
        }
        
        public void setNamSinh(String namsinh){
            this.namsinh = namsinh;
        }
}
