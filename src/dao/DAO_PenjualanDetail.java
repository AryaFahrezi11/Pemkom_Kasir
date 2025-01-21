
package dao;

import apkkasir.databasekoneksi;
import apkkasir.fungsi;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.model_PenjualanDetail;
import model.model_Penjualan;
import service.service_PenjualanDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.model_Produk;

public class DAO_PenjualanDetail implements service_PenjualanDetail{
    
    private Connection conn;
    
    public DAO_PenjualanDetail(){
        conn = databasekoneksi.getConnection();
    }

    @Override
    public void tambahData(model_PenjualanDetail mopdet) {
        PreparedStatement st = null;
        try {
            String sql ="INSERT INTO penjualan_detail (id_penjualan, id_produk, jumlah, subtotal) SELECT '"+mopdet.getModelPenjualan().getIdPenjualan()+"',id_produk, jumlah, subtotal from penjualan_smt";
            
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            st.close();
//            fungsi.savelog("Produk berhasil ditambahkan: " + mopdet.getIdPenjualan() + " dengan ID " + mopdet.getId_produk());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void sumTotal(model_PenjualanDetail mopdet) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql ="SELECT SUM(subtotal) FROM penjualan_smt";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mopdet.setSubTotal(rs.getLong(1));
            }
//            fungsi.savelog("Produk berhasil ditambahkan: " + mopdet.getIdPenjualan() + " dengan ID " + mopdet.getId_produk());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void sumJumlah(model_PenjualanDetail mopdet) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql ="SELECT SUM(jumlah) FROM penjualan_smt";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mopdet.setJumlah(rs.getInt(1));
            }
//            fungsi.savelog("Produk berhasil ditambahkan: " + mopdet.getIdPenjualan() + " dengan ID " + mopdet.getId_produk());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void hapusDataSementara() {
        PreparedStatement st = null;
        String sql ="DELETE FROM penjualan_smt";
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
//            fungsi.savelog("Produk berhasil ditambahkan: " + mopdet.getIdPenjualan() + " dengan ID " + mopdet.getId_produk());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public List<model_PenjualanDetail> tampilData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="""
                    SELECT pj.id_penjualan, det.id_produk, pd.nama_produk, pd.harga_jual, det.jumlah, det.subtotal
                    FROM penjualan_detail det
                    INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan
                    INNER JOIN produk pd ON pd.ID = det.id_produk
                    WHERE pj.id_penjualan='"""+id+"'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_PenjualanDetail det = new model_PenjualanDetail();
                model_Penjualan pj = new model_Penjualan();
                model_Produk pd = new model_Produk();
                
                pj.setIdPenjualan    (rs.getString ("id_penjualan"));
                pd.setId_produk      (rs.getInt    ("id_produk"));
                pd.setNama_produk    (rs.getString ("nama_produk"));
                pd.setHarga_jual     (rs.getLong    ("harga_jual"));
                det.setJumlah        (rs.getInt    ("jumlah"));
                det.setSubTotal      (rs.getLong   ("subtotal"));
                
                det.setModelPenjualan(pj);
                det.setModelProduk(pd);
                
                list.add(det);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<model_PenjualanDetail> pencarianData(String id, String kataKunci) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="""
                    SELECT pj.id_penjualan, det.id_produk, pd.nama_produk, pd.harga_jual, det.jumlah, det.subtotal
                    FROM penjualan_detail det
                    INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan
                    INNER JOIN produk pd ON pd.ID = det.id_produk
                    WHERE pj.id_penjualan='"""+id+"' AND (pj.id_penjualan LIKE '%"+kataKunci+"%' "
                + "OR det.id_produk LIKE '%"+kataKunci+"%'"
                + "OR pd.nama_produk LIKE '%"+kataKunci+"%')";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_PenjualanDetail det = new model_PenjualanDetail();
                model_Penjualan pj = new model_Penjualan();
                model_Produk pd = new model_Produk();
                
                pj.setIdPenjualan    (rs.getString ("id_penjualan"));
                pd.setId_produk      (rs.getInt    ("id_produk"));
                pd.setNama_produk    (rs.getString ("nama_produk"));
                pd.setHarga_jual     (rs.getLong    ("harga_jual"));
                det.setJumlah        (rs.getInt    ("jumlah"));
                det.setSubTotal      (rs.getLong   ("subtotal"));
                
                det.setModelPenjualan(pj);
                det.setModelProduk(pd);
                
                list.add(det);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
