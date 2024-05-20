/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.TaiKhoanDTO;
import config.MySQLConnection;
import java.sql.Connection;
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
public class TaiKhoanDAO {
            Connection connect;
            PreparedStatement pst;
            
         public static TaiKhoanDAO getInstance() {
                return new TaiKhoanDAO();
    }
            
       public ArrayList<TaiKhoanDTO> getAll(){
           ArrayList<TaiKhoanDTO> result = new ArrayList<>();
           try {
                connect = (Connection) MySQLConnection.getConnection();
                String query = "SELECT * FROM tbl_taikhoan WHERE trangthai=1";
                pst = connect.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    int idTaiKhoan = rs.getInt("id_tai_khoan");
                    int idNhanVien = rs.getInt("id_nhanvien");
                    String tendangnhap = rs.getString("tendangnhap");
                    String matkhau = rs.getString("matkhau");
                    int loaitaikhoan = rs.getInt("loaitaikhoan");
                    int trangthai = rs.getInt("trangthai");
                    String quyen = rs.getString("tenquyen");
                    TaiKhoanDTO tkDTO = new TaiKhoanDTO(idTaiKhoan, tendangnhap, matkhau, loaitaikhoan, idNhanVien, quyen, trangthai);
                    result.add(tkDTO);
                    
                }
                      MySQLConnection.closeConnection(connect);
           }    catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
           return result;
       }
       
       public boolean addTaiKhoan(TaiKhoanDTO taiKhoanDTO){
           boolean status = false;
           String sql = "INSERT INTO `tbl_taikhoan` (tendangnhap, matkhau, tenquyen,id_nhanvien) VALUES (?,?,?,?)";
                   try {
                        connect = MySQLConnection.getConnection();
                        pst = connect.prepareStatement(sql);
                        pst.setString(1, taiKhoanDTO.getTenDangNhap());
                        pst.setString(2, taiKhoanDTO.getMatKhau());
                        pst.setString(3,taiKhoanDTO.getTenQuyen());
                        pst.setInt(4 ,taiKhoanDTO.getIdNhanVien());
                        int allRow  = pst.executeUpdate();
                        if (allRow > 0 ){
                                status = true;
                        }    
                        MySQLConnection.closeConnection(connect);
                   } catch (SQLException ex) { 
                       JOptionPane.showMessageDialog(null,ex);
                       status = false;
                } 
                   return status;
       }
       
       public boolean suaTaiKhoan(TaiKhoanDTO taiKhoanDTO){
           boolean status = false;
           try {
               connect = MySQLConnection.getConnection();
               String sql = "UPDATE `tbl_taikhoan` SET tendangnhap = ? , matkhau=?,  tenquyen =?, id_nhanvien = ? WHERE id_tai_khoan=?";
               pst = connect.prepareStatement(sql);
               pst.setString(1, taiKhoanDTO.getTenDangNhap());
               pst.setString(2, taiKhoanDTO.getMatKhau());
               pst.setString(3,taiKhoanDTO.getTenQuyen());
               pst.setInt(4 ,taiKhoanDTO.getIdNhanVien());
               pst.setInt(5, taiKhoanDTO.getIdTaiKhoan());
               int allRow  = pst.executeUpdate();
                   if (allRow > 0 ){
                       status = true;
                    }    
           } catch (SQLException ex){
                    status = false;
                    JOptionPane.showMessageDialog(null, "Lỗi không thể sửa dữ liệu tài khoản ");
             }
             return status;
         }
       
       public boolean xoaTaiKhoan(String t){
             boolean status = false;
             try {
                 connect = MySQLConnection.getConnection();
                 String sql = "UPDATE `tbl_taikhoan` SET `trangthai`=0 WHERE `tendangnhap` = ?";
                 pst = connect.prepareStatement(sql);
                 pst.setString(1, t);
                 int allRow = pst.executeUpdate();
                 if (allRow > 0){
                     status = true;
                 }
                 MySQLConnection.closeConnection(connect);
             }     catch (SQLException ex) { 
                       status = false;
                       JOptionPane.showMessageDialog(null, "Lỗi không thể xóa dữ liệu nhà cung cấp");
                   } 
             return status;
         }
       
       public TaiKhoanDTO selectByUserName(String t) {
        TaiKhoanDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM tbl_taikhoan WHERE tendangnhap=?";
            pst = (PreparedStatement) connect.prepareStatement(query);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int idTaiKhoan = rs.getInt("id_tai_khoan");
                int idNhanVien = rs.getInt("id_nhanvien");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                String  tenquyen = rs.getString("tenquyen");
                 TaiKhoanDTO tkDTO = new TaiKhoanDTO(idTaiKhoan, tendangnhap, matkhau,  tenquyen,idNhanVien );
                result = tkDTO;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
       
       public TaiKhoanDTO selectById(int t) {
        TaiKhoanDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String query = "SELECT * FROM tbl_taikhoan WHERE id_tai_khoan=?";
            pst = (PreparedStatement) connect.prepareStatement(query);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int idTaiKhoan = rs.getInt("id_tai_khoan");
                int idNhanVien = rs.getInt("id_nhanvien");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                String tenquyen = rs.getString("tenquyen");
                 TaiKhoanDTO tkDTO = new TaiKhoanDTO(idTaiKhoan, tendangnhap, matkhau, tenquyen, idNhanVien );
                result = tkDTO;
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
