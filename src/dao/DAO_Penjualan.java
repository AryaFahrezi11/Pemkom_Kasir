
package dao;

import apkkasir.databasekoneksi;
import apkkasir.fungsi;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import model.model_Penjualan;
import service.service_Penjualan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.model_User;

public class DAO_Penjualan implements service_Penjualan{
    
    private Connection conn;
    
    public DAO_Penjualan(){
        conn = databasekoneksi.getConnection();
    }

    @Override
    public void tambahData(model_Penjualan mopen) {
        PreparedStatement st = null;
        String sql = "INSERT INTO penjualan (id_penjualan, tanggal, total_jumlah, total_harga, bayar, diskon, kembali, id_user) VALUES (?,?,?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString    (1, mopen.getIdPenjualan());
            st.setString    (2, mopen.getTanggal());
            st.setInt       (3, mopen.getTotalJumlah());
            st.setDouble    (4, mopen.getTotalHarga());
            st.setDouble    (5, mopen.getBayar());
            st.setDouble    (6, mopen.getDiskon());
            st.setDouble    (7, mopen.getKembali());
            st.setInt       (8, mopen.getModelUser().getId_pengguna());
            
            st.executeUpdate();
            st.close();
//            fungsi.savelog("Produk berhasil ditambahkan: " + mopen.getIdPenjualan() + " dengan ID " + mopen.getId_produk());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<model_Penjualan> tampilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="""
                    SELECT pj.id_penjualan, pj.tanggal, pj.total_jumlah, pj.total_harga, pj.bayar, pj.diskon, pj.kembali, us.id_user, us.fullname
                    FROM penjualan pj
                    INNER JOIN user us ON us.id_user = pj.id_user""";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_Penjualan pj = new model_Penjualan();
                model_User us = new model_User();
                
                pj.setIdPenjualan    (rs.getString ("id_penjualan"));
                pj.setTanggal        (rs.getString ("tanggal"));
                pj.setTotalJumlah    (rs.getInt ("total_jumlah"));
                pj.setTotalHarga     (rs.getDouble ("total_harga"));
                pj.setBayar          (rs.getDouble ("bayar"));
                pj.setDiskon         (rs.getDouble ("diskon"));
                pj.setKembali        (rs.getDouble ("kembali"));
                us.setId_pengguna    (rs.getInt    ("id_user"));
                us.setFullname       (rs.getString ("fullname"));
                
                pj.setModelUser(us);
                
                list.add(pj);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<model_Penjualan> pencarianData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="""
                    SELECT pj.id_penjualan, pj.tanggal, pj.total_jumlah, pj.total_harga, pj.bayar, pj.diskon, pj.kembali, us.id_user, us.fullname
                    FROM penjualan pj
                    INNER JOIN user us ON us.id_user = pj.id_user
                    WHERE pj.id_penjualan LIKE '%"""+id+"%'"
                   + "OR pj.tanggal LIKE '%"+id+"%'"
                   + "OR us.id_user LIKE '%"+id+"%'"
                   + "OR us.fullname LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_Penjualan pj = new model_Penjualan();
                model_User us = new model_User();
                
                pj.setIdPenjualan    (rs.getString ("id_penjualan"));
                pj.setTanggal        (rs.getString ("tanggal"));
                pj.setTotalJumlah    (rs.getInt ("total_jumlah"));
                pj.setTotalHarga     (rs.getDouble ("total_harga"));
                pj.setBayar          (rs.getDouble ("bayar"));
                pj.setDiskon         (rs.getDouble ("diskon"));
                pj.setKembali        (rs.getDouble ("kembali"));
                us.setId_pengguna    (rs.getInt    ("id_user"));
                us.setFullname       (rs.getString ("fullname"));
                
                pj.setModelUser(us);
                
                list.add(pj);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String noTransaksi() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
        
        String sql = "SELECT RIGHT(id_penjualan, 3) AS Nomor " +
                     "FROM penjualan " +
                     "WHERE id_penjualan LIKE 'TRS" + no + "%' " +
                     "ORDER BY id_penjualan DESC " +
                     "LIMIT 1";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "TRS" + no + String.format("%03d", nomor);
            }else {
                urutan = "TRS" + no + "001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return urutan;
    }

}
