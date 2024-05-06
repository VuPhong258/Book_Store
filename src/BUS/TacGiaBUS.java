/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TacGiaDAO;
import DTO.TacGiaDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class TacGiaBUS {
    public final TacGiaDAO  newTacGiaDAO = new TacGiaDAO();
    private ArrayList<TacGiaDTO> listTacGia = new ArrayList<>();
    
    public TacGiaBUS(){
        listTacGia = newTacGiaDAO.getAll();
    }
    
    public ArrayList<TacGiaDTO> getAll(){
        return this.listTacGia;
    }
    
    public boolean addTacGia(TacGiaDTO tacGiaDTO){
        return TacGiaDAO.getInstance().themTacGia(tacGiaDTO);
    }
    
    public boolean suaTacGia(TacGiaDTO tacGiaDTO){
        return TacGiaDAO.getInstance().suaTacGia(tacGiaDTO);
    }
    
    public boolean xoaTacGia(String tentacgia){
        return TacGiaDAO.getInstance().xoaTacGia(tentacgia);
    }
    
    public TacGiaDTO selectByName(String tentacgia){
        return TacGiaDAO.getInstance().selectByName(tentacgia);
    }
}
