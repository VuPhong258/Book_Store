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
import java.sql.Timestamp;
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
    
      public ArrayList<PhieuNhapDTO> getAll() {
    ArrayList<PhieuNhapDTO> result = new ArrayList<>();
    try {
        connect = MySQLConnection.getConnection();
        String sql = "SELECT * FROM `tbl_phieunhap` WHERE trangthai = 1";
        pst = connect.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO();
            phieuNhapDTO.setIdPhieuNhap(rs.getInt("id_phieunhap"));
            phieuNhapDTO.setNgayNhap(rs.getString("ngaynhap"));
            phieuNhapDTO.setIdNhaCungCap(rs.getInt("id_ncc"));
            phieuNhapDTO.setIdNV(rs.getInt("id_nhanvien"));
            phieuNhapDTO.setTongTien(rs.getString("tongtien"));
            phieuNhapDTO.setTrangthai(rs.getInt("trangthai"));
            result.add(phieuNhapDTO);
        }
        MySQLConnection.closeConnection(connect);
    } catch (SQLException ex) {
        Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}
      
    public boolean addPhieuNhap(PhieuNhapDTO phieuNhapDTO){
    boolean status = false;
    String sql  = "INSERT INTO `tbl_phieunhap`(id_ncc, id_nhanvien, ngaynhap, trangthai, tongtien) VALUES (?, ?, ?, ?, ?)";
    try {
        connect = MySQLConnection.getConnection();
        pst = connect.prepareStatement(sql);
        pst.setInt(1, phieuNhapDTO.getIdNhaCungCap());
        pst.setInt(2, phieuNhapDTO.getIdNV());
        pst.setString(3, phieuNhapDTO.getNgayNhap());
        pst.setInt(4, phieuNhapDTO.getTrangthai());
        pst.setString(5, phieuNhapDTO.getTongTien());

        int allRow = pst.executeUpdate();
        if (allRow > 0) {
            status = true;
        } else {
            status = false; // Set status to false if no rows were affected
        }

        MySQLConnection.closeConnection(connect);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi SQL khi thêm phiếu nhập: " + ex.getMessage());
        status = false;
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi: Kiểu dữ liệu không hợp lệ. Vui lòng kiểm tra lại.");
        status = false;
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi thêm phiếu nhập: " + ex.getMessage());
        status = false;
    }
    return status;
}


      
      public PhieuNhapDTO selectById(int t) {
    PhieuNhapDTO result = null;
    try {
        connect = MySQLConnection.getConnection();
        String sql = "SELECT * FROM `tbl_phieunhap` WHERE id_phieunhap=?";
        pst = connect.prepareStatement(sql);
        pst.setInt(1, t);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_phieunhap = rs.getInt("id_phieunhap");
            String ngaynhap = rs.getString("ngaynhap");
            int id_ncc = rs.getInt("id_ncc");
            int id_nhanvien = rs.getInt("id_nhanvien");
            String tongtien = rs.getString("tongtien");
            int trangthai = rs.getInt("trangthai");
            PhieuNhapDTO pnDTO = new PhieuNhapDTO(id_phieunhap, ngaynhap, id_ncc, id_nhanvien, tongtien, trangthai);
            result = pnDTO;
        }
        MySQLConnection.closeConnection(connect);
    } catch (SQLException e) {
        System.out.println(e);
    }
    return result;
}
      
       public boolean xoaPhieuNhap(int t) {
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_phieunhap` SET `trangthai` = 0 WHERE `id_phieunhap` = ?";
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
