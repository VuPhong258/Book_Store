/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCapDTO;
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
public class NhaCungCapDAO {
               Connection connect;
        public static NhaCungCapDAO getInstance() {
            return new NhaCungCapDAO();
    }
         public ArrayList<NhaCungCapDTO> getAll() {
        ArrayList<NhaCungCapDTO> result = new ArrayList<NhaCungCapDTO>();
        try {
            connect = (Connection) MySQLConnection.getConnection();
            String query = "SELECT * FROM tbl_ncc WHERE trangthai=1";
            PreparedStatement pst = (PreparedStatement) connect.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int idNcc = rs.getInt("id_ncc");
                String tenncc = rs.getNString("tenncc");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                NhaCungCapDTO nccDTO = new NhaCungCapDTO(idNcc, tenncc, diachi, sodienthoai);
                result.add(nccDTO);
            }
            MySQLConnection.closeConnection(connect);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi không thể kết nối với dữ liệu nhà cung cấp");
        }
        return result;
    }
         
         public boolean addNcc(NhaCungCapDTO nhaCungCapDTO){
                boolean status = false;
                String sql = "INSERT into `tbl_ncc` (tenncc, diachi, sodienthoai) VALUES( ? , ? , ?)";
                try {
                    connect = MySQLConnection.getConnection();
                    PreparedStatement pst = connect.prepareStatement(sql);
                    pst.setString(1, nhaCungCapDTO.getTenNcc());
                    pst.setString(2, nhaCungCapDTO.getDiaChi());
                    pst.setString(3, nhaCungCapDTO.getSoDienThoai());
                    int allRow = pst.executeUpdate();
                    if (allRow > 0){
                        status = true;
                    }
                    MySQLConnection.closeConnection(connect);
                }  catch (SQLException ex) {
                       System.out.println(ex);
                       JOptionPane.showMessageDialog(null, "Lỗi không thể thêm nhà cung cấp");
                       status = false;    
                   }
                return status;
         }
         
         public boolean suaNcc(NhaCungCapDTO nhaCungCapDTO){
             boolean status = false;
             try {
                 connect = MySQLConnection.getConnection();
                 String sql = "UPDATE `tbl_ncc` SET tenncc = ?,  diachi =? , sodienthoai =? WHERE id_ncc=?";
                 PreparedStatement pst = connect.prepareStatement(sql);
                 pst.setString(1, nhaCungCapDTO.getTenNcc());
                 pst.setString(2, nhaCungCapDTO.getDiaChi());
                 pst.setString(3, nhaCungCapDTO.getSoDienThoai());
                 pst.setInt(4, nhaCungCapDTO.getIdNcc());
                 int allRow = pst.executeUpdate();
                 if (allRow > 0){
                     status = true;
                    }
                 MySQLConnection.closeConnection(connect);
             } catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Lỗi không thể sửa dữ liệu nhà cung cấp");
                    status = false;
                 
             }
             return status;
         }
         
         public boolean xoaNhaCungCap(int t){
             boolean status = false;
             try {
                 connect = MySQLConnection.getConnection();
                 String sql = "UPDATE `tbl_ncc` SET `trangthai`=0 WHERE `id_ncc` = ?";
                 PreparedStatement pst = connect.prepareStatement(sql);
                 pst.setInt(1, t);
                 int allRow = pst.executeUpdate();
                 if (allRow > 0){
                     status = true;
                 }
                 MySQLConnection.closeConnection(connect);
             }     catch (SQLException ex) { 
                       status = false;
                       Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
                   } 
             return status;
         }
         
         public NhaCungCapDTO selectById(int id_ncc) {
        NhaCungCapDTO result = null;
        try {
            connect = MySQLConnection.getConnection();
            String sql = "SELECT * FROM tbl_ncc WHERE id_ncc=?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setInt(1, id_ncc);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_ncc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                result = new NhaCungCapDTO(id, tenncc, diachi, sodienthoai);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
        }
        return result;
    }
}
