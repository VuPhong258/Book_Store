/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class HoaDonBUS {
            private final HoaDonDAO hdDAO = new HoaDonDAO();
            public ArrayList<HoaDonDTO> hoaDonList = new ArrayList<>();
            
            public HoaDonBUS(){
                this.hoaDonList = hdDAO.getAllHoaDon();
            }
            
            public ArrayList<HoaDonDTO> getAll(){ 
                return this.hoaDonList;
            }
            
            
            
}
