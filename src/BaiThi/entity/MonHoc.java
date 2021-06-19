package BaiThi.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonHoc {
    String maMon, tenMon;
    BoMonChuQuan boMonCQ;
    int soTiet;

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public BoMonChuQuan getBoMonCQ() {
        return boMonCQ;
    }

    public void setBoMonCQ(BoMonChuQuan boMonCQ) {
        this.boMonCQ = boMonCQ;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public MonHoc(String maMon, String tenMon, BoMonChuQuan boMonCQ, int soTiet) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.boMonCQ = boMonCQ;
        this.soTiet = soTiet;
    }

    public MonHoc(ResultSet rs) throws SQLException {
        this(rs.getString("maMon"), rs.getString("tenMon"), new BoMonChuQuan(rs), rs.getInt("soTiet"));
    }
}
