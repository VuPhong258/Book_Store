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
            tkDTO =  tkDAO.selectAll();
    }
    
     public ArrayList<TaiKhoanDTO> getAll() {
        return this.tkDTO;
    }
     
     
}
