package BaiThi.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoMonChuQuan {
    String maBoMonCQ, tenBoMon;

    public String getMaBoMonCQ() {
        return maBoMonCQ;
    }

    public void setMaBoMonCQ(String maBoMonCQ) {
        this.maBoMonCQ = maBoMonCQ;
    }

    public String getTenBoMon() {
        return tenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
        this.tenBoMon = tenBoMon;
    }

    public BoMonChuQuan(String maBoMonCQ, String tenBoMon) {
        this.maBoMonCQ = maBoMonCQ;
        this.tenBoMon = tenBoMon;
    }
    public BoMonChuQuan(ResultSet rs) throws SQLException {
        this(rs.getString("maBoMonCQ"), rs.getString("tenBoMon"));
    }

}
