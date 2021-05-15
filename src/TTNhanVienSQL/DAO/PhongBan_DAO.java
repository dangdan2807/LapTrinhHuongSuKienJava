package TTNhanVienSQL.DAO;

import java.util.*;

import TTNhanVienSQL.connectDB.ConnectDB;
import TTNhanVienSQL.entity.*;

import java.sql.*;

public class PhongBan_DAO {
    public ArrayList<PhongBan> getAllDsPhongBan() {
        ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT * FROM PhongBan";
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maPB = rs.getString(1);
                String tenPB = rs.getString(2);
                PhongBan p = new PhongBan(maPB, tenPB);
                dsPhongBan.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPhongBan;
    }

    public ArrayList<PhongBan> getNhanVienTheoMaPB(String idPB) {
        ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT * FROM PhongBan where maPB = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, idPB);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maPB = rs.getString(1);
                String tenPB = rs.getString(2);
                PhongBan phongBan = new PhongBan(maPB, tenPB);
                dsPhongBan.add(phongBan);
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
        return dsPhongBan;
    }

    public boolean create(PhongBan pb) {
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        try {
            String sql = "insert into PhongBan values(?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, pb.getMaPB());
            statement.setString(2, pb.getTenPB());
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

    public boolean update(PhongBan pb) {
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        try {
            String sql = "update PhongBan set tenPB = ? " + " where maPB = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, pb.getTenPB());
            statement.setString(2, pb.getMaPB());
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

    public boolean delete(PhongBan pb) {
        PreparedStatement statement = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        try {
            String sql = "delete from dbo.PhongBan " + "where maPB = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, pb.getMaPB());
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
