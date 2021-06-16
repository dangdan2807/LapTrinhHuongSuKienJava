package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LopHoc {
    String maLop, tenLop;
    GiaoVien giaoVien;
    int siSo;

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public LopHoc(String maLop, String tenLop, GiaoVien giaoVien, int siSo) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.giaoVien = giaoVien;
        this.siSo = siSo;
    }

    public LopHoc(ResultSet rs) throws SQLException {
        this(rs.getString("maLop"), rs.getString("tenLop"),
                new GiaoVien(rs.getString("maGiaoVien"), rs.getString("tenGiaoVien")), rs.getInt("siSo"));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maLop == null) ? 0 : maLop.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LopHoc other = (LopHoc) obj;
        if (maLop == null) {
            if (other.maLop != null)
                return false;
        } else if (!maLop.equals(other.maLop))
            return false;
        return true;
    }

    
}
