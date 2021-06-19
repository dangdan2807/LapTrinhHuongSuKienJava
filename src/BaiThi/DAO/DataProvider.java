package BaiThi.DAO;

import java.sql.*;

import BaiThi.ConnectDB.ConnectDB;

public class DataProvider {
    private static DataProvider instance;
    private static ConnectDB db = ConnectDB.getInstance();

    public static DataProvider getInstance() {
        if (instance == null)
            instance = new DataProvider();
        return instance;
    }

    public ResultSet ExecuteQuery(String query, Object[] params) {
        PreparedStatement ps = null;
        ResultSet dataList = null;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(query);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        ps.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            dataList = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public int ExecuteNonQuery(String query, Object[] params) {
        PreparedStatement ps = null;
        int dataList = 0;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(query);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        ps.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            dataList = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    public Object ExecuteScalar(String query, Object[] params) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object dataList = null;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(query);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        ps.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            rs = ps.executeQuery();
            rs.next();
            dataList = rs.getObject(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }
}