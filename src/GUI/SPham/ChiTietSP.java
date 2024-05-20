/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.SPham;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ChiTietSP extends javax.swing.JFrame {
    SanPhamDTO sanPhamDTO;
    SanPhamDAO sanPhamDAO;
    SanPhamBUS sanPhamBUS;
    /**
     * Creates new form ThemSP
     */
    public ChiTietSP() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public ChiTietSP(SanPhamDTO sanPhamDTO) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        txt_namesach.setEditable(false);
        txt_nametacgia.setEditable(false);
        txt_price.setEditable(false);
        txt_quantity.setEditable(false);
        txt_loai.setEditable(false);
        txt_namehinhanh.setEditable(false);
        LoadDuLieu(sanPhamDTO);
        
        sanPhamDTO.getIdSanPham();
    }
         
        public void LoadDuLieu(SanPhamDTO sanPhamDTO){
        String url = String.valueOf(sanPhamDTO.getHinhAnh());
        System.out.println(url);
        txt_namesach.setText(String.valueOf(sanPhamDTO.getTenSanPham()));
        txt_nametacgia.setText(String.valueOf(sanPhamDTO.getTenTacGia()));
        txt_price.setText(String.valueOf(sanPhamDTO.getDonGia()));
        txt_quantity.setText(String.valueOf(sanPhamDTO.getSoLuong()));
        txt_loai.setText(String.valueOf(sanPhamDTO.getLoaiSach()));
        txt_namehinhanh.setText(String.valueOf(sanPhamDTO.getHinhAnh()));
        Icon icon = new ImageIcon("src/GUI/img_product/" + url +".png");
        
        lbl_anh.setIcon(icon);
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
        lbl_title = new javax.swing.JLabel();
        pnl_center = new javax.swing.JPanel();
        lbl_nametacgia = new javax.swing.JLabel();
        lbl_namesach = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        txt_nametacgia = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_namesach = new javax.swing.JTextField();
        lbl_loai = new javax.swing.JLabel();
        lbl_titleanh = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        txt_namehinhanh = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        lbl_anh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_loai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        pnl_top.setBackground(new java.awt.Color(204, 255, 204));

        lbl_title.setBackground(new java.awt.Color(255, 51, 51));
        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Chi tiết sản phẩm");

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnl_center.setBackground(new java.awt.Color(255, 255, 255));

        lbl_nametacgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nametacgia.setText("Tên tác giả");

        lbl_namesach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_namesach.setText("Tên sách");

        lbl_price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_price.setText("Giá sản phẩm");

        txt_nametacgia.setEditable(false);
        txt_nametacgia.setBackground(new java.awt.Color(255, 255, 255));
        txt_nametacgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_nametacgia.setEnabled(false);

        txt_price.setEditable(false);
        txt_price.setBackground(new java.awt.Color(255, 255, 255));
        txt_price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_price.setEnabled(false);
        txt_price.setFocusable(false);

        txt_namesach.setEditable(false);
        txt_namesach.setBackground(new java.awt.Color(255, 255, 255));
        txt_namesach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_namesach.setEnabled(false);
        txt_namesach.setFocusable(false);

        lbl_loai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_loai.setText("Thể loại");

        lbl_titleanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titleanh.setText("Ảnh sản phẩm");

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_quantity.setText("Số lượng ");

        txt_quantity.setEditable(false);
        txt_quantity.setBackground(new java.awt.Color(255, 255, 255));
        txt_quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_quantity.setEnabled(false);
        txt_quantity.setFocusable(false);

        txt_namehinhanh.setEditable(false);
        txt_namehinhanh.setBackground(new java.awt.Color(255, 255, 255));
        txt_namehinhanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_namehinhanh.setEnabled(false);
        txt_namehinhanh.setFocusable(false);

        btn_exit.setBackground(new java.awt.Color(255, 102, 102));
        btn_exit.setText("Thoát");
        btn_exit.setFocusable(false);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        lbl_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img_product/tosocaidongho.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên hình ảnh");

        txt_loai.setEditable(false);
        txt_loai.setBackground(new java.awt.Color(255, 255, 255));
        txt_loai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_loai.setEnabled(false);
        txt_loai.setFocusable(false);

        javax.swing.GroupLayout pnl_centerLayout = new javax.swing.GroupLayout(pnl_center);
        pnl_center.setLayout(pnl_centerLayout);
        pnl_centerLayout.setHorizontalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_centerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(lbl_titleanh, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_namesach, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_namesach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_price, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_price, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_loai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_loai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_nametacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nametacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_namehinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(438, 438, 438))
        );
        pnl_centerLayout.setVerticalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_nametacgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_namesach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_titleanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_anh)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_centerLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_namesach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nametacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_centerLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_namehinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

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
//            java.util.logging.Logger.getLogger(ThemSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietSP().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_loai;
    private javax.swing.JLabel lbl_namesach;
    private javax.swing.JLabel lbl_nametacgia;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_titleanh;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTextField txt_loai;
    private javax.swing.JTextField txt_namehinhanh;
    private javax.swing.JTextField txt_namesach;
    private javax.swing.JTextField txt_nametacgia;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
