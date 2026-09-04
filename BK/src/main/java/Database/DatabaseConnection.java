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

        String sql = """
            SELECT 
                siswa.nisn,
                siswa.nama_siswa,
                siswa.kelas,
                COALESCE(SUM(pelanggaran_siswa.poin), 0) AS total_poin
            FROM siswa
            LEFT JOIN pelanggaran_siswa
                ON siswa.nisn = pelanggaran_siswa.nisn
            GROUP BY
                siswa.nisn,
                siswa.nama_siswa,
                siswa.kelas
            """;

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet hasil = stmt.executeQuery()) {
            while (hasil.next()) {
                Siswa siswa = new Siswa(
                    hasil.getInt("nisn"),
                    hasil.getString("nama_siswa"),
                    hasil.getString("kelas"),
                    hasil.getInt("total_poin")
                );

                daftar.add(siswa);
            }
        }

        return daftar;
    }

    public void add_siswa(Siswa siswa) throws SQLException {

       String sql = """
            INSERT INTO siswa
            (nisn, nama_siswa, kelas)
            VALUES (?, ?, ?)
            """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, siswa.nisn);
            stmt.setString(2, siswa.nama_siswa);
            stmt.setString(3, siswa.kelas);

            stmt.executeUpdate();
        }
    }
}
