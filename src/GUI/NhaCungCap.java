/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import GUI.NCC.SuaNcc;
import java.util.ArrayList;
import GUI.NCC.ThemNcc;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class NhaCungCap extends javax.swing.JPanel {
    
     public final NhaCungCapBUS nccBUS = new NhaCungCapBUS();
     public ArrayList<NhaCungCapDTO> nhaCungCapList = nccBUS.getAllNCC();
     DefaultTableModel tblModel;
     NhaCungCapDAO nhaCungCapDAO;
     NhaCungCapBUS nhaCungCapBUS;
     ThemNcc addNcc;
     SuaNcc suaNcc;
    /**
     * Creates new form SanPham
     */
    public NhaCungCap() {
        initComponents();
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_sua.setIcon(new FlatSVGIcon("./GUI/icon/edit.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        tbl_ncc.setFocusable(false);     
        tbl_ncc.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tbl_ncc.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_ncc.setFocusable(false);
        tbl_ncc.setAutoCreateRowSorter(true);
        hienThiListNhaCungCap(nhaCungCapList);
    }
    
       private void hienThiListNhaCungCap(ArrayList<NhaCungCapDTO> nhaCungCapList) {
        nhaCungCapBUS = new NhaCungCapBUS();
        nhaCungCapDAO = new NhaCungCapDAO();
        DefaultTableModel model = (DefaultTableModel) tbl_ncc.getModel();
        model.setRowCount(0);
        for (NhaCungCapDTO nhaCungCap : nhaCungCapList) {
            Object[] row = {
                nhaCungCap.getIdNcc(),
                nhaCungCap.getTenNcc(),
                nhaCungCap.getDiaChi(),
                nhaCungCap.getSoDienThoai(),
            };
            model.addRow(row);
        }

//         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tbl_ncc.getColumnCount(); i++) {
            tbl_ncc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
       private NhaCungCapDTO selectNhaCungCap() {
            int selectedRow = tbl_ncc.getSelectedRow();
            NhaCungCapDTO result = null;
            if (selectedRow != -1) {
            int mancc = (int) tbl_ncc.getValueAt(selectedRow, 0);
            nhaCungCapBUS = new NhaCungCapBUS();
            result = nhaCungCapBUS.selectByID(mancc);
        }
        return result;
    }

       private void xoaNhaCungCap() {
        int selectedRow = tbl_ncc.getSelectedRow();
        if (selectedRow != -1) {
            int mancc = (int) tbl_ncc.getValueAt(selectedRow, 0);
            NhaCungCapDTO canXoa = nhaCungCapBUS.selectByID(mancc);
            nhaCungCapBUS = new NhaCungCapBUS();
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhà cung cấp này");
            
            if (result == JOptionPane.YES_OPTION) {
                boolean thanhCong = nhaCungCapBUS.xoaNhaCungCap(mancc);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp thành công");
                nhaCungCapList = nhaCungCapBUS.getAllNCC();
                hienThiListNhaCungCap(nhaCungCapList);
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi xóanhà cung cấp");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Không xóa nhà cung cấp nữa");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để xóa");
    }
    }
       
        private void timKiemNhaCungCap(String keyword) {
        ArrayList<NhaCungCapDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_ncc.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tennhacungcap = (String) model.getValueAt(i, 1);
            int id_ncc = (int) model.getValueAt(i, 0);
            String diachi = (String) model.getValueAt(i, 2);
            String sodienthoai = (String) model.getValueAt(i, 3);
            if (tennhacungcap.toLowerCase().contains(keyword.toLowerCase())
                    || String.valueOf(id_ncc).contains(keyword) || diachi.toLowerCase().contains(keyword.toLowerCase()) || sodienthoai.toLowerCase().contains(keyword.toLowerCase())) {
                ketQuaTimKiem.add(nhaCungCapBUS.selectByID(id_ncc));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp ! ");
            }
            hienThiListNhaCungCap(ketQuaTimKiem);
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
        tbl_ncc = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
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

        tbl_ncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên nhà  cung cấp", "Địa chỉ", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ncc.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane2.setViewportView(tbl_ncc);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addNcc = new ThemNcc();
        addNcc.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
       if (selectNhaCungCap() !=null){
            suaNcc = new SuaNcc(selectNhaCungCap());
            suaNcc.setVisible(true);
       }
       else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp");
       }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        nhaCungCapList = nhaCungCapBUS.getAllNCC();
        hienThiListNhaCungCap(nhaCungCapList);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
       xoaNhaCungCap();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemNhaCungCap(keyword);
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
    private javax.swing.JTable tbl_ncc;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
