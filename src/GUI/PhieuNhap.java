/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.PhieuNhapBUS;
import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import DTO.TaiKhoanDTO;
import GUI.PNhap.ChiTietPNhap;
import GUI.PNhap.SuaPNhap;
import GUI.PNhap.ThemPNhap;
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
public class PhieuNhap extends javax.swing.JPanel {
    public final PhieuNhapBUS tkBUS = new PhieuNhapBUS();
    private ArrayList<PhieuNhapDTO> listPhieuNhap = tkBUS.getAll();
    PhieuNhapBUS phieuNhapBUS;
    PhieuNhapDAO phieuNhapDAO;
    DefaultTableModel tblmodel;
    ThemPNhap addPN;
    SuaPNhap suaPN;
    ChiTietPNhap chiTietPNhap;
    private TaiKhoanDTO nhanVien;
    /**
     * Creates new form SanPham
     */
        public PhieuNhap(){
         initComponents();
        this.nhanVien = nhanVien;
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_xoa.setVisible(false);
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        hienThiListPhieuNhap(listPhieuNhap);
    }
    public PhieuNhap(TaiKhoanDTO nhanVien) {
        initComponents();
        this.nhanVien = nhanVien;
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_xoa.setVisible(false);
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        hienThiListPhieuNhap(listPhieuNhap);
    }
    private PhieuNhapDTO selectPhieuNhap() {
            int selectedRow = tbl_phieunhap.getSelectedRow();
            PhieuNhapDTO  result = null;
            if (selectedRow != -1) {
            int id_phieunhap = (int) tbl_phieunhap.getValueAt(selectedRow, 0);
            phieuNhapBUS = new PhieuNhapBUS();
            result = phieuNhapBUS.selectByID(id_phieunhap);
        }
        return result;
    }
    public void hienThiListPhieuNhap(ArrayList<PhieuNhapDTO> listPhieuNhap){
                phieuNhapBUS = new PhieuNhapBUS();
                phieuNhapDAO  = new PhieuNhapDAO();
                DefaultTableModel model = (DefaultTableModel) tbl_phieunhap.getModel();
                model.setRowCount(0);
                for (PhieuNhapDTO phieuNhapDTO : listPhieuNhap){
                    Object [] row = {
                        phieuNhapDTO.getIdPhieuNhap(),
                        phieuNhapDTO.getIdNhaCungCap(),
                        phieuNhapDTO.getIdNV(),
                        phieuNhapDTO.getNgayNhap(),
                        phieuNhapDTO.getTongTien(),
                        phieuNhapDTO.getTrangthai()                       
                    };
                    model.addRow(row);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                
                for (int i =0;  i< tbl_phieunhap.getColumnCount(); i++){
                       tbl_phieunhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
        }
    private void xoaPhieuNhap() {
        int selectedRow = tbl_phieunhap.getSelectedRow();
        if (selectedRow != -1) {
            int id_phieunhap = (int) tbl_phieunhap.getValueAt(selectedRow, 0);
            PhieuNhapDTO canXoa = phieuNhapBUS.selectByID(id_phieunhap);
            phieuNhapBUS = new PhieuNhapBUS();
            boolean thanhCong = phieuNhapBUS.xoaPhieuNhap(id_phieunhap);
            JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa phiếu nhập này");
            if (thanhCong) {

                JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thành công");
                listPhieuNhap = phieuNhapBUS.getAll();
                hienThiListPhieuNhap(listPhieuNhap);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa phiếu nhập bị lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu nhập để xóa");
        }}
    private void timKiemPhieuNhap(String keyword) {
        ArrayList<PhieuNhapDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_phieunhap.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int id_ncc = (int) model.getValueAt(i, 1);
            int id_phieunhap = (int) model.getValueAt(i, 0);
            int id_nhanvien = (int) model.getValueAt(i, 2);
            if (String.valueOf(id_phieunhap).contains(keyword) 
                    || String.valueOf(id_nhanvien).contains(keyword) ||String.valueOf(id_ncc).contains(keyword) ) {
                ketQuaTimKiem.add(phieuNhapBUS.selectByID(id_phieunhap));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng ! ");
            }
            hienThiListPhieuNhap(ketQuaTimKiem);
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
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_chitiet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        btn_lammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_phieunhap = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 500));
        setLayout(new java.awt.BorderLayout());

        panel_control.setMinimumSize(new java.awt.Dimension(100, 100));
        panel_control.setPreferredSize(new java.awt.Dimension(1000, 80));

        btn_xoa.setText("Xóa");
        btn_xoa.setFocusable(false);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        panel_control.add(btn_xoa);

        btn_them.setText("Thêm");
        btn_them.setFocusable(false);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        panel_control.add(btn_them);

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

        btn_lammoi.setText("Làm mới");
        btn_lammoi.setFocusable(false);
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        panel_control.add(btn_lammoi);

        add(panel_control, java.awt.BorderLayout.PAGE_START);

        tbl_phieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã NCC", "Mã Nhân Viên", "Ngày nhập", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_phieunhap.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane2.setViewportView(tbl_phieunhap);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
       addPN = new ThemPNhap(this.nhanVien);
       addPN.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed
       
    private void btn_chitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chitietActionPerformed
        PhieuNhapDTO selectedPhieuNhap = selectPhieuNhap();
    if (selectedPhieuNhap != null) {
        int id_phieunhap = selectedPhieuNhap.getIdPhieuNhap();
        ArrayList<ChiTietPhieuNhapDTO> chiTietList = phieuNhapBUS.selectAllByID(id_phieunhap);
        if (chiTietList != null && !chiTietList.isEmpty()) {
            chiTietPNhap = new ChiTietPNhap(selectedPhieuNhap, chiTietList);
            chiTietPNhap.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có chi tiết cho phiếu nhập này");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu nhập");
    }
    }//GEN-LAST:event_btn_chitietActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaPhieuNhap();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        listPhieuNhap = phieuNhapBUS.getAll();
        hienThiListPhieuNhap(listPhieuNhap);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemPhieuNhap(keyword);
        }
    }//GEN-LAST:event_txt_timkiemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chitiet;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_control;
    private javax.swing.JTable tbl_phieunhap;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
