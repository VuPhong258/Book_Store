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
            
       public ArrayList<TaiKhoanDTO> selectAll(){
           ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
           try {
                connect = MySQLConnection.getConnection();
                String query = "SELECT * FROM tbl_taikhoan WHERE trangthai=1";
                pst = connect.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    int idTaiKhoan = rs.getInt("id_tai_khoan");
                    int idNhanVien = rs.getInt("id_nhan_vien");
                    String tendangnhap = rs.getString("tendangnhap");
                    String matkhau = rs.getString("matkhau");
                    int loaitaikhoan = rs.getInt("loaitaikhoan");
                    int trangthai = rs.getInt("trangthai");
                    TaiKhoanDTO tkDTO = new TaiKhoanDTO(idTaiKhoan, tendangnhap, matkhau, idNhanVien, loaitaikhoan, trangthai );
                    result.add(tkDTO);
                    
                }
                      MySQLConnection.closeConnection(connect);
           }    catch (SQLException ex) {
                    Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
           return result;
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
                int idNhanVien = rs.getInt("id_nhan_vien");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                int loaitaikhoan = rs.getInt("loaitaikhoan");
                int trangthai = rs.getInt("trangthai");
                 TaiKhoanDTO tkDTO = new TaiKhoanDTO(idTaiKhoan, tendangnhap, matkhau, idNhanVien, loaitaikhoan, trangthai );
                result = tkDTO;
            }
            MySQLConnection.closeConnection(connect);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
