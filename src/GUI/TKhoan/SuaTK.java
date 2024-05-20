/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.TKhoan;
import GUI.TKhoan.*;
import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.TKhoan.ThemTK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class SuaTK extends javax.swing.JFrame {

    TaiKhoanDTO taiKhoanDTO;
    TaiKhoanDAO taiKhoanDAO;
    TaiKhoanBUS taiKhoanBUS;
    int id_taikhoan;
    /**
     * 
     * Creates new form ThemNcc
     */
    public SuaTK() {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        LoadDuLieu(taiKhoanDTO);
    }
    public SuaTK(TaiKhoanDTO taiKhoanDTO){
             initComponents();
             this.setLocationRelativeTo(null);
            this.setResizable(false);
            LoadDuLieu(taiKhoanDTO);
            id_taikhoan = taiKhoanDTO.getIdTaiKhoan();
    }
    
     private void LoadDuLieu(TaiKhoanDTO taiKhoanDTO) {
            System.err.println("LoadDuLieu() được gọi");   
//            String flag = nhaCungCapDTO.getTenNcc();
//            System.out.println(flag);
           if (taiKhoanDTO != null) {
            txt_name.setText(String.valueOf(taiKhoanDTO.getTenDangNhap()));
            txt_password.setText(String.valueOf(taiKhoanDTO.getMatKhau()));
            txt_idNV.setText(String.valueOf(taiKhoanDTO.getIdNhanVien()));
            cbb_role.getSelectedObjects();

            }else {
        // Xử lý trường hợp nhaCungCapDTO là null
        // Ví dụ: Xóa dữ liệu trên giao diện hoặc hiển thị thông báo
        txt_name.setText("");
        txt_idNV.setText("");
        txt_password.setText("");
//        showMessage("Không có thông tin nhà cung cấp để hiển thị");
        JOptionPane.showMessageDialog(this, "Không có thông tin tài khoản để hiển thị", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
}
    
    private TaiKhoanDTO getNewTaiKhoan() {
        String name = txt_name.getText();
        int idNhanVien = Integer.parseInt(txt_idNV.getText());
        String password = txt_password.getText();
        String tenquyen = (String) cbb_role.getSelectedItem(); 
        if(txt_name.getText().isEmpty()){
           showMessage("Vui lòng không để trống tên tài khoản");
        }
        else if (txt_password.getText().isEmpty()){
           showMessage("Vui lòng không để trống password");
        }
        else if (txt_idNV.getText().isEmpty()){
           showMessage("Vui lòng không để trống ID nhân viên");
        } else {
             taiKhoanDTO = new TaiKhoanDTO(name,password,tenquyen,idNhanVien);
        }
      
        return taiKhoanDTO;
    }

    private boolean containsSpecialCharacter(String str) {
    // Biểu thức chính quy để kiểm tra ký tự đặc biệt
    String regex = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]";
    
    // Kiểm tra xem chuỗi có chứa ký tự đặc biệt không
    return str.matches(".*" + regex + ".*");
}

    
    private boolean isValidData() {
        String username =  txt_name.getText();
//        int type =Integer.parseInt( txt_type.getText());
        String password = txt_password.getText();
//        int id_nv =Integer.parseInt( txt_idnv.getText());
        // Kiểm tra tên đăng nhập không chưa ký tự đặc biệt
        if (containsSpecialCharacter(username)){
            showMessage("Tên đăng nhập không được chứa ký tự đặc biệt");
                return false;
        }
        
        // Kiểm tra độ dài của mật khẩu
        if (password.length() < 8){
            showMessage("Mật khẩu phải dài hơn 8 ký tự");
            return false;
        }
        // Kiểm tra tên đã tồn tại chưa
         if (isDuplicateTK(username,password)) {
            showMessage("Tài khoản đã tồn tại");
        return false;
        }
        return true;
}
    
    private void SuaTaiKhoan() throws IOException {
        if (!isValidData()) {
        return;
        }
        try {

// Nhận thông tin từ giao diện
        TaiKhoanDTO tkNew = getNewTaiKhoan();
        tkNew.setIdTaiKhoan(id_taikhoan);
        taiKhoanBUS= new TaiKhoanBUS();
        boolean status = taiKhoanBUS.suaTaiKhoan(tkNew);
        if (status) {
            showMessage( "Sửa tài khoản thành công");
            dispose();
        } else {
            showMessage( "Sửa tài khoản thất bại");
          
        }
        } catch (Exception ex) {
            showMessage("Sửa tài khoản thất bại do có textField bị bỏ trống");
        }
        
    }
 
    private boolean isDuplicateTK(String tenTaiKhoan, String matKhau) {
                taiKhoanBUS = new TaiKhoanBUS();
                ArrayList<TaiKhoanDTO> danhSachTaiKhoan = taiKhoanBUS.getAll();
                for (TaiKhoanDTO tk : danhSachTaiKhoan) {
                    if (tk.getTenDangNhap().equalsIgnoreCase(tenTaiKhoan) && tk.getMatKhau().equalsIgnoreCase(matKhau)) {
            return true;
        }
    }
    return false;
}
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
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
        lbl_name = new javax.swing.JLabel();
        txt_idNV = new javax.swing.JTextField();
        lbl_idNV = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lbl_loai = new javax.swing.JLabel();
        cbb_role = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(720, 400));

        pnl_top.setBackground(new java.awt.Color(204, 255, 204));

        lbl_title.setBackground(new java.awt.Color(255, 51, 51));
        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Sửa Tài Khoản");

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_center.setBackground(new java.awt.Color(255, 255, 255));

        lbl_name.setText("Tên đăng nhập");

        txt_idNV.setPreferredSize(new java.awt.Dimension(93, 16));

        lbl_idNV.setText("Id nhân viên");

        lbl_password.setText("Mật khẩu");

        btn_sua.setBackground(new java.awt.Color(51, 153, 255));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 102, 102));
        btn_cancel.setText("Hủy bỏ");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        lbl_loai.setText("Loại tài khoản");

        cbb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không có", "Admin", "Quản lý kho", "Quản lý nhập", "Nhân viên bán hàng" }));
        cbb_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_roleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_centerLayout = new javax.swing.GroupLayout(pnl_center);
        pnl_center.setLayout(pnl_centerLayout);
        pnl_centerLayout.setHorizontalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(txt_name)
                            .addComponent(lbl_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_password))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_centerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idNV, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(txt_idNV, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(lbl_loai, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(cbb_role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        pnl_centerLayout.setVerticalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_role)))
                .addGap(18, 18, 18)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            SuaTaiKhoan();
        } catch (IOException ex) {
            Logger.getLogger(SuaTK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void cbb_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_roleActionPerformed

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
//            java.util.logging.Logger.getLogger(SuaNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SuaNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SuaNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SuaNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SuaTK().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_sua;
    private javax.swing.JComboBox<String> cbb_role;
    private javax.swing.JLabel lbl_idNV;
    private javax.swing.JLabel lbl_loai;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTextField txt_idNV;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
