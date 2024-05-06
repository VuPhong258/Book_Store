/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class KhachHangBUS {
         public final KhachHangDAO  newKhachHangDAO = new KhachHangDAO();
    private ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();
    
    public KhachHangBUS(){
        listKhachHang = newKhachHangDAO.getAll();
    }
    
    public ArrayList<KhachHangDTO> getAll(){
        return this.listKhachHang;
    }
    
    public boolean addKhachHang(KhachHangDTO khachHangDTO){
        return KhachHangDAO.getInstance().addKhachHang(khachHangDTO);
    }
    
    public boolean suaKhachHang(KhachHangDTO khachHangDTO){
        return KhachHangDAO.getInstance().suaKhachHang(khachHangDTO);
    }
    
    public boolean xoaKhachHang(int id_khachhang){
        return KhachHangDAO.getInstance().xoaKhachHang(id_khachhang);
    }
    
    public KhachHangDTO selectByID(int id_khachhang){
        return KhachHangDAO.getInstance().selectByIdKhachHang(id_khachhang);
    }
}
