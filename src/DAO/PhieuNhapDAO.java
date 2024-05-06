/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhieuNhapDTO;
import java.sql.Connection;
import config.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Acer
 */
public class PhieuNhapDAO {
    Connection connect;
    PreparedStatement pst;
    
    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    
      public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_phieunhap` WHERE trangthai = 1"; // Lấy những phiếu nhập có trạng thái là 1
        try {
            connect = MySQLConnection.getConnection();
            pst = connect.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO();
                phieuNhapDTO.setIdPhieuNhap(rs.getInt("id_phieunhap"));
                phieuNhapDTO.setNgayNhap(rs.getString("ngaynhap"));
                phieuNhapDTO.setIdNhaCungCap(rs.getInt("id_ncc"));
                phieuNhapDTO.setIdNV(rs.getInt("id_nhanvien"));
                phieuNhapDTO.setTongTien(rs.getString("tongtien"));
                result.add(phieuNhapDTO);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi theo nhu cầu của bạn
        }
        return result;
    }
      
      public boolean addPhieuNhap(PhieuNhapDTO phieuNhapDTO){
          boolean status = false;
          String sql  = "INSERT INTO `tbl_phieunhap`(id_ncc, id_nhanvien, ngaynhap, tongtien) VALUES (?, ? ,? ,?)";
          try {
               connect = MySQLConnection.getConnection();
               pst = connect.prepareStatement(sql);
               pst.setInt(1, phieuNhapDTO.getIdNhaCungCap());
               pst.setInt(2, phieuNhapDTO.getIdNV());
               pst.setString(3, phieuNhapDTO.getNgayNhap());
               pst.setString(4, phieuNhapDTO.getTongTien());
               
               int allRow = pst.executeUpdate();
               if (allRow > 0) {
                   status = false;
               }
               
               MySQLConnection.closeConnection(connect);
          } catch (SQLException ex) { 
              status = false;
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return status;
      }
      
      public PhieuNhapDTO selectById(int id_phieunhap) {
        PhieuNhapDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "SELECT * FROM `tbl_phieunhap` WHERE id_phieunhap=?";
            pst = connect.prepareStatement(sql);
            pst.setInt(1, id_phieunhap);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id_pn = rs.getInt("id_phieunhap");
                String ngaynhap = rs.getString("ngaynhap");
                int id_ncc = rs.getInt("id_ncc");
                int id_nhanvien = rs.getInt("id_nhanvien");
                String tongtien = rs.getString("tongtien");
                result = new PhieuNhapDTO(id_pn, ngaynhap, id_ncc, id_nhanvien, tongtien);
                MySQLConnection.closeConnection(connect);
            }
        } catch (SQLException e) {
        }
        return result;
    }
      
       public boolean xoaPhieuNhap(int t) {
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_phieunhap` SET `trangthai` = 0 WHERE `id_phieunhap= ?";
            pst = connect.prepareStatement(sql);
            pst.setInt(1, t);
            int allRow = pst.executeUpdate();
            if (allRow > 0) {
                status = true;
            }

            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
       
    
}
