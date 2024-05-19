/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKe.ThongKeDoanhThuDTO;
//import DTO.ThongKe.ThongKeKhachHangDTO;
import DTO.ThongKe.ThongKeNccDTO;
import DTO.ThongKe.ThongKeSanPhamBanChayDTO;
import DTO.ThongKe.ThongKeTonKhoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import config.MySQLConnection;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getTop5SanPhamBanChay() {
        Connection connect = MySQLConnection.getConnection();
        ArrayList<ThongKeSanPhamBanChayDTO> listThongKeSP = new ArrayList<>();
        String sql = "SELECT sp.id_sach, sp.tensach, SUM(ct.soluongmua) AS soluong_ban "
                + "FROM tbl_sach sp, tbl_chitiethoadon ct "
                + "WHERE sp.id_sach = ct.id_sach "
                + "GROUP BY sp.tensach "
                + "ORDER BY soluong_ban DESC ";

        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tensp = rs.getString("tensp");
                int soluongBan = rs.getInt("soluong_ban");

                ThongKeSanPhamBanChayDTO thongKeSanPhamBanChayDTO = new ThongKeSanPhamBanChayDTO(tensp, soluongBan);
                listThongKeSP.add(thongKeSanPhamBanChayDTO);
            }
            MySQLConnection.closeConnection(connect);

        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
        }
        return listThongKeSP;
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getListSanPhamBanChay(String ngaylaphoadon) {
        Connection connect = MySQLConnection.getConnection();
        ArrayList<ThongKeSanPhamBanChayDTO> listThongKeSP = new ArrayList<>();
        String sql = "SELECT sp.id_sach, sp.tensach, SUM(ct.soluongmua) AS soluong_ban "
                + "FROMtbl_sach sp, tbl_chitiethoadon ct, tbl_hoadon hd "
                + "WHERE ct.id_sach = sp.id_sach AND hd.id_hoadon = ct.id_hoadon AND hd.ngaylaphoadon = ? "
                + "GROUP BY sp.tensach "
                + "ORDER BY soluong_ban DESC ";
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, ngaylaphoadon); // Thiết lập tháng
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tensp = rs.getString("tensp");
                int soluongBan = rs.getInt("soluong_ban");
                ThongKeSanPhamBanChayDTO thongKeSanPhamBanChayDTO = new ThongKeSanPhamBanChayDTO(tensp, soluongBan);
                listThongKeSP.add(thongKeSanPhamBanChayDTO);
            }
            MySQLConnection.closeConnection(connect);
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
            // Ghi log hoặc xử lý exception theo nhu cầu của bạn
        }
        return listThongKeSP;
    }


}
