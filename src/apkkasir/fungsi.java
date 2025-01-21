
package apkkasir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;



public class fungsi {
    static String folder = "aktivitas";
    static String home = "C:\\Mata kuliah S3\\pemkom";
    static String pathFolder = home + File.separator + folder;
    static String logName = "log.txt";
    static String pathLog = pathFolder + File.separator + logName;

    // Menambahkan method untuk mendapatkan format tanggal
    public static String getDateNow() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m:s z");
        return sdf.format(d);
    }

    // Memodifikasi savelog untuk menggunakan getDateNow
    public static void savelog(String activity) {
        try {
            File f = new File(pathFolder);
            f.mkdir();  // Membuat folder "aktivitas" jika belum ada

            File log = new File(pathLog);
            log.createNewFile();  // Membuat file "log.txt" jika belum ada

            String logEntry = "\n[" + getDateNow() + "] " + activity;

            Files.write(
                Paths.get(pathLog),
                logEntry.getBytes(),
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error Code: 101 => " + e.getMessage());
        }
    }
}