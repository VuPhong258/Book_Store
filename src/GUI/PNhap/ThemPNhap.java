/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI.PNhap;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DAO.PhieuNhapDAO;
import DAO.SanPhamDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
/**
 *
 * @author Acer
 */
public class ThemPNhap extends javax.swing.JFrame {
    private final int id_phieunhap = new PhieuNhapBUS().getAll().size() + 1;
    public final SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<ChiTietPhieuNhapDTO> listCTPN = new ArrayList<>();
    private ArrayList<SanPhamDTO> listSanPham = spBUS.getAll();
    PhieuNhapDTO phieuNhapDTO;
    PhieuNhapDAO phieuNhapDAO;
    PhieuNhapBUS phieuNhapBUS;
    SanPhamBUS sanPhamBUS;
    SanPhamDAO sanPhamDAO;
    private TaiKhoanDTO nhanVien;
    DefaultTableModel tblModel;
    
    public ThemPNhap(TaiKhoanDTO nhanVien) {
        this.nhanVien = nhanVien;      
        initComponents();
        setLocationRelativeTo(null);
        hienThiListSanPham(listSanPham);
        lbl_idnv.setText(String.valueOf(this.nhanVien.getIdNhanVien()));
        LocalDateTime ngayTao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lbl_ngaynhap.setText(ngayTao.format(formatter));   
        loadNCCToComboBox();    
    }
        

  private PhieuNhapDTO getNewPN() {
    updateTongTien();
    if (this.nhanVien == null) {
        showMessage("Nhan vien is not set");
        return null;
    }
    String ngaynhap = lbl_ngaynhap.getText();
    String tenncc = (jComboBox_tenncc.getSelectedItem().toString());
    int id_nhanvien = Integer.parseInt(lbl_idnv.getText());
    String tongtien = lbl_tongtien.getText();
    int trangthai = 1;
    phieuNhapDTO = new PhieuNhapDTO(id_phieunhap,ngaynhap, tenncc, id_nhanvien, tongtien, trangthai);
    return phieuNhapDTO;
}
  private ArrayList<ChiTietPhieuNhapDTO> getNewCTPN(int idPhieuNhap) {
    updateTongTien();
    DefaultTableModel model = (DefaultTableModel) tbl_sanpham1.getModel();
    ArrayList<ChiTietPhieuNhapDTO> ctpnList = new ArrayList<>();

    for (int row = 0; row < model.getRowCount(); row++) {
        Object idSachObj = model.getValueAt(row, 1);
        Object tenSachObj = model.getValueAt(row, 2);
        Object giaNhapObj = model.getValueAt(row, 3);
        Object soLuongNhapObj = model.getValueAt(row, 4);

        if (idSachObj != null && tenSachObj != null && giaNhapObj != null && soLuongNhapObj != null) {
            try {
                int idSach = (int) idSachObj;
                String tenSach = (String) tenSachObj;
                String giaNhap = giaNhapObj.toString();
                int soLuongNhap = (int) soLuongNhapObj;

                ChiTietPhieuNhapDTO ctpnDTO = new ChiTietPhieuNhapDTO(idPhieuNhap, idSach, tenSach, giaNhap, soLuongNhap);
                ctpnList.add(ctpnDTO);
            } catch (ClassCastException e) {
                System.err.println("Lỗi chuyển đổi kiểu dữ liệu tại hàng " + row);
            }
        }
    }

    return ctpnList;
}
  private void loadNCCToComboBox() {
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    ArrayList<NhaCungCapDTO> listNCC = nccBUS.getAllNCC();
    jComboBox_tenncc.removeAllItems(); 
    for (NhaCungCapDTO ncc : listNCC) {
        jComboBox_tenncc.addItem(ncc.getTenNcc()); 
    }
}
  private boolean isValidData() {
    return true;
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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tbl_sanpham.getColumnCount(); i++) {
            tbl_sanpham.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }  
  private void updateTongTien() {
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham1.getModel();
        int rowCount = model.getRowCount();
        int tongTien = 0;
        for (int i = 0; i < rowCount; i++) {
            int donGia = Integer.parseInt(model.getValueAt(i, 3).toString());
            tongTien += donGia;
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("vi", "VN"));
        DecimalFormat formatter = new DecimalFormat("###,###,###.##", symbols);
        String formattedTongTien = formatter.format(tongTien);

        lbl_tongtien.setText(formattedTongTien + "VNĐ");
        
    }
    private void themPhieuNhap() {
    try {
        PhieuNhapDTO pnNew = getNewPN(); 
        updateTongTien();
        if (!isValidData()) {
            return; 
        }
        phieuNhapBUS = new PhieuNhapBUS(); 
        boolean status = phieuNhapBUS.addPhieuNhap(pnNew); 
        if (status) {
                int idPhieuNhap = pnNew.getIdPhieuNhap(); 
                ArrayList<ChiTietPhieuNhapDTO> ctpnList = getNewCTPN(idPhieuNhap); 
                boolean ctpnStatus = phieuNhapBUS.addChiTietPhieuNhap(ctpnList); 
                if (ctpnStatus) {
                    showMessage("Thêm phiếu nhập và chi tiết phiếu nhập thành công");
                } else {
                    showMessage("Lỗi khi thêm chi tiết phiếu nhập");
                }
            } else {
                showMessage("Thêm phiếu nhập thất bại");
            }
    
    } catch (Exception ex) {
        showMessage("Lỗi khi thêm phiếu nhập: " + ex.getMessage());
    }
}

    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_top = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        pnl_center = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        lbl_name1 = new javax.swing.JLabel();
        txt_id_phieunhap1 = new javax.swing.JTextField();
        lbl_name2 = new javax.swing.JLabel();
        txt_id_phieunhap2 = new javax.swing.JTextField();
        txt_id_phieunhap3 = new javax.swing.JTextField();
        lbl_name3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_year = new javax.swing.JLabel();
        lbl_phone = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        lbl_phone1 = new javax.swing.JLabel();
        jComboBox_tenncc = new javax.swing.JComboBox<>();
        btn_add1 = new javax.swing.JButton();
        lbl_ngaynhap = new javax.swing.JLabel();
        lbl_idnv = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanpham1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1125, 800));
        setResizable(false);

        pnl_top.setBackground(new java.awt.Color(204, 255, 204));

        lbl_title.setBackground(new java.awt.Color(255, 51, 51));
        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Thêm Phiếu Nhập");

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_center.setBackground(new java.awt.Color(255, 255, 255));

        btn_add.setBackground(new java.awt.Color(51, 153, 255));
        btn_add.setText("Thêm sản phẩm");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 102, 102));
        btn_delete.setText("Xóa sản phẩm");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

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
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sanpham);

        lbl_name1.setText("Tên sản phẩm");

        lbl_name2.setText("Mã sản phẩm");

        lbl_name3.setText("Số lượng ");

        javax.swing.GroupLayout pnl_centerLayout = new javax.swing.GroupLayout(pnl_center);
        pnl_center.setLayout(pnl_centerLayout);
        pnl_centerLayout.setHorizontalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_id_phieunhap1)
                        .addComponent(lbl_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_id_phieunhap2)
                        .addComponent(lbl_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_id_phieunhap3)
                        .addComponent(lbl_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnl_centerLayout.setVerticalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_centerLayout.createSequentialGroup()
                        .addComponent(lbl_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_phieunhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_phieunhap2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(lbl_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_phieunhap3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        lbl_year.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_year.setText("Ngày nhập");

        lbl_phone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_phone.setText("Tên NCC");

        lbl_address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_address.setText("Mã Nhân Viên");

        lbl_tongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbl_phone1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_phone1.setText("Tổng tiền:");

        jComboBox_tenncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tennccActionPerformed(evt);
            }
        });

        btn_add1.setBackground(new java.awt.Color(51, 153, 255));
        btn_add1.setText("Nhập phiếu");
        btn_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add1MouseClicked(evt);
            }
        });
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        lbl_ngaynhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_idnv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_exit.setBackground(new java.awt.Color(255, 102, 102));
        btn_exit.setText("Thoát");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(lbl_phone1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_address, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox_tenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lbl_idnv, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbl_year, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbl_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_tenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_address, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_idnv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        tbl_sanpham1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        tbl_sanpham1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jScrollPane3.setViewportView(tbl_sanpham1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_top, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(651, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        themPhieuNhap();
        this.dispose();
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked

    int selectedRow = tbl_sanpham.getSelectedRow();
    if (selectedRow != -1) {
        String maSanPham = tbl_sanpham.getValueAt(selectedRow, 0).toString();
        String tenSanPham = tbl_sanpham.getValueAt(selectedRow, 1).toString();
        txt_id_phieunhap2.setText(maSanPham);
        txt_id_phieunhap1.setText(tenSanPham);       
    }
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        int maSanPham = Integer.parseInt(txt_id_phieunhap2.getText());
    String tenSanPham = txt_id_phieunhap1.getText();
    int soLuong = Integer.parseInt(txt_id_phieunhap3.getText());
    if (tenSanPham.isEmpty()) {
        showMessage("Vui lòng nhập đầy đủ thông tin.");
        return;
    }
    String giaBanStr = tbl_sanpham.getValueAt(tbl_sanpham.getSelectedRow(), 3).toString();
    String chiSoGia = giaBanStr.replaceAll("[^0-9]", "");
    int giaBan = Integer.parseInt(chiSoGia);
    int donGia = giaBan * soLuong;
    DefaultTableModel model = (DefaultTableModel) tbl_sanpham1.getModel();
    Object[] row = {
        model.getRowCount() + 1, 
        maSanPham,
        tenSanPham,
        Integer.toString(donGia), // Chuyển đơn giá sang kiểu String
        soLuong,
    };
    model.addRow(row);
    updateTongTien();
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        int selectedRow = tbl_sanpham1.getSelectedRow();
    
    // Kiểm tra xem có hàng nào được chọn không
    if (selectedRow != -1) {
        // Xóa dòng được chọn từ bảng
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham1.getModel();
        model.removeRow(selectedRow);
        
        // Cập nhật lại giá trị của cột STT
        for (int i = selectedRow; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Giảm giá trị của cột STT đi 1
        }
    } else {
        // Nếu không có hàng nào được chọn, hiển thị thông báo
        showMessage("Vui lòng chọn dòng để xóa.");
    }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
    
        
    }//GEN-LAST:event_btn_add1MouseClicked

    private void jComboBox_tennccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tennccActionPerformed
    
    }//GEN-LAST:event_jComboBox_tennccActionPerformed

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
//            java.util.logging.Logger.getLogger(ThemNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemNcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThemTK().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JComboBox<String> jComboBox_tenncc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_idnv;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JLabel lbl_name3;
    private javax.swing.JLabel lbl_ngaynhap;
    private javax.swing.JLabel lbl_phone;
    private javax.swing.JLabel lbl_phone1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_tongtien;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTable tbl_sanpham1;
    private javax.swing.JTextField txt_id_phieunhap1;
    private javax.swing.JTextField txt_id_phieunhap2;
    private javax.swing.JTextField txt_id_phieunhap3;
    // End of variables declaration//GEN-END:variables

    
}
