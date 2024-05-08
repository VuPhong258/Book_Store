/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.QuyenDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.MySQLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class QuyenDAO {
        private Connection connect;
    private PreparedStatement pst;
    
    public static QuyenDAO getInstance(){
        return new QuyenDAO();
    }
    
    public ArrayList<QuyenDTO> getAllQuyen() {
        ArrayList<QuyenDTO> listQuyen = new ArrayList<>();
        connect = MySQLConnection.getConnection();
        String query = "SELECT * FROM `tbl_quyen`";
        try {
            pst = connect.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                QuyenDTO quyenDTO = new QuyenDTO();
                quyenDTO.setIdQuyen(rs.getInt("id_quyen"));
                quyenDTO.setTenQuyen(rs.getString("tenquyen"));
                listQuyen.add(quyenDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể tải dữ liệu");
        }
        return listQuyen;
    }
    
    public QuyenDTO selectById(int t) {
        QuyenDTO result = null;
        try {
            connect = (Connection) MySQLConnection.getConnection();
            String sql = "SELECT * FROM nhomquyen WHERE manhomquyen=?";
            pst = (PreparedStatement) connect.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int id_quyen = rs.getInt("id_quyen");
                String tenquyen = rs.getString("tenquyen");
                result = new QuyenDTO(id_quyen, tenquyen);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
        }
        return result;
    }
}
