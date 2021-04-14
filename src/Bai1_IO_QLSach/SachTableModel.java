package Bai1_IO_QLSach;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SachTableModel extends AbstractTableModel{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final int MASACH = 0;
	private static final int TUASACH = 1;
	private static final int TACGIA = 2;
	private static final int NAMXB = 3;
	private static final int NHAXB = 4;
	private static final int SOTRANG = 5;
	private static final int DONGIA = 6;
	private static final int ISBN = 7;
	private ArrayList<Sach> dsSach;
	private String [] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

	/**
	 * @param dsSach
	 */
	public SachTableModel(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	@Override
	
	public int getRowCount() {
		return dsSach.size();
	}
	
	@Override
	public int getColumnCount() {
		return headers .length;
	}

	@Override
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sach s = dsSach.get(rowIndex);
		switch (columnIndex) {
		case MASACH:
			return s.getMaSach();
		case TUASACH:
			return s.getTuaSach();
		case TACGIA:
			return s.getTacGia();
		case NAMXB:
			return s.getNamXB();
		case NHAXB:
			return s.getNhaXB();
		case SOTRANG:
			return s.getSoTrang();
		case DONGIA:
			return s.getDonGia();
		case ISBN:
			return s.getIsbn();
		default:
			return s;
		}
	}
	
	//Tieu de cột cho Table
	@Override
	public String getColumnName(int column) {
		return headers[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == SOTRANG || columnIndex == NAMXB)
			return Integer.class;
		if(columnIndex == DONGIA)
			return Double.class;
		return String.class;
	}
}
