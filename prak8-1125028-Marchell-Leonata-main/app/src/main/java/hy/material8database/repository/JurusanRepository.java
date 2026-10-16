package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Jurusan;

public class JurusanRepository {

    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    public static void addJurusan(Jurusan jurusan) {

        String sql =
            "INSERT INTO jurusan (kode_jurusan, nama) VALUES (?, ?)";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                jurusan.kodeJurusan
            );

            ps.setString(
                2,
                jurusan.nama
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Jurusan> getAllJurusan() {

        List<Jurusan> result =
            new ArrayList<>();

        String sql =
            "SELECT * FROM jurusan";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                result.add(
                    new Jurusan(
                        rs.getString("kode_jurusan"),
                        rs.getString("nama")
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void updateJurusan(
        Jurusan jurusan
    ) {

        String sql =
            "UPDATE jurusan SET nama = ? WHERE kode_jurusan = ?";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                jurusan.nama
            );

            ps.setString(
                2,
                jurusan.kodeJurusan
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteJurusan(
        String kodeJurusan
    ) {

        String sql =
            "DELETE FROM jurusan WHERE kode_jurusan = ?";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                kodeJurusan
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}