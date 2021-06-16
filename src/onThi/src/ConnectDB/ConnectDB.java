package ConnectDB;

import java.sql.*;

public class ConnectDB {
    private static ConnectDB instance;
    public static Connection con;

    public static ConnectDB getInstance() {
        if(instance == null)
            instance = new ConnectDB();
        return instance;
    }

    public void connect() throws SQLException {
        String username = "sa";
        String password = "123456";
        String serverName = "localhost";
        String databaseName = "QLLop";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName;
        con = DriverManager.getConnection(url, username, password);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
