package week3.JTableEditIO;

import java.io.Serializable;

public class Sach implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String maSach, tenSach;
    private int soTrang;

    public String getMaSach() {
        return this.maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return this.tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoTrang() {
        return this.soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
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
    public int hashCode() {
        final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		return result;
    }
    

    public Sach(String maSach, String tenSach, int soTrang) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soTrang = soTrang;
    }

    public Sach() {
    }

    @Override
	public String toString() {
		return super.toString();
	}
}