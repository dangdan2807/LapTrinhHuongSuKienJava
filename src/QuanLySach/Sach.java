package QuanLySach;

public class Sach {
    private String maSach, tuaSach, tacGia, nxb, ISBN;
    private int namSx, soTrang;
    private double donGia;

    public String getMaSach() {
        return this.maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return this.tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getTacGia() {
        return this.tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNxb() {
        return this.nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNamSx() {
        return this.namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public int getSoTrang() {
        return this.soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Sach() {
    }
    
    public Sach(String maSach) {
        this.maSach = maSach;
    }

    public Sach(String maSach, String tuaSach, String tacGia, String nxb, int namSx, int soTrang,
            double donGia, String ISBN) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tacGia = tacGia;
        this.nxb = nxb;
        this.ISBN = ISBN;
        this.namSx = namSx;
        this.soTrang = soTrang;
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
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
        Sach other = (Sach) obj;
        if (maSach == null) {
            if (other.maSach != null)
                return false;
        } else if (!maSach.equals(other.maSach))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return maSach + ";" + tuaSach + ";" + tacGia + ";" + namSx + ";" + nxb + ";" + soTrang + ";" + donGia + ";"
                + ISBN;
    }
}
