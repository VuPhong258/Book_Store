/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ChiTietHoaDonBUS {
    private final ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
    public ArrayList<ChiTietHoaDonDTO> cthdList = new ArrayList<>();
            
    public ChiTietHoaDonBUS(){
        this.cthdList = cthdDAO.selectAll();
    }

    public ArrayList<ChiTietHoaDonDTO> getAllByID(int id){
        return this.cthdDAO.selectAllByID(id);
    }
    
    public ArrayList<ChiTietHoaDonDTO> getAll(){ 
        return this.cthdList;
    }
}
