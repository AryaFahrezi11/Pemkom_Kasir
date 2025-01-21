package service;

import java.util.List;
import model.model_PenjualanSmt;
import model.model_Produk;

public interface service_Produk {
    
    void kurangiStok(model_PenjualanSmt mopsmt, model_Produk mobar);
    // Tambah data produk
    void tambahData(model_Produk mobar);
    
    // Perbarui data produk
    void perbaruiData(model_Produk mobar);
    
    // Hapus data produk
    void hapusData(model_Produk mobar);
    
    // Cari produk berdasarkan ID
    model_Produk getByid(String id);
    
    // Ambil semua data produk berdasarkan ID tertentu
    List<model_Produk> getDataByID();
    
    // Ambil semua data produk
    List<model_Produk> getData();
    
    // Pencarian produk berdasarkan ID atau nama
    List<model_Produk> pencarian(String id);
    
    // Implementasi pencarian alternatif (opsional)
    List<model_Produk> pencarian2(String id);
    
    // Generate nomor otomatis untuk produk baru
    String nomor();
    
    // Implementasi alternatif untuk nomor otomatis (opsional)
    String nomor2();
}
