/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.HoaDonDTO;
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
public class HoaDonDAO {
            Connection connect;
            PreparedStatement pst;
            public static HoaDonDAO getIntance(){
             return new HoaDonDAO();
    }
    
    public ArrayList<HoaDonDTO> getAllHoaDon(){
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        try {
            connect =  MySQLConnection.getConnection();
            String query = "SELECT * FROM `tbl_hoadon`";
            pst = (PreparedStatement) connect.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id_hoadon = rs.getInt("id_hoadon");
                int id_khachhang = rs.getInt("id_khachhang");
                int id_nhanvien = rs.getInt("id_nhanvien");
                String ngaylaphoadon = rs.getString("ngaylaphoadon");
                String tongtien = rs.getString("tongtien");
                HoaDonDTO hd = new HoaDonDTO(id_hoadon,id_nhanvien,id_khachhang,ngaylaphoadon,tongtien);
                result.add(hd);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    
    public boolean addHoaDon(HoaDonDTO hoaDonDTO){
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String query = "INSERT INTO `tbl_hoadon` (id_hoadon,id_khachhang,id_nhanvien,ngaylaphoadon,tongtien) VALUES (?,?,?,?,?)";
            pst = connect.prepareStatement(query);
            pst.setInt(1, hoaDonDTO.getIdHoaDon());
            pst.setInt(2, hoaDonDTO.getIdKh());
            pst.setInt(3, hoaDonDTO.getIdNv());
            pst.setString(4, hoaDonDTO.getNgayLapHoaDon());
            pst.setString(5, hoaDonDTO.getTongTien());
            int allRow  = pst.executeUpdate();
            if (allRow > 0 ){
                status = true;
            }
            MySQLConnection.closeConnection(connect);
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public boolean xoaHoaDon(int t) {
        boolean status = false;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "DELETE FROM `tbl_hoadon` WHERE id_hoadon = ?";
            pst =connect.prepareStatement(sql);
            pst.setInt(1, t);
             int allRow = pst.executeUpdate();
            if (allRow > 0) {
                status = true;
            }
                        MySQLConnection.closeConnection(connect);

        } catch (SQLException ex) {
            System.out.println(ex);
            status = false;
        }
        return status;
    }
}
