/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class SanPhamBUS {
       public final SanPhamDAO newSanPhamDAO = new SanPhamDAO();
       private ArrayList<SanPhamDTO> listSanPham = new ArrayList<>();
       
       public SanPhamBUS (){
           listSanPham = newSanPhamDAO.getAllSanPham();
       }
       
       public  ArrayList<SanPhamDTO> getAll(){
           return this.listSanPham;
       }
       
       public boolean addSanPham(SanPhamDTO sanPhamDTO){
           return SanPhamDAO.getInstance().addSanPham(sanPhamDTO);
       }
       
       public boolean suaSanPham(SanPhamDTO sanPhamDTO){
            return SanPhamDAO.getInstance().suaSanPham(sanPhamDTO);
       }
       
       public boolean xoaSanPham(int id_sach) {
            return SanPhamDAO.getInstance().xoaSanPham(id_sach);
       }
       
       public SanPhamDTO selectByID(int id_sach){
           return SanPhamDAO.getInstance().selectByID(id_sach);
       }
       
}
