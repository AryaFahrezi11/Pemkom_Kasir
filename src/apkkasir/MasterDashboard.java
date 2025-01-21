package apkkasir;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class MasterDashboard extends javax.swing.JPanel {
    
    private Connection conn;
    
    public MasterDashboard() {
        initComponents();
        conn = databasekoneksi.getConnection();
        loadData();
        setLayoutForm();
        getKasirDenganPenjualanTerbanyak();
        getProdukDenganPenjualanTerbanyak();
        totalBarangTerjualBulanIni() ;
        createTransactionBarChart();
        createBestSellingProductsBarChart();
        startDateChooser.setDateFormatString("yyyy-MM-dd");
        endDateChooser.setDateFormatString("yyyy-MM-dd");
        createTopCashiersBarChartForCurrentMonth();
    }
    

    
    private void setLayoutForm(){
        cardAnggota.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
        cardBuku.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
        cardPeminjaman.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
        cardPengembalian.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
        
//        iconDashboard.setIcon(new FlatSVGIcon("com/kasir/icon/dashboard.svg", 1f));
        iconAnggota.setIcon(new FlatSVGIcon("com/kasir/icon/anggota_white.svg", 2f));
        iconBuku.setIcon(new FlatSVGIcon("com/kasir/icon/book_white.svg", 2f));
        iconPeminjaman.setIcon(new FlatSVGIcon("com/kasir/icon/stok.svg", 2f));
        iconPengembalian.setIcon(new FlatSVGIcon("com/kasir/icon/pengembalian_white.svg", 2f));
    }
private void createTransactionBarChart() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Query untuk menghitung jumlah transaksi per bulan dan tahun
    String sql = "SELECT " +
                 "MONTH(trs.tanggal) AS Bulan, " +
                 "YEAR(trs.tanggal) AS Tahun, " +
                 "COUNT(*) AS Total_Transaksi " +  // Menggunakan COUNT(*) untuk menghitung jumlah transaksi
                 "FROM penjualan trs " +
                 "WHERE trs.tanggal IS NOT NULL " +
                 "GROUP BY YEAR(trs.tanggal), MONTH(trs.tanggal) " +
                 "ORDER BY Tahun ASC, Bulan ASC";

    // Mempersiapkan dan menjalankan query
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
            // Mengecek apakah hasil query tidak kosong
            if (!rs.isBeforeFirst()) {
            }

            // Mengambil data dan menambahkannya ke dataset
            while (rs.next()) {
                int bulan = rs.getInt("Bulan");
                int tahun = rs.getInt("Tahun");
                int totalTransaksi = rs.getInt("Total_Transaksi");  // Mengambil jumlah transaksi

                // Menyusun label untuk sumbu X (Bulan-Tahun)
                String labelBulan = tahun + "-" + bulan;
                dataset.addValue(totalTransaksi, "Total Transaksi", labelBulan);

            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Membuat grafik batang
    JFreeChart chart = ChartFactory.createBarChart(
            "Total Transaksi per Bulan", // Judul grafik
            "Bulan",                    // Label sumbu X
            "Total Transaksi",          // Label sumbu Y
            dataset                     // Dataset
    );

    // Mengatur warna bar grafik
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
    plot.getRenderer().setSeriesPaint(0, new java.awt.Color(0,204,204));  // Mengubah warna bar ke #0ca1c6

    // Menambahkan grafik ke dalam PanelGrafik
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 200)); // Ukuran grafik
    chartPanel.setMouseWheelEnabled(true);

    // Memastikan PanelGrafik menggunakan layout yang benar
    PanelGrafik.setLayout(new BorderLayout());  // Menggunakan BorderLayout untuk menambahkan chart di tengah
    PanelGrafik.removeAll();  // Menghapus komponen yang ada sebelumnya
    PanelGrafik.add(chartPanel, BorderLayout.CENTER);  // Menambahkan grafik ke posisi CENTER

    // Memperbarui dan merender ulang panel
    PanelGrafik.setPreferredSize(new Dimension(500, 500));  // Pastikan PanelGrafik cukup besar untuk menampung grafik
    PanelGrafik.revalidate();  // Memperbarui layout
    PanelGrafik.repaint();     // Merender ulang panel

}

private void createBestSellingProductsDate() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Format tanggal untuk query SQL
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Mendapatkan tanggal dari JDateChooser
    String startDate = sdf.format(startDateChooser.getDate()); // Tanggal awal
    String endDate = sdf.format(endDateChooser.getDate());     // Tanggal akhir

    // Query untuk mendapatkan produk terlaris berdasarkan periode
    String sql = "SELECT det.id_produk, pd.nama_produk, SUM(det.jumlah) AS Total_Jumlah " +
                 "FROM penjualan_detail det " +
                 "INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan " +
                 "INNER JOIN produk pd ON pd.ID = det.id_produk " +
                 "WHERE pj.tanggal BETWEEN ? AND ? " +
                 "GROUP BY det.id_produk, pd.nama_produk " +
                 "ORDER BY Total_Jumlah DESC";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, startDate); // Mengatur parameter tanggal awal
        stmt.setString(2, endDate);   // Mengatur parameter tanggal akhir

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String namaProduk = rs.getString("nama_produk");
                int totalJumlah = rs.getInt("Total_Jumlah");

                // Menambahkan data ke dataset
                dataset.addValue(totalJumlah, "Jumlah Terjual", namaProduk);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Membuat grafik batang
    JFreeChart chart = ChartFactory.createBarChart(
            "Produk Terlaris",        // Judul grafik
            "Nama Produk",            // Label sumbu X
            "Jumlah Terjual",         // Label sumbu Y
            dataset,                  // Dataset
            PlotOrientation.VERTICAL, // Orientasi grafik
            false,                    // Legend (keterangan)
            true,                     // Tooltips
            false                     // URL
    );

    // Mengatur warna grafik
    CategoryPlot plot = chart.getCategoryPlot();
    plot.getRenderer().setSeriesPaint(0, new java.awt.Color(0,204,204));

    // Menampilkan grafik di panel
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));
    chartPanel.setMouseWheelEnabled(true);

    // Memastikan PanelGrafik menggunakan layout yang benar
    PanelGrafik1.setLayout(new BorderLayout());
    PanelGrafik1.removeAll(); // Menghapus komponen sebelumnya
    PanelGrafik1.add(chartPanel, BorderLayout.CENTER); // Menambahkan grafik
    PanelGrafik1.revalidate(); // Memperbarui layout
    PanelGrafik1.repaint(); // Merender ulang panel
}

    private void createBestSellingProductsBarChart() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Query untuk mendapatkan produk terlaris secara umum
    String sql = "SELECT det.id_produk, pd.nama_produk, SUM(det.jumlah) AS Total_Jumlah " +
                 "FROM penjualan_detail det " +
                 "INNER JOIN produk pd ON pd.ID = det.id_produk " +
                 "GROUP BY det.id_produk, pd.nama_produk " +
                 "ORDER BY Total_Jumlah DESC";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String namaProduk = rs.getString("nama_produk");
                int totalJumlah = rs.getInt("Total_Jumlah");

                // Menambahkan data ke dataset
                dataset.addValue(totalJumlah, "Jumlah Terjual", namaProduk);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Membuat grafik batang
    JFreeChart chart = ChartFactory.createBarChart(
            "Produk Terlaris Bulan Ini",        // Judul grafik
            "Nama Produk",            // Label sumbu X
            "Jumlah Terjual",         // Label sumbu Y
            dataset,                  // Dataset
            PlotOrientation.VERTICAL, // Orientasi grafik
            false,                    // Legend (keterangan)
            true,                     // Tooltips
            false                     // URL
    );

    // Mengatur warna grafik
    CategoryPlot plot = chart.getCategoryPlot();
    plot.getRenderer().setSeriesPaint(0, new java.awt.Color(0,204,204));

    // Menampilkan grafik di panel
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));
    chartPanel.setMouseWheelEnabled(true);

    // Memastikan PanelGrafik menggunakan layout yang benar
    PanelGrafik1.setLayout(new BorderLayout());
    PanelGrafik1.removeAll(); // Menghapus komponen sebelumnya
    PanelGrafik1.add(chartPanel, BorderLayout.CENTER); // Menambahkan grafik
    PanelGrafik1.revalidate(); // Memperbarui layout
    PanelGrafik1.repaint(); // Merender ulang panel
}

    private void createTopCashiersBarChartForCurrentMonth() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Mendapatkan bulan dan tahun saat ini
    LocalDate currentDate = LocalDate.now();
    int currentMonth = currentDate.getMonthValue(); // Bulan sekarang
    int currentYear = currentDate.getYear();       // Tahun sekarang

    // Query untuk mendapatkan jumlah transaksi per kasir berdasarkan bulan saat ini
    String sql = "SELECT us.fullname, COUNT(pj.id_penjualan) AS Total_Transaksi " +
                 "FROM penjualan pj " +
                 "INNER JOIN user us ON us.id_user = pj.id_user " +
                 "WHERE MONTH(pj.tanggal) = ? AND YEAR(pj.tanggal) = ? " +
                 "GROUP BY us.fullname " +
                 "ORDER BY Total_Transaksi DESC";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, currentMonth); // Bulan sekarang
        stmt.setInt(2, currentYear);  // Tahun sekarang

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String kasir = rs.getString("fullname");
                int totalTransaksi = rs.getInt("Total_Transaksi");
                dataset.addValue(totalTransaksi, "Jumlah Transaksi", kasir);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Membuat grafik batang
    JFreeChart chart = ChartFactory.createBarChart(
            "Kasir Terbaik (Bulan Ini)", // Judul grafik
            "Kasir",                    // Label sumbu X
            "Jumlah Transaksi",         // Label sumbu Y
            dataset,                    // Dataset
            PlotOrientation.VERTICAL,   // Orientasi grafik
            true,                       // Legend (keterangan)
            true,                       // Tooltips
            false                       // URL
    );

    // Mengatur warna bar grafik
    CategoryPlot plot = chart.getCategoryPlot();
    plot.getRenderer().setSeriesPaint(0, new java.awt.Color(0,204,204)); // Warna biru

    // Menampilkan grafik di panel
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));
    chartPanel.setMouseWheelEnabled(true);

    PanelGrafik2.setLayout(new BorderLayout());
    PanelGrafik2.removeAll();
    PanelGrafik2.add(chartPanel, BorderLayout.CENTER);
    PanelGrafik2.revalidate();
    PanelGrafik2.repaint();
}

    private void createTopCashiersBarChart() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Format tanggal untuk query SQL
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String startDate = sdf.format(startDateChooser.getDate()); // Tanggal awal
    String endDate = sdf.format(endDateChooser.getDate());     // Tanggal akhir

    // Query untuk mendapatkan jumlah transaksi per kasir berdasarkan periode
    String sql = "SELECT us.fullname, COUNT(pj.id_penjualan) AS Total_Transaksi " +
                 "FROM penjualan pj " +
                 "INNER JOIN user us ON us.id_user = pj.id_user " +
                 "WHERE pj.tanggal BETWEEN ? AND ? " +
                 "GROUP BY us.fullname " +
                 "ORDER BY Total_Transaksi DESC";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String kasir = rs.getString("fullname");
                int totalTransaksi = rs.getInt("Total_Transaksi");
                dataset.addValue(totalTransaksi, "Jumlah Transaksi", kasir);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Membuat grafik batang
    JFreeChart chart = ChartFactory.createBarChart(
            "Kasir Terbaik",          // Judul grafik
            "Kasir",                  // Label sumbu X
            "Jumlah Transaksi",       // Label sumbu Y
            dataset,                  // Dataset
            PlotOrientation.VERTICAL, // Orientasi grafik
            true,                     // Legend (keterangan)
            true,                     // Tooltips
            false                     // URL
    );

    // Mengatur warna bar grafik
    CategoryPlot plot = chart.getCategoryPlot();
    plot.getRenderer().setSeriesPaint(0, new java.awt.Color(0,204,204)); // Warna biru

    // Menampilkan grafik di panel
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 200));
    chartPanel.setMouseWheelEnabled(true);

    PanelGrafik2.setLayout(new BorderLayout());
    PanelGrafik2.removeAll();
    PanelGrafik2.add(chartPanel, BorderLayout.CENTER);
    PanelGrafik2.revalidate();
    PanelGrafik2.repaint();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconDashboard = new javax.swing.JLabel();
        cardAnggota = new javax.swing.JPanel();
        iconAnggota = new javax.swing.JLabel();
        lbJumlahAnggota = new javax.swing.JLabel();
        lb_anggota = new javax.swing.JLabel();
        lbNamaKasir = new javax.swing.JLabel();
        cardBuku = new javax.swing.JPanel();
        lbJumlahBuku = new javax.swing.JLabel();
        lb_anggota1 = new javax.swing.JLabel();
        iconBuku = new javax.swing.JLabel();
        lbNamaProduk = new javax.swing.JLabel();
        cardPeminjaman = new javax.swing.JPanel();
        lbJumlahPeminjaman = new javax.swing.JLabel();
        lb_anggota5 = new javax.swing.JLabel();
        iconPeminjaman = new javax.swing.JLabel();
        cardPengembalian = new javax.swing.JPanel();
        lbJumlahTransaksi = new javax.swing.JLabel();
        lb_anggota3 = new javax.swing.JLabel();
        iconPengembalian = new javax.swing.JLabel();
        lbNamaBulan = new javax.swing.JLabel();
        PanelGrafik = new javax.swing.JPanel();
        PanelGrafik1 = new javax.swing.JPanel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PanelGrafik2 = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 0, 75));
        jLabel1.setText("Grafik Penjualan");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(62, 0, 75));
        jLabel2.setText("Dashboard");

        cardAnggota.setBackground(new java.awt.Color(0, 204, 204));

        iconAnggota.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconAnggota.setForeground(new java.awt.Color(0, 102, 153));

        lbJumlahAnggota.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahAnggota.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahAnggota.setText("999");

        lb_anggota.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota.setForeground(new java.awt.Color(255, 255, 255));
        lb_anggota.setText("Kasir Terbaik");

        lbNamaKasir.setBackground(new java.awt.Color(255, 255, 255));
        lbNamaKasir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbNamaKasir.setForeground(new java.awt.Color(255, 255, 255));
        lbNamaKasir.setText("Nama Kasir");

        javax.swing.GroupLayout cardAnggotaLayout = new javax.swing.GroupLayout(cardAnggota);
        cardAnggota.setLayout(cardAnggotaLayout);
        cardAnggotaLayout.setHorizontalGroup(
            cardAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAnggotaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNamaKasir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cardAnggotaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbJumlahAnggota)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(iconAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardAnggotaLayout.setVerticalGroup(
            cardAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAnggotaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardAnggotaLayout.createSequentialGroup()
                        .addComponent(lb_anggota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbJumlahAnggota)))
                .addGap(16, 16, 16))
        );

        cardBuku.setBackground(new java.awt.Color(0, 204, 204));

        lbJumlahBuku.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahBuku.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahBuku.setText("999");

        lb_anggota1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota1.setForeground(new java.awt.Color(255, 255, 255));
        lb_anggota1.setText("PRODUK TERLARIS");

        iconBuku.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconBuku.setForeground(new java.awt.Color(0, 102, 153));

        lbNamaProduk.setBackground(new java.awt.Color(255, 255, 255));
        lbNamaProduk.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbNamaProduk.setForeground(new java.awt.Color(255, 255, 255));
        lbNamaProduk.setText("Nama Produk");

        javax.swing.GroupLayout cardBukuLayout = new javax.swing.GroupLayout(cardBuku);
        cardBuku.setLayout(cardBukuLayout);
        cardBukuLayout.setHorizontalGroup(
            cardBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBukuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardBukuLayout.createSequentialGroup()
                        .addGroup(cardBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbJumlahBuku)
                            .addComponent(lb_anggota1))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(lbNamaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardBukuLayout.setVerticalGroup(
            cardBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardBukuLayout.createSequentialGroup()
                        .addComponent(lb_anggota1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJumlahBuku)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardPeminjaman.setBackground(new java.awt.Color(0, 204, 204));

        lbJumlahPeminjaman.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahPeminjaman.setText("999");

        lb_anggota5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota5.setForeground(new java.awt.Color(255, 255, 255));
        lb_anggota5.setText("PENDAPATAN");

        iconPeminjaman.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconPeminjaman.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout cardPeminjamanLayout = new javax.swing.GroupLayout(cardPeminjaman);
        cardPeminjaman.setLayout(cardPeminjamanLayout);
        cardPeminjamanLayout.setHorizontalGroup(
            cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPeminjamanLayout.createSequentialGroup()
                .addGroup(cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPeminjamanLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lb_anggota5))
                    .addGroup(cardPeminjamanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbJumlahPeminjaman)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(iconPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardPeminjamanLayout.setVerticalGroup(
            cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPeminjamanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPeminjamanLayout.createSequentialGroup()
                        .addComponent(iconPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(cardPeminjamanLayout.createSequentialGroup()
                        .addComponent(lb_anggota5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbJumlahPeminjaman)
                        .addGap(16, 16, 16))))
        );

        cardPengembalian.setBackground(new java.awt.Color(0, 204, 204));
        cardPengembalian.setToolTipText("");

        lbJumlahTransaksi.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahTransaksi.setText("999");

        lb_anggota3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota3.setForeground(new java.awt.Color(255, 255, 255));
        lb_anggota3.setText("PRODUK TERJUAL");

        iconPengembalian.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconPengembalian.setForeground(new java.awt.Color(0, 102, 153));

        lbNamaBulan.setBackground(new java.awt.Color(255, 255, 255));
        lbNamaBulan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbNamaBulan.setForeground(new java.awt.Color(255, 255, 255));
        lbNamaBulan.setText("Nama Bulan");

        javax.swing.GroupLayout cardPengembalianLayout = new javax.swing.GroupLayout(cardPengembalian);
        cardPengembalian.setLayout(cardPengembalianLayout);
        cardPengembalianLayout.setHorizontalGroup(
            cardPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPengembalianLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPengembalianLayout.createSequentialGroup()
                        .addGroup(cardPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbJumlahTransaksi)
                            .addComponent(lb_anggota3))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addComponent(lbNamaBulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        cardPengembalianLayout.setVerticalGroup(
            cardPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPengembalianLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_anggota3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPengembalianLayout.createSequentialGroup()
                        .addComponent(lbNamaBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJumlahTransaksi))
                    .addComponent(iconPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelGrafik.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelGrafikLayout = new javax.swing.GroupLayout(PanelGrafik);
        PanelGrafik.setLayout(PanelGrafikLayout);
        PanelGrafikLayout.setHorizontalGroup(
            PanelGrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        PanelGrafikLayout.setVerticalGroup(
            PanelGrafikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        PanelGrafik1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelGrafik1Layout = new javax.swing.GroupLayout(PanelGrafik1);
        PanelGrafik1.setLayout(PanelGrafik1Layout);
        PanelGrafik1Layout.setHorizontalGroup(
            PanelGrafik1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        PanelGrafik1Layout.setVerticalGroup(
            PanelGrafik1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("LIHAT GRAFIK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("S/D");

        PanelGrafik2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelGrafik2Layout = new javax.swing.GroupLayout(PanelGrafik2);
        PanelGrafik2.setLayout(PanelGrafik2Layout);
        PanelGrafik2Layout.setHorizontalGroup(
            PanelGrafik2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        PanelGrafik2Layout.setVerticalGroup(
            PanelGrafik2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cardAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(cardBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cardPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(cardPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(PanelGrafik1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelGrafik2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(428, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardAnggota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardPeminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jButton1))
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelGrafik2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelGrafik1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createBestSellingProductsDate();
        createTopCashiersBarChart();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrafik;
    private javax.swing.JPanel PanelGrafik1;
    private javax.swing.JPanel PanelGrafik2;
    private javax.swing.JPanel cardAnggota;
    private javax.swing.JPanel cardBuku;
    private javax.swing.JPanel cardPeminjaman;
    private javax.swing.JPanel cardPengembalian;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel iconAnggota;
    private javax.swing.JLabel iconBuku;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconPeminjaman;
    private javax.swing.JLabel iconPengembalian;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbJumlahAnggota;
    private javax.swing.JLabel lbJumlahBuku;
    private javax.swing.JLabel lbJumlahPeminjaman;
    private javax.swing.JLabel lbJumlahTransaksi;
    private javax.swing.JLabel lbNamaBulan;
    private javax.swing.JLabel lbNamaKasir;
    private javax.swing.JLabel lbNamaProduk;
    private javax.swing.JLabel lb_anggota;
    private javax.swing.JLabel lb_anggota1;
    private javax.swing.JLabel lb_anggota3;
    private javax.swing.JLabel lb_anggota5;
    private com.toedter.calendar.JDateChooser startDateChooser;
    // End of variables declaration//GEN-END:variables

    // Metode untuk mengambil Kasir dengan penjualan terbanyak dan total barang yang dijual
private int getKasirDenganPenjualanTerbanyak() {
    int totalBarang = 0;
    try {
        // Query untuk mengambil nama kasir dan total barang yang dijual
        String sql = "SELECT usr.fullname AS Kasir, SUM(det.jumlah) AS Total_Barang " +
                     "FROM penjualan_detail det " +
                     "INNER JOIN penjualan tr ON tr.id_penjualan = det.id_penjualan " +
                     "INNER JOIN user usr ON usr.id_user = tr.id_user " +
                     "GROUP BY usr.fullname " +
                     "ORDER BY Total_Barang DESC LIMIT 1"; // Kasir dengan penjualan terbanyak
        
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String namaKasir = rs.getString("Kasir");  // Nama Kasir dengan penjualan terbanyak
                totalBarang = rs.getInt("Total_Barang");  // Total barang yang dijual oleh kasir tersebut
                
                // Set label untuk nama kasir dan total barang yang dijual
                lbNamaKasir.setText(namaKasir);
                lbJumlahAnggota.setText(String.valueOf(totalBarang));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return totalBarang;
}


    
   private int getProdukDenganPenjualanTerbanyak() {
    int jumlahTerjual = 0;
    try {
        // Query untuk mengambil nama produk dan total jumlah terjual
        String sql = "SELECT pd.nama_produk, SUM(det.Jumlah) AS Jumlah_Terjual " +
                     "FROM penjualan_detail det " +
                     "INNER JOIN penjualan tr ON tr.id_penjualan = det.id_penjualan " +
                     "INNER JOIN produk pd ON pd.ID = det.id_produk " +
                     "GROUP BY pd.nama_produk " +
                     "ORDER BY Jumlah_Terjual DESC LIMIT 1";  // Produk dengan jumlah terjual terbanyak

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String namaProduk = rs.getString("Nama_Produk");  // Nama produk dengan jumlah terjual terbanyak
                jumlahTerjual = rs.getInt("Jumlah_Terjual");  // Jumlah produk yang terjual
                
                // Set label untuk nama produk dan jumlah terjual
                lbNamaProduk.setText(namaProduk);
                lbJumlahBuku.setText("" + jumlahTerjual);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return jumlahTerjual;
}


    
    private int jumlahPeminjaman(){
        int totalPeminjaman = 0;
        
        try {
            String sql = "SELECT SUM(total_harga) AS total FROM penjualan;"; // stok produk
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                totalPeminjaman = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPeminjaman;
    }
    
private int totalBarangTerjualBulanIni() {
    int totalBarangTerjual = 0;

    try {
        String sql = "SELECT SUM(det.jumlah) AS total_terjual " +
                     "FROM penjualan_detail det " +
                     "INNER JOIN penjualan tr ON det.id_penjualan = tr.id_penjualan " +
                     "WHERE MONTH(tr.tanggal) = MONTH(CURDATE()) " +
                     "AND YEAR(tr.tanggal) = YEAR(CURDATE())";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            totalBarangTerjual = rs.getInt("total_terjual");

            // Mendapatkan nama bulan sekarang
            java.time.Month currentMonth = java.time.LocalDate.now().getMonth();
            String namaBulan = currentMonth.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.getDefault());

            // Set ke label lbNamaBulan
            lbNamaBulan.setText("" + namaBulan);

            // Set ke label lbJumlahTransaksi
            lbJumlahTransaksi.setText("" + totalBarangTerjual);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return totalBarangTerjual;
}
    
    private void loadData() {
        lbJumlahPeminjaman.setText(String.valueOf("RP."+jumlahPeminjaman()+",-"));
    }
}
