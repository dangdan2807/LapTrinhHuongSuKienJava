package onThi.src.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiaoVien {
    String maGiaoVien, tenGiaoVien;

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public GiaoVien(String maGV, String tenGiaoVien) {
        this.maGiaoVien = maGV;
        this.tenGiaoVien = tenGiaoVien;
    }

    public GiaoVien(ResultSet rs) throws SQLException {
        this(rs.getString("maGiaoVien"), rs.getString("tenGiaoVien"));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maGiaoVien == null) ? 0 : maGiaoVien.hashCode());
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
        GiaoVien other = (GiaoVien) obj;
        if (maGiaoVien == null) {
            if (other.maGiaoVien != null)
                return false;
        } else if (!maGiaoVien.equals(other.maGiaoVien))
            return false;
        return true;
    }

}
