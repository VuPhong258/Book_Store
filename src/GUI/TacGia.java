/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.TacGiaBUS;
import DAO.TacGiaDAO;
import GUI.TGia.ThemTG;
import GUI.TGia.SuaTG;
import DTO.TacGiaDTO;
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
public class TacGia extends javax.swing.JPanel {
    public final TacGiaBUS tgBUS = new TacGiaBUS();
    private ArrayList<TacGiaDTO> listTacGia = tgBUS.getAll();
    TacGiaBUS tacGiaBUS;
    TacGiaDAO tacGiaDAO;
    TacGiaDTO tacGiaDTO;
    DefaultTableModel tblmodel;
    ThemTG addTGia;
    SuaTG suaTGia;
    
    
    /**
     * Creates new form SanPham
     */
    public TacGia() {
        initComponents();
        btn_them.setIcon(new FlatSVGIcon("./GUI/icon/add.svg"));
        btn_sua.setIcon(new FlatSVGIcon("./GUI/icon/edit.svg"));
        btn_xoa.setIcon(new FlatSVGIcon("./GUI/icon/delete.svg"));
        btn_chitiet.setIcon(new FlatSVGIcon("./GUI/icon/detail.svg"));
        btn_lammoi.setIcon(new FlatSVGIcon("./GUI/icon/toolBar_refresh.svg"));
        tbl_tacgia.setFocusable(false);     
        tbl_tacgia.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tbl_tacgia.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_tacgia.setFocusable(false);
        tbl_tacgia.setAutoCreateRowSorter(true);
        hienThiListTacGia(listTacGia);
    }
    
        public void hienThiListTacGia(ArrayList<TacGiaDTO> listTacGia){
                tacGiaBUS = new TacGiaBUS();
                tacGiaDAO = new TacGiaDAO();
                DefaultTableModel model = (DefaultTableModel) tbl_tacgia.getModel();
                model.setRowCount(0);
                for (TacGiaDTO tacGiaDTO : listTacGia){
                    Object [] row = {
                        tacGiaDTO.getTenTacGia(),
                        tacGiaDTO.getNamSinh()
                    };
                    model.addRow(row);
                }
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                
                for (int i =0;  i< tbl_tacgia.getColumnCount(); i++){
                       tbl_tacgia.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
        }
        
        private TacGiaDTO selectTacGia() {
            int selectedRow = tbl_tacgia.getSelectedRow();
            TacGiaDTO  result = null;
            if (selectedRow != -1) {
            String tentacgia = (String) tbl_tacgia.getValueAt(selectedRow, 0);
            tacGiaBUS = new TacGiaBUS();
            result = tacGiaBUS.selectByName(tentacgia);
        }
        return result;
    }
        
        
        
        private void xoaTacGia() {
        int selectedRow = tbl_tacgia.getSelectedRow();
        if (selectedRow != -1) {
            String tentacgia = (String) tbl_tacgia.getValueAt(selectedRow, 0);
            TacGiaDTO canXoa = tacGiaBUS.selectByName(tentacgia);
            tacGiaBUS = new TacGiaBUS();
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tác giả này");
            
            if (result == JOptionPane.YES_OPTION) {
                boolean thanhCong = tacGiaBUS.xoaTacGia(tentacgia);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Xóa tác giả thành công");
                listTacGia = tacGiaBUS.getAll();
                hienThiListTacGia(listTacGia);
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi xóa tác giả");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Không xóa tác giả nữa");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để xóa");
    }
    }
        
         private void timKiemTacGia(String keyword) {
        ArrayList<TacGiaDTO> ketQuaTimKiem = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbl_tacgia.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String tentacgia = (String) model.getValueAt(i, 0);
            String namsinh = (String)  model.getValueAt(i, 1);
            if (tentacgia.toLowerCase().contains(keyword.toLowerCase())
                    || namsinh.toLowerCase().contains(keyword.toLowerCase())) {
                ketQuaTimKiem.add(tacGiaBUS.selectByName(tentacgia));
            }
           
            }
            if (ketQuaTimKiem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy tác giả! ");
            }
            hienThiListTacGia(ketQuaTimKiem);
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
        tbl_tacgia = new javax.swing.JTable();

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

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1200, 800));

        tbl_tacgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên tác giả", "Năm sinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tacgia.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane2.setViewportView(tbl_tacgia);
        if (tbl_tacgia.getColumnModel().getColumnCount() > 0) {
            tbl_tacgia.getColumnModel().getColumn(0).setResizable(false);
            tbl_tacgia.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
       addTGia = new ThemTG();
       addTGia.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        listTacGia = tacGiaBUS.getAll();
        hienThiListTacGia(listTacGia);
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaTacGia();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
         if (selectTacGia() !=null){
            suaTGia = new SuaTG(selectTacGia());
            suaTGia.setVisible(true);
       }
       else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn tác giả");
       }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txt_timkiem.getText().trim();
            timKiemTacGia(keyword);
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
    private javax.swing.JTable tbl_tacgia;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
