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

    public ChiTietHoaDonDAO getCthdDAO(){
        return this.cthdDAO;
    }
    
    public ArrayList<ChiTietHoaDonDTO> getAllByID(int id){
        return this.cthdDAO.selectAllByID(id);
    }
    
    public ArrayList<ChiTietHoaDonDTO> getAll(){ 
        return this.cthdList;
    }
    
    public static String tinhTongTien(ArrayList<ChiTietHoaDonDTO> listCTHD) {    //method này tính tổng tiền của các row có cùng id hóa đơn
        float tongTien = 0;
        StringBuilder result = new StringBuilder();
        for(ChiTietHoaDonDTO cthdDTO : listCTHD) {
            float giaTien = Float.parseFloat(cthdDTO.getGiaBan().substring(0, cthdDTO.getGiaBan().length() - 3)); //bỏ 3 chữ VND ở cuối
            tongTien += giaTien;
        }
        result.append(tongTien);
        int decimalIndex = result.length() - Float.toString(tongTien).indexOf('.');
        while(decimalIndex <= 3) {
            result.append('0');
            decimalIndex++;
        }
        result.append("VNĐ");
        return result.toString();
    }
}
