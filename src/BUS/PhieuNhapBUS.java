/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class PhieuNhapBUS {
    public final PhieuNhapDAO newPhieuNhapDAO = new PhieuNhapDAO();
//    public final ChiTietPhieuNhapDAO newChiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap = new ArrayList<>();
    
    public PhieuNhapBUS(){
        listPhieuNhap = newPhieuNhapDAO.getAllPhieuNhap();
    }
    
    public ArrayList<PhieuNhapDTO> getAll(){
        return this.listPhieuNhap;
    }
    
     public boolean addPhieuNhap(PhieuNhapDTO phieuNhapDTO){
           return PhieuNhapDAO.getInstance().addPhieuNhap(phieuNhapDTO);
       }
      
       public PhieuNhapDTO selectByID(int id_phieunhap){
           return PhieuNhapDAO.getInstance().selectById(id_phieunhap);
       }
       
       public ArrayList<ChiTietPhieuNhapDTO> getAllChiTietPhieuNhap(int id_phieunhap){
           return ChiTietPhieuNhapDAO.getInstance().getAll(id_phieunhap);
       }
}
