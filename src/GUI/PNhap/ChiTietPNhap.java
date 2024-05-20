/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.PNhap;

import DTO.ChiTietPhieuNhapDTO;
// import DTO.KhachHangDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class ChiTietPNhap extends javax.swing.JFrame {

    // Khai báo một biến để lưu trữ danh sách chi tiết phiếu nhập

    /**
     * Creates new form ChiTietKH
     */
    public ChiTietPNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public ChiTietPNhap(PhieuNhapDTO phieuNhapDTO) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        txt_idPN.setEditable(false);
        txt_idNV.setEditable(false);
        txt_tongtien.setEditable(false);
        txt_ngaynhap.setEditable(false);
        
        txt_idNCC.setEditable(false);
        LoadDuLieu(phieuNhapDTO);
        phieuNhapDTO.getIdPhieuNhap();
    }
    public ChiTietPNhap(PhieuNhapDTO phieuNhapDTO, ArrayList<ChiTietPhieuNhapDTO> chiTietList) {
        initComponents();
        LoadDuLieu(phieuNhapDTO);
        displayChiTietList(chiTietList);
    }
    
    public void LoadDuLieu(PhieuNhapDTO phieuNhapDTO){
        txt_idPN.setText(String.valueOf(phieuNhapDTO.getIdPhieuNhap()));
        txt_idNV.setText(String.valueOf(phieuNhapDTO.getIdNV()));
        txt_idNCC.setText(String.valueOf(phieuNhapDTO.getIdNhaCungCap()));
        txt_tongtien.setText(String.valueOf(phieuNhapDTO.getTongTien()));
        txt_ngaynhap.setText(String.valueOf(phieuNhapDTO.getNgayNhap()));
    }
    private void displayChiTietList(ArrayList<ChiTietPhieuNhapDTO> chiTietList) {
        DefaultTableModel model = (DefaultTableModel) tbl_ctphieunhap.getModel();
        model.setRowCount(0);
        int stt = 1; // Initialize the sequence number
        for (ChiTietPhieuNhapDTO chiTiet : chiTietList) {
            Object[] row = {
                stt++, 
                chiTiet.getIdSach(),
                chiTiet.getTenSach(),
                chiTiet.getGiaNhap(),
                chiTiet.getSoLuongNhap()
            };
            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_center = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        txt_idNCC = new javax.swing.JTextField();
        txt_idPN = new javax.swing.JTextField();
        lbl_date = new javax.swing.JLabel();
        lbl_idKH = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        txt_idNV = new javax.swing.JTextField();
        txt_ngaynhap = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ctphieunhap = new javax.swing.JTable();
        txt_tongtien = new javax.swing.JTextField();
        lbl_address1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_top.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi tiết phiếu nhập");

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_center.setBackground(new java.awt.Color(255, 255, 255));

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_name.setText("Mã nhân viên");

        txt_idNCC.setEditable(false);
        txt_idNCC.setBackground(new java.awt.Color(255, 255, 255));
        txt_idNCC.setFocusable(false);
        txt_idNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idNCCActionPerformed(evt);
            }
        });

        txt_idPN.setEditable(false);
        txt_idPN.setBackground(new java.awt.Color(255, 255, 255));
        txt_idPN.setFocusable(false);

        lbl_date.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_date.setText("Mã nhà cung cấp");

        lbl_idKH.setBackground(new java.awt.Color(255, 255, 255));
        lbl_idKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_idKH.setText("Mã Phiếu");

        lbl_address.setBackground(new java.awt.Color(255, 255, 255));
        lbl_address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_address.setText("Ngày nhập");

        txt_idNV.setEditable(false);
        txt_idNV.setBackground(new java.awt.Color(255, 255, 255));
        txt_idNV.setFocusable(false);

        txt_ngaynhap.setEditable(false);
        txt_ngaynhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_ngaynhap.setFocusable(false);

        btn_exit.setBackground(new java.awt.Color(255, 102, 102));
        btn_exit.setText("Thoát");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        tbl_ctphieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ctphieunhap.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane3.setViewportView(tbl_ctphieunhap);

        txt_tongtien.setEditable(false);
        txt_tongtien.setBackground(new java.awt.Color(255, 255, 255));
        txt_tongtien.setFocusable(false);
        txt_tongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongtienActionPerformed(evt);
            }
        });

        lbl_address1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_address1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_address1.setText("Tổng tiền");

        javax.swing.GroupLayout pnl_centerLayout = new javax.swing.GroupLayout(pnl_center);
        pnl_center.setLayout(pnl_centerLayout);
        pnl_centerLayout.setHorizontalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idPN, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(lbl_idKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_address1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnl_centerLayout.setVerticalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_idKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idPN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(lbl_address1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnl_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void txt_idNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idNCCActionPerformed

    private void txt_tongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongtienActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChiTietKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChiTietKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChiTietKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChiTietKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietKH().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_address1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_idKH;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTable tbl_ctphieunhap;
    private javax.swing.JTextField txt_idNCC;
    private javax.swing.JTextField txt_idNV;
    private javax.swing.JTextField txt_idPN;
    private javax.swing.JTextField txt_ngaynhap;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}