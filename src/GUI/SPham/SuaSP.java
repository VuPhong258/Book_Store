/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.SPham;

import BUS.SanPhamBUS;
import BUS.TacGiaBUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class SuaSP extends javax.swing.JFrame {
    SanPhamDTO sanPhamDTO;
    SanPhamDAO sanPhamDAO;
    SanPhamBUS sanPhamBUS;
    int id_sach;
    /**
     * Creates new form ThemSP
     */
    public SuaSP() {
        initComponents();
        setLocationRelativeTo(null);
        SanPhamDTO spDTO = new SanPhamDTO();
        LoadDuLieu(spDTO);
    }
    
    public SuaSP(SanPhamDTO sanPhamDTO) {
        initComponents();
        setLocationRelativeTo(null);
        LoadDuLieu(sanPhamDTO);
        id_sach = sanPhamDTO.getIdSanPham();
    }
    
    private void LoadDuLieu(SanPhamDTO sanPhamDTO) {
        System.err.println("LoadDuLieu() được gọi");
        if (sanPhamDTO != null) {
            String url = String.valueOf(sanPhamDTO.getHinhAnh());
            txt_namesach.setText(String.valueOf(sanPhamDTO.getTenSanPham()));
            txt_nametacgia.setText(String.valueOf(sanPhamDTO.getTenTacGia()));
            txt_price.setText(String.valueOf(sanPhamDTO.getDonGia()));
            txt_quantity.setText(String.valueOf(sanPhamDTO.getSoLuong()));
            txt_loai.setText(String.valueOf(sanPhamDTO.getLoaiSach()));
            txt_namehinhanh.setText(String.valueOf(sanPhamDTO.getHinhAnh()));
            Icon icon = new ImageIcon("src/GUI/img_product/" + url +".png");
            lbl_anh.setIcon(icon);

           
        } else {
            // Xử lý trường hợp tacGiaDTO là null
            // Ví dụ: Xóa dữ liệu trên giao diện hoặc hiển thị thông báo
            txt_namesach.setText("");
            txt_nametacgia.setText("");
            txt_price.setText("");
            txt_quantity.setText("");
            txt_loai.setText("");
            txt_namehinhanh.setText("");
            JOptionPane.showMessageDialog(this, "Không có thông tin sản phẩm để hiển thị", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    
    public SanPhamDTO getNewSP(){
         String namesach = txt_namesach.getText();
         String nametacgia = txt_nametacgia.getText();
         String giasach = txt_price.getText();
         int soluong = Integer.parseInt(txt_quantity.getText());
         String loai = txt_loai.getText();
         String tenhinhanh = txt_namehinhanh.getText();
         if(txt_namesach.getText().isEmpty()){
           showMessage("Vui lòng không để trống tên sách");
        }
        else if (txt_nametacgia.getText().isEmpty()){
           showMessage("Vui lòng không để trống tên tác giả");
        }
        else if (txt_price.getText().isEmpty()){
           showMessage("Vui lòng không để trống giá sách");
        } else if (txt_quantity.getText().isEmpty()){
           showMessage("Vui lòng không để trống số lượng đang có");
        } else if (txt_loai.getText().isEmpty()){
           showMessage("Vui lòng không để trống thể loại sách");
        } else if (txt_namehinhanh.getText().isEmpty()){
           showMessage("Vui lòng không để trống tên hình ảnh");

        } else {
            sanPhamDTO = new SanPhamDTO(namesach, nametacgia, giasach, soluong, loai,tenhinhanh);
        }
         
        
         
         
         return sanPhamDTO;
        
    }
    
    private boolean isValidData() {
       String namesanpham =  txt_namesach.getText();
        String tentacgia = txt_nametacgia.getText();
      
        // Kiểm tra tên tác giả đã tồn tại hay chưa
        if (!isExitNameAuthor(tentacgia)) {
            showMessage("Tên tác giả chưa tồn tại! Hãy thêm tác giả này trước khi sửa sản phẩm");
            return false;
        }
      
     
        // Kiểm tra tên đã tồn tại chưa
         if (isDuplicateSanPham(namesanpham)) {
            showMessage("Sản phẩm đã tồn tại");
        return false;
        }
    return true;
}
    
       private boolean isDuplicateSanPham(String tensanpham) {
                sanPhamBUS = new SanPhamBUS();
                ArrayList<SanPhamDTO> danhSachSanPham = sanPhamBUS.getAll();
                for (SanPhamDTO sp : danhSachSanPham) {
                    if (sp.getTenSanPham().equalsIgnoreCase(tensanpham)) {
            return true;
        }
    }
    return false;
}
       
       public boolean isExitNameAuthor(String tentacgia){
           TacGiaBUS tacGiaBUS = new TacGiaBUS();
           ArrayList<TacGiaDTO> danhSachTacGia = tacGiaBUS.getAll();
           for (TacGiaDTO tg : danhSachTacGia) {
               if (tg.getTenTacGia().equalsIgnoreCase(tentacgia)){
                   return true;
               }
           }
           return false;
       }
       
       
       private void SuaSanPham() throws IOException {
        if (!isValidData()) {
            return;
        } 
        try {

        // Nhận thông tin từ giao diện
        SanPhamDTO spNew = getNewSP();
        spNew.setIdSanPham(id_sach);
        sanPhamBUS = new SanPhamBUS();
        boolean status = sanPhamBUS.suaSanPham(spNew);
        if (status) {
            showMessage("Sửa sản phẩm thành công");
            dispose();
        } else {
            showMessage("Sửa sản phẩm thất bại");

        }
        } catch (Exception ex) {
            showMessage("Sửa sản phẩm thất bại do có textField bị bỏ trống");
        }
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imagePath = selectedFile.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(imagePath);
            lbl_anh.setIcon(imageIcon);
        }
    }
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
        btn_edit = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lbl_anh = new javax.swing.JLabel();
        btn_chooseimage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_loai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_top.setBackground(new java.awt.Color(204, 255, 204));

        lbl_title.setBackground(new java.awt.Color(255, 51, 51));
        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Sửa Sản Phẩm");

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

        lbl_loai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_loai.setText("Thể loại");

        lbl_titleanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titleanh.setText("Ảnh sản phẩm");

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_quantity.setText("Số lượng ");

        btn_edit.setBackground(new java.awt.Color(51, 153, 255));
        btn_edit.setText("Sửa");
        btn_edit.setFocusable(false);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 102, 102));
        btn_cancel.setText("Hủy bỏ");
        btn_cancel.setFocusable(false);
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        lbl_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/img_product/tosocaidongho.png"))); // NOI18N

        btn_chooseimage.setBackground(new java.awt.Color(255, 0, 255));
        btn_chooseimage.setText("Chọn ảnh");
        btn_chooseimage.setFocusTraversalPolicyProvider(true);
        btn_chooseimage.setFocusable(false);
        btn_chooseimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseimageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên hình ảnh");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
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
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btn_chooseimage, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
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
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(lbl_anh)
                        .addGap(34, 34, 34)
                        .addComponent(btn_chooseimage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txt_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(339, 398, Short.MAX_VALUE))
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

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            SuaSanPham();
        } catch (IOException ex) {
            Logger.getLogger(SuaSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_chooseimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseimageActionPerformed
        chooseImage();
    }//GEN-LAST:event_btn_chooseimageActionPerformed

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
//                new SuaSP().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_chooseimage;
    private javax.swing.JButton btn_edit;
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
