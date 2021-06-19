package onThi.src.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import onThi.src.entity.GiaoVien;

public class GiaoVienDAO {
    private static GiaoVienDAO instance;

    public static GiaoVienDAO getInstance() {
        if (instance == null)
            instance = new GiaoVienDAO();
        return instance;
    }
    
    
    public ArrayList<GiaoVien> getGiaoVienList() {
        ArrayList<GiaoVien> dataList = new ArrayList<GiaoVien>();
        String query = "SELECT * FROM dbo.giaovien";
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, null);
        try {
            while (rs.next()) {
                dataList.add(new GiaoVien(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public String getGiaoVienIDByName(String name) {
        String dataList = "";
        String query = "SELECT * FROM dbo.giaovien Where tenGiaoVien = ?";
        Object[] params = new Object[] { name };
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, params);
        try {
            rs.next();
            dataList = rs.getString("maGiaoVien");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
