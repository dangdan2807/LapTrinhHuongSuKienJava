package TTNhanVien;

import java.io.Serializable;

public class NhanVien implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String maNV;
    private String hoNV;
    private String tenNV;
    private Boolean phai;
    private int tuoi;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, Boolean phai, int tuoi, double luong) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.phai = phai;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public String getMaNV() {
        return this.maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return this.hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return this.tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Boolean isPhai() {
        return this.phai;
    }

    public Boolean getPhai() {
        return this.phai;
    }

    public void setPhai(Boolean phai) {
        this.phai = phai;
    }

    public int getTuoi() {
        return this.tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getLuong() {
        return this.luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NhanVien other = (NhanVien) obj;
        if (maNV == null) {
            if (other.maNV != null)
                return false;
        } else if (!maNV.equals(other.maNV))
            return false;
        return true;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
