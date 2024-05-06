/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class TaiKhoanBUS {
    public final TaiKhoanDAO tkDAO  = new TaiKhoanDAO();
    private ArrayList<TaiKhoanDTO> tkDTO = new ArrayList<>(); 
    
    public TaiKhoanBUS(){
            tkDTO =  tkDAO.getAll();
    }
    
     public ArrayList<TaiKhoanDTO> getAll() {
        return this.tkDTO;
    }
     
     public boolean addTaiKhoan(TaiKhoanDTO taiKhoanDTO){
         return TaiKhoanDAO.getInstance().addTaiKhoan(taiKhoanDTO);
     }
     
     public boolean suaTaiKhoan(TaiKhoanDTO taiKhoanDTO){
         return TaiKhoanDAO.getInstance().suaTaiKhoan(taiKhoanDTO);
     }
     
     public boolean xoaTaiKhoan(String tendangnhap){
         return TaiKhoanDAO.getInstance().xoaTaiKhoan(tendangnhap);
     }
     
     public TaiKhoanDTO selectByUserName(String tendangnhap){
         return TaiKhoanDAO.getInstance().selectByUserName(tendangnhap);
     }
     
     public TaiKhoanDTO selectById(int id_taikhoan) {
         return TaiKhoanDAO.getInstance().selectById(id_taikhoan);
     }
     
}
