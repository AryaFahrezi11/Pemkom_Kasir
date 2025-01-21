
package apkkasir;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class databasekoneksi {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/kasir1"; // Sesuaikan dengan database-mu
            String user = "root"; // Ganti dengan username MySQL-mu
            String password = ""; // Ganti dengan password MySQL-mu
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }
    
}
