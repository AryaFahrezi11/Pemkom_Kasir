
package dao;

import apkkasir.databasekoneksi;
import apkkasir.fungsi;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_User;
import service.service_User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DAO_User implements service_User{
    
    private Connection conn;
    
    public DAO_User(){
        conn = databasekoneksi.getConnection();
    }

    @Override
    public void tambahData(model_User mod_user) {
        PreparedStatement st = null;
        String sql = "INSERT INTO user (id_user, fullname, email, no_telepon, username, password, role) VALUES (?,?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt       (1, mod_user.getId_pengguna());
            st.setString    (2, mod_user.getFullname());
            st.setString    (3, mod_user.getEmail());
            st.setInt       (4, mod_user.getTelepon());
            st.setString    (5, mod_user.getUsernama());
            st.setString    (6, mod_user.getPass());
            st.setString    (7, mod_user.getRole());
            
            st.executeUpdate();
            fungsi.savelog("User berhasil ditambahkan: " + mod_user.getFullname() + " dengan ID " + mod_user.getId_pengguna());
        } catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!= null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_User mod_user) {
        PreparedStatement st = null;
        String sql = "UPDATE user SET fullname=?, email=?, no_telepon=?, username=?, password=?, role=? WHERE id_user='"+mod_user.getId_pengguna()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString    (1, mod_user.getFullname());
            st.setString    (2, mod_user.getEmail());
            st.setInt       (3, mod_user.getTelepon());
            st.setString    (4, mod_user.getUsernama());
            st.setString    (5, mod_user.getPass());
            st.setString    (6, mod_user.getRole());
            
            st.executeUpdate();
            fungsi.savelog("Data user berhasil diperbarui: " + mod_user.getFullname() + " dengan ID " + mod_user.getId_pengguna());
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!= null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(model_User mod_user) {
        PreparedStatement st =null;
        String sql = "DELETE FROM user WHERE id_user = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setInt(1, mod_user.getId_pengguna());
            
            st.executeUpdate();
            fungsi.savelog("User berhasil dihapus: " + mod_user.getFullname() + " dengan ID " + mod_user.getId_pengguna());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public model_User getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_User> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT id_user, fullname, email, no_telepon, username, password, role FROM user";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_User mod_user = new model_User();
                
                
                mod_user.setId_pengguna(rs.getInt ("id_user"));
                mod_user.setFullname(rs.getString("fullname"));
                mod_user.setEmail(rs.getString("email"));
                mod_user.setTelepon(rs.getInt("no_telepon"));
                mod_user.setUsernama(rs.getString("username"));
                mod_user.setPass(rs.getString("password"));
                mod_user.setRole(rs.getString("role"));
                
                list.add(mod_user);
            }
            fungsi.savelog("Data user berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<model_User> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT id_user, fullname, email, no_telepon, username, password, role FROM user WHERE id_user LIKE '%"+id+"%' OR fullname LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                model_User mod_user = new model_User();
                
                
                mod_user.setId_pengguna(rs.getInt ("id_user"));
                mod_user.setFullname(rs.getString("fullname"));
                mod_user.setEmail(rs.getString("email"));
                mod_user.setTelepon(rs.getInt("no_telepon"));
                mod_user.setUsernama(rs.getString("username"));
                mod_user.setPass(rs.getString("password"));
                mod_user.setRole(rs.getString("role"));
                
                list.add(mod_user);
            }
            fungsi.savelog("Data user berhasil diambil, total: " + list.size());
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String nomor() {
    PreparedStatement st = null;
    ResultSet rs = null;
    String urutan = null;

    Date now = new Date();
    SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
    String no = noformat.format(now);

    String sql = "SELECT RIGHT(id_user, 3) AS Nomor " +
                 "FROM user " +
                 "WHERE id_user LIKE ? " +
                 "ORDER BY id_user DESC " +
                 "LIMIT 1";

    try {
        st = conn.prepareStatement(sql);
        st.setString(1, no + "%");
        rs = st.executeQuery();

        if (rs.next()) {
            int nomor = Integer.parseInt(rs.getString("Nomor"));
            nomor++;
            urutan = no + String.format("%03d", nomor); // Tambahkan leading zero
        } else {
            urutan = no + "001"; // Jika tidak ada data, mulai dari 001
        }
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Selalu tutup resource dengan aman
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return urutan;
}


    @Override
    public boolean validateOldPassword(String username, String oldPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
