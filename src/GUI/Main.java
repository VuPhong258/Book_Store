/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Main extends javax.swing.JFrame {
    
    TrangChu trangChu;
    SanPham sanPham;
    TacGia tacGia;
    NhaCungCap nhaCungCap;
    PhieuNhap phieuNhap;
    TaiKhoan taiKhoan;
    HoaDon hoaDon;
    KhachHang khachHang;
    ThongKe thongKe;

    /**
     * Creates new form Main
     */
    private final Color defaultColor = new Color(255, 255, 255);
    private final Color hoverColor = new Color(187, 222, 251);
    Color BackgroundColor = new Color(240, 247, 250);
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        addHoverBtn();
        setTitle("Hệ thống quản lý cửa hàng sách");
//        JScrollPane scrollPane = new JScrollPane(taskBar);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setBorder(null);
//        menuTaskbar.add(scrollPane, java.awt.BorderLayout.CENTER);
           btn_home.setIcon(new FlatSVGIcon("./GUI/icon/home.svg"));
           btn_product.setIcon(new FlatSVGIcon("./GUI/icon/book.svg"));
           btn_tacgia.setIcon(new FlatSVGIcon("./GUI/icon/tacgia.svg"));
           btn_phieunhap.setIcon(new FlatSVGIcon("./GUI/icon/phieunhap.svg"));
           btn_hoadon.setIcon(new FlatSVGIcon("./GUI/icon/bill.svg"));
           btn_nhacungcap.setIcon(new FlatSVGIcon("./GUI/icon/nhacungcap.svg"));
           btn_taikhoan.setIcon(new FlatSVGIcon("./GUI/icon/taikhoan.svg"));
           btn_khachhang.setIcon(new FlatSVGIcon("./GUI/icon/customer.svg"));
           btn_thongke.setIcon(new FlatSVGIcon("./GUI/icon/thongke.svg"));
           btn_dangxuat.setIcon(new FlatSVGIcon("./GUI/icon/dangxuat.svg"));
           
//           lbl_chucvu.setText(String.valueOf(taiKhoanDTO.getTenQuyen()));
//           if(String.valueOf(taiKhoanDTO.getTenQuyen()).equalsIgnoreCase("Không có")) {
//               lbl_chucvu.setText("Khách hàng");
//           }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuTaskbar = new javax.swing.JPanel();
        info = new javax.swing.JPanel();
        lbl_tenNV = new javax.swing.JLabel();
        lbl_chucvu = new javax.swing.JLabel();
        taskBar = new javax.swing.JPanel();
        btn_home = new javax.swing.JToggleButton();
        btn_tacgia = new javax.swing.JToggleButton();
        btn_product = new javax.swing.JToggleButton();
        btn_phieunhap = new javax.swing.JToggleButton();
        btn_hoadon = new javax.swing.JToggleButton();
        btn_nhacungcap = new javax.swing.JToggleButton();
        btn_taikhoan = new javax.swing.JToggleButton();
        btn_khachhang = new javax.swing.JToggleButton();
        btn_thongke = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        btn_dangxuat = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mainContent.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/java.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Lập trình Java");

        javax.swing.GroupLayout mainContentLayout = new javax.swing.GroupLayout(mainContent);
        mainContent.setLayout(mainContentLayout);
        mainContentLayout.setHorizontalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContentLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        mainContentLayout.setVerticalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContentLayout.createSequentialGroup()
                .addGroup(mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainContentLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainContentLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(394, Short.MAX_VALUE))
        );

        menuTaskbar.setBackground(new java.awt.Color(255, 255, 255));

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setPreferredSize(new java.awt.Dimension(180, 457));

        lbl_tenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tenNV.setText("Trần Nguyễn Vũ Phong");
        lbl_tenNV.setToolTipText("");

        lbl_chucvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_chucvu.setText("Quản lý kho");

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_tenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_chucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        taskBar.setBackground(new java.awt.Color(255, 255, 255));

        btn_home.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_home);
        btn_home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_home.setText("Trang chủ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_tacgia.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_tacgia);
        btn_tacgia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tacgia.setText("Tác giả");
        btn_tacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tacgiaActionPerformed(evt);
            }
        });

        btn_product.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_product);
        btn_product.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_product.setText("Sản phẩm");
        btn_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productActionPerformed(evt);
            }
        });

        btn_phieunhap.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_phieunhap);
        btn_phieunhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_phieunhap.setText("Phiếu nhập");
        btn_phieunhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_phieunhapActionPerformed(evt);
            }
        });

        btn_hoadon.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_hoadon);
        btn_hoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hoadon.setText("Hóa đơn");
        btn_hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoadonActionPerformed(evt);
            }
        });

        btn_nhacungcap.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_nhacungcap);
        btn_nhacungcap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_nhacungcap.setText("Nhà cung cấp");
        btn_nhacungcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhacungcapActionPerformed(evt);
            }
        });

        btn_taikhoan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_taikhoan);
        btn_taikhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taikhoan.setText("Tài khoản");
        btn_taikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taikhoanActionPerformed(evt);
            }
        });

        btn_khachhang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_khachhang);
        btn_khachhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_khachhang.setText("Khách hàng");
        btn_khachhang.setBorderPainted(false);
        btn_khachhang.setOpaque(true);
        btn_khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khachhangActionPerformed(evt);
            }
        });

        btn_thongke.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_thongke);
        btn_thongke.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thongke.setText("Thống kê");
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskBarLayout = new javax.swing.GroupLayout(taskBar);
        taskBar.setLayout(taskBarLayout);
        taskBarLayout.setHorizontalGroup(
            taskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tacgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_product, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_phieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btn_taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khachhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        taskBarLayout.setVerticalGroup(
            taskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskBarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout menuTaskbarLayout = new javax.swing.GroupLayout(menuTaskbar);
        menuTaskbar.setLayout(menuTaskbarLayout);
        menuTaskbarLayout.setHorizontalGroup(
            menuTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(taskBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuTaskbarLayout.setVerticalGroup(
            menuTaskbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaskbarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_dangxuat.setBackground(new java.awt.Color(255, 255, 255));
        btn_dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_dangxuat.setText("Đăng xuất");
        btn_dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuTaskbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuTaskbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        trangChu = new TrangChu();
        addTaskBar(mainContent, trangChu);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productActionPerformed
       sanPham = new SanPham();
       addTaskBar(mainContent, sanPham);
    }//GEN-LAST:event_btn_productActionPerformed

    private void btn_tacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tacgiaActionPerformed
         tacGia = new TacGia();
        addTaskBar(mainContent, tacGia);
    }//GEN-LAST:event_btn_tacgiaActionPerformed

    private void btn_phieunhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_phieunhapActionPerformed
        phieuNhap =  new PhieuNhap();
        addTaskBar(mainContent, phieuNhap);
    }//GEN-LAST:event_btn_phieunhapActionPerformed

    private void btn_hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoadonActionPerformed
         hoaDon = new HoaDon();
       addTaskBar(mainContent, hoaDon);
    }//GEN-LAST:event_btn_hoadonActionPerformed

    private void btn_nhacungcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhacungcapActionPerformed
         nhaCungCap = new NhaCungCap();
         addTaskBar(mainContent, nhaCungCap);
    }//GEN-LAST:event_btn_nhacungcapActionPerformed

    private void btn_taikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taikhoanActionPerformed
         taiKhoan = new TaiKhoan();
       addTaskBar(mainContent, taiKhoan);
    }//GEN-LAST:event_btn_taikhoanActionPerformed

    private void btn_dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangxuatActionPerformed
        Login login = new Login();
        login.setVisible(true);
         dispose();
    }//GEN-LAST:event_btn_dangxuatActionPerformed

    private void btn_khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khachhangActionPerformed
        khachHang = new KhachHang();
        addTaskBar(mainContent, khachHang);
    }//GEN-LAST:event_btn_khachhangActionPerformed

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        thongKe = new ThongKe();
        addTaskBar(mainContent, thongKe);
    }//GEN-LAST:event_btn_thongkeActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void addHoverEffect(JToggleButton button) {

        button.setBorderPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                button.setBackground(hoverColor); // Khi di chuột vào, đổi màu nền 

            }

            @Override
            public void mouseExited(MouseEvent e) {

                button.setBackground(defaultColor); // Khi di chuột ra khỏi, đổi lại màu nền mặc định

            }
        });
    }
    // hàm taskbar
    public void addTaskBar(Container mainContent, JPanel panel) {
        mainContent.setLayout(new BorderLayout());
        panel.setSize(mainContent.getSize());
        mainContent.removeAll();
        mainContent.add(panel, BorderLayout.CENTER);
        mainContent.setVisible(true);
        mainContent.revalidate();
        mainContent.repaint();
    }

    private void addHoverEffect(JButton button) {
        button.setBorderPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor); // Khi di chuột vào, đổi màu nền 

            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor); // Khi di chuột ra khỏi, đổi lại màu nền mặc định
            }
        });
    }
    private void addHoverBtn() {
        addHoverEffect(btn_home);
        addHoverEffect(btn_product);
        addHoverEffect(btn_tacgia);
        addHoverEffect(btn_phieunhap);
        addHoverEffect(btn_hoadon);
        addHoverEffect(btn_nhacungcap);
        addHoverEffect(btn_taikhoan);
        addHoverEffect(btn_khachhang);
        addHoverEffect(btn_thongke);
        addHoverEffect(btn_dangxuat);
        // Thêm hiệu ứng hover cho từng button
    }
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
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Main().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_dangxuat;
    private javax.swing.JToggleButton btn_hoadon;
    private javax.swing.JToggleButton btn_home;
    private javax.swing.JToggleButton btn_khachhang;
    private javax.swing.JToggleButton btn_nhacungcap;
    private javax.swing.JToggleButton btn_phieunhap;
    private javax.swing.JToggleButton btn_product;
    private javax.swing.JToggleButton btn_tacgia;
    private javax.swing.JToggleButton btn_taikhoan;
    private javax.swing.JToggleButton btn_thongke;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_chucvu;
    private javax.swing.JLabel lbl_tenNV;
    private javax.swing.JPanel mainContent;
    private javax.swing.JPanel menuTaskbar;
    private javax.swing.JPanel taskBar;
    // End of variables declaration//GEN-END:variables
}
