/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
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
public class SanPhamDAO {

    Connection connect;
    PreparedStatement pst;
    
    public static SanPhamDAO getInstance(){
        return new SanPhamDAO();
    }
    

    public ArrayList<SanPhamDTO> getAllSanPham() {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM   `tbl_sach` WHERE trangthai = 1";
            pst = connect.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int id_sanpham = rs.getInt("id_sach");
                String tensach = rs.getString("tensach");
                String tentacgia = rs.getString("tentacgia");
                String dongia = rs.getString("dongia");
                int soluong = rs.getInt("soluong");
                String loaisach = rs.getString("loaisach");
                String hinhanh = rs.getString("hinhanh");
                SanPhamDTO spDTO = new SanPhamDTO(id_sanpham, tensach, tentacgia, dongia, soluong, loaisach, hinhanh);
                result.add(spDTO);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean addSanPham(SanPhamDTO sanPhamDTO) {
        boolean status = false;
        String sql = "INSERT INTO `tbl_sach` (tensach, tentacgia,dongia,soluong,loaisach, hinhanh) VALUES (?,?,?,?,?,?)";
        try {
            connect = MySQLConnection.getConnection();
            pst = connect.prepareStatement(sql);
            pst.setString(1, sanPhamDTO.getTenSanPham());
            pst.setString(2, sanPhamDTO.getTenTacGia());
            pst.setString(3, sanPhamDTO.getDonGia());
            pst.setInt(4, sanPhamDTO.getSoLuong());
            pst.setString(5, sanPhamDTO.getLoaiSach());
            pst.setString(6, sanPhamDTO.getHinhAnh());

            int allRow = pst.executeUpdate();
            if (allRow > 0) {
                status = true;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            status = false;
            JOptionPane.showMessageDialog(null, ex.getMessage() + "Lỗi thêm sản phẩm: ", "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
        return status;
    }

    public boolean suaSanPham(SanPhamDTO sanPhamDTO) {
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_sach` SET tensach = ? , tentacgia = ?, dongia = ?, soluong = ?, loaisach = ?, hinhanh = ? WHERE id_sach = ?";
            pst = connect.prepareStatement(sql);
            pst.setString(1, sanPhamDTO.getTenSanPham());
            pst.setString(2, sanPhamDTO.getTenTacGia());
            pst.setString(3, sanPhamDTO.getDonGia());
            pst.setInt(4, sanPhamDTO.getSoLuong());
            pst.setString(5, sanPhamDTO.getLoaiSach());
            pst.setString(6, sanPhamDTO.getHinhAnh());
            pst.setInt(7, sanPhamDTO.getIdSanPham());

            int allRow = pst.executeUpdate();
            if (allRow > 0) {
                status = true;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa sản phẩm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            status = false;
        }
        return status;
    }

    public boolean xoaSanPham(int t) {
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_sach` SET `trangthai` = 0 WHERE `id_sach` = ?";
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

    public SanPhamDTO selectByID(int id_sach) {
        SanPhamDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "SELECT * FROM `tbl_sach` WHERE `id_sach`=?";
            pst = connect.prepareStatement(sql);
            pst.setInt(1, id_sach);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pst = connect.prepareStatement(sql);
                int id_sanpham = rs.getInt("id_sach");
                String tensach = rs.getString("tensach");
                String tentacgia = rs.getString("tentacgia");
                String dongia = rs.getString("dongia");
                int soluong = rs.getInt("soluong");
                String loaisach = rs.getString("loaisach");
                String hinhanh = rs.getString("hinhanh");
                result = new SanPhamDTO(id_sanpham, tensach, tentacgia, dongia, soluong, loaisach, hinhanh);
            }
            
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
        }
        return result;
        }
        
       public int tangSoLuong(int id, int soLuong) {
        SanPhamDTO slsp = this.selectByID(id);
        int result = 0;
        int newSoLuong = slsp.getSoLuong()+ soLuong;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_sach` SET `soluong`=? WHERE id_sach = ?";
            pst = connect.prepareStatement(sql);
            pst.setInt(1, newSoLuong);
            pst.setInt(2, slsp.getIdSanPham());
            result = pst.executeUpdate();
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
       
       public int giamSoLuong(int id, int soLuong){
        SanPhamDTO slsp = this.selectByID(id);
        int result = 0;
        int newSoLuong = slsp.getSoLuong()- soLuong;
        try {
            connect =MySQLConnection.getConnection();
            String sql = "UPDATE `tbl_sach` SET `soluong`=? WHERE id_sach = ?";
            pst =connect.prepareStatement(sql);
            pst.setInt(1, newSoLuong);
            pst.setInt(2, slsp.getIdSanPham());
            result = pst.executeUpdate();
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    }
