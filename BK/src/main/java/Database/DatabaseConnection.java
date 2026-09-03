package Database;

import java.sql.*;
import java.util.ArrayList;
import Model.*;

/**
 *
 * @author DELL
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_siswa";
    private static final String USER = "admin_bk";
    private static final String PASSWORD = "admin123";

    private Connection conn;

    public DatabaseConnection() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public ArrayList<Siswa> get_siswa() throws SQLException {
        ArrayList<Siswa> daftar = new ArrayList();

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM siswa");
            ResultSet hasil = stmt.executeQuery()) {
            while (hasil.next()){
                
            }
        }

        return daftar;
    }
}
