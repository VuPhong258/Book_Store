/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
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
            String query = "SELECT * FROM ctphieunhap WHERE id_phieunhap =?";
            pst =connect.prepareStatement(query);
            pst.setInt(1, id_pn);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id_phieunhap = rs.getInt("id_phieunhap");
                int id_sach = rs.getInt("id_sach");
                int soluongnhap = rs.getInt("soluongnhap");
                String gianhap = rs.getString("gianhap");   
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(id_phieunhap, id_sach, soluongnhap, gianhap);
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
                int soluongnhap = rs.getInt("soluongnhap");
                String gianhap = rs.getString("gianhap");   
                ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(id_phieunhap, id_sach, soluongnhap, gianhap);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public boolean themCtpn(ArrayList<ChiTietPhieuNhapDTO> ctpnList) {
        boolean status  = false;
        for (int i = 0; i < ctpnList.size(); i++) {
            try {
                connect = MySQLConnection.getConnection();
                String sql = "INSERT INTO `chitietphieunhap`(`id_phieunhap`, `id_sach`, `soluongnhap`, `gianhap`) VALUES (?,?,?,?)";
                PreparedStatement pst = (PreparedStatement) connect.prepareStatement(sql);
                pst.setInt(1, ctpnList.get(i).getIdPhieuNhap());
                pst.setInt(2, ctpnList.get(i).getIdSach());
                pst.setInt(3, ctpnList.get(i).getSoLuongNhap());
                pst.setString(4, ctpnList.get(i).getGiaNhap());
                int allRow = pst.executeUpdate();
                if (allRow > 0 ) {
                    status = true;
                }
                MySQLConnection.closeConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            SanPhamDAO.getInstance().tangSoLuong(ctpnList.get(i).getIdPhieuNhap(), ctpnList.get(i).getSoLuongNhap());
        }
        return status;
    }
}
