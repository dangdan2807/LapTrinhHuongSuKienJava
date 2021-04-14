package Bai1_IO_QLSach;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThuVien {
	private ArrayList<Sach> dsSach;

	public ThuVien() {
		dsSach = new ArrayList<Sach>(10);
	}
	
	public void napDuLieuTuFile() {
		dsSach = Database.docTuFile();
	}
	
	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}
	
	public int count() {
		return dsSach.size();
	}
	
	public Sach timKiem(String maSach) {
		Sach s = new Sach(maSach);
		if(dsSach.contains(s))
			return dsSach.get(dsSach.indexOf(s));
		return null;
	}
	
	
	public boolean xoa1CuonSach(int index) {
		if(index >= 0 && index < dsSach.size()){
			dsSach.remove(index);
			return true;
		}
		return false;
	}
	
	
	public boolean themSach(Sach s) {
		if(dsSach.contains(s))
			return false;
		return dsSach.add(s);
	}
	/**
	 * Cập nhật thông tin cuốn sách khi biết mã sách
	 * Không được phép cập nhật trên trường khóa
	 * @param maSachOld
	 * @param sachNew
	 * @return
	 */
	public boolean capNhatSach(String maSachOld, Sach sachNew) {
		Sach sachOld = new Sach(maSachOld);
		if(dsSach.contains(sachOld)){
			sachOld = dsSach.get(dsSach.indexOf(sachOld));
			sachOld.setTuaSach(sachNew.getTuaSach());
			sachOld.setTacGia(sachNew.getTacGia());
			sachOld.setNamXB(sachNew.getNamXB());
			sachOld.setNhaXB(sachNew.getNhaXB());
			sachOld.setSoTrang(sachNew.getSoTrang());
			sachOld.setDonGia(sachNew.getDonGia());
			sachOld.setIsbn(sachNew.getIsbn());
			return true;
		}
		return false;
	}
	
	/**
	 * Lọc dữ liệu dựa trên tựa sách
	 * @param regex
	 * @return
	 */
	public ArrayList<Sach> filter(String regex) {
		ArrayList<Sach> result = new ArrayList<Sach>();
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		for(Sach s : dsSach){
			Matcher m = p.matcher(s.getTuaSach());
			if(m.find())
				result.add(s);
		}
		return result;
	}
}
