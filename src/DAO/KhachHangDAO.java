/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import DTO.KhachHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.MySQLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class KhachHangDAO {
    Connection connect;
    PreparedStatement pst;
    
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }
    
    public ArrayList<KhachHangDTO> getAll(){
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM `tbl_khachhang` WHERE trangthai = 1";
            pst  = connect.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id_khachhang = rs.getInt("id_khachhang");
                String hoten = rs.getString("hoten");
                String ngaysinh = rs.getString("ngaysinh");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                KhachHangDTO khDTO = new KhachHangDTO(id_khachhang, hoten, ngaysinh, diachi, sodienthoai,email);
                result.add(khDTO);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public boolean addKhachHang(KhachHangDTO khachHangDTO){
           boolean status = false;
           String sql = "INSERT INTO `tbl_khachhang` (hoten, ngaysinh, diachi, sodienthoai, email) VALUES (?,?,?,?,?)";
                   try {
                        connect = MySQLConnection.getConnection();
                        pst = connect.prepareStatement(sql);
                        pst.setString(1, khachHangDTO.getHoTen());
                        pst.setString(2, khachHangDTO.getNgaySinh());
                        pst.setString(3,khachHangDTO.getDiaChi());
                        pst.setString(4, khachHangDTO.getSoDienThoai());
                        pst.setString(5 ,khachHangDTO.getEmail());
                        int allRow  = pst.executeUpdate();
                        if (allRow > 0 ){
                       status = true;
                        }    
                        MySQLConnection.closeConnection(connect);
                   } catch (SQLException ex) { 
                       JOptionPane.showMessageDialog(null, "Lỗi thêm khách hàng!");
                       status = false;
                } 
                   return status;
       }
       
       public boolean suaKhachHang(KhachHangDTO khachHangDTO){
           boolean status = false;
           try {
               connect = MySQLConnection.getConnection();
               String sql = "UPDATE `tbl_khachhang` SET hoten = ? , ngaysinh = ?,  diachi = ?, sodienthoai = ?, email = ? WHERE id_khachhang=?";
               pst = connect.prepareStatement(sql);
               pst.setString(1, khachHangDTO.getHoTen());
               pst.setString(2, khachHangDTO.getNgaySinh());
               pst.setString(3,khachHangDTO.getDiaChi());
               pst.setString(4, khachHangDTO.getSoDienThoai());
               pst.setString(5 ,khachHangDTO.getEmail());
               pst.setInt(6, khachHangDTO.getIdKhachHang());
               int allRow  = pst.executeUpdate();
                   if (allRow > 0 ){
                       status = true;
                    }    
                   MySQLConnection.closeConnection(connect);
           } catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, ex);
                    status = false;
             }
             return status;
         }
       
       
       
       public boolean xoaKhachHang(int t){
             boolean status = false;
             try {
                 connect = MySQLConnection.getConnection();
                 String sql = "UPDATE `tbl_khachhang` SET `trangthai`=0 WHERE `id_khachhang` = ?";
                 pst = connect.prepareStatement(sql);
                 pst.setInt(1, t);
                 int allRow = pst.executeUpdate();
                 if (allRow > 0){
                     status = true;
                 }
                 MySQLConnection.closeConnection(connect);
             }     catch (SQLException ex) { 
                       status = false;
                       JOptionPane.showMessageDialog(null, "Lỗi không thể xóa dữ liệu khách hàng");
                   } 
             return status;
         }
       
       public KhachHangDTO selectByIdKhachHang(int t) {
        KhachHangDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM tbl_khachhang WHERE id_khachhang=?";
            pst = (PreparedStatement) connect.prepareStatement(query);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id_khachhang = rs.getInt("id_khachhang");
                String hoten = rs.getString("hoten");
                String ngaysinh = rs.getString("ngaysinh");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                KhachHangDTO khDTO = new KhachHangDTO(id_khachhang, hoten, ngaysinh, diachi, sodienthoai,email );
                result = khDTO;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
