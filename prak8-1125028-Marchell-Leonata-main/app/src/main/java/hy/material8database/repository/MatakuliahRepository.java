package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Matakuliah;

public class MatakuliahRepository {

    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    public static void addMatakuliah(
        Matakuliah matkul
    ) {

        String sql =
            "INSERT INTO matakuliah " +
            "(kode_matakuliah,nama,sks,kode_jurusan) " +
            "VALUES (?,?,?,?)";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                matkul.kodeMatakuliah
            );

            ps.setString(
                2,
                matkul.nama
            );

            ps.setInt(
                3,
                matkul.sks
            );

            ps.setString(
                4,
                matkul.kodeJurusan
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Matakuliah>
        getAllMatakuliah() {

        List<Matakuliah> result =
            new ArrayList<>();

        String sql =
            "SELECT * FROM matakuliah";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                result.add(
                    new Matakuliah(
                        rs.getString(
                            "kode_matakuliah"
                        ),
                        rs.getString(
                            "nama"
                        ),
                        rs.getInt(
                            "sks"
                        ),
                        rs.getString(
                            "kode_jurusan"
                        )
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void updateMatakuliah(
        Matakuliah matkul
    ) {

        String sql =
            "UPDATE matakuliah " +
            "SET nama=?, sks=?, kode_jurusan=? " +
            "WHERE kode_matakuliah=?";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                matkul.nama
            );

            ps.setInt(
                2,
                matkul.sks
            );

            ps.setString(
                3,
                matkul.kodeJurusan
            );

            ps.setString(
                4,
                matkul.kodeMatakuliah
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMatakuliah(
        String kode
    ) {

        String sql =
            "DELETE FROM matakuliah WHERE kode_matakuliah=?";

        try {

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(
                1,
                kode
            );

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}