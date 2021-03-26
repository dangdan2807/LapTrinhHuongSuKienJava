package demoIO;

import java.io.Serializable;

public class SinhVien implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String mssv;
	private String ho;
	private String ten;
	
	public SinhVien() {
	}
	public SinhVien(String mssv, String ho, String ten) {
		this.mssv = mssv;
		this.ho = ho;
		this.ten = ten;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mssv == null) ? 0 : mssv.hashCode());
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
		SinhVien other = (SinhVien) obj;
		if (mssv == null) {
			if (other.mssv != null)
				return false;
		} else if (!mssv.equals(other.mssv))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
