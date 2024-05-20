/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class NhaCungCapBUS {
         private final NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        private ArrayList<NhaCungCapDTO> nhaCungCapList = new ArrayList<>();
        
        public NhaCungCapBUS() {
            nhaCungCapList = nccDAO.getAll();
    }
       public ArrayList<NhaCungCapDTO> getAllNCC() {
        NhaCungCapDAO nccDAO = new NhaCungCapDAO();
        return nccDAO.getAll();
    }
        
        public boolean themNhaCungCap(NhaCungCapDTO nhaCungCapDTO){
            return NhaCungCapDAO.getInstance().addNcc(nhaCungCapDTO);
    }
    
        public boolean xoaNhaCungCap(int id_ncc){
        return NhaCungCapDAO.getInstance().xoaNhaCungCap(id_ncc);
    }
        
        public boolean suaNhaCungCap(NhaCungCapDTO nhaCungCapDTO){
        return NhaCungCapDAO.getInstance().suaNcc(nhaCungCapDTO);
    }
        
        public NhaCungCapDTO selectByID(int id_ncc){
        return NhaCungCapDAO.getInstance().selectById(id_ncc);
    }

}
