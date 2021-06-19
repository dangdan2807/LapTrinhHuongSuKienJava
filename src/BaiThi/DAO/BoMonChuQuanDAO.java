package BaiThi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BaiThi.entity.BoMonChuQuan;

public class BoMonChuQuanDAO {
    private static BoMonChuQuanDAO instance;

    public static BoMonChuQuanDAO getInstance() {
        if (instance == null)
            instance = new BoMonChuQuanDAO();
        return instance;
    }

    public ArrayList<BoMonChuQuan> getBMList() {
        ArrayList<BoMonChuQuan> data = new ArrayList<BoMonChuQuan>();
        String query = "SELECT * FROM BoMonChuQuan";
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, null);
        try {
            while (rs.next()) {
                data.add(new BoMonChuQuan(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String getIDByName(String tenBoMon) {
        String data = "";
        String query = "SELECT * FROM BoMonChuQuan where tenBoMon = ?";
        data = DataProvider.getInstance().ExecuteScalar(query, new Object[] { tenBoMon })
                .toString();
        return data;
    }
}
