/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.TacGiaDTO;
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
public class TacGiaDAO {
            Connection connect;
        
        public static TacGiaDAO getInstance(){
            return new TacGiaDAO();
        }
        
        public ArrayList<TacGiaDTO> getAll(){
            ArrayList<TacGiaDTO> result = new ArrayList<>();
            try {
                connect = MySQLConnection.getConnection();
                String query = "SELECT * FROM tbl_tacgia WHERE trangthai=1";
                PreparedStatement pst = connect.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                   String tentacgia = rs.getString("tentacgia");
                   String namsinh = rs.getString("namsinh");
                   TacGiaDTO tgDTO = new TacGiaDTO(tentacgia,namsinh);
                   result.add(tgDTO);
                }
                MySQLConnection.closeConnection(connect);
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public boolean themTacGia(TacGiaDTO tacGiaDTO){
            boolean status = false;
            String sql = "INSERT INTO `tbl_tacgia`(tentacgia, namsinh) VALUES (?, ?)";
            try {
                connect = (Connection) MySQLConnection.getConnection();
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.setString(1,tacGiaDTO.getTenTacGia());
                pst.setString(2,tacGiaDTO.getNamSinh());
                int allRow = pst.executeUpdate();
                if (allRow > 0){
                    status = true;
                }
                MySQLConnection.closeConnection(connect);
            } catch (SQLException ex) {
                status = false;
                JOptionPane.showMessageDialog(null,"Thêm tác giả thất bại!");
            }
            return status;
            
        }
        
        public boolean xoaTacGia(String name){
            boolean status = false;
            try {
                connect = (Connection) MySQLConnection.getConnection();
                String sql = "UPDATE `tbl_tacgia` SET `trangthai` = 0 WHERE `tentacgia` = ?";
                PreparedStatement pst =  connect.prepareStatement(sql);
                pst.setString(1,name);
                int allRow = pst.executeUpdate();
                if (allRow > 0) {
                    status = true;
                }
                MySQLConnection.closeConnection(connect);
            } catch (SQLException ex ) {
                status = false;
                JOptionPane.showMessageDialog(null, "Lỗi không thể xóa dữ liệu về tác giả");

            }
            return status;
        }
        
        public  boolean suaTacGia(TacGiaDTO tacGiaDTO){
            boolean status = false;
            try {
                connect = (Connection) MySQLConnection.getConnection();
                String sql = "UPDATE `tbl_tacgia` SET tentacgia = ?,namsinh = ? WHERE tentacgia=?";
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.setString(1,tacGiaDTO.getTenTacGia());
                pst.setString(2, tacGiaDTO.getNamSinh());
                pst.setString(3,tacGiaDTO.getTenTacGia());

                int allRow = pst.executeUpdate();
                if(allRow > 0) {
                    status = true;
                }
               MySQLConnection.closeConnection(connect);
            } catch (SQLException ex) {
                status = false;
                JOptionPane.showMessageDialog(null, "Lỗi không thể sửa dữ liệu về tác giả");

            }
            return status;
        }
        
        public TacGiaDTO selectByName(String name){
            TacGiaDTO result = null;
            try {
                connect = (Connection) MySQLConnection.getConnection();
                String sql = "SELECT * FROM `tbl_tacgia` WHERE tentacgia=?";
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.setString(1,name);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                   String tentacgia = rs.getString("tentacgia");
                   String namsinh = rs.getString("namsinh");
                   TacGiaDTO tgDTO = new TacGiaDTO(tentacgia, namsinh);
                   result = tgDTO;
                } 
                        MySQLConnection.closeConnection(connect);
                } catch (SQLException ex) {
                    System.out.println(ex);
            }
            return result;
        }
        
//        public int selectByName(String name) {
//             int id_tacgia = 0;
//            try {
//                connect = MySQLConnection.getConnection();
//                String sql = "SELECT id_tacgia FROM `tbl_tacgia` WHERE tentacgia =?";
//                PreparedStatement pst = connect.prepareStatement(sql);
//                pst.setString(1, name);
//                ResultSet rs = pst.executeQuery();
//                if (rs.next()){
//                    id_tacgia = rs.getInt("id_tacgia");
//                }
//            }   catch (SQLException ex) {
//                    Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            return id_tacgia;
//        }
}
