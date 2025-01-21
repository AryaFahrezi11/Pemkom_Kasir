/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package apkkasir;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aryam
 */
public class formlaporanPenjualanKasir extends javax.swing.JPanel {

    private DefaultTableModel model;
    public formlaporanPenjualanKasir() {
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
        
        loadKasir();
    }
    
    public void Nonaktif(){
        cb_kasir.setEnabled(true);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        btn_lihat = new javax.swing.JButton();
        txt_pendapatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb_kasir = new javax.swing.JComboBox<>();
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

        btn_lihat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_lihat.setText("Lihat");
        btn_lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lihatActionPerformed(evt);
            }
        });

        txt_pendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pendapatanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Pendapatan");

        cb_kasir.setModel(cb_kasir.getModel());
        cb_kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kasirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Laporan Transaksi Kasir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_lihat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_lihat, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihatActionPerformed
    model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        String selectedKasir = cb_kasir.getSelectedItem().toString();
        String idKasir = selectedKasir.split(" - ")[0];

        try {
            java.sql.Connection c = databasekoneksi.getConnection();
            String sql = "SELECT * FROM penjualan WHERE id_user = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, idKasir);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)
                });
            }
            tabel_transaksi.setModel(model);
            TotalBiaya();
        } catch (Exception e) {
            System.out.println("Cari Data Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_lihatActionPerformed

    private void cb_kasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_kasirActionPerformed

    private void txt_pendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pendapatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pendapatanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lihat;
    private javax.swing.JComboBox<String> cb_kasir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField txt_pendapatan;
    // End of variables declaration//GEN-END:variables

    private void loadKasir() {
        try {
            java.sql.Connection c = databasekoneksi.getConnection();
            String sql = "SELECT id_user, fullname FROM user";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cb_kasir.addItem(rs.getString("id_user") + " - " + rs.getString("fullname"));
            }
        } catch (Exception e) {
            System.out.println("Error Load Kasir: " + e.getMessage());
        }
    }
}
