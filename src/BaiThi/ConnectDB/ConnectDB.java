package BaiThi.ConnectDB;

import java.sql.*;

public class ConnectDB {
    private static ConnectDB instance;
    private static Connection con = null;

    public static ConnectDB getInstance() {
        if (instance == null)
            instance = new ConnectDB();
        return instance;
    }

    public void connect() throws SQLException {
        String serverName = "localhost";
        String databaseName = "QLMonHoc";
        String userName = "sa";
        String password = "123456";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName;
        con = DriverManager.getConnection(url, userName, password);
    }

    public void disconnect() {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public static Connection getConnection() {
        return con;
    }
}
