/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.QuyenDAO;
import DTO.QuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class QuyenBUS {
        private final QuyenDAO quyenDAO = new QuyenDAO();
        
        
        public ArrayList<QuyenDTO> getAllQuyen(){
            return quyenDAO.getAllQuyen();
        }
        
        public String[] getArrayTenQuyen(){
            int size = getAllQuyen().size();
            String[] result = new String[size];
            for (int i = 0; i<size; i++) {
                result[i] = getAllQuyen().get(i).getTenQuyen();
            }
            return result;
        }
        
        public QuyenDTO selectById(int id_quyen){
            return QuyenDAO.getInstance().selectById(id_quyen);
        }
}
