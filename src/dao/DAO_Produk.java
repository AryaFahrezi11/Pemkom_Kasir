package dao;

import apkkasir.databasekoneksi;
import apkkasir.fungsi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_PenjualanSmt;
import model.model_Produk;
import service.service_Produk;

public class DAO_Produk implements service_Produk {

    private Connection conn;

    public DAO_Produk() {
        conn = databasekoneksi.getConnection();
    }    


    @Override
    public void tambahData(model_Produk mobar) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String checkSql = "SELECT ID FROM produk WHERE ID = ?";
            st = conn.prepareStatement(checkSql);
            st.setInt(1, mobar.getId_produk());
            rs = st.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "ID produk sudah ada. Tidak dapat menambahkan data dengan ID yang sama.");
                return;
            }

            String sql = "INSERT INTO produk (ID, nama_produk, harga_beli, harga_jual, stok, satuan) VALUES (?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);

            st.setInt(1, mobar.getId_produk());
            st.setString(2, mobar.getNama_produk());
            st.setLong(3, mobar.getHarga_beli());
            st.setLong(4, mobar.getHarga_jual());
            st.setInt(5, mobar.getStok());
            st.setString(6, mobar.getSatuan());

            st.executeUpdate();
            fungsi.savelog("Produk berhasil ditambahkan: " + mobar.getNama_produk() + " dengan ID " + mobar.getId_produk());
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void perbaruiData(model_Produk mobar) {
        PreparedStatement st = null;

        try {
            String sql = "UPDATE produk SET nama_produk = ?, harga_beli = ?, harga_jual = ?, stok = ?, satuan = ? WHERE ID = ?";
            st = conn.prepareStatement(sql);

            st.setString(1, mobar.getNama_produk());
            st.setLong(2, mobar.getHarga_beli());
            st.setLong(3, mobar.getHarga_jual());
            st.setInt(4, mobar.getStok());
            st.setString(5, mobar.getSatuan());
            st.setInt(6, mobar.getId_produk());

            st.executeUpdate();
            fungsi.savelog("Produk berhasil diperbarui: " + mobar.getNama_produk() + " dengan ID " + mobar.getId_produk());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void hapusData(model_Produk mobar) {
        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM produk WHERE ID = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1, mobar.getId_produk());

            st.executeUpdate();
            fungsi.savelog("Produk berhasil dihapus: " + mobar.getNama_produk() + " dengan ID " + mobar.getId_produk());
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public model_Produk getByid(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        model_Produk mobar = null;

        try {
            String sql = "SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk WHERE ID = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                mobar = new model_Produk();
                mobar.setId_produk(rs.getInt("ID"));
                mobar.setNama_produk(rs.getString("nama_produk"));
                mobar.setHarga_beli(rs.getLong("harga_beli"));
                mobar.setHarga_jual(rs.getLong("harga_jual"));
                mobar.setStok(rs.getInt("stok"));
                mobar.setSatuan(rs.getString("satuan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return mobar;
    }

    @Override
    public List<model_Produk> getDataByID() {
        return new ArrayList<>(); // Implementasi kosong
    }

    @Override
    public List<model_Produk> getData() {
        PreparedStatement st = null;
        List<model_Produk> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            String sql = "SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                model_Produk mobar = new model_Produk();

                mobar.setId_produk(rs.getInt("ID"));
                mobar.setNama_produk(rs.getString("nama_produk"));
                mobar.setHarga_beli(rs.getLong("harga_beli"));
                mobar.setHarga_jual(rs.getLong("harga_jual"));
                mobar.setStok(rs.getInt("stok"));
                mobar.setSatuan(rs.getString("satuan"));

                list.add(mobar);
            }

            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
public List<model_Produk> pencarian(String id) {
    PreparedStatement st = null;
    List<model_Produk> list = new ArrayList<>();
    ResultSet rs = null;

    try {
        // Trim ID untuk menghapus whitespace di awal/akhir
        if (id != null) {
            id = id.trim(); // Menghapus spasi di awal/akhir
        }

        // Validasi awal: Cek apakah input kosong setelah trim
        if (id == null || id.isEmpty()) {
            return list; // Kembalikan list kosong jika input kosong
        }

        // Validasi: Jika panjang ID belum mencapai 8 digit
        if (id.length() < 8) {
            return list; // Kembalikan list kosong tanpa pesan
        }

        // Validasi: Jika ID tidak terdiri dari tepat 8 digit angka
        if (!id.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "ID harus terdiri dari 8 digit angka!");
            return list; // Kembalikan list kosong jika ID tidak valid
        }

        // Query untuk pencarian berdasarkan ID
        String sql = "SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk WHERE ID = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, id);

        rs = st.executeQuery();

        // Iterasi hasil pencarian
        while (rs.next()) {
            model_Produk mobar = new model_Produk();
            mobar.setId_produk(rs.getInt("ID"));
            mobar.setNama_produk(rs.getString("nama_produk"));
            mobar.setHarga_beli(rs.getLong("harga_beli"));
            mobar.setHarga_jual(rs.getLong("harga_jual"));
            mobar.setStok(rs.getInt("stok"));
            mobar.setSatuan(rs.getString("satuan"));

            list.add(mobar);
        }

        // Jika tidak ada data ditemukan, tampilkan pesan
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Produk tidak ditemukan untuk input: " + id);
        } else {
            fungsi.savelog("Pencarian berhasil, total produk ditemukan: " + list.size());
        }

    } catch (SQLException ex) {
        Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (st != null) st.close();
            if (rs != null) rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return list; // Kembalikan hasil pencarian
}


    @Override
    public List<model_Produk> pencarian2(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT ID, nama_produk, harga_beli, harga_jual, stok, satuan FROM produk WHERE ID LIKE '%"+id+"%' OR nama_produk LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_Produk mobar = new model_Produk();
                
                mobar.setId_produk(rs.getInt ("ID"));
                mobar.setNama_produk(rs.getString ("nama_produk"));
                mobar.setHarga_beli(rs.getLong ("harga_beli"));
                mobar.setHarga_jual(rs.getLong ("harga_jual"));
                mobar.setStok(rs.getInt ("stok"));
                mobar.setSatuan(rs.getString ("satuan"));
                
                list.add(mobar);
            }
            fungsi.savelog("Data produk berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        try {
            Date now = new Date();
            SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
            String no = noformat.format(now);

            String sql = "SELECT RIGHT(ID, 3) AS Nomor FROM produk WHERE ID LIKE ? ORDER BY ID DESC LIMIT 1";
            st = conn.prepareStatement(sql);
            st.setString(1, no + "%");
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = no + String.format("%03d", nomor);
            } else {
                urutan = no + "001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return urutan;
    }

    @Override
    public String nomor2() {
        return ""; // Implementasi kosong
    }

    @Override
public void kurangiStok(model_PenjualanSmt mopsmt, model_Produk mobar) {
    // Ambil nilai ID produk dan jumlah
    int id_produk = mobar.getId_produk(); 
    int jumlah = mopsmt.getJumlah();      

    // Validasi jumlah
    if (jumlah <= 0) {
        JOptionPane.showMessageDialog(null, "Jumlah harus lebih besar dari 0!");
        return;
    }

    try {
        // Ambil stok saat ini
        try (PreparedStatement cekStokStmt = conn.prepareStatement("SELECT stok FROM produk WHERE ID = ?")) {
            cekStokStmt.setInt(1, id_produk);
            ResultSet rs = cekStokStmt.executeQuery();

            if (rs.next()) {
                int stokSaatIni = rs.getInt("stok");

                if (stokSaatIni < jumlah) {
                    JOptionPane.showMessageDialog(null, "Stok tidak mencukupi! Stok saat ini: " + stokSaatIni);
                    return;
                }

                // Kurangi stok di database
                try (PreparedStatement kurangiStokStmt = conn.prepareStatement("UPDATE produk SET stok = stok - ? WHERE ID = ?")) {
                    kurangiStokStmt.setInt(1, jumlah);
                    kurangiStokStmt.setInt(2, id_produk);
                    int rowsAffected = kurangiStokStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Stok produk berhasil dikurangi. ID Produk: " + id_produk);
                        fungsi.savelog("Stok produk berhasil dikurangi. ID: " + id_produk + ", Jumlah: " + jumlah);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal mengurangi stok. Produk tidak ditemukan.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Produk dengan ID: " + id_produk + " tidak ditemukan!");
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Produk.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengurangi stok produk.");
    }
}
}

