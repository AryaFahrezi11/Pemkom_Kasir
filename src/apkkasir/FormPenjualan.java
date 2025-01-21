
package apkkasir;

import JDialog.DataPenjualanDetail;
import JDialog.DataProduk;
import dao.DAO_Penjualan;
import dao.DAO_PenjualanDetail;
import dao.DAO_PenjualanSmt;
import dao.DAO_Produk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableColumnModel;
import model.model_Penjualan;
import model.model_PenjualanDetail;
import model.model_PenjualanSmt;
import model.model_Produk;
import model.model_User;
import service.service_Penjualan;
import service.service_PenjualanDetail;
import service.service_PenjualanSmt;
import service.service_Produk;
import tableModel.tableMod_Penjualan;
import tableModel.tableMod_PenjualanSmt;
import java.sql.SQLException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FormPenjualan extends javax.swing.JPanel {
    
//    private Connection conn;
    private service_Penjualan servis = new DAO_Penjualan();
    private service_PenjualanSmt servisSmt = new DAO_PenjualanSmt();
    private service_PenjualanDetail servisDet = new DAO_PenjualanDetail();
    private service_Produk servisProd = new DAO_Produk();
    
    private tableMod_Penjualan tblModelPen = new tableMod_Penjualan();
    private tableMod_PenjualanSmt tblModelSmt = new tableMod_PenjualanSmt();
    
    private Integer idProduk;
    private int TotalJumlah;
    private Timer timer;
    
    public FormPenjualan(String id, String nama) {
        initComponents();

        tbl_Produk.setModel(tblModelPen);
        tableDataSementara.setModel(tblModelSmt);
        txtNamaKasir.setText(nama);
        txtId.setText(id);
        loadData();
        loadDataSementara();
        
        setLebarKolom();
        setTanggal();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mainPanel = new javax.swing.JPanel();
        dataPenjualan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Produk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bt_Tambah = new javax.swing.JButton();
        bt_Detail = new javax.swing.JButton();
        text_Cari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bt_Print = new javax.swing.JButton();
        tambahPenjualan = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        bt_Simpan = new javax.swing.JButton();
        bt_Batal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        txtNoTransaksi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtNamaKasir = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbTotalHarga = new javax.swing.JLabel();
        lbTanggal = new javax.swing.JLabel();
        lbHari = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtIdProduk = new javax.swing.JTextField();
        btProduk = new javax.swing.JButton();
        txtNamaProduk = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDataSementara = new javax.swing.JTable();
        btPerbaruiSmt = new javax.swing.JButton();
        btHapusSmt = new javax.swing.JButton();
        btBatalSmt = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDiskon = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtKembali = new javax.swing.JTextField();
        txtPersen = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        dataPenjualan.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Produk.setRowHeight(30);
        tbl_Produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Produk);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Transaksi");

        bt_Tambah.setText("TAMBAH");
        bt_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TambahActionPerformed(evt);
            }
        });

        bt_Detail.setText("DETAIL");
        bt_Detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DetailActionPerformed(evt);
            }
        });

        text_Cari.setText("Cari Produk Disini");
        text_Cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_Cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text_CariMouseClicked(evt);
            }
        });
        text_Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_CariKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-search-24.png"))); // NOI18N

        bt_Print.setText("PRINT");
        bt_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataPenjualanLayout = new javax.swing.GroupLayout(dataPenjualan);
        dataPenjualan.setLayout(dataPenjualanLayout);
        dataPenjualanLayout.setHorizontalGroup(
            dataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
            .addGroup(dataPenjualanLayout.createSequentialGroup()
                .addComponent(bt_Tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_Detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_Print)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
            .addComponent(jSeparator2)
            .addGroup(dataPenjualanLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPenjualanLayout.setVerticalGroup(
            dataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_Tambah)
                        .addComponent(bt_Detail)
                        .addComponent(bt_Print))
                    .addGroup(dataPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(text_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
        );

        mainPanel.add(dataPenjualan, "card2");

        tambahPenjualan.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bt_Simpan.setText("SIMPAN");
        bt_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SimpanActionPerformed(evt);
            }
        });

        bt_Batal.setText("BATAL");
        bt_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BatalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Transaksi");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi"));

        txtNoTransaksi.setText("No. Transaksi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNoTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Kasir"));

        txtNamaKasir.setText("Nama Kasir");

        txtId.setText("ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        lbTotalHarga.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbTotalHarga.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTotalHarga)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbTanggal.setText("Tanggal");

        lbHari.setText("Hari");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi"));

        txtIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdukActionPerformed(evt);
            }
        });
        txtIdProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProdukKeyReleased(evt);
            }
        });

        btProduk.setText("jButton1");
        btProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdukActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Produk");

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Produk");

        jLabel8.setText("Harga");

        jLabel10.setText("Stok");

        jLabel11.setText("Jumlah");

        tableDataSementara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataSementara.setRowHeight(30);
        tableDataSementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataSementaraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDataSementara);

        btPerbaruiSmt.setText("Perbarui");
        btPerbaruiSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPerbaruiSmtActionPerformed(evt);
            }
        });

        btHapusSmt.setText("Hapus");
        btHapusSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusSmtActionPerformed(evt);
            }
        });

        btBatalSmt.setText("Batal");
        btBatalSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalSmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtIdProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(135, 135, 135))
                            .addComponent(txtJumlah)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btPerbaruiSmt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btHapusSmt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBatalSmt)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProduk)
                    .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPerbaruiSmt)
                    .addComponent(btHapusSmt)
                    .addComponent(btBatalSmt))
                .addGap(79, 79, 79))
        );

        jLabel12.setText("Sub Total");

        jLabel13.setText("Diskon");

        jLabel14.setText("Total Harga");

        jLabel15.setText("Bayar");

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel16.setText("Kembali");

        txtPersen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersenActionPerformed(evt);
            }
        });

        jLabel17.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Batal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(39, 39, 39)
                        .addComponent(txtPersen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(txtDiskon)
                    .addComponent(txtSubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTanggal)
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbHari)
                    .addComponent(lbTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Simpan)
                    .addComponent(bt_Batal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 435, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPersen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6))
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout tambahPenjualanLayout = new javax.swing.GroupLayout(tambahPenjualan);
        tambahPenjualan.setLayout(tambahPenjualanLayout);
        tambahPenjualanLayout.setHorizontalGroup(
            tambahPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        tambahPenjualanLayout.setVerticalGroup(
            tambahPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );

        mainPanel.add(tambahPenjualan, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
        tambahData();
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void tbl_ProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProdukMouseClicked
        bt_Detail.setEnabled(true);
        bt_Print.setEnabled(true);
    }//GEN-LAST:event_tbl_ProdukMouseClicked

    private void bt_DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DetailActionPerformed
        detailPenjualan();
    }//GEN-LAST:event_bt_DetailActionPerformed

    private void text_CariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_CariMouseClicked
        text_Cari.setText("");
    }//GEN-LAST:event_text_CariMouseClicked

    private void bt_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SimpanActionPerformed
        try {
            simpanData();
        } catch (IOException ex) {
            Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_SimpanActionPerformed

    private void bt_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BatalActionPerformed
        showPanel();
        loadData();
//        loadDataSementara();
//        resetProduk();
    }//GEN-LAST:event_bt_BatalActionPerformed

    private void btHapusSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusSmtActionPerformed
        hapusDataSementara();
    }//GEN-LAST:event_btHapusSmtActionPerformed

    private void txtPersenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersenActionPerformed
        hitungPotongan();
    }//GEN-LAST:event_txtPersenActionPerformed

    private void text_CariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_CariKeyReleased
        pencarianData();
    }//GEN-LAST:event_text_CariKeyReleased

    private void txtIdProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProdukKeyReleased
        pencarianProduk();
    }//GEN-LAST:event_txtIdProdukKeyReleased

    private void btProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdukActionPerformed
        pencarianProdukFromDialog();
    }//GEN-LAST:event_btProdukActionPerformed

    private void tableDataSementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataSementaraMouseClicked
        dataTabelSementara();
    }//GEN-LAST:event_tableDataSementaraMouseClicked

    private void btPerbaruiSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPerbaruiSmtActionPerformed
        perbaruaiDataSementara();
    }//GEN-LAST:event_btPerbaruiSmtActionPerformed

    private void btBatalSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalSmtActionPerformed
        loadDataSementara();
        resetProduk();
    }//GEN-LAST:event_btBatalSmtActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        pembayaran();
    }//GEN-LAST:event_txtBayarActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        perbaruaiDataSementara();
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtIdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdukActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void bt_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PrintActionPerformed
        cetakNotaDataBase();
    }//GEN-LAST:event_bt_PrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatalSmt;
    private javax.swing.JButton btHapusSmt;
    private javax.swing.JButton btPerbaruiSmt;
    private javax.swing.JButton btProduk;
    private javax.swing.JButton bt_Batal;
    private javax.swing.JButton bt_Detail;
    private javax.swing.JButton bt_Print;
    private javax.swing.JButton bt_Simpan;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JPanel dataPenjualan;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbHari;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JLabel lbTotalHarga;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tableDataSementara;
    private javax.swing.JPanel tambahPenjualan;
    private javax.swing.JTable tbl_Produk;
    private javax.swing.JTextField text_Cari;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdProduk;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNamaKasir;
    private javax.swing.JTextField txtNamaProduk;
    private javax.swing.JTextField txtNoTransaksi;
    private javax.swing.JTextField txtPersen;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables

    private void aktif(){
        txtIdProduk.setEnabled(true);
        txtNamaProduk.setEnabled(true);
        txtHarga.setEnabled(true);
        txtStok.setEnabled(true);
        txtJumlah.setEnabled(true);
        
        btProduk.setEnabled(true);
        btPerbaruiSmt.setEnabled(true);
        btHapusSmt.setEnabled(true);
    }
    
    private void nonaktif(){
        txtNoTransaksi.setEditable(false);
        txtNamaKasir.setEditable(false);
   
        txtNamaProduk.setEditable(false);
        txtHarga.setEditable(false);
        txtStok.setEditable(false);
        txtJumlah.setEditable(false);
        
        btProduk.setEnabled(false);
        btPerbaruiSmt.setEnabled(false);
        btHapusSmt.setEnabled(false);
        btBatalSmt.setEnabled(false);
    }

    private void resetProduk() {
        txtIdProduk.setText("");
        txtNamaProduk.setText("");
        txtHarga.setText("");
        txtStok.setText("");
        txtJumlah.setText("");
    }
    
    private void resetPembayaran(){
        txtSubtotal.setText("");
        txtPersen.setText("");
        txtDiskon.setText("");
        txtTotalHarga.setText("");
        txtBayar.setText("");
        txtKembali.setText("");
        lbTotalHarga.setText("0");
        
    }
    
    private void tambahData() {
        mainPanel.removeAll();
        mainPanel.add(tambahPenjualan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void showPanel() {
        mainPanel.removeAll();
        mainPanel.add(dataPenjualan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }


    private void setLebarKolom() {
        TableColumnModel kolom = tbl_Produk.getColumnModel();
        kolom.getColumn(0).setPreferredWidth(50);
        kolom.getColumn(0).setMaxWidth(50);
        kolom.getColumn(0).setMinWidth(50);
        
        TableColumnModel kolom2 = tableDataSementara.getColumnModel();
        kolom.getColumn(0).setPreferredWidth(50);
        kolom.getColumn(0).setMaxWidth(50);
        kolom.getColumn(0).setMinWidth(50);
    }
    
    private void setTanggal(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance();
                Date now = new Date();
                SimpleDateFormat formatHari =new SimpleDateFormat("EEEE", new Locale("in","ID"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String hari = formatHari.format(calendar.getTime());
                String dateTime = dateFormat.format(now);
                lbHari.setText(hari+",");
                lbTanggal.setText(dateTime);
            }
        });
        
        timer.start();
    }

    private void loadData() {
        txtNoTransaksi.setText(servis.noTransaksi());
        bt_Detail.setEnabled(false);
        bt_Print.setEnabled(false);
        List<model_Penjualan> list = servis.tampilData();
        tblModelPen.setData(list);
        
    }

    private void loadDataSementara() {
        List<model_PenjualanSmt> list = servisSmt.tampilData();
        tblModelSmt.setData(list);
        
        txtDiskon.setText("0");
        nonaktif();
        txtIdProduk.requestFocus();
        txtIdProduk.setEnabled(true);
        btProduk.setEnabled(true);
        
    }

    private void pencarianData() {
        List<model_Penjualan> list = servis.pencarianData(text_Cari.getText());
        tblModelPen.setData(list);
    }

    private void detailPenjualan() {
        int row = tbl_Produk.getSelectedRow();
        String id = tbl_Produk.getValueAt(row, 1).toString();
        DataPenjualanDetail dataDetail = new DataPenjualanDetail(null, true, id);
        dataDetail.setVisible(true);
        loadData();
    }

    private void pencarianProduk() {
    List<model_Produk> list = servisProd.pencarian(txtIdProduk.getText());
    
    if (!list.isEmpty()) {
        model_Produk produk = list.get(0);
        
        boolean produkSudahAda = false;
        int jumlah = 1; // Tambahkan deklarasi
        Long harga = produk.getHarga_jual(); // Tambahkan deklarasi

        for (int i = 0; i < tblModelSmt.getRowCount(); i++) {
    System.out.println("Baris " + i + ": " + tblModelSmt.getData(i)); // Debug untuk melihat data pada baris tabel
    if (tblModelSmt.getData(i) != null) {
        System.out.println("ID Produk Tabel: " + tblModelSmt.getData(i).getModelProduk().getId_produk()); // Debug untuk ID
    }

    if (tblModelSmt.getData(i) != null &&
        tblModelSmt.getData(i).getModelProduk().getId_produk().equals(produk.getId_produk())) {
        produkSudahAda = true;
        updateJumlah(i, jumlah, harga);
        break;
    }
}

        
        if (!produkSudahAda) {
            int id = produk.getId_produk();
            String namaProduk = produk.getNama_produk();
            int stok = produk.getStok();
            double subTotal = harga * jumlah;
            
            model_PenjualanSmt smt = new model_PenjualanSmt();
            model_Produk pd = new model_Produk();
            model_PenjualanDetail det = new model_PenjualanDetail();
            
            pd.setId_produk(id);
            pd.setNama_produk(namaProduk);
            pd.setHarga_jual(harga);
            pd.setStok(stok);
            
            det.setJumlah(jumlah);
            det.setSubTotal(subTotal);
            
            smt.setModelProduk(pd);
            smt.setModelPenDet(det);
            
            servisSmt.tambahData(smt);
            servisDet.sumTotal(det);
            
            DecimalFormat df1 = new DecimalFormat("#,##0");
            DecimalFormat df2 = new DecimalFormat("#,##0.00");
            double jumlahSubTotal = det.getSubTotal();
            
            String totalNoDecimal = df1.format(jumlahSubTotal);
            String totalDecimal = df2.format(jumlahSubTotal);
                
            txtSubtotal.setText(String.valueOf(det.getSubTotal()));
            String total = txtSubtotal.getText();
            txtTotalHarga.setText(total);
            lbTotalHarga.setText("Rp. " + total);
            
            loadDataSementara();
            resetProduk();
        }
    }
}

    private void dataTabelSementara() {
    int row = tableDataSementara.getSelectedRow();
        
//        idProduk = Integer.valueOf(tableDataSementara.getValueAt(row, 1).toString());
        txtIdProduk.setText(tableDataSementara.getValueAt(row, 1).toString());
        txtNamaProduk.setText(tableDataSementara.getValueAt(row, 2).toString());
        txtHarga.setText(tableDataSementara.getValueAt(row, 3).toString());
        txtStok.setText(tableDataSementara.getValueAt(row, 4).toString());
        txtJumlah.setText(tableDataSementara.getValueAt(row, 5).toString());
        
        nonaktif();
        txtJumlah.setEditable(true);
        btPerbaruiSmt.setEnabled(true);
        btHapusSmt.setEnabled(true);
        btBatalSmt.setEnabled(true);
}
    
    
    private void updateJumlah(int rowIndex, int jumlah, Long harga) {
    // Ambil data detail dari baris yang diubah
    model_PenjualanDetail det = tblModelSmt.getData(rowIndex).getModelPenDet();
    
    // Update jumlah dan subtotal
    int jumlahLama = det.getJumlah();
    int jumlahBaru = jumlahLama + jumlah;
    double subTotalBaru = jumlahBaru * harga;
    
    // Set data yang baru
    det.setJumlah(jumlahBaru);
    det.setSubTotal(subTotalBaru);
    
    // Memperbarui model
    servisSmt.perbaruiData(tblModelSmt.getData(rowIndex));
    servisDet.sumTotal(det);

    // Panggil fireTableRowsUpdated untuk baris tertentu yang diubah
    tblModelSmt.fireTableRowsUpdated(rowIndex, rowIndex);

    // Segarkan seluruh tabel jika perlu
    tblModelSmt.fireTableDataChanged(); // Menyegarkan seluruh tabel
    
    // Atur total harga dan subtotal ke UI
    DecimalFormat df1 = new DecimalFormat("#,##0");
    DecimalFormat df2 = new DecimalFormat("#,##0.00");
    double jumlahSubTotal = det.getSubTotal();
                
    String totalNoDecimal = df1.format(jumlahSubTotal);
    String totalDecimal = df2.format(jumlahSubTotal);
                    
    txtSubtotal.setText(String.valueOf(det.getSubTotal()));
    String total = txtSubtotal.getText();
    txtTotalHarga.setText(total);
    lbTotalHarga.setText("Rp. " + total);
    
    // Update data lainnya atau reset produk jika perlu
    loadDataSementara();
    resetProduk();
}


    
    
    
    private void pencarianProdukFromDialog() {
    boolean closable = true;
    DataProduk modelForm = new DataProduk(null, closable);
    modelForm.setVisible(true);

    if (modelForm.modelDialog.getId_produk() != null) {
        int idProduk = modelForm.modelDialog.getId_produk();
        String namaProduk = modelForm.modelDialog.getNama_produk();
        long harga = modelForm.modelDialog.getHarga_jual();
        int stok = modelForm.modelDialog.getStok();
        int jumlah = 1; // Jumlah default untuk penambahan pertama
        double subTotal = harga * jumlah;

        boolean produkSudahAda = false;

        // Periksa apakah produk sudah ada di tabel sementara
        for (int i = 0; i < tblModelSmt.getRowCount(); i++) {
            if (tblModelSmt.getData(i).getModelProduk().getId_produk().equals(idProduk)) {
                produkSudahAda = true;

                // Tambahkan jumlah jika produk sudah ada
                int jumlahLama = tblModelSmt.getData(i).getModelPenDet().getJumlah();
                int jumlahBaru = jumlahLama + jumlah;
                double subTotalBaru = harga * jumlahBaru;

                tblModelSmt.getData(i).getModelPenDet().setJumlah(jumlahBaru);
                tblModelSmt.getData(i).getModelPenDet().setSubTotal(subTotalBaru);

                loadDataSementara();
                return;
            }
        }

        // Tambahkan produk baru jika belum ada
        if (!produkSudahAda) {
            model_PenjualanSmt smt = new model_PenjualanSmt();
            model_Produk pd = new model_Produk();
            model_PenjualanDetail det = new model_PenjualanDetail();

            pd.setId_produk(idProduk);
            pd.setNama_produk(namaProduk);
            pd.setHarga_jual(harga);
            pd.setStok(stok);

            det.setJumlah(jumlah);
            det.setSubTotal(subTotal);

            smt.setModelProduk(pd);
            smt.setModelPenDet(det);

            servisSmt.tambahData(smt);
            servisDet.sumTotal(det);
            
            DecimalFormat df1 = new DecimalFormat("#,##0");
            DecimalFormat df2 = new DecimalFormat("#,##0.00");
            double jumlahSubTotal = det.getSubTotal();
            
            String totalNoDecimal = df1.format(jumlahSubTotal);
            String totalDecimal = df2.format(jumlahSubTotal);
                
            txtSubtotal.setText(String.valueOf(det.getSubTotal()));
            String total = txtSubtotal.getText();
            txtTotalHarga.setText(total);
            lbTotalHarga.setText("Rp. " + total);
            
            loadDataSementara();
            resetProduk();


            loadDataSementara();
        }
    }
}

    private void perbaruaiDataSementara() {
        if(!txtJumlah.getText().equals("")){
            int id              = Integer.valueOf(txtIdProduk.getText());
            String namaProduk   = txtNamaProduk.getText();
            long harga          = Long.valueOf(txtHarga.getText());
            int stok            = Integer.valueOf(txtStok.getText());
            int jumlah          = Integer.valueOf(txtJumlah.getText());
            double subTotal     = harga * jumlah;
            
            model_PenjualanSmt smt      = new model_PenjualanSmt();
            model_Produk pd             = new model_Produk();
            model_PenjualanDetail det   = new model_PenjualanDetail();
                
            pd.setId_produk(id);
            pd.setNama_produk(namaProduk);
            pd.setHarga_jual(harga);
            pd.setStok(stok);
                
            det.setJumlah(jumlah);
            det.setSubTotal(subTotal);
                
            smt.setModelProduk(pd);
            smt.setModelPenDet(det);
                
            servisSmt.perbaruiData(smt);
            servisDet.sumTotal(det);
            servisDet.sumJumlah(det);
            TotalJumlah = det.getJumlah();
                
            txtSubtotal.setText(String.valueOf(det.getSubTotal()));
            String total = txtSubtotal.getText();
            txtTotalHarga.setText(total);
            lbTotalHarga.setText("Rp. " + total);
                
            loadDataSementara();
            resetProduk();
            txtIdProduk.setEnabled(true);
            btProduk.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong !");
        }
    }

    private void hapusDataSementara() {
        int row = tableDataSementara.getSelectedRow();
        if(row != -1){
            model_PenjualanSmt model = tblModelSmt.getData(row);
            if(JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus ?", 
                    "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
            {
                servisSmt.hapusData(model);
                tblModelSmt.hapusData(row);
                loadDataSementara();
                resetProduk();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu data yang akan dihapus");
        }
    }

    private void simpanData() throws IOException {
    if (validasiSimpan()) {
        // Ambil data dari input pengguna
        int idUser = Integer.parseInt(txtId.getText());
        String idPenjualan = txtNoTransaksi.getText();
        String tanggal = lbTanggal.getText();
        double total = Double.parseDouble(txtTotalHarga.getText());
        double diskon = Double.parseDouble(txtDiskon.getText());
        double bayar = Double.parseDouble(txtBayar.getText());
        double kembali = Double.parseDouble(txtKembali.getText());
        String nama = txtNamaKasir.getText();

        // Inisialisasi model
        model_Penjualan modelPen = new model_Penjualan();
        model_Produk modelPro = new model_Produk();
        model_User modelKar = new model_User();
        model_PenjualanDetail modelDet = new model_PenjualanDetail();

        // Set data ke model penjualan
        modelPen.setIdPenjualan(idPenjualan);
        modelPen.setTanggal(tanggal);
        modelPen.setTotalJumlah(TotalJumlah);
        modelPen.setTotalHarga(total);
        modelPen.setBayar(bayar);
        modelPen.setDiskon(diskon);
        modelPen.setKembali(kembali);

        // Set pengguna ke model penjualan
        modelKar.setId_pengguna(idUser);
        modelPen.setModelUser(modelKar);

        // Set data ke model penjualan detail
        modelDet.setModelPenjualan(modelPen);
        modelDet.setModelProduk(modelPro);

        try {
            // Simpan data ke database
            servis.tambahData(modelPen);
            servisDet.tambahData(modelDet);

            // Cetak nota
            cetakNotaPdf(idPenjualan, tanggal, nama, total, diskon, bayar, kembali);

            // Kurangi stok produk berdasarkan jumlah terjual
            if (tblModelSmt.getRowCount() > 0) {
                for (int i = 0; i < tblModelSmt.getRowCount(); i++) {
                    int idPro = Integer.parseInt(tblModelSmt.getValueAt(i, 1).toString()); // ID Produk
                    int jumlahTerjual = Integer.parseInt(tblModelSmt.getValueAt(i, 5).toString()); // Jumlah terjual
                    kurangiStokProduk(idPro, jumlahTerjual);
                }
            }

            // Hapus data sementara di database
            servisDet.hapusDataSementara();

            // Perbarui tabel dan reset form
            tblModelPen.tambahData(modelPen);
            showPanel();
            loadData();
            loadDataSementara();
            resetProduk();
            resetPembayaran();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format angka salah: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan IO: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan tidak terduga: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Validasi data gagal. Harap periksa input Anda.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}

    
    private void kurangiStokProduk(int idpro, int jumlahTerjual) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;

    try {
        // Mendapatkan koneksi dari database
        conn = databasekoneksi.getConnection();

        if (conn != null) {
            // Query untuk mengurangi stok
            String query = "UPDATE produk SET stok = stok - ? WHERE ID = ? AND stok >= ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, jumlahTerjual);
            stmt.setInt(2, idpro);
            stmt.setInt(3, jumlahTerjual);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("Stok produk tidak mencukupi untuk ID: " + idpro);
            } else {
                System.out.println("Stok produk berhasil diperbarui untuk ID: " + idpro);
            }
        }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat mengupdate stok: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Kesalahan saat menutup koneksi: " + e.getMessage());
            }
        }
    }


    private boolean validasiSimpan() {
        boolean valid = false;
        if (txtTotalHarga.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Total harga tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }

    private void pembayaran() {
        try {
            String totalStr = txtTotalHarga.getText().replaceAll("[^\\d.]", "");
            double total = Double.parseDouble(totalStr);
            double bayar = Double.parseDouble(txtBayar.getText());
            double kembali = bayar - total;
            
            txtKembali.setText(String.format("%.0f", kembali));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukan nominal pembayaran yang valid");
        }
    }

    private void hitungPotongan() {
        try {
            double subtotal = Double.parseDouble(txtSubtotal.getText());
            int diskon = Integer.parseInt(txtPersen.getText());
            double hasilDiskon = subtotal * (diskon / 100.0);
            double total = subtotal - hasilDiskon;
            
            txtDiskon.setText(String.valueOf(hasilDiskon));
            txtTotalHarga.setText(String.valueOf(total));
            
            String totalHarga = txtTotalHarga.getText();
            lbTotalHarga.setText("Rp. " + totalHarga);
            txtBayar.requestFocus();
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukan angka yang valid untuk diskon");
        }
    }
    
    public void cetakNotaPdf(String idPenjualan, String tanggal, String namaKasir,
                                       double total, double diskon, double bayar, double kembali) {
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin mencetak nota?", 
                        "Konfirmasi Cetak Nota", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
        // Mendapatkan path folder Downloads
        String downloadsPath = System.getProperty("user.home") + File.separator + "Downloads";
        String fileName = downloadsPath + File.separator + "Nota_" + idPenjualan + ".pdf";

        // Tambahkan timestamp jika file sudah ada
        File file = new File(fileName);
        if (file.exists()) {
            fileName = downloadsPath + File.separator + "Nota_" + idPenjualan + "_" + System.currentTimeMillis() + ".pdf";
        }

            try {
                // Membuat dokumen PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(fileName));
                document.open();

                // Font untuk header dan isi
                Font headerFont = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);
                Font bodyFont = new Font(Font.FontFamily.COURIER, 12);
                Font columnFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

                // Header Nota
                Paragraph header = new Paragraph("NOTA PENJUALAN", headerFont);
                header.setAlignment(Element.ALIGN_CENTER);
                document.add(header);
                document.add(new Paragraph("========================================\n", bodyFont));

                // Informasi Penjualan
                document.add(new Paragraph("ID Penjualan : " + idPenjualan, bodyFont));
                document.add(new Paragraph("Tanggal      : " + tanggal, bodyFont));
                document.add(new Paragraph("Nama Kasir   : " + namaKasir, bodyFont));
                document.add(new Paragraph("\n"));

                // Daftar Barang
                Paragraph columnHeader = new Paragraph();
                columnHeader.add(new Chunk(String.format("%-20s", "Nama Produk"), columnFont));
                columnHeader.add(new Chunk(String.format("%-10s", "Jumlah"), columnFont));
                columnHeader.add(new Chunk(String.format("%-15s", "Subtotal"), columnFont));
                document.add(columnHeader);

                // Garis pemisah
                document.add(new Paragraph("--------------------------------------------------"));

                // Daftar Produk
                if (tblModelSmt.getRowCount() > 0) {
                    for (int i = 0; i < tblModelSmt.getRowCount(); i++) {
                        String namaProduk = tblModelSmt.getValueAt(i, 2).toString();
                        String jumlah = tblModelSmt.getValueAt(i, 5).toString();
                        String subtotal = tblModelSmt.getValueAt(i, 6).toString();

                        Paragraph item = new Paragraph();
                        item.add(new Chunk(String.format("%-20s", namaProduk), bodyFont));
                        item.add(new Chunk(String.format("%-10s", jumlah), bodyFont));
                        item.add(new Chunk(String.format("%-15s", subtotal), bodyFont));

                        document.add(item);
                    }
                } else {
                    document.add(new Paragraph("Data barang tidak ditemukan.", bodyFont));
                }
                document.add(new Paragraph("\n"));

                // Rincian Pembayaran
                document.add(new Paragraph("Total Harga : Rp " + String.format("%.2f", total), bodyFont));
                document.add(new Paragraph("Diskon      : Rp " + String.format("%.2f", diskon), bodyFont));
                document.add(new Paragraph("Bayar       : Rp " + String.format("%.2f", bayar), bodyFont));
                document.add(new Paragraph("Kembali     : Rp " + String.format("%.2f", kembali), bodyFont));
                document.add(new Paragraph("\n"));

                // Footer
                Paragraph footer = new Paragraph("Terima Kasih Telah Berbelanja!", headerFont);
                footer.setAlignment(Element.ALIGN_CENTER);
                document.add(footer);
                document.add(new Paragraph("========================================", bodyFont));

                document.close();
                JOptionPane.showMessageDialog(null, "Nota berhasil dicetak: " + fileName, 
                                              "Cetak Nota", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mencetak nota: " + e.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cetak nota dibatalkan.", 
                                          "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

        public void cetakNotaDataBase() {
        int row = tbl_Produk.getSelectedRow();
        String idPenjualan = tbl_Produk.getValueAt(row, 1).toString();
        String namaKasir = tbl_Produk.getValueAt(row, 8).toString();
        double bayar = Double.parseDouble(tbl_Produk.getValueAt(row, 4).toString());
        double diskon = Double.parseDouble(tbl_Produk.getValueAt(row, 5).toString());
        double kembali = Double.parseDouble(tbl_Produk.getValueAt(row, 6).toString());
        // Nama file PDF
        // Mendapatkan path folder Downloads
        String downloadsPath = System.getProperty("user.home") + File.separator + "Downloads";
        String fileName = downloadsPath + File.separator + "Nota_" + idPenjualan + ".pdf";

        // Tambahkan timestamp jika file sudah ada
        File file = new File(fileName);
        if (file.exists()) {
            fileName = downloadsPath + File.separator + "Nota_" + idPenjualan + "_" + System.currentTimeMillis() + ".pdf";
        }

        try (Connection conn = databasekoneksi.getConnection()) {
            // Query untuk mendapatkan data penjualan detail
            String sql = """
                SELECT pj.id_penjualan, pj.tanggal, 
                       pd.nama_produk, pd.harga_jual, det.jumlah, det.subtotal
                FROM penjualan_detail det
                INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan
                INNER JOIN produk pd ON pd.ID = det.id_produk
                WHERE pj.id_penjualan = ?
            """;

            // Eksekusi query
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, idPenjualan);
            ResultSet rs = ps.executeQuery();

            // Membuat dokumen PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Font
            Font headerFont = new Font(Font.FontFamily.COURIER, 14, Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.COURIER, 12);

            // Header Nota
            Paragraph header = new Paragraph("NOTA PENJUALAN", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Paragraph("========================================\n", bodyFont));

            // Informasi Umum
            String tanggal = "";
            if (rs.next()) {  // Ambil informasi dari baris pertama
                idPenjualan = rs.getString("id_penjualan");
                tanggal = rs.getString("tanggal");

                document.add(new Paragraph("ID Transaksi: " + idPenjualan, bodyFont));
                document.add(new Paragraph("Tanggal     : " + tanggal, bodyFont));
                document.add(new Paragraph("Kasir       : " + namaKasir, bodyFont));
                document.add(new Paragraph("========================================", bodyFont));
            }

            // Daftar Barang
            document.add(new Paragraph("Daftar Produk:\n", headerFont));
            rs.beforeFirst();  // Kembali ke awal ResultSet
            int nomor = 1;
            double totalHarga = 0;

            while (rs.next()) {
                String namaProduk = rs.getString("nama_produk");
                double hargaJual = rs.getDouble("harga_jual");
                int jumlah = rs.getInt("jumlah");
                double subtotal = rs.getDouble("subtotal");

                // Format produk
                document.add(new Paragraph(String.format("%d. %-20s Rp %-10.2f x %d = Rp %-10.2f", 
                        nomor++, namaProduk, hargaJual, jumlah, subtotal), bodyFont));
                totalHarga += subtotal;
            }

            document.add(new Paragraph("========================================", bodyFont));

            // Rincian Pembayaran
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Total Harga : Rp " + String.format("%.2f", totalHarga), bodyFont));
            document.add(new Paragraph("Diskon      : Rp " + String.format("%.2f", diskon), bodyFont));
            document.add(new Paragraph("Bayar       : Rp " + String.format("%.2f", bayar), bodyFont));
            document.add(new Paragraph("Kembali     : Rp " + String.format("%.2f", kembali), bodyFont));
            document.add(new Paragraph("\n"));

            // Footer
            Paragraph footer = new Paragraph("Terima Kasih Telah Berbelanja!", headerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);
            document.add(new Paragraph("========================================", bodyFont));

            document.close();
            System.out.println("Nota berhasil dicetak: " + fileName);

            // Dialog untuk melihat file
            int pilih = JOptionPane.showConfirmDialog(null, 
                "Nota berhasil dicetak: " + fileName + "\nApakah Anda ingin membukanya sekarang?", 
                "Cetak Nota", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

            if (pilih == JOptionPane.YES_OPTION) {
                // Buka file PDF
                Desktop.getDesktop().open(new File(fileName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        
}
