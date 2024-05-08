/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Acer
 */
public class QuyenDTO {
           private int id_quyen;
           private String tenquyen;
           private int trangthai;
           
           
           public QuyenDTO(){
               
           }
           
           public QuyenDTO(int id_quyen, String tenquyen, int trangthai){
               this.id_quyen = id_quyen;
               this.tenquyen = tenquyen;
               this.trangthai = trangthai;
           }
           
           public QuyenDTO(int id_quyen, String tenquyen){
               this.id_quyen = id_quyen;
               this.tenquyen = tenquyen;
           }
           
           public int getIdQuyen(){
               return id_quyen;
           }
           
           public void setIdQuyen(int id_quyen){
               this.id_quyen = id_quyen;
           }
           
           public String getTenQuyen(){
               return tenquyen;
           }
           
           public void setTenQuyen(String tenquyen){
               this.tenquyen = tenquyen;
           }
           
           public int getTrangThai(){
               return trangthai;
           }
           
           public void setTrangThai(int trangthai){
               this.trangthai = trangthai;
           }
}
