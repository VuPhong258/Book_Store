/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import GUI.KHang.ChiTietKH;
import GUI.KHang.SuaKH;
import GUI.KHang.ThemKH;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class KhachHang extends javax.swing.JPanel {

    public final KhachHangBUS tkBUS = new KhachHangBUS();
    private ArrayList<KhachHangDTO> listKhachHang = tkBUS.getAll();
    KhachHangBUS khachHangBUS;
    KhachHangDAO khachHangDAO;
    DefaultTableModel tblmodel;
    ThemKH addKH;
    SuaKH suaKH;
    ChiTietKH chiTietKH;
    /**
     * Creates new form SanPham
     */
    public KhachHang() {
        initComponents();
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_sua.setIcon(new FlatSVGIcon("./GUI/icon/edit.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        tbl_khachhang.setFocusable(false);     
        tbl_khachhang.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tbl_khachhang.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_khachhang.setFocusable(false);
        tbl_khachhang.setAutoCreateRowSorter(true);
        hienThiListKhachHang(listKhachHang);
    }
    
    public void hienThiListKhachHang(ArrayList<KhachHangDTO> listKhachHang){
                khachHangBUS = new KhachHangBUS();
                khachHangDAO  = new KhachHangDAO();
                DefaultTableModel model = (DefaultTableModel) tbl_khachhang.getModel();
                model.setRowCount(0);
                for (KhachHangDTO khachHangDTO : listKhachHang){
                    Object [] row = {
                        khachHangDTO.getIdKhachHang(),
                        khachHangDTO.getHoTen(),
                        khachHangDTO.getSoDienThoai(),
                        khachHangDTO.getEmail()
                    };
                    model.addRow(row);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                
                for (int i =0;  i< tbl_khachhang.getColumnCount(); i++){
                       tbl_khachhang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
        }
        
        private KhachHangDTO selectKhachHang() {
            int selectedRow = tbl_khachhang.getSelectedRow();
            KhachHangDTO  result = null;
            if (selectedRow != -1) {
            int id_khachhang = (int) tbl_khachhang.getValueAt(selectedRow, 0);
            khachHangBUS = new KhachHangBUS();
            result = khachHangBUS.selectByID(id_khachhang);
        }
        return result;
    }
        
         private void xoaKhachHang() {
        int selectedRow = tbl_khachhang.getSelectedRow();
        if (selectedRow != -1) {
            int id_tacgia = (int) tbl_khachhang.getValueAt(selectedRow, 0);
            KhachHangDTO canXoa = khachHangBUS.selectByID(id_tacgia);
            khachHangBUS = new KhachHangBUS();
            
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khách hàng này");
            if (result == JOptionPane.YES_OPTION){
                boolean thanhCong = khachHangBUS.xoaKhachHang(id_tacgia);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
                listKhachHang = khachHangBUS.getAll();
                hienThiListKhachHang(listKhachHang);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng bị lỗi");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Không xóa khách hàng nữa");
        }
        }
            else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xóa");
        }
    }
         
          private void timKiemKhachHang(String keyword) {
        ArrayList<KhachHangDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_khachhang.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tenkhachhang = (String) model.getValueAt(i, 1);
            int id_khachhang = (int) model.getValueAt(i, 0);
            String sodienthoai = (String) model.getValueAt(i, 2);
            String emai = (String) model.getValueAt(i, 3);
            if (tenkhachhang.toLowerCase().contains(keyword.toLowerCase())
                    || String.valueOf(id_khachhang).contains(keyword) ||sodienthoai.toLowerCase().contains(keyword.toLowerCase()) || emai.toLowerCase().contains(keyword.toLowerCase())) {
                ketQuaTimKiem.add(khachHangBUS.selectByID(id_khachhang));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng ! ");
            }
            hienThiListKhachHang(ketQuaTimKiem);
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_control = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_chitiet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        btn_lammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 500));
        setLayout(new java.awt.BorderLayout());

        panel_control.setMinimumSize(new java.awt.Dimension(100, 100));
        panel_control.setPreferredSize(new java.awt.Dimension(1000, 80));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.setFocusable(false);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        panel_control.add(btn_them);

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.setFocusable(false);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        panel_control.add(btn_sua);

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.setFocusable(false);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        panel_control.add(btn_xoa);

        btn_chitiet.setBackground(new java.awt.Color(255, 255, 255));
        btn_chitiet.setText("Chi tiết");
        btn_chitiet.setFocusable(false);
        btn_chitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chitietActionPerformed(evt);
            }
        });
        panel_control.add(btn_chitiet);

        jLabel1.setText("Tìm kiếm");
        panel_control.add(jLabel1);

        txt_timkiem.setPreferredSize(new java.awt.Dimension(100, 30));
        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyPressed(evt);
            }
        });
        panel_control.add(txt_timkiem);

        btn_lammoi.setBackground(new java.awt.Color(255, 255, 255));
        btn_lammoi.setText("Làm mới");
        btn_lammoi.setFocusable(false);
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        panel_control.add(btn_lammoi);

        add(panel_control, java.awt.BorderLayout.PAGE_START);

        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                " Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_khachhang.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane2.setViewportView(tbl_khachhang);
        if (tbl_khachhang.getColumnModel().getColumnCount() > 0) {
            tbl_khachhang.getColumnModel().getColumn(0).setResizable(false);
            tbl_khachhang.getColumnModel().getColumn(1).setResizable(false);
            tbl_khachhang.getColumnModel().getColumn(2).setResizable(false);
            tbl_khachhang.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaKhachHang();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addKH = new ThemKH();
        addKH.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
          if (selectKhachHang() !=null){
            suaKH = new SuaKH(selectKhachHang());
            suaKH.setVisible(true);
       }
       else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
       }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        listKhachHang = khachHangBUS.getAll();
        hienThiListKhachHang(listKhachHang);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_chitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chitietActionPerformed
          if (selectKhachHang() !=null){
            chiTietKH = new ChiTietKH(selectKhachHang());
            chiTietKH.setVisible(true);
       }
       else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
       }
    }//GEN-LAST:event_btn_chitietActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemKhachHang(keyword);
        }
    }//GEN-LAST:event_txt_timkiemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chitiet;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_control;
    private javax.swing.JTable tbl_khachhang;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
