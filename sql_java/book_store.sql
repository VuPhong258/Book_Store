-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 01:36 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_chitiethoadon`
--

CREATE TABLE `tbl_chitiethoadon` (
  `id_sach` int(11) NOT NULL,
  `soluongmua` int(11) NOT NULL,
  `id_hoadon` int(20) NOT NULL,
  `giaban` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_chitietphieunhap`
--

CREATE TABLE `tbl_chitietphieunhap` (
  `id_phieu_nhap` int(10) NOT NULL,
  `id_sach` int(11) NOT NULL,
  `soluongnhap` int(11) NOT NULL,
  `gianhap` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hoadon`
--

CREATE TABLE `tbl_hoadon` (
  `id_hoadon` int(10) NOT NULL,
  `id_khachhang` int(11) NOT NULL,
  `id_nhanvien` int(11) NOT NULL,
  `ngaylaphoadon` varchar(50) NOT NULL,
  `tongtien` varchar(50) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_khachhang`
--

CREATE TABLE `tbl_khachhang` (
  `id_khachhang` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `ngaysinh` varchar(20) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sodienthoai` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_khachhang`
--

INSERT INTO `tbl_khachhang` (`id_khachhang`, `hoten`, `ngaysinh`, `diachi`, `sodienthoai`, `email`, `trangthai`) VALUES
(1, 'Trần Nguyễn Vũ Phong', '25-08-2004', 'Hóc Môn, TPHCM', '0367897023', 'phong@gmail.com', 1),
(2, 'Bùi Hữu Quang', '05-09-2003', 'Bà  Rịa - Vũng Tàu', '0983234242', 'quang@gmail.com', 1),
(3, 'Nguyễn Văn B\r\n', '21-09-2004', 'Quận Tân Bình, TPHCM', '0986162519', 'b@gmail.com', 1),
(4, 'Trần Chí Bảo', '07-07-2000', 'Quận 7', '0943224233', 'bao@gmail.com', 1),
(5, 'Nguyễn Hoàng Mai', '08-02-1995', 'Quận Tân Phú', '0354452012', 'mai@gmail.com', 1),
(6, 'Nguyễn Linh Phương', '23-10-1984', 'Quận 3', '0542395833', 'phuong@gmail.com', 1),
(7, 'Lê Ái Khanh', '12-11-2006', 'Thủ Đức', '0323045439', 'khanh@gmail.com', 1),
(8, 'Lê Phương Thảo', '01-05-2002', 'Quận 12', '0942143656', 'thao@gmail.com', 1),
(9, 'Ngô Ðức Khiêm', '15-07-1998', 'Quận 11', '0843365005', 'khiem@gmail.com', 1),
(10, 'Đặng Quốc Hưng', '17-04-1991', 'Quận 5', '0943076575', 'hung@gmail.com', 1),
(11, 'Bùi Ðức Tuệ', '04-09-1997', 'Quận 1', '0832343505', 'tue@gmail.com', 1),
(12, 'Bùi Thảo Quyên', '09-08-2001', 'Tây Ninh', '0359541033', 'quyen@gmail.com', 1),
(13, 'Phạm Ngọc Dung', '30-04-1996', 'Đồng Nai', '0934234123', 'dung@gmail.com', 1),
(14, 'Phạm Hải Vân', '05-10-2004', 'An Giang', '0732423450', 'van@gmail.com', 1),
(15, 'Đỗ Trung Hiếu', '13-06-2005', 'Gia Lai', '0845340941', 'hieu@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ncc`
--

CREATE TABLE `tbl_ncc` (
  `id_ncc` int(10) NOT NULL,
  `tenncc` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1,
  `sodienthoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_ncc`
--

INSERT INTO `tbl_ncc` (`id_ncc`, `tenncc`, `diachi`, `trangthai`, `sodienthoai`) VALUES
(1, 'Công Ty Cổ Phần Phát Hành Sách Tp. HCM', '60-62 Lê Lợi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh', 1, '02838225798'),
(2, 'Công Ty Cổ Phần Sách & Thiết Bị Giáo Dục Trí Tuệ', '187 Giảng Võ, Q. Đống Đa, Hà Nội', 1, '02438515567'),
(3, 'Công Ty TNHH Văn Hóa Việt Long', '14/35, Đào Duy Anh, P.9, Q. Phú Nhuận, Tp. Hồ Chí Minh', 1, '02838452708'),
(4, 'Công Ty TNHH Đăng Nguyên', 'Thôn Đức Mỹ, X. Suối Nghệ, H. Châu Đức, Bà Rịa-Vũng Tàu', 1, '02543716857'),
(5, 'Nhà Sách Trực Tuyến BOOKBUY.VN', '147 Pasteur, P. 6, Q. 3, Tp. Hồ Chí Minh', 1, '02838207153'),
(6, 'Công ty TNHH Một Thành viên Thương mại & Dịch vụ Văn hóa Minh Long', '33 Đỗ Thừa Tự, Tân Quý, Tân Phú, Thành phố Hồ Chí Minh, Việt Nam', 1, '02866751142'),
(7, ' Công Ty TNHH Sản Xuất Kinh Doanh Thiết Bị Giáo Dục Thành Kiên', '55/5 Bình Quới, P. 28, Q. Bình Thạnh, Tp. Hồ Chí Minh (TPHCM)', 1, '02835561920'),
(8, 'Hiệu Sách Tiến Thành', 'Số 11-13 Đường 53, P. 10, Q. 6, Tp. Hồ Chí Minh (TPHCM)', 1, '0919196677'),
(9, 'Nobita.Vn - Nhà Sách Trên Mạng', '74/7 Nguyễn Cừ, Thảo Điền, Q. 2, Tp. Hồ Chí Minh (TPHCM)', 1, '0974941097'),
(10, 'Nhà Sách Đất Việt', '23-25 Hoàng Hoa Thám, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh (TPHCM)', 1, '02862972356'),
(11, 'Công Ty Cổ Phần Văn Hóa Nhân Văn', '1 Trường Chinh, P. 1, Q. Tân Bình, Tp. Hồ Chí Minh (TPHCM)', 1, '02836007777');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_phieunhap`
--

CREATE TABLE `tbl_phieunhap` (
  `id_phieunhap` int(10) NOT NULL,
  `id_ncc` int(11) NOT NULL,
  `id_nhanvien` int(11) NOT NULL,
  `ngaynhap` varchar(20) NOT NULL,
  `tongtien` varchar(50) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sach`
--

CREATE TABLE `tbl_sach` (
  `id_sach` int(10) NOT NULL,
  `tensach` varchar(255) NOT NULL,
  `tentacgia` varchar(100) NOT NULL,
  `dongia` varchar(255) NOT NULL,
  `soluong` int(20) NOT NULL,
  `loaisach` varchar(50) NOT NULL,
  `hinhanh` varchar(50) NOT NULL,
  `trangthai` int(3) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_sach`
--

INSERT INTO `tbl_sach` (`id_sach`, `tensach`, `tentacgia`, `dongia`, `soluong`, `loaisach`, `hinhanh`, `trangthai`) VALUES
(1, 'Tạp văn Nguyễn Ngọc Tư', 'Nguyễn Ngọc Tư', '90.000VNĐ', 2, 'Truyện ngắn- tản văn', 'tapvannguyenngoctu', 1),
(2, 'Mùa hè không tên', 'Nguyễn Nhật Ánh', '130.000VNĐ', 3, 'Tiểu thuyết', 'muahekhongten', 1),
(3, 'Nhật ký trong tù', 'Hồ Chí Minh', '79.000VNĐ', 1, 'Thơ', 'nhatkytrongtu', 1),
(4, '5 đường mòn Hồ Chí Minh', 'Đặng Phong', '190.000VNĐ', 2, 'Lịch sử - Địa  lý', '5duongmonhochiminh', 1),
(5, 'Ám thị tâm lý', 'Patrick King', '149.000VNĐ', 5, 'Tâm lý giáo dục', 'amthitamly', 1),
(6, 'Bạn đắt giá bao nhiêu?', 'Vân tình', '119.000VNĐ', 4, 'Kỹ năng sống', 'bandatgiabaonhieu', 1),
(7, 'Bông sen Vàng', 'Sơn Tùng', '160.000VNĐ', 5, 'Tiểu thuyết', 'bongsenvang', 1),
(8, 'Cà phê cùng Tony', 'Tony buổi sáng', '105.000VNĐ', 5, 'Kỹ năng sống', 'caphecungtony', 1),
(9, 'Cậu bé Bạc', 'Kristina Ohlsson', '42.000VNĐ', 5, 'Truyện thiếu nhi', 'caubebac', 1),
(10, 'Đắc nhân tâm', 'Dale Carnegie', '86.000VNĐ', 5, 'Tâm lý - Kỹ năng sống', 'dacnhantam', 1),
(11, 'Đảo ngàn sao', 'Emma Karinsdotter', '60.000VNĐ', 5, 'Tiểu thuyết', 'daongansao', 1),
(12, 'Dấu ấn Việt Nam trên Biển Đông', 'TS.Trần Công Trục', '200.000VNĐ', 5, 'Kiến thức bách khoa', 'dauanvietnamtrenbiendong', 1),
(13, 'Dế mèn phiêu lưu ký', 'Tô Hoài', '150.000VNĐ', 5, 'Truyện thiếu nhi', 'demenphieuluuky', 1),
(14, 'Đời ngắn đừng ngủ dài', 'Robin Sharma', '75.000VNĐ', 5, 'Kỹ năng sống', 'doingandungngudai', 1),
(15, 'Đời thay đổi khi chúng ta thay đổi', 'Andrew Matthews', '75.000VNĐ', 5, 'Kỹ năng sống', 'doithaydoikhichungtathaydoi', 1),
(16, 'Đồng tiền hạnh phúc', 'Ken Honda', '95.000VNĐ', 5, 'Kỹ năng sống ', 'dongtienhanhphuc', 1),
(17, 'Hãy gọi tên tôi', 'Chanel Miller', '169.000VNĐ', 5, 'Hồi ký', 'haygoitentoi', 1),
(18, 'Khu rừng trong phố', 'Nguyễn Quỳnh Mai', '56.000VNĐ', 5, 'Truyện thiếu nhi', 'khurungtrongpho', 1),
(19, 'Làm bạn với bầu trời', 'Nguyễn Nhật Ánh', '110.000VNĐ', 5, 'Tiểu thuyết', 'lambanvoibautroi', 1),
(20, 'Lũ trẻ đường ray', 'Edith Nesbit', '90.000VNĐ', 5, 'Tiểu thuyết', 'lutreduongray', 1),
(21, 'Lũ trẻ thủy tinh', 'Kristina Ohlsson', '40.000VNĐ', 5, 'Truyện thiếu nhi', 'lutrethuytinh', 1),
(22, 'Mặc Kệ Thiên Hạ - Sống Như Người Nhật', 'Mari Tamagawa', '79.000VNĐ', 5, 'Kỹ năng sống', 'mackethienhasongnhunguoinhat', 1),
(23, 'Mỗi Lần Vấp Ngã Là Một Lần Trưởng Thành', 'Liêu Trí Phong', '120.000VNĐ', 5, 'Kỹ năng sống', 'moilanvapngalamotlantruongthanh', 1),
(24, 'Mùa Hè Không Tên', 'Nguyễn Nhật Ánh', '130.000VNĐ', 5, 'Tiểu thuyết', 'muahekhongten', 1),
(25, 'Nhà Giả Kim', 'Paulo Coelho', '69.000VNĐ', 5, 'Tiểu thuyết', 'nhagiakim', 1),
(26, 'Nhật Ký Trong Tù', 'Hồ Chí Minh', '80.000VNĐ', 5, 'Thơ', 'nhatkytrongtu', 1),
(27, 'Người Bán Hàng Vĩ Đại Nhất Thế Giới', 'Og Mandino', '148.000VNĐ', 5, 'Marketing - Bán hàng', 'nguoibanhangvidainhatthegioi', 1),
(28, ' Phận Liễu', 'Chu Thanh Hương', '190.000VNĐ', 5, 'Tiểu thuyết', 'phanlieu', 1),
(29, 'Sự Im Lặng Của Bầy Cừu', 'Thomas Harris', '115.000VNĐ', 5, 'Truyện Trinh Thám - Kiếm hiệp', 'suimlangcuabaycuu', 1),
(30, 'Tạp Văn Nguyễn Ngọc Tư', 'Nguyễn Ngọc Tư', '90.000VNĐ', 5, 'Truyện ngắn - tản văn', 'tapvannguyenngoctu', 1),
(31, 'Tội Ác Sau Những Bức Tranh', 'Jason Rekulak', '209.000VNĐ', 5, 'Tiểu thuyết', 'toiacsaunhungbuctranh', 1),
(32, 'Tớ Sợ Cái Đồng Hồ', 'Nguyễn Quỳnh Mai', '52.000VNĐ', 5, 'Truyện thiếu nhi', 'tosocaidongho', 1),
(33, 'Tư Duy Ngược ', 'Nguyễn Anh Dũng', '139.000VNĐ', 5, 'Kỹ năng sống', 'tuduynguoc', 1),
(34, 'You Can - Không Gì Là Không Thể', 'George Matthew Adams', '56.000VNĐ', 5, 'Kỹ năng sống', 'youcan', 1),
(35, 'fdsfa', 'Vũ Phong', '200.000VNĐ', 1, 'Nhật ký', 'phong', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tacgia`
--

CREATE TABLE `tbl_tacgia` (
  `tentacgia` varchar(100) NOT NULL,
  `namsinh` varchar(20) NOT NULL,
  `trangthai` int(10) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_tacgia`
--

INSERT INTO `tbl_tacgia` (`tentacgia`, `namsinh`, `trangthai`) VALUES
('Andrew Matthews', '1957', 1),
('Chanel Miller', '1992', 1),
('Chu Thanh Hương', '1986', 1),
('Dale Carnegie', '1888-1955', 1),
('Edith Nesbit', '1858-1924', 1),
('Emma Karinsdotter', '1985', 1),
('George Matthew Adams', '1878-1962', 1),
('Hà Văn Tấn', '1937-2019', 1),
('Hồ Chí Minh', '1890-1969', 1),
('Jason Rekulak', '1987', 1),
('Ken Honda', '1965', 1),
('Kristina Ohlsson', '1979', 1),
('Liêu Trí Phong', 'Chưa rõ', 1),
('Mari Tamagawa', 'Chưa rõ', 1),
('Nguyễn Anh Dũng', '1986', 1),
('Nguyễn Ngọc Tư ', '1976', 1),
('Nguyễn Nhật Ánh', '1955', 1),
('Nguyễn Quỳnh Mai', 'Chưa rõ', 1),
('Og Mandino', '1923-1996', 1),
('Patrick King', 'Chưa rõ', 1),
('Paulo Coelho', '1947', 1),
('Phong', '2004', 0),
('Robin Sharma', '1964', 1),
('Sơn Tùng', '1928-2021', 1),
('Thomas Harris', '1940', 1),
('Tô Hoài', '1920-2014', 1),
('Tony buổi sáng', 'Chưa rõ', 1),
('TS. Trần Công Trục', '1943', 1),
('Vân Tình', 'Chưa rõ', 1),
('Đặng Phong', '1937-2010', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_taikhoan`
--

CREATE TABLE `tbl_taikhoan` (
  `id_tai_khoan` int(11) NOT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `loaitaikhoan` varchar(255) NOT NULL,
  `id_nhanvien` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_taikhoan`
--

INSERT INTO `tbl_taikhoan` (`id_tai_khoan`, `tendangnhap`, `matkhau`, `loaitaikhoan`, `id_nhanvien`, `trangthai`) VALUES
(1, 'phong4', 'phong258', '5', 4234234, 1),
(2, 'phong8', 'phong219', '3', 342342, 1),
(3, 'phong3', '123', '2', 23432423, 0),
(4, 'phong4', 'phong123', '1', 85443, 0),
(5, 'phong', '12345678', '9', 9423431, 1),
(6, 'phong8', 'phong2582', '8', 43432423, 1),
(7, 'quang', '12345678', '2', 2312231, 1),
(8, 'an', 'an123456', '4', 5432452, 1),
(9, 'truong', 'truong123', '2', 3432423, 1),
(10, 'thanh', 'thanh123', '4', 53453434, 1),
(11, 'khoa', 'khoa1234', '1', 7878677, 1),
(12, 'hien', 'hien1234', '2', 4431134, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_chitiethoadon`
--
ALTER TABLE `tbl_chitiethoadon`
  ADD PRIMARY KEY (`id_hoadon`),
  ADD KEY `id_sach` (`id_sach`);

--
-- Indexes for table `tbl_chitietphieunhap`
--
ALTER TABLE `tbl_chitietphieunhap`
  ADD PRIMARY KEY (`id_phieu_nhap`),
  ADD KEY `id_sach` (`id_sach`);

--
-- Indexes for table `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD PRIMARY KEY (`id_hoadon`),
  ADD KEY `id_khachhang` (`id_khachhang`);

--
-- Indexes for table `tbl_khachhang`
--
ALTER TABLE `tbl_khachhang`
  ADD PRIMARY KEY (`id_khachhang`);

--
-- Indexes for table `tbl_ncc`
--
ALTER TABLE `tbl_ncc`
  ADD PRIMARY KEY (`id_ncc`);

--
-- Indexes for table `tbl_phieunhap`
--
ALTER TABLE `tbl_phieunhap`
  ADD PRIMARY KEY (`id_phieunhap`),
  ADD KEY `id_ncc` (`id_ncc`);

--
-- Indexes for table `tbl_sach`
--
ALTER TABLE `tbl_sach`
  ADD PRIMARY KEY (`id_sach`);

--
-- Indexes for table `tbl_tacgia`
--
ALTER TABLE `tbl_tacgia`
  ADD PRIMARY KEY (`tentacgia`);

--
-- Indexes for table `tbl_taikhoan`
--
ALTER TABLE `tbl_taikhoan`
  ADD PRIMARY KEY (`id_tai_khoan`,`id_nhanvien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_chitiethoadon`
--
ALTER TABLE `tbl_chitiethoadon`
  MODIFY `id_hoadon` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_chitietphieunhap`
--
ALTER TABLE `tbl_chitietphieunhap`
  MODIFY `id_phieu_nhap` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  MODIFY `id_hoadon` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_khachhang`
--
ALTER TABLE `tbl_khachhang`
  MODIFY `id_khachhang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_ncc`
--
ALTER TABLE `tbl_ncc`
  MODIFY `id_ncc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_phieunhap`
--
ALTER TABLE `tbl_phieunhap`
  MODIFY `id_phieunhap` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_sach`
--
ALTER TABLE `tbl_sach`
  MODIFY `id_sach` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `tbl_taikhoan`
--
ALTER TABLE `tbl_taikhoan`
  MODIFY `id_tai_khoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_chitiethoadon`
--
ALTER TABLE `tbl_chitiethoadon`
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_1` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`),
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_2` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`),
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_3` FOREIGN KEY (`id_hoadon`) REFERENCES `tbl_hoadon` (`id_hoadon`),
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_4` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`),
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_5` FOREIGN KEY (`id_hoadon`) REFERENCES `tbl_hoadon` (`id_hoadon`);

--
-- Constraints for table `tbl_chitietphieunhap`
--
ALTER TABLE `tbl_chitietphieunhap`
  ADD CONSTRAINT `tbl_chitietphieunhap_ibfk_1` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`),
  ADD CONSTRAINT `tbl_chitietphieunhap_ibfk_2` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`),
  ADD CONSTRAINT `tbl_chitietphieunhap_ibfk_3` FOREIGN KEY (`id_sach`) REFERENCES `tbl_sach` (`id_sach`);

--
-- Constraints for table `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD CONSTRAINT `tbl_hoadon_ibfk_1` FOREIGN KEY (`id_khachhang`) REFERENCES `tbl_khachhang` (`id_khachhang`),
  ADD CONSTRAINT `tbl_hoadon_ibfk_2` FOREIGN KEY (`id_khachhang`) REFERENCES `tbl_khachhang` (`id_khachhang`),
  ADD CONSTRAINT `tbl_hoadon_ibfk_3` FOREIGN KEY (`id_khachhang`) REFERENCES `tbl_khachhang` (`id_khachhang`),
  ADD CONSTRAINT `tbl_hoadon_ibfk_4` FOREIGN KEY (`id_khachhang`) REFERENCES `tbl_khachhang` (`id_khachhang`);

--
-- Constraints for table `tbl_phieunhap`
--
ALTER TABLE `tbl_phieunhap`
  ADD CONSTRAINT `tbl_phieunhap_ibfk_1` FOREIGN KEY (`id_ncc`) REFERENCES `tbl_ncc` (`id_ncc`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_2` FOREIGN KEY (`id_phieunhap`) REFERENCES `tbl_chitietphieunhap` (`id_phieu_nhap`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_3` FOREIGN KEY (`id_ncc`) REFERENCES `tbl_ncc` (`id_ncc`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_4` FOREIGN KEY (`id_phieunhap`) REFERENCES `tbl_chitietphieunhap` (`id_phieu_nhap`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_5` FOREIGN KEY (`id_ncc`) REFERENCES `tbl_ncc` (`id_ncc`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_6` FOREIGN KEY (`id_phieunhap`) REFERENCES `tbl_chitietphieunhap` (`id_phieu_nhap`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_7` FOREIGN KEY (`id_ncc`) REFERENCES `tbl_ncc` (`id_ncc`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_8` FOREIGN KEY (`id_phieunhap`) REFERENCES `tbl_chitietphieunhap` (`id_phieu_nhap`),
  ADD CONSTRAINT `tbl_phieunhap_ibfk_9` FOREIGN KEY (`id_phieunhap`) REFERENCES `tbl_chitietphieunhap` (`id_phieu_nhap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
