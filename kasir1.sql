-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2025 at 02:19 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir1`
--

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_penjualan` char(15) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `total_jumlah` int(11) NOT NULL,
  `total_harga` decimal(10,2) DEFAULT NULL,
  `bayar` decimal(10,2) DEFAULT NULL,
  `diskon` decimal(10,2) NOT NULL,
  `kembali` decimal(10,2) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `create_at` timestamp NULL DEFAULT current_timestamp(),
  `update_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_penjualan`, `tanggal`, `total_jumlah`, `total_harga`, `bayar`, `diskon`, `kembali`, `id_user`, `create_at`, `update_at`) VALUES
('TRS250119001', '2025-01-19', 0, 2580.00, 4000.00, 0.00, 1420.00, 250103, '2025-01-19 03:34:30', '2025-01-19 03:34:30'),
('TRS250119002', '2025-01-19', 0, 1200.00, 5000.00, 0.00, 3800.00, 2501001, '2025-01-19 08:18:40', '2025-01-19 08:18:40'),
('TRS250119003', '2025-01-19', 13, 20040.00, 25000.00, 0.00, 4960.00, 2501002, '2025-01-19 10:24:42', '2025-01-19 10:24:42'),
('TRS250119004', '2025-01-19', 0, 1280.40, 4000.00, 39.60, 2720.00, 2501002, '2025-01-19 10:25:52', '2025-01-19 10:25:52'),
('TRS250119005', '2025-01-19', 6, 21600.00, 30000.00, 2400.00, 8400.00, 2501002, '2025-01-19 10:26:35', '2025-01-19 10:26:35'),
('TRS250119006', '2025-01-19', 0, 1380.00, 2000.00, 0.00, 620.00, 2501001, '2025-01-19 10:45:47', '2025-01-19 10:45:47'),
('TRS250119007', '2025-01-19', 0, 4000.00, 5000.00, 0.00, 1000.00, 2501001, '2025-01-19 14:20:11', '2025-01-19 14:20:11'),
('TRS250120001', '2025-01-20', 0, 7996.80, 10000.00, 163.20, 2003.00, 250103, '2025-01-20 02:41:58', '2025-01-20 02:41:58');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_detail`
--

CREATE TABLE `penjualan_detail` (
  `id_penjualan` char(15) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan_detail`
--

INSERT INTO `penjualan_detail` (`id_penjualan`, `id_produk`, `jumlah`, `subtotal`, `create_at`, `update_at`) VALUES
('TRS250119001', 24110002, 1, 1260.00, '2025-01-19 03:34:30', '2025-01-19 03:34:30'),
('TRS250119001', 24110003, 1, 1320.00, '2025-01-19 03:34:30', '2025-01-19 03:34:30'),
('TRS250119002', 24110001, 1, 1200.00, '2025-01-19 08:18:40', '2025-01-19 08:18:40'),
('TRS250119003', 24110003, 1, 1320.00, '2025-01-19 10:24:42', '2025-01-19 10:24:42'),
('TRS250119003', 24110006, 1, 1500.00, '2025-01-19 10:24:42', '2025-01-19 10:24:42'),
('TRS250119003', 24110008, 1, 1620.00, '2025-01-19 10:24:42', '2025-01-19 10:24:42'),
('TRS250119003', 24110007, 10, 15600.00, '2025-01-19 10:24:42', '2025-01-19 10:24:42'),
('TRS250119004', 24110003, 1, 1320.00, '2025-01-19 10:25:52', '2025-01-19 10:25:52'),
('TRS250119005', 2501001, 6, 24000.00, '2025-01-19 10:26:35', '2025-01-19 10:26:35'),
('TRS250119006', 24110004, 1, 1380.00, '2025-01-19 10:45:47', '2025-01-19 10:45:47'),
('TRS250119007', 2501001, 1, 4000.00, '2025-01-19 14:20:11', '2025-01-19 14:20:11'),
('TRS250120001', 24110001, 1, 1200.00, '2025-01-20 02:41:58', '2025-01-20 02:41:58'),
('TRS250120001', 24110010, 4, 6960.00, '2025-01-20 02:41:58', '2025-01-20 02:41:58');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_smt`
--

CREATE TABLE `penjualan_smt` (
  `id_produk` int(11) NOT NULL,
  `nama_produk` varchar(255) NOT NULL,
  `harga` decimal(10,2) NOT NULL,
  `stok` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan_smt`
--

INSERT INTO `penjualan_smt` (`id_produk`, `nama_produk`, `harga`, `stok`, `jumlah`, `subtotal`) VALUES
(24110002, 'Tahu Pletok', 1260.00, 9, 1, 1260.00),
(24110004, 'Kacang Bogares', 1380.00, 11, 1, 1380.00),
(24110006, 'Kerupuk Antor', 1500.00, 14, 1, 1500.00),
(24110009, 'Lontong Tegal', 1680.00, 18, 1, 1680.00),
(24110010, 'Nasi Lengko', 1740.00, 15, 1, 1740.00),
(24110059, 'Roti Jahe', 4680.00, 28, 1, 4680.00);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `ID` int(11) NOT NULL,
  `nama_produk` varchar(65) NOT NULL,
  `harga_beli` decimal(10,2) NOT NULL,
  `harga_jual` decimal(10,2) NOT NULL,
  `stok` int(11) NOT NULL,
  `satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`ID`, `nama_produk`, `harga_beli`, `harga_jual`, `stok`, `satuan`) VALUES
(2501001, 'gado', 3000.00, 4000.00, 23, 'Pcs'),
(2501002, 'roma', 3000.00, 4000.00, 10, 'Pcs'),
(24110001, 'Tahu Aci', 1000.00, 1200.00, 5, 'Pack'),
(24110002, 'Tahu Pletok', 1050.00, 1260.00, 9, 'Pcs'),
(24110003, 'Pilus', 1100.00, 1320.00, 6, 'Kg'),
(24110004, 'Kacang Bogares', 1150.00, 1380.00, 11, 'Pack'),
(24110005, 'Kripik Tempe', 1200.00, 1440.00, 14, 'Pcs'),
(24110006, 'Kerupuk Antor', 1250.00, 1500.00, 14, 'Kg'),
(24110007, 'Gorengan Olos', 1300.00, 1560.00, 6, 'Pack'),
(24110008, 'Sate Blengong', 1350.00, 1620.00, 16, 'Pcs'),
(24110009, 'Lontong Tegal', 1400.00, 1680.00, 18, 'Kg'),
(24110010, 'Nasi Lengko', 1450.00, 1740.00, 15, 'Pack'),
(24110011, 'Krupuk Rambak', 1500.00, 1800.00, 20, 'Pcs'),
(24110012, 'Teh Poci', 1550.00, 1860.00, 21, 'Kg'),
(24110013, 'Poci Tegal', 1600.00, 1920.00, 22, 'Pack'),
(24110014, 'Rengginang', 1650.00, 1980.00, 23, 'Pcs'),
(24110015, 'Kerupuk Nasi', 1700.00, 2040.00, 24, 'Kg'),
(24110016, 'Opak Gambir', 1750.00, 2100.00, 25, 'Pack'),
(24110017, 'Sirup Parijoto', 1800.00, 2160.00, 26, 'Pcs'),
(24110018, 'Bandeng Presto', 1850.00, 2220.00, 27, 'Kg'),
(24110019, 'Petis Bandeng', 1900.00, 2280.00, 28, 'Pack'),
(24110020, 'Gorengan Mendoan', 1950.00, 2340.00, 29, 'Pcs'),
(24110021, 'Wingko Babat', 2000.00, 2400.00, 10, 'Kg'),
(24110022, 'Jenang Tegal', 2050.00, 2460.00, 11, 'Pack'),
(24110023, 'Kripik Daun Singkong', 2100.00, 2520.00, 12, 'Pcs'),
(24110024, 'Kripik Bayam', 2150.00, 2580.00, 13, 'Kg'),
(24110025, 'Ampyang', 2200.00, 2640.00, 14, 'Pack'),
(24110026, 'Kripik Usus', 2250.00, 2700.00, 15, 'Pcs'),
(24110027, 'Kacang Garing', 2300.00, 2760.00, 16, 'Kg'),
(24110028, 'Emping Mlinjo', 2350.00, 2820.00, 17, 'Pack'),
(24110029, 'Kacang Asin', 2400.00, 2880.00, 18, 'Pcs'),
(24110030, 'Dodol Tegal', 2450.00, 2940.00, 19, 'Kg'),
(24110031, 'Kerupuk Kulit', 2500.00, 3000.00, 20, 'Pack'),
(24110032, 'Keripik Kentang', 2550.00, 3060.00, 21, 'Pcs'),
(24110033, 'Roti Tegal', 2600.00, 3120.00, 22, 'Kg'),
(24110034, 'Brownies Singkong', 2650.00, 3180.00, 23, 'Pack'),
(24110035, 'Kripik Pisang', 2700.00, 3240.00, 24, 'Pcs'),
(24110036, 'Sagon', 2750.00, 3300.00, 25, 'Kg'),
(24110037, 'Gula Merah Cetak', 2800.00, 3360.00, 26, 'Pack'),
(24110038, 'Kopi Bubuk Lokal', 2850.00, 3420.00, 27, 'Pcs'),
(24110039, 'Teh Tubruk', 2900.00, 3480.00, 28, 'Kg'),
(24110040, 'Getuk Tegal', 2950.00, 3540.00, 29, 'Pack'),
(24110041, 'Abon Sapi', 3000.00, 3600.00, 10, 'Pcs'),
(24110042, 'Abon Ayam', 3050.00, 3660.00, 11, 'Kg'),
(24110043, 'Ikan Asin Tegal', 3100.00, 3720.00, 12, 'Pack'),
(24110044, 'Dendeng Sapi', 3150.00, 3780.00, 13, 'Pcs'),
(24110045, 'Rengginang Tegal', 3200.00, 3840.00, 14, 'Kg'),
(24110046, 'Tempe Goreng', 3250.00, 3900.00, 15, 'Pack'),
(24110047, 'Keripik Jengkol', 3300.00, 3960.00, 16, 'Pcs'),
(24110048, 'Sambal Terasi', 3350.00, 4020.00, 17, 'Kg'),
(24110049, 'Petis Udang', 3400.00, 4080.00, 18, 'Pack'),
(24110050, 'Dodok Tepung', 3450.00, 4140.00, 19, 'Pcs'),
(24110051, 'Krupuk Tahu', 3500.00, 4200.00, 20, 'Kg'),
(24110052, 'Krupuk Blengong', 3550.00, 4260.00, 21, 'Pack'),
(24110053, 'Empal Gentong Instan', 3600.00, 4320.00, 22, 'Pcs'),
(24110054, 'Mangut Bandeng', 3650.00, 4380.00, 23, 'Kg'),
(24110055, 'Lontong Sayur', 3700.00, 4440.00, 24, 'Pack'),
(24110056, 'Pilus Tegal', 3750.00, 4500.00, 25, 'Pcs'),
(24110057, 'Peyek Kacang', 3800.00, 4560.00, 26, 'Kg'),
(24110058, 'Peyek Udang', 3850.00, 4620.00, 27, 'Pack'),
(24110059, 'Roti Jahe', 3900.00, 4680.00, 28, 'Pcs'),
(24110060, 'Kacang Atom', 3950.00, 4740.00, 29, 'Kg'),
(24110061, 'Keripik Bonggol Pisang', 4000.00, 4800.00, 10, 'Pack'),
(24110062, 'Keripik Ubi', 4050.00, 4860.00, 11, 'Pcs'),
(24110063, 'Puding Tahu', 4100.00, 4920.00, 12, 'Kg'),
(24110064, 'Lontong Opor', 4150.00, 4980.00, 13, 'Pack'),
(24110065, 'Kue Lumpur', 4200.00, 5040.00, 14, 'Pcs'),
(24110066, 'Kue Getas', 4250.00, 5100.00, 15, 'Kg'),
(24110067, 'Gethuk Lindri', 4300.00, 5160.00, 16, 'Pack'),
(24110068, 'Emping Jagung', 4350.00, 5220.00, 17, 'Pcs'),
(24110069, 'Tape Singkong', 4400.00, 5280.00, 18, 'Kg'),
(24110070, 'Roti Gandum', 4450.00, 5340.00, 19, 'Pack'),
(24110071, 'Cookies Kacang', 4500.00, 5400.00, 20, 'Pcs'),
(24110072, 'Kopi Tubruk', 4550.00, 5460.00, 21, 'Kg'),
(24110073, 'Teh Rosella', 4600.00, 5520.00, 22, 'Pack'),
(24110074, 'Kerupuk Palembang', 4650.00, 5580.00, 23, 'Pcs'),
(24110075, 'Keripik Ceker', 4700.00, 5640.00, 24, 'Kg'),
(24110076, 'Keripik Kerang', 4750.00, 5700.00, 25, 'Pack'),
(24110077, 'Ikan Pindang', 4800.00, 5760.00, 26, 'Pcs'),
(24110078, 'Ikan Bandeng', 4850.00, 5820.00, 27, 'Kg'),
(24110079, 'Pindang Cemplung', 4900.00, 5880.00, 28, 'Pack'),
(24110080, 'Sambal Teri', 4950.00, 5940.00, 29, 'Pcs'),
(24110081, 'Bakpia Tegal', 5000.00, 6000.00, 10, 'Kg'),
(24110082, 'Onde-onde', 5050.00, 6060.00, 11, 'Pack'),
(24110083, 'Tiwul Instan', 5100.00, 6120.00, 12, 'Pcs'),
(24110084, 'Lupis Tegal', 5150.00, 6180.00, 13, 'Kg'),
(24110085, 'Apem Tegal', 5200.00, 6240.00, 14, 'Pack'),
(24110086, 'Lemper Ayam', 5250.00, 6300.00, 15, 'Pcs'),
(24110087, 'Kue Klepon', 5300.00, 6360.00, 16, 'Kg'),
(24110088, 'Kue Putu', 5350.00, 6420.00, 17, 'Pack'),
(24110089, 'Putu Ayu', 5400.00, 6480.00, 18, 'Pcs'),
(24110090, 'Putu Mayang', 5450.00, 6540.00, 19, 'Kg'),
(24110091, 'Kacang Telur', 5500.00, 6600.00, 20, 'Pack'),
(24110092, 'Bolu Kukus', 5550.00, 6660.00, 21, 'Pcs'),
(24110093, 'Kue Sus', 5600.00, 6720.00, 22, 'Kg'),
(24110094, 'Kue Nastar', 5650.00, 6780.00, 23, 'Pack'),
(24110095, 'Tape Madu', 5700.00, 6840.00, 24, 'Pcs'),
(24110096, 'Dodol Madu', 5750.00, 6900.00, 25, 'Kg'),
(24110097, 'Kacang Mete', 5800.00, 6960.00, 26, 'Pack'),
(24110098, 'Sumpil', 5850.00, 7020.00, 27, 'Pcs'),
(24110099, 'Serundeng Tegal', 5900.00, 7080.00, 28, 'Kg'),
(24110100, 'Bakso Instan', 5950.00, 7140.00, 29, 'Pack');

-- --------------------------------------------------------

--
-- Table structure for table `profil`
--

CREATE TABLE `profil` (
  `id_user` int(11) NOT NULL,
  `foto_profil` longblob NOT NULL,
  `bio` text NOT NULL,
  `website` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `total_harga` decimal(10,2) NOT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_detail`
--

CREATE TABLE `transaksi_detail` (
  `id_transaksi_detail` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga_produk` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `fullname` varchar(75) NOT NULL,
  `email` varchar(50) NOT NULL,
  `no_telepon` int(13) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `fullname`, `email`, `no_telepon`, `username`, `password`, `role`) VALUES
(250102, 'Moh. Sidni Ilma', 'Moh. Sidni Ilma@gmail.com', 897773377, 'owner', '123', 'ADMIN'),
(250103, 'Resta Sabrina', 'Resta Sabrina', 87462782, 'kasir', '123', 'KASIR'),
(2501001, 'Arya Fahrezi Amarully', 'Arya Fahrezi Amarully@gmail.com', 817746624, 'admin', '123', 'ADMIN'),
(2501002, 'Sugeng ', 'Sugeng@gmail.com', 98776636, 'kasir', '1234', 'KASIR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_penjualan`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD KEY `id_penjualan` (`id_penjualan`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `penjualan_smt`
--
ALTER TABLE `penjualan_smt`
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `profil`
--
ALTER TABLE `profil`
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD PRIMARY KEY (`id_transaksi_detail`),
  ADD KEY `id_transaksi` (`id_transaksi`,`id_user`,`id_produk`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24110101;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  MODIFY `id_transaksi_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2501003;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD CONSTRAINT `penjualan_detail_ibfk_1` FOREIGN KEY (`id_penjualan`) REFERENCES `penjualan` (`id_penjualan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_detail_ibfk_2` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan_smt`
--
ALTER TABLE `penjualan_smt`
  ADD CONSTRAINT `penjualan_smt_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `profil`
--
ALTER TABLE `profil`
  ADD CONSTRAINT `profil_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD CONSTRAINT `transaksi_detail_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_detail_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_detail_ibfk_3` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
