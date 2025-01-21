
package dao;

import apkkasir.databasekoneksi;
import apkkasir.fungsi;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.util.List;
import model.model_PenjualanSmt;
import model.model_Produk;
import service.service_PenjualanSmt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.model_Penjualan;
import model.model_PenjualanDetail;

public class DAO_PenjualanSmt implements service_PenjualanSmt{
    
    private Connection conn;
    
    public DAO_PenjualanSmt(){
        conn = databasekoneksi.getConnection();
    }

    @Override
    public void tambahData(model_PenjualanSmt mopsmt) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO penjualan_smt(id_produk, nama_produk, harga, stok, jumlah, subtotal) VALUES (?,?,?,?,?,?)";
            
            st = conn.prepareStatement(sql);
            
            st.setInt       (1, mopsmt.getModelProduk().getId_produk());
            st.setString    (2, mopsmt.getModelProduk().getNama_produk());
            st.setLong      (3, mopsmt.getModelProduk().getHarga_jual());
            st.setInt       (4, mopsmt.getModelProduk().getStok());
            st.setInt       (5, mopsmt.getModelPenDet().getJumlah());
            st.setDouble    (6, mopsmt.getModelPenDet().getSubTotal());
            
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void perbaruiData(model_PenjualanSmt mopsmt) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE penjualan_smt SET nama_produk=?, harga=?, stok=?, jumlah=?, subtotal=? WHERE id_produk=?";
            
            st = conn.prepareStatement(sql);
            
            
            st.setString    (1, mopsmt.getModelProduk().getNama_produk());
            st.setLong      (2, mopsmt.getModelProduk().getHarga_jual());
            st.setInt       (3, mopsmt.getModelProduk().getStok());
            st.setInt       (4, mopsmt.getModelPenDet().getJumlah());
            st.setDouble    (5, mopsmt.getModelPenDet().getSubTotal());
            st.setInt       (6, mopsmt.getModelProduk().getId_produk());
            
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(model_PenjualanSmt mopsmt) {
        PreparedStatement st = null;
        try {
            String sql = "DELETE FROM penjualan_smt WHERE id_produk=? AND nama_produk=? AND harga=? AND stok=? AND jumlah=? AND subtotal=?";
            
            st = conn.prepareStatement(sql);
            
            
            
            st.setInt       (1, mopsmt.getModelProduk().getId_produk());
            st.setString    (2, mopsmt.getModelProduk().getNama_produk());
            st.setLong      (3, mopsmt.getModelProduk().getHarga_jual());
            st.setInt       (4, mopsmt.getModelProduk().getStok());
            st.setInt       (5, mopsmt.getModelPenDet().getJumlah());
            st.setDouble    (6, mopsmt.getModelPenDet().getSubTotal());
            
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<model_PenjualanSmt> tampilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM penjualan_smt";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_PenjualanSmt smt = new model_PenjualanSmt();
                model_Produk pd = new model_Produk();
                model_PenjualanDetail det = new model_PenjualanDetail();
                
                pd.setId_produk     (rs.getInt("id_produk"));
                pd.setNama_produk   (rs.getString("nama_produk"));
                pd.setHarga_jual    (rs.getLong("harga"));
                pd.setStok          (rs.getInt("stok"));
                
                det.setJumlah(rs.getInt("jumlah"));
                det.setSubTotal(rs.getLong("subtotal"));
                
                smt.setModelPenDet(det);
                smt.setModelProduk(pd);
                
                list.add(smt);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    

}
