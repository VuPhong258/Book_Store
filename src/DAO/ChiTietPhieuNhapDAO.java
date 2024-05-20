/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import com.mysql.jdbc.Statement;
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
public class ChiTietPhieuNhapDAO {
    Connection connect;
    PreparedStatement pst;
         public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getAll(int id_pn) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        try {
            connect =MySQLConnection.getConnection();
            String query = "SELECT * FROM tbl_chitietphieunhap WHERE id_phieunhap =?";
            pst =connect.prepareStatement(query);
            pst.setInt(1, id_pn);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id_phieunhap = rs.getInt("id_phieunhap");
                int id_sach = rs.getInt("id_sach");
                String tensach = rs.getString("tensach");
                String gianhap = rs.getString("gianhap");
                int soluongnhap = rs.getInt("soluongnhap");
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(id_phieunhap, id_sach,tensach, gianhap, soluongnhap);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> selectAllByID(int id_pn) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM `tbl_chitietphieunhap` WHERE id_phieunhap="+id_pn;
            pst =  connect.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id_phieunhap = rs.getInt("id_phieunhap");
                int id_sach = rs.getInt("id_sach");
                String tensach = rs.getString("tensach"); 
                String gianhap = rs.getString("gianhap"); 
                int soluongnhap = rs.getInt("soluongnhap");
                  
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(id_phieunhap, id_sach, tensach, gianhap,soluongnhap);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public boolean addChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> ctpnList) {
    boolean status = false;
    Connection connect = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
        connect = MySQLConnection.getConnection();
        String sql = "INSERT INTO `tbl_chitietphieunhap`(`id_phieunhap`, `id_sach`, `tensach`, `gianhap`, `soluongnhap`) VALUES (?, ?, ?, ?, ?)";
        for (int i = 0; i < ctpnList.size(); i++) {
            // Execute query to get the last inserted id
            pst = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ctpnList.get(i).getIdPhieuNhap());
            pst.setInt(2, ctpnList.get(i).getIdSach());
            pst.setString(3, ctpnList.get(i).getTenSach());
            pst.setString(4, ctpnList.get(i).getGiaNhap());
            pst.setInt(5, ctpnList.get(i).getSoLuongNhap());
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                status = true;
                SanPhamDAO.getInstance().tangSoLuong(ctpnList.get(i).getIdPhieuNhap(), ctpnList.get(i).getSoLuongNhap());
            } else {
                status = false;
                break; // Stop the loop if any insertion fails
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return status;
}

}
