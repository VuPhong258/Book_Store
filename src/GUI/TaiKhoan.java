/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.TKhoan.SuaTK;
import GUI.TKhoan.ThemTK;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class TaiKhoan extends javax.swing.JPanel {

    public final TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    public ArrayList<TaiKhoanDTO> listTaiKhoan = tkBUS.getAll();
    DefaultTableModel tblModel;
    TaiKhoanBUS taiKhoanBUS;
    TaiKhoanDAO taiKhoanDAO;
    ThemTK themTk;
    SuaTK suaTk;

    /**
     * Creates new form SanPham
     */
    public TaiKhoan() {
        initComponents();
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_sua.setIcon(new FlatSVGIcon("./GUI/icon/edit.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        hienThiListTaiKhoan(listTaiKhoan);
    }

    public void hienThiListTaiKhoan(ArrayList<TaiKhoanDTO> listTaiKhoan) {
        taiKhoanBUS = new TaiKhoanBUS();
        taiKhoanDAO = new TaiKhoanDAO();
        DefaultTableModel model = (DefaultTableModel) tbl_taikhoan.getModel();
        model.setRowCount(0);
        for (TaiKhoanDTO taiKhoanDTO : listTaiKhoan) {
            Object[] row = {
                taiKhoanDTO.getIdTaiKhoan(),
                taiKhoanDTO.getTenDangNhap(),
                taiKhoanDTO.getMatKhau(),
                taiKhoanDTO.getTenQuyen(),
                taiKhoanDTO.getIdNhanVien()};
            model.addRow(row);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tbl_taikhoan.getColumnCount(); i++) {
            tbl_taikhoan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private TaiKhoanDTO selectTaiKhoan() {
        int selectedRow = tbl_taikhoan.getSelectedRow();
        TaiKhoanDTO result = null;
        if (selectedRow != -1) {
            String tendangnhap = (String) tbl_taikhoan.getValueAt(selectedRow, 1);
            taiKhoanBUS = new TaiKhoanBUS();
            result = taiKhoanBUS.selectByUserName(tendangnhap);
        }
        return result;
    }

    public void xoaTaiKhoan() {
        int selectedRow = tbl_taikhoan.getSelectedRow();
        if (selectedRow != -1) {

            String tendangnhap = (String) tbl_taikhoan.getValueAt(selectedRow, 1);
            TaiKhoanDTO canXoa = taiKhoanBUS.selectByUserName(tendangnhap);
            taiKhoanBUS = new TaiKhoanBUS();
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tài khoản này");
            if (result == JOptionPane.YES_OPTION ){
                 boolean thanhcong = taiKhoanBUS.xoaTaiKhoan(tendangnhap);
                if (thanhcong) {
                JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công");
                listTaiKhoan = taiKhoanBUS.getAll();
                hienThiListTaiKhoan(listTaiKhoan);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa tài khoản lỗi");
            } 
            }else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Không xóa tài khoản nữa");
        }
       }           else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để xóa");
    }
    }

    private void timKiemTaiKhoan(String keyword) {
        ArrayList<TaiKhoanDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_taikhoan.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tentaikhoan = (String) model.getValueAt(i, 1);
            int id_taikhoan = (int) model.getValueAt(i, 0);
            int idnhanvien = (int) model.getValueAt(i, 4);
            int loaitaikhoan = (int) model.getValueAt(i, 3);
            if (tentaikhoan.toLowerCase().contains(keyword.toLowerCase())
                    || String.valueOf(id_taikhoan).contains(keyword) || String.valueOf(idnhanvien).contains(keyword) || String.valueOf(loaitaikhoan).contains(keyword)) {
                ketQuaTimKiem.add(taiKhoanBUS.selectById(id_taikhoan));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy tài khoản! ");
            }
            hienThiListTaiKhoan(ketQuaTimKiem);
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
        tbl_taikhoan = new javax.swing.JTable();

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
        btn_chitiet.setEnabled(false);
        btn_chitiet.setFocusable(false);
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

        tbl_taikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên đăng nhâp", "Mật khẩu", "Quyền", "Id nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_taikhoan.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_taikhoan.setPreferredSize(new java.awt.Dimension(1200, 800));
        tbl_taikhoan.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(tbl_taikhoan);
        if (tbl_taikhoan.getColumnModel().getColumnCount() > 0) {
            tbl_taikhoan.getColumnModel().getColumn(0).setResizable(false);
            tbl_taikhoan.getColumnModel().getColumn(1).setResizable(false);
            tbl_taikhoan.getColumnModel().getColumn(2).setResizable(false);
            tbl_taikhoan.getColumnModel().getColumn(3).setResizable(false);
            tbl_taikhoan.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        ThemTK tk = new ThemTK();
        tk.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        listTaiKhoan = taiKhoanBUS.getAll();
        hienThiListTaiKhoan(listTaiKhoan);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaTaiKhoan();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (selectTaiKhoan() != null) {
            suaTk = new SuaTK(selectTaiKhoan());
            suaTk.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản ");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemTaiKhoan(keyword);
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
    private javax.swing.JTable tbl_taikhoan;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
