/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package apkkasir;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aryam
 */
public class formlaporan extends javax.swing.JPanel {

    private DefaultTableModel model;
    public formlaporan() {
        initComponents();
        
        Nonaktif();

        model = new DefaultTableModel();
        tabel_transaksi.setModel(model);

        model.addColumn("ID Transaksi");
        model.addColumn("Tanggal");
        model.addColumn("Total Harga");
        model.addColumn("Bayar");
        model.addColumn("Diskon");
        model.addColumn("Kembali");
        model.addColumn("ID Kasir");
        model.addColumn("Nama Kasir");
    }
    
    public void Nonaktif(){
        jc_tanggal.setEnabled(false);
        jc_daritanggal1.setEnabled(false);
        jc_daritanggal2.setEnabled(false);
        btn_lihat.setEnabled(false);
        btn_caritanggal.setEnabled(false);
    }
    
    public void TotalBiaya(){
        int jumahBaris = tabel_transaksi.getRowCount();
        double totalBiaya = 0;
        double total;
        for(int i = 0; i < jumahBaris; i++){
            total = Double.parseDouble(tabel_transaksi.getValueAt(i, 2).toString());
            totalBiaya = totalBiaya + total;
        }
        txt_pendapatan.setText(String.valueOf("RP."+totalBiaya+",-"));
    }
    
    @SuppressWarnings("un0checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        rd_tanggal = new javax.swing.JRadioButton();
        rd_daritanggal = new javax.swing.JRadioButton();
        jc_tanggal = new com.toedter.calendar.JDateChooser();
        btn_lihat = new javax.swing.JButton();
        jc_daritanggal1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jc_daritanggal2 = new com.toedter.calendar.JDateChooser();
        btn_caritanggal = new javax.swing.JButton();
        txt_pendapatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_transaksi.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tabel_transaksi);

        rd_tanggal.setText("Tanggal");
        rd_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_tanggalActionPerformed(evt);
            }
        });

        rd_daritanggal.setText("Dari Tanggal");
        rd_daritanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_daritanggalActionPerformed(evt);
            }
        });

        btn_lihat.setText("Lihat");
        btn_lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lihatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("S/D");

        btn_caritanggal.setText("Lihat");
        btn_caritanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caritanggalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Pendapatan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Laporan Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 246, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_tanggal)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jc_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_lihat)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_daritanggal)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jc_daritanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jc_daritanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_caritanggal)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_tanggal)
                            .addComponent(rd_daritanggal))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_lihat)
                            .addComponent(jc_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jc_daritanggal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jc_daritanggal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_caritanggal))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihatActionPerformed
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();

    SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
    String date = sDate.format(jc_tanggal.getDate());
//    PreparedStatement st = null;
//    ResultSet rs = null;
    
    try {
        java.sql.Connection c = databasekoneksi.getConnection();
        String sql = """
                     SELECT pj.id_penjualan, pj.tanggal, pj.total_jumlah, pj.total_harga, pj.bayar, pj.diskon, pj.kembali, us.id_user, us.fullname
                     FROM penjualan pj
                     INNER JOIN user us ON us.id_user = pj.id_user
                     WHERE pj.tanggal = '"""+date+"'";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
//        rs = st.executeQuery();a

        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getString(1),
                rs.getString(2),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
            });
        }
        tabel_transaksi.setModel(model);
        TotalBiaya();
    } catch (Exception e) {
            System.out.println("Cari Data Error: " + e.getMessage());
        }finally{
            jc_daritanggal1.setDate(null);
            jc_daritanggal2.setDate(null);
        }
    }//GEN-LAST:event_btn_lihatActionPerformed

    private void rd_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_tanggalActionPerformed
        jc_tanggal.setEnabled(true);
        jc_daritanggal1.setEnabled(false);
        jc_daritanggal2.setEnabled(false);
        btn_lihat.setEnabled(true);
        btn_caritanggal.setEnabled(false);
    }//GEN-LAST:event_rd_tanggalActionPerformed

    private void rd_daritanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_daritanggalActionPerformed
        jc_tanggal.setEnabled(false);
        jc_daritanggal1.setEnabled(true);
        jc_daritanggal2.setEnabled(true);
        btn_lihat.setEnabled(false);
        btn_caritanggal.setEnabled(true);
    }//GEN-LAST:event_rd_daritanggalActionPerformed

    private void btn_caritanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caritanggalActionPerformed
        model.getDataVector().removeAllElements();
    model.fireTableDataChanged();

    SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
    String date1 = sDate.format(jc_daritanggal1.getDate());
    String date2 = sDate.format(jc_daritanggal2.getDate());

    try (java.sql.Connection c = databasekoneksi.getConnection();
         PreparedStatement pst = c.prepareStatement(
            "SELECT pj.id_penjualan, pj.tanggal, pj.total_jumlah, pj.total_harga, pj.bayar, pj.diskon, pj.kembali, us.id_user, us.fullname "
            + "FROM penjualan pj "
            + "INNER JOIN user us ON us.id_user = pj.id_user "
            + "WHERE pj.tanggal BETWEEN ? AND ?")) {

        pst.setString(1, date1); // Mengisi parameter pertama dengan date1
        pst.setString(2, date2); // Mengisi parameter kedua dengan date2
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                });
            }
        }
        tabel_transaksi.setModel(model);
        TotalBiaya();
    } catch (Exception e) {
        System.out.println("Cari Data Error: " + e.getMessage());
    } finally {
        jc_daritanggal1.setDate(null);
        jc_daritanggal2.setDate(null);
    }
    }//GEN-LAST:event_btn_caritanggalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_caritanggal;
    private javax.swing.JButton btn_lihat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jc_daritanggal1;
    private com.toedter.calendar.JDateChooser jc_daritanggal2;
    private com.toedter.calendar.JDateChooser jc_tanggal;
    private javax.swing.JRadioButton rd_daritanggal;
    private javax.swing.JRadioButton rd_tanggal;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField txt_pendapatan;
    // End of variables declaration//GEN-END:variables
}
