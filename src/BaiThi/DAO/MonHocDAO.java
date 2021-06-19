package BaiThi.DAO;

import java.sql.*;
import java.util.ArrayList;

import BaiThi.entity.MonHoc;

public class MonHocDAO {
    private static MonHocDAO instance;

    public static MonHocDAO getInstance() {
        if (instance == null)
            instance = new MonHocDAO();
        return instance;
    }

    public ArrayList<MonHoc> getBMList() {
        ArrayList<MonHoc> data = new ArrayList<MonHoc>();
        String query = "SELECT m.maMon, m.tenMon, m.maBoMonCQ, b.tenBoMon, m.soTiet FROM MonHoc m, BoMonChuQuan b where m.maBoMonCQ = b.maBoMonCQ";
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, null);
        try {
            while (rs.next()) {
                data.add(new MonHoc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean insert(MonHoc mh) {
        String query = "INSERT MonHoc([maMon], [tenMon],[maBoMonCQ],[soTiet]) VALUES ( ? , ? , ? , ?)";
        Object[] params = new Object[] { mh.getMaMon(), mh.getTenMon(), mh.getBoMonCQ().getMaBoMonCQ(),
                mh.getSoTiet() };
        int data = DataProvider.getInstance().ExecuteNonQuery(query, params);
        return data > 0;
    }

    public boolean delete(MonHoc mh) {
        String query = "delete from MonHoc where [maMon]= ?";
        Object[] params = new Object[] { mh.getMaMon() };
        int data = DataProvider.getInstance().ExecuteNonQuery(query, params);
        return data > 0;
    }

    public ArrayList<MonHoc> searchByTenMonHoc(String maMonHoc) {
        ArrayList<MonHoc> data = new ArrayList<MonHoc>();
        String query = "SELECT m.maMon, m.tenMon, m.maBoMonCQ, b.tenBoMon, m.soTiet FROM MonHoc m, BoMonChuQuan b where m.maBoMonCQ = b.maBoMonCQ AND b.maBoMonCQ = ?";
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, new Object[] { maMonHoc });
        try {
            while (rs.next()) {
                data.add(new MonHoc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
