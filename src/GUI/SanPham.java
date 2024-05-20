/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import GUI.SPham.ChiTietSP;
import GUI.SPham.SuaSP;
import GUI.SPham.ThemSP;
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
public class SanPham extends javax.swing.JPanel {

    public final SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<SanPhamDTO> listSanPham = spBUS.getAll();
    DefaultTableModel tblModel;
    SanPhamBUS sanPhamBUS;
    SanPhamDAO sanPhamDAO;
    ThemSP themSP;
    SuaSP suaSP;
    ChiTietSP chiTietSP;

    /**
     * Creates new form SanPham
     */
    public SanPham() {
        initComponents();
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_sua.setIcon(new FlatSVGIcon("./GUI/icon/edit.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        tbl_sanpham.setFocusable(false);
        tbl_sanpham.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tbl_sanpham.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_sanpham.setFocusable(false);
        tbl_sanpham.setAutoCreateRowSorter(true);
        hienThiListSanPham(listSanPham);
    }

    private void hienThiListSanPham(ArrayList<SanPhamDTO> listSanPham) {
        sanPhamBUS = new SanPhamBUS();
        sanPhamDAO = new SanPhamDAO();
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham.getModel();
        model.setRowCount(0);
        for (SanPhamDTO sanPham : listSanPham) {
            Object[] row = {
                sanPham.getIdSanPham(),
                sanPham.getTenSanPham(),
                sanPham.getTenTacGia(),
                sanPham.getDonGia(),
                sanPham.getLoaiSach()
            };
            model.addRow(row);
        }

//         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tbl_sanpham.getColumnCount(); i++) {
            tbl_sanpham.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private SanPhamDTO selectSanPham() {
        int selectedRow = tbl_sanpham.getSelectedRow();
        SanPhamDTO result = null;
        if (selectedRow != -1) {
            int id_sanpham = (int) tbl_sanpham.getValueAt(selectedRow, 0);
            sanPhamBUS = new SanPhamBUS();
            result = sanPhamBUS.selectByID(id_sanpham);
        }
        return result;
    }

    private void xoaSanPham() {
        int selectedRow = tbl_sanpham.getSelectedRow();
        if (selectedRow != -1) {
            int id_sanpham = (int) tbl_sanpham.getValueAt(selectedRow, 0);
            SanPhamDTO canXoa = sanPhamBUS.selectByID(id_sanpham);
            sanPhamBUS = new SanPhamBUS();
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sản phẩm này");
            if (result == JOptionPane.YES_OPTION) {
                boolean thanhCong = sanPhamBUS.xoaSanPham(id_sanpham);
                if (thanhCong) {
                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công");
                    listSanPham = sanPhamBUS.getAll();
                    hienThiListSanPham(listSanPham);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm lỗi");
                }
            } 
            else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Không xóa sản phẩm nữa");
        }
        }            else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa");
            }
        }
    
     private void timKiemSanPham(String keyword) {
        ArrayList<SanPhamDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tensanpham = (String) model.getValueAt(i, 1);
            int id_sanpham = (int) model.getValueAt(i, 0);
            String tentacgia = (String) model.getValueAt(i, 2);
            String giaban = (String) model.getValueAt(i, 3);
            String theloai = (String) model.getValueAt(i, 4);
            if (tensanpham.toLowerCase().contains(keyword.toLowerCase())
                    || String.valueOf(id_sanpham).contains(keyword) ||tentacgia.toLowerCase().contains(keyword.toLowerCase()) || giaban.toLowerCase().contains(keyword.toLowerCase()) || theloai.toLowerCase().contains(keyword.toLowerCase()) ) {
                ketQuaTimKiem.add(sanPhamBUS.selectByID(id_sanpham));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng ! ");
            }
            hienThiListSanPham(ketQuaTimKiem);
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
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
        tbl_sanpham = new javax.swing.JTable();

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

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Tên tác giả", "Giá bán", "Thể loại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tbl_sanpham.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane2.setViewportView(tbl_sanpham);
        if (tbl_sanpham.getColumnModel().getColumnCount() > 0) {
            tbl_sanpham.getColumnModel().getColumn(0).setResizable(false);
            tbl_sanpham.getColumnModel().getColumn(1).setResizable(false);
            tbl_sanpham.getColumnModel().getColumn(2).setResizable(false);
            tbl_sanpham.getColumnModel().getColumn(3).setResizable(false);
            tbl_sanpham.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        themSP = new ThemSP();
        themSP.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaSanPham();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        listSanPham = sanPhamBUS.getAll();
        hienThiListSanPham(listSanPham);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_chitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chitietActionPerformed
        if (selectSanPham() != null) {
            chiTietSP = new ChiTietSP(selectSanPham());
            chiTietSP.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }
    }//GEN-LAST:event_btn_chitietActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (selectSanPham() != null) {
            suaSP = new SuaSP(selectSanPham());
            suaSP.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemSanPham(keyword);
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
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
