package TTNhanVienSQL.DAO;

import java.sql.*;
import java.util.*;

import TTNhanVienSQL.connectDB.*;
import TTNhanVienSQL.entity.*;

public class NhanVien_DAO {

    public ArrayList<NhanVien> getAllDsNhanVien() {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM NhanVien";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoNV = rs.getString(2);
                String tenNV = rs.getString(3);
                int tuoi = rs.getInt(4);
                Boolean phai = rs.getBoolean(5);
                Double luong = rs.getDouble(6);
                PhongBan phongBan = new PhongBan(rs.getString(7));
                NhanVien p = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, phongBan);
                dsNhanVien.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsNhanVien;
    }

    public ArrayList<NhanVien> getNhanVienTheoMaNV(String idNhanVien) {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        PreparedStatement stmt = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT * FROM NhanVien where maNV = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, idNhanVien);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoNV = rs.getString(2);
                String tenNV = rs.getString(3);
                int tuoi = rs.getInt(4);
                Boolean phai = rs.getBoolean(5);
                Double luong = rs.getDouble(6);
                PhongBan maPB = new PhongBan(rs.getString(7));
                NhanVien p = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, maPB);
                dsNhanVien.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dsNhanVien;
    }

    public ArrayList<NhanVien> getNhanVienTheoMaPB(String idPB) {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT * FROM NhanVien where maPB = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, idPB);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoNV = rs.getString(2);
                String tenNV = rs.getString(3);
                int tuoi = rs.getInt(4);
                Boolean phai = rs.getBoolean(5);
                Double luong = rs.getDouble(6);
                PhongBan maPB = new PhongBan(rs.getString(7));
                NhanVien p = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, maPB);
                dsNhanVien.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dsNhanVien;
    }

    public boolean create(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            String sql = "insert into NhanVien values(?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, nv.getMaNV());
            statement.setString(2, nv.getHoNV());
            statement.setString(3, nv.getTenNV());
            statement.setInt(4, nv.getTuoi());
            statement.setBoolean(5, nv.getPhai());
            statement.setDouble(6, nv.getLuong());
            statement.setString(7, nv.getPhongBan().getMaPB());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean update(NhanVien nv) {
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        try {
            String sql = "update NhanVien set hoNV = ?, tenNV = ?, tuoi = ?, phai = ?," + " luong = ?, maPB = ?"
                    + " where maNV = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, nv.getHoNV());
            statement.setString(2, nv.getTenNV());
            statement.setInt(3, nv.getTuoi());
            statement.setBoolean(4, nv.getPhai());
            statement.setDouble(5, nv.getLuong());
            statement.setString(6, nv.getPhongBan().getMaPB());
            statement.setString(7, nv.getMaNV());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean delete(NhanVien nv) {
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        try {
            String sql = "delete from dbo.NhanVien " + "where maNV = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, nv.getMaNV());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
}
