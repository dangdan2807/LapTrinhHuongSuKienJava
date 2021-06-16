package DAO;

import java.sql.*;

import ConnectDB.ConnectDB;

public class DataProvider {
    private static DataProvider instance;
    private static ConnectDB db = ConnectDB.getInstance();

    public static DataProvider getInstance() {
        if (instance == null)
            instance = new DataProvider();
        return instance;
    }

    public ResultSet ExecuteQuery(String query, Object[] params) {
        PreparedStatement stmt = null;
        ResultSet data = null;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        stmt.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            data = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int ExecuteNonQuery(String query, Object[] params) {
        PreparedStatement stmt = null;
        int data = 0;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        stmt.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            data = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public Object ExecuteScalar(String query, Object[] params) {
        PreparedStatement stmt = null;
        Object data = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db.connect();
            con = ConnectDB.getConnection();
            stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (params != null) {
                String[] list = query.split(" ");
                int i = 1;
                for (String item : list) {
                    if (item.contains("?")) {
                        stmt.setObject(i, params[i - 1]);
                        i++;
                    }
                }
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                data = rs.getObject(1);
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
        return data;
    }
}
