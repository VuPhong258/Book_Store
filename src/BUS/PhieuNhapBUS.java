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
    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO;
    public final PhieuNhapDAO newPhieuNhapDAO = new PhieuNhapDAO();

    private ArrayList<PhieuNhapDTO> listPhieuNhap = new ArrayList<>();
    
    public PhieuNhapBUS(){
        listPhieuNhap = newPhieuNhapDAO.getAll();
        chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    }
    public PhieuNhapBUS(ChiTietPhieuNhapDAO chiTietPhieuNhapDAO) {
        this();
        this.chiTietPhieuNhapDAO = chiTietPhieuNhapDAO;
    }
    public ArrayList<PhieuNhapDTO> getAll(){
        return this.listPhieuNhap;
    }
    
     public boolean addPhieuNhap(PhieuNhapDTO phieuNhapDTO){
           return PhieuNhapDAO.getInstance().addPhieuNhap(phieuNhapDTO);
       }
    public boolean addChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> ctpnList) {
        return chiTietPhieuNhapDAO.addChiTietPhieuNhap(ctpnList);
    }
      
       public PhieuNhapDTO selectByID(int id_phieunhap){
           return PhieuNhapDAO.getInstance().selectById(id_phieunhap);
       }
       public ArrayList<ChiTietPhieuNhapDTO> selectAllByID(int id_pn) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        try {
            // Gọi phương thức tương ứng từ DAO
            result = chiTietPhieuNhapDAO.selectAllByID(id_pn);
        } catch (Exception e) {
            // Xử lý ngoại lệ hoặc ghi log nếu cần
            System.out.println("Lỗi khi lấy dữ liệu từ cơ sở dữ liệu: " + e.getMessage());
        }
        return result;
    }
       public boolean xoaPhieuNhap(int maphieunhap){
        return PhieuNhapDAO.getInstance().xoaPhieuNhap(maphieunhap);
    }
       public ArrayList<ChiTietPhieuNhapDTO> getAllChiTietPhieuNhap(int id_phieunhap){
           return ChiTietPhieuNhapDAO.getInstance().getAll(id_phieunhap);
       }

    
}
