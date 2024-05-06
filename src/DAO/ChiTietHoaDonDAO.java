/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHoaDonDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class ChiTietHoaDonDAO {
    
    Connection connect;
    PreparedStatement pst;
    public static ChiTietHoaDonDAO getInstance() {
        return new ChiTietHoaDonDAO();
    }

    public ArrayList<ChiTietHoaDonDTO> selectAll() {
        ArrayList<ChiTietHoaDonDTO> result = new ArrayList<>();
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM `chitiethoadon`";
            pst = connect.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt("id_hoadon");
                int soluongmua = rs.getInt("soluongmua");
                int id_sach = rs.getInt("id_sach");
                String tongtien = rs.getString("giaban");
                ChiTietHoaDonDTO ctpn = new ChiTietHoaDonDTO(idHoaDon, soluongmua, id_sach, tongtien);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<ChiTietHoaDonDTO> selectAllByID(int idhd) {
        ArrayList<ChiTietHoaDonDTO> result = new ArrayList<>();
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM `chitiethoadon` WHERE id_hoadon=" + idhd;
            pst = connect.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                 int idHoaDon = rs.getInt("id_hoadon");
                int soluongmua = rs.getInt("soluongmua");
                int id_sach = rs.getInt("id_sach");
                String tongtien = rs.getString("giaban");
                ChiTietHoaDonDTO ctpn = new ChiTietHoaDonDTO(idHoaDon, soluongmua, id_sach, tongtien);
                result.add(ctpn);;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public boolean addCTHD(ArrayList<ChiTietHoaDonDTO> listcthd) {
        boolean status = false;
        for (int i = 0; i < listcthd.size(); i++) {
            try {
                connect = MySQLConnection.getConnection();
                String sql = "INSERT INTO `chitiethoadon`(`id_hoadon`, `soluongmua`, `id_sach`, `giaban`) VALUES (?,?,?,?)";
                pst = (PreparedStatement) connect.prepareStatement(sql);
                pst.setInt(1, listcthd.get(i).getIdHoaDon());
                pst.setInt(2, listcthd.get(i).getIdSach());
                pst.setInt(3, listcthd.get(i).getSoLuongMua());
                pst.setString(4, listcthd.get(i).getGiaBan());
                int allRow = pst.executeUpdate();
                if (allRow > 0){
                    status = true;
                }
                MySQLConnection.closeConnection(connect);
            } catch (SQLException ex) {
                status = false;
                Logger.getLogger(ChiTietHoaDonDTO.class.getName()).log(Level.SEVERE, null, ex);
            }
//            PhienBanSanPhamDAO.getInstance().tangSoLuong(ctpnList.get(i).getIdPBSanPham(), ctpnList.get(i).getSoLuong());
        }
        return status;
    }
    
    public boolean deleteByHDId(int hdId) {
        boolean status= false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "DELETE FROM `chitiethoadon` WHERE id_hoadon = ?";
            pst = (PreparedStatement) connect.prepareStatement(sql);
            pst.setInt(1, hdId);
            int allRow  = pst.executeUpdate();
            if (allRow > 0){
                status = true;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            status = false;
            System.out.println(ex);
        }
        return status;
    }
}
